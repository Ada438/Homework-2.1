package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new DiscountedProduct("Хлеб", 40, 10);
        Product milk = new FixPriceProduct ("Молоко");
        Product cheese = new SimpleProduct ("Сыр", 120);
        Product butter = new DiscountedProduct ("Масло", 90, 15);
        Product chocolate = new SimpleProduct ("Шоколад", 130);

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
