package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main() {

        //Создание продуктов:
        System.out.println("//Создание продуктов:");
        Product first = new Product("one", 1);
        Product second = new Product("two", 2);
        Product third = new Product("three", 4);
        Product fourth = new Product("four", 8);
        Product fifth = new Product("five", 16);

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

        //Добавление продукта в заполненную корзину, в которой нет свободного места:
        System.out.println("//Попытка добавить продукт в уже полностью заполненную корзину:");
        Product sixth = new Product("six", 32);
        basket.addProduct(sixth);

        //Печать содержимого корзины с несколькими товарами:
        System.out.println("//Вывод списка наполненной корзины:");
        basket.toString();

        //Получение стоимости корзины с несколькими товарами:
        System.out.println("//Получение стоимости корзины с несколькими товарами:");
        System.out.println(basket.basketCost());

        //Поиск товара, который есть в корзине:
        System.out.println("//Поиск товара, который есть в корзине:");
        basket.checkProduct("one");

        //Поиск товара, которого нет в корзине:
        System.out.println("//Поиск товара, которого нет в корзине:");
        basket.checkProduct("six");

        //Очистка корзины:
        System.out.println("//Очистка корзины:");
        basket.clear();

        //Печать содержимого пустой корзины:
        System.out.println("//Печать содержимого пустой корзины:");
        basket.toString();

        //Получение стоимости пустой корзины:
        System.out.println("//Получение стоимости пустой корзины:");
        System.out.println(basket.basketCost());

        //Поиск товара по имени в пустой корзине:
        System.out.println("//Поиск товара в пустой корзине:");
        basket.checkProduct("one");
    }
}
