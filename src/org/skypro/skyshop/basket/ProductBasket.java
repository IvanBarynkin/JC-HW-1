package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchEngine.SearchPullComparator;

import java.util.*;
import java.util.stream.Collectors;

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

        return products.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(product -> !Objects.equals(product.getName(), nameOfProduct))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int basketCost() {

        /*return products.values()
                .stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getCost)
                .sum();*/

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
        }
        else{
            int specialProductAmount = 0;
            return products.values()
                    .stream()
                    .flatMap(Collection::stream)
                    .map(Product::toString)
                    .collect(Collectors.joining("\n")) +
                    "\n" + "Итого: " + basketCost() + "\n" +
                    "Специальных товаров: " + specialProductAmount + "\n";


        }
    }

    protected int getSpecialCount(){
           return products.values()
                   .stream()
                   .flatMap(Collection::stream)
                   .mapToInt(p -> p.isSpecial()? 1:0)
                   .sum();

    }

    public void printBasket() {
        System.out.println(toString());
    }
}

