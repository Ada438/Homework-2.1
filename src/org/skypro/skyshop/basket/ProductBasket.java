package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] basket = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size < basket.length) {
            basket[size] = product;
            size++;
        } else {
            System.out.println("Невозможно добавить продукт — корзина полна.");
        }
    }

    public int getTotalPrice() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += basket[i].getPrice();
        }
        return sum;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("В корзине пусто.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(basket[i].getName() + ": " + basket[i].getPrice());
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean hasProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (basket[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            basket[i] = null;
        }
        size = 0;
    }
}
