package org.skypro.skyshop.product;

public abstract class Product {

    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract int getCost();

    public boolean isSpecial() {
        return false;
    }

    public String getName() {
        return name;
    }
}
