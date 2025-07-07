package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Collection;




public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(product.getStringRepresentation()));

        System.out.println("Итого: " + getTotalPrice() + " руб.");
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
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

