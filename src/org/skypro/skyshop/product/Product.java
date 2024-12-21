package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable {

    protected String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String searchContentType() {
        return "PRODUCT";
    }

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String searchName() {
        return name;
    }

    public abstract int getCost();

    public boolean isSpecial() {
        return false;
    }

    public String getName() {
        return name;
    }
}
