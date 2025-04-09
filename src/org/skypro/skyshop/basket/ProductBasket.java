package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductBasket {

    private final Map<String, ArrayList<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    public void add(Product product) {
        String key = product.getName();
        ArrayList<Product> productListByKey;
        if (products.containsKey(key)) {
            productListByKey = products.get(key);
        } else {
            productListByKey = new ArrayList<>();
        }
        productListByKey.add(product);
        products.put(key, productListByKey);
        System.out.println("Продукт добавлен в корзину.");
    }

    public List<Product> del(String nameOfProduct) {
        ArrayList<Product> removedProducts = products.get(nameOfProduct);
        products.remove(nameOfProduct);
        return removedProducts;
    }

    public int basketCost() {
        int allCost = 0;
        for (Map.Entry<String, ArrayList<Product>> productList : products.entrySet()) {
            for (Product product : productList.getValue()) {
                allCost += product.getCost();
            }
        }
        return allCost;
    }

    public boolean checkProduct(String name) {

        if (products.containsKey(name)) {
            System.out.println("Продукты с таким именем есть в корзине");
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        products.clear();
    }

    @Override

    public String toString() {
        if (products.isEmpty()) {
            return "В корзине пусто.";
        } else {
            String str = "";
            int specialProductAmount = 0;
            for (Map.Entry<String, ArrayList<Product>> productList : products.entrySet()) {
                str += "Продукты с именем " + productList.getKey() + ":" + "\n";
                for (Product product : productList.getValue()) {
                    str += "   " + product.toString() + ";" + "\n";
                }
            }
            str += "Итого: " + this.basketCost() + "\n";
            str += "Специальных товаров: " + specialProductAmount + "\n";
            return str;
        }
    }

    public void printBasket() {
        System.out.println(toString());
    }
}

