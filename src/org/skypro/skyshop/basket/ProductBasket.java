package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {
    private final List<Product> products = new LinkedList<>();
    public void add(Product product) {
        products.add(product);
    }

    public List<Product> removeByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                removed.add(product);
                iterator.remove();
            }
        }

        return removed;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        int specialCount = 0;
        for (Product product : products) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean hasProduct(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        products.clear();
    }
}
