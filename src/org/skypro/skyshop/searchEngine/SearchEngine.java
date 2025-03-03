package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;

public class SearchEngine {
    private final ArrayList<Searchable> searchablePull;

    public SearchEngine() {
        this.searchablePull = new ArrayList<>();
    }

    public void add(Searchable addSearchableUnit) {
        this.searchablePull.add(addSearchableUnit);
    }

    public ArrayList<Searchable> search(String searchTerm) {
        ArrayList<Searchable> searchResult = new ArrayList<>();
        for (Searchable searchObject : searchablePull) {
            if (searchObject == null) {
                continue;
            }
            if ((searchObject.searchTerm()).contains(searchTerm)) {
                searchResult.add(searchObject);
            }
        }
        return searchResult;
    }


    public Searchable searchCoincidence(String search) throws BestResultNotFound {
        int IndexObjectMaxCoincidences = 0;
        int maxCoincidence = 0;
        for (int i = 0; i < searchablePull.size(); i++) {
            String str = searchablePull.get(i).searchTerm();
            int coincidence = 0;
            int strIndex = 0;
            int subStrIndex = str.indexOf(search, strIndex);
            while (subStrIndex != -1) {
                coincidence++;
                strIndex += search.length();
                subStrIndex = str.indexOf(search, strIndex);
            }
            if (coincidence > maxCoincidence) {
                maxCoincidence = coincidence;
                IndexObjectMaxCoincidences = i;
            }
        }
        if (maxCoincidence == 0) {
            throw new BestResultNotFound("По запросу \"" + search + "\" не найдено результатов.");
        } else {
            return searchablePull.get(IndexObjectMaxCoincidences);
        }
    }
}
