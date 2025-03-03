package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductBasket {

    private final ArrayList<Product> products;

    public ProductBasket() {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        products.add(product);
        System.out.println("Продукт добавлен в корзину.");
    }

    public ArrayList<Product> del(String nameOfProduct){
        ArrayList<Product> removedProducts = new ArrayList<>();
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product nextproduct = productIterator.next();
            if (nextproduct.getName().equals(nameOfProduct)) {
                removedProducts.add(nextproduct);
                productIterator.remove();
            }
        }
        return removedProducts;

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

    public void printBasket(){
        System.out.println(toString());
    }
}

