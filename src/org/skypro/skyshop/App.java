package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.discountedproduct.DiscountedProduct;
import org.skypro.skyshop.fixpriceproduct.FixPriceProduct;
import org.skypro.skyshop.searchEngine.BestResultNotFound;
import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main() {
        //Создание поискового пулла:
        System.out.println("//Создание поискового пулла:");
        SearchEngine Searcher = new SearchEngine();

        //Создание статей, 4-ая статья дубликат 2-ой:
        System.out.println("//Создание статей, 4-ая статья дубликат 2-ой:");
        Article article1 = new Article("OneOneOneOne", "1");
        Article article2 = new Article("OneOne", "11");
        Article article3 = new Article("OneOneOne", "111");
        Article article4 = new Article("OneOne", "222");
        Article article5 = new Article("OneTwo", "333");

        Searcher.add(article1);
        Searcher.add(article2);
        Searcher.add(article3);
        Searcher.add(article4);
        Searcher.add(article5);

        //Поиск статей с поисковым запросом One, обратите внимание, что дубликат (4-ая статья) не попал в поисковой пулл:
        System.out.println("//Поиск статей с поисковым запросом One, обратите внимание, что дубликат (4-ая статья) не попал в поисковой пулл:");
        System.out.println(Searcher.search("One"));


    }
}
