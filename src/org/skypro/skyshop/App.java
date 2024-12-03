package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.discountedproduct.DiscountedProduct;
import org.skypro.skyshop.fixpriceproduct.FixPriceProduct;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

public class App {
    public static void main() {

        //Создание обычных и специальных продуктов:
        System.out.println("//Создание продуктов:");

        SimpleProduct first = new SimpleProduct("one", 100);
        FixPriceProduct second = new FixPriceProduct("two", 200);
        DiscountedProduct third = new DiscountedProduct("three", 400, 25);
        DiscountedProduct fourth = new DiscountedProduct("four", 800, 50);
        SimpleProduct fifth = new SimpleProduct("five", 1600);

        //Создание корзины:
        System.out.println("//Создание корзины:");
        ProductBasket basket = new ProductBasket(5);

        //Добавление продуктов в корзину:
        System.out.println("//Добавление продуктов в корзину:");
        basket.addProduct(first);
        basket.addProduct(second);
        basket.addProduct(third);
        basket.addProduct(fourth);
        basket.addProduct(fifth);

        //Проверка методов получения объекта в виде строки:
        System.out.println("//Проверка методов получения объекта в виде строки:");
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
        System.out.println(fifth);


        //Печать содержимого корзины
        System.out.println("//Печать содержимого корзины");
        System.out.print(basket);


    }
}
