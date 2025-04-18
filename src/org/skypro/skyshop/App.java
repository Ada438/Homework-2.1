package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 40);
        Product milk = new Product("Молоко", 70);
        Product cheese = new Product("Сыр", 120);
        Product butter = new Product("Масло", 90);
        Product chocolate = new Product("Шоколад", 150);

        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(butter);

        basket.addProduct(chocolate);

        basket.printBasket();

        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        System.out.println("Есть ли Хлеб в корзине? " + basket.hasProduct("Хлеб"));
        System.out.println("Есть ли Сникерс в корзине? " + basket.hasProduct("Сникерс"));

        basket.clear();

        System.out.println("После очистки корзины:");
        basket.printBasket();
        System.out.println("Общая стоимость: " + basket.getTotalPrice());
        System.out.println("Есть ли Хлеб в корзине? " + basket.hasProduct("Хлеб"));
    }
}
