package org.skypro.skyshop.product;

public abstract class Product {

    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract int getCost();

    public abstract boolean isSpecial();

    public String getName() {
        return name;
    }
}
