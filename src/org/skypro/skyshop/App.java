package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.discountedproduct.DiscountedProduct;

import org.skypro.skyshop.product.Product;

import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main() {
        //Создание поискового пула и корзины продуктов:
        System.out.println("//Создание поискового пула и корзины продуктов:");
        SearchEngine Searcher = new SearchEngine();
        ProductBasket basket = new ProductBasket();

        //Создание продуктов, добавление в пул и корзину:
        System.out.println("//Создание продуктов, добавление в пул и корзину:");
        Product p1 = new SimpleProduct("1", 100);
        Product p2 = new SimpleProduct("2", 200);
        Product p3 = new SimpleProduct("3", 300);
        Product p4 = new SimpleProduct("4", 400);
        Product p5 = new DiscountedProduct("51", 500, 50);

        Searcher.add(p1);
        Searcher.add(p2);
        Searcher.add(p3);
        Searcher.add(p4);
        Searcher.add(p5);

        basket.add(p1);
        basket.add(p2);
        basket.add(p3);
        basket.add(p4);
        basket.add(p5);

        //Поиск объектов, содержащих "1":
        System.out.println("//Поиск объектов, содержащих \"1\":");
        System.out.println(Searcher.search("1"));

        //Вывод списка продуктов корзине (проверка второй части работы, в вывод входит отображение списка продуктов, количество особых товаров и общая стоимость товаров:
        System.out.println("//Вывод списка продуктов корзине (проверка второй части работы, в вывод входит отображение списка продуктов, количество особых товаров и общая стоимость товаров:");
        System.out.println(basket.toString());


    }
}
