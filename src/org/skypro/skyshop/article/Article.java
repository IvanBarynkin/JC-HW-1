package org.skypro.skyshop.article;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable {

    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return text;
    }


    @Override
    public String searchContentType() {
        return "ARTICLE";
    }

    @Override
    public String searchTerm() {
        return this.toString();
    }

    @Override
    public String searchName() {
        return name;
    }

    public boolean equalsArticle(Article other) {
        return (this.getName().equals(other.getName()));
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }
}
