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


        /*Добрый день!
        Попробовал в этом задании применить знания на тему интерфейсов.
        Реализовал проверку правильности заполнения полей через интерфейс.
         */

        //Создание различных продуктов, проверка правильности заполнения полей.
        System.out.println("//Создание различных продуктов, проверка правильности заполнения полей.");
        SimpleProduct firstIncorrect = new SimpleProduct("", 100);
        DiscountedProduct secondIncorrect = new DiscountedProduct("two", 200, 1000);
        FixPriceProduct thirdIncorrect = new FixPriceProduct("three", -100);

        //Создание различных продуктов с правильно заполненными полями.
        System.out.println("//Создание различных продуктов, проверка правильности заполнения полей.");
        SimpleProduct first = new SimpleProduct("one", 100);
        DiscountedProduct second = new DiscountedProduct("two", 200, 50);
        FixPriceProduct third = new FixPriceProduct("three", 300);


        //Создаем поисковой пулл на 5 мест и заполняем 3 объектами типа Товар и 2 объектами типа Статья.
        System.out.println("//Создаем поисковой пулл на 5 мест и заполняем 3 объектами типа Товар и 2 объектами типа Статья.");
        SearchEngine Searcher = new SearchEngine(5);

        Article articleOne = new Article("A one", "search");
        Article articleTwo = new Article("A two", "search search");

        Searcher.add(first);
        Searcher.add(second);
        Searcher.add(third);
        Searcher.add(articleOne);
        Searcher.add(articleTwo);

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
    }
}
