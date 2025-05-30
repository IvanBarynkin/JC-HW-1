package org.skypro.skyshop.product;

import org.skypro.skyshop.InputChecks.InputChecks;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable, InputChecks {

    protected String name;

    public Product(String name) {
        try {
            checkName(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
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


    public boolean equalsProduct(Product other) {
        return (this.getName().equals(other.getName()));
    }

    public abstract int getCost();

    public boolean isSpecial() {
        return false;
    }

    public String getName() {
        return name;
    }
}
