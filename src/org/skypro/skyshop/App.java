package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new DiscountedProduct("Хлеб", 40, 10);
        Product milk = new FixPriceProduct("Молоко");
        Product cheese = new SimpleProduct("Сыр", 120);
        Product butter = new DiscountedProduct("Масло", 90, 15);
        Product chocolate = new SimpleProduct("Шоколад", 130);

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

        SearchEngine searchEngine = new SearchEngine(20);

        searchEngine.add(apple);
        searchEngine.add(bread);
        searchEngine.add(milk);
        searchEngine.add(cheese);
        searchEngine.add(butter);
        searchEngine.add(chocolate);

        Article article1 = new Article("Статья про молоко", "Ценная информация про молоко.");
        Article article2 = new Article("Статья про хлеб", "Ценная информация про хлеб.");
        Article article3 = new Article("Статья про сыр", "Ценная информация про сыр.");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println("\nРезультаты поиска по слову 'хлеб':");
        for (Searchable result : searchEngine.search("хлеб")) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }

        System.out.println("\nРезультаты поиска по слову 'молоко':");
        for (Searchable result : searchEngine.search("молоко")) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }

        System.out.println("\nРезультаты поиска по слову 'сыр':");
        for (Searchable result : searchEngine.search("сыр")) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }
}


