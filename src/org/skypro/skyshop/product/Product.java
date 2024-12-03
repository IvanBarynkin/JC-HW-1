package org.skypro.skyshop.product;

public class Product {

    private final String name;
    private final int cost;

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
