package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;




public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void add(Product product) {
        String name = product.getName().toLowerCase();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public boolean remove(Product product) {
        String name = product.getName().toLowerCase();
        List<Product> list = products.get(name);
        if (list != null && list.remove(product)) {
            if (list.isEmpty()) {
                products.remove(name);
            }
            return true;
        }
        return false;
    }

    public List<Product> getByName(String name) {
        return products.getOrDefault(name.toLowerCase(), Collections.emptyList());
    }

    public List<Product> getAll() {
        List<Product> all = new ArrayList<>();
        for (List<Product> group : products.values()) {
            all.addAll(group);
        }
        return all;
    }

    public void printAll() {
        for (List<Product> group : products.values()) {
            for (Product product : group) {
                System.out.println(product.getStringRepresentation());
            }
        }
    }

    public int getTotalPrice() {
        int sum = 0;
        for (List<Product> list : products.values()) {
            for (Product p : list) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        int specialCount = 0;
        for (List<Product> list : products.values()) {
            for (Product product : list) {
                System.out.println(product.getStringRepresentation());
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public List<Product> removeByName(String name) {
        name = name.toLowerCase();
        List<Product> removed = products.get(name);
        if (removed != null) {
            products.remove(name);
            return removed;
        }
        return Collections.emptyList();
    }


    public boolean hasProduct(String name) {
        return products.containsKey(name.toLowerCase());
    }

    public void clear() {
        products.clear();
    }
}

