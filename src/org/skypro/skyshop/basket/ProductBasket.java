package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;

public class ProductBasket {

    private final ArrayList<Product> products;
    private final int size;

    public ProductBasket(int size) {
        this.size = size;
        products = new ArrayList<>(size);
    }

    public void addProduct(Product product) {
        if (products.size() < size) {
            products.add(product);
        } else {
            System.out.println("Корзина заполнена!");
        }
    }

    public int basketCost() {
        int allCost = 0;
        for (Product product : products) {
            allCost += product.getCost();
        }
        return allCost;
    }

    public boolean checkProduct(String name) {

        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
            return false;
        }
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println("Такой товар есть в корзине.");
                return true;
            }
        }
        System.out.println("Такого товара нет в корзине.");
        return false;
    }

    public void clear() {
        products.clear();
    }

    @Override

    public String toString() {
        if (products.isEmpty()) {
            return "В корзине пусто.";
        }
        String str = "";
        int specialProductAmount = 0;
        for (Product product : products) {
            if (product.isSpecial()) {
                specialProductAmount++;
            }
            str += product + "\n";
        }
        str += "Итого: " + this.basketCost() + "\n";
        str += "Специальных товаров: " + specialProductAmount + "\n";
        return str;
    }
}

