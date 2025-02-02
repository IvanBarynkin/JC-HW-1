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






        //Создание различных продуктов и статей.
        System.out.println("//Создание различных продуктов, проверка правильности заполнения полей.");
        SimpleProduct first = new SimpleProduct("one", 100);
        DiscountedProduct second = new DiscountedProduct("two", 200, 50);
        FixPriceProduct third = new FixPriceProduct("three", 300);
        Article articleOne = new Article("A one", "search");
        Article articleTwo = new Article("A two", "search search");


        //Создаем поисковой пулл.
        System.out.println("//Создаем поисковой пулл.");
        SearchEngine Searcher = new SearchEngine();

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
        System.out.println(Searcher.search("two"));
    }
}
