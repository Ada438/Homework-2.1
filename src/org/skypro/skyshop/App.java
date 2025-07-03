package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new DiscountedProduct("Хлеб", 40, 10);
        Product milk = new FixPriceProduct("Молоко");
        Product cheese = new SimpleProduct("Сыр", 120);
        Product butter = new DiscountedProduct("Масло", 90, 15);
        Product chocolate = new SimpleProduct("Шоколад", 130);
        try {
            Product p1 = new SimpleProduct("  ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product p2 = new SimpleProduct("Рис", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product p3 = new DiscountedProduct("Сок", 90, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product p4 = new DiscountedProduct(null, 90, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        basket.add(apple);
        basket.add(bread);
        basket.add(milk);
        basket.add(cheese);
        basket.add(butter);
        basket.add(chocolate);

        System.out.println("Первичное содержимое корзины:");
        basket.printBasket();

        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        System.out.println("Есть ли Хлеб в корзине? " + basket.hasProduct("Хлеб"));
        System.out.println("Есть ли Сникерс в корзине? " + basket.hasProduct("Сникерс"));


        System.out.println("\nУдаление продуктов с именем 'Молоко':");
        List<Product> removedMilk = basket.removeByName("Молоко");
        if (removedMilk.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product product : removedMilk) {
                System.out.println("Удалён: " + product.getName());
            }
        }

        System.out.println("Содержимое корзины после удаления 'Молоко':");
        basket.printBasket();

        System.out.println("\nУдаление продуктов с именем 'Колбаса':");
        List<Product> removedSausage = basket.removeByName("Колбаса");
        if (removedSausage.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product product : removedSausage) {
                System.out.println("Удалён: " + product.getName());
            }
        }

        System.out.println("Содержимое корзины после удаления 'Колбаса':");
        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine();

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

        System.out.println("\nРезультаты поиска по слову 'молоко':");
        Map<String, Searchable> milkResults = searchEngine.search("молоко");
        if (milkResults.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Searchable result : milkResults.values()) {
                System.out.println(result.getStringRepresentation());
            }
        }

        System.out.println("\nРезультаты поиска по слову 'хлеб':");
        Map<String, Searchable> breadResults = searchEngine.search("хлеб");
        for (Searchable result : breadResults.values()) {
            System.out.println(result.getStringRepresentation());
        }

        System.out.println("\nРезультаты поиска по слову 'сыр':");
        Map<String, Searchable> cheeseResults = searchEngine.search("сыр");
        for (Searchable result : cheeseResults.values()) {
            System.out.println(result.getStringRepresentation());
        }

        basket.clear();

            System.out.println("После очистки корзины:");
            basket.printBasket();
            System.out.println("Общая стоимость: " + basket.getTotalPrice());

        }
    }


