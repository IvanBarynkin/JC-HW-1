package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.discountedproduct.DiscountedProduct;
import org.skypro.skyshop.fixpriceproduct.FixPriceProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main() {

        //Создание различных типов продуктов
        System.out.println("//Создание различных продуктов");
        SimpleProduct first = new SimpleProduct("111", 100);
        System.out.println(first);
        FixPriceProduct second = new FixPriceProduct("222", 200);
        System.out.println(second);
        DiscountedProduct third = new DiscountedProduct("333", 400, 25);
        System.out.println(third);
        DiscountedProduct fourth = new DiscountedProduct("444", 800, 50);
        System.out.println(fourth);
        SimpleProduct fifth = new SimpleProduct("555", 1600);
        System.out.println(fifth);

        //Создание статей
        System.out.println("//Создание статей");
        Article firstA = new Article("111", "AAA");
        System.out.println(firstA);
        Article secondA = new Article("222", "BBB");
        System.out.println(secondA);

        //Создание статьи с "перевернутой" логикой полей для проверки алгоритма поиска
        System.out.println("//Создание статьи с \"перевернутой\" логикой полей для проверки алгоритма поиска");
        Article thirdA = new Article("CCC", "333");
        System.out.println(thirdA);

        //Создание пула объектов c количество ячеек 10 с возможностью поиска
        System.out.println("//Создание пула объектов c количество ячеек 10 с возможностью поиска");
        SearchEngine searchPull = new SearchEngine(10);

        //Добавление в пул раннее созданных объектов
        System.out.println("//Добавление в пул раннее созданных объектов");
        searchPull.add(first);
        searchPull.add(second);
        searchPull.add(third);
        searchPull.add(fourth);
        searchPull.add(fifth);

        searchPull.add(firstA);
        searchPull.add(secondA);
        searchPull.add(thirdA);

        //Поиск объектов по запросу "111"
        System.out.println("//Поиск объектов по запросу \"111\"");
        System.out.println(Arrays.toString(searchPull.search("111")));

        //Поиск объектов по запросу "AAA"
        System.out.println("//Поиск объектов по запросу \"AAA\"");
        System.out.println(Arrays.toString(searchPull.search("AAA")));

        //Поиск объектов по запросу "CCC"
        System.out.println("//Поиск объектов по запросу \"CCC\"");
        System.out.println(Arrays.toString(searchPull.search("CCC")));

        //Поиск объектов по запросу "333"
        System.out.println("//Поиск объектов по запросу \"333\"");
        System.out.println(Arrays.toString(searchPull.search("333")));
    }
}
