package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.discountedproduct.DiscountedProduct;
import org.skypro.skyshop.fixpriceproduct.FixPriceProduct;
import org.skypro.skyshop.searchEngine.BestResultNotFound;
import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main() {

        //Создание различных продуктов и статей
        System.out.println("Создание различных продуктов и статей");
        SimpleProduct first = new SimpleProduct("one", 100);
        DiscountedProduct second = new DiscountedProduct("two", 200, 50);
        FixPriceProduct third = new FixPriceProduct("three", 300);
        SimpleProduct fourth = new SimpleProduct("one", 400);
        Article articleOne = new Article("A one", "search");
        Article articleTwo = new Article("A two", "search search");

        //Создание корзины
        System.out.println("Создание корзины");
        ProductBasket basket = new ProductBasket();

        //Отображение корзины
        System.out.println("Отображение корзины");
        basket.printBasket();

        //Добавление продуктов в корзину
        System.out.println("Добавление продуктов в корзину");
        basket.add(first);
        basket.add(second);
        basket.add(third);
        basket.add(fourth);

        //Отображение корзины
        System.out.println("Отображение корзины");
        basket.printBasket();

        //Отображение списка продуктов, удаленных из корзины
        System.out.println("Отображение списка продуктов, удаленных из корзины");
        System.out.println(basket.del("one"));

        //Отображение корзины
        System.out.println("Отображение корзины");
        basket.printBasket();


        //Попытка удаления несуществующего продукта и последующая "проверка пустоты" возвращаемого списка
        System.out.println("Попытка удаления несуществующего продукта и последующая \"проверка пустоты\" возвращаемого списка");

        if (basket.del("five").isEmpty()) {
            System.out.println("Список пуст!");
        }

        //Отображение корзины
        System.out.println("Отображение корзины");
        basket.printBasket();

        //Создаем поисковой пулл
        System.out.println("//Создаем поисковой пулл.");
        SearchEngine Searcher = new SearchEngine();

        //Заполнение пулла
        System.out.println("Заполнение пулла");
        Searcher.add(first);
        Searcher.add(second);
        Searcher.add(third);
        Searcher.add(fourth);
        Searcher.add(articleOne);
        Searcher.add(articleTwo);

        //Поиск объектов
        System.out.println("Поиск объектов");
        try {
            System.out.println(Searcher.searchCoincidence("two"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        try {
            System.out.println(Searcher.searchCoincidence("A three"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        System.out.println(Searcher.search("two"));
    }
}
