package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.searchable.Searchable;

public class SearchEngine {
    private final Searchable[] searchablePull;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchablePull = new Searchable[size];
    }

    public Searchable[] search(String searchTerm) {
        int amountOfCoincidence = 0;
        int maxAmountOfCoincidence = 5;
        Searchable[] searchResult = new Searchable[maxAmountOfCoincidence];
        for (Searchable searchObject : searchablePull) {
            if (searchObject == null) {
                continue;
            }
            if ((searchObject.searchTerm()).contains(searchTerm)) {
                searchResult[amountOfCoincidence] = searchObject;
                amountOfCoincidence++;
            }
            if (amountOfCoincidence == maxAmountOfCoincidence) {
                break;
            }
        }
        return searchResult;
    }

    public void add(Searchable addSearchableUnit) {
        if (count == searchablePull.length) {
            System.out.println("Пулл поиска заполнен!");
        } else {
            this.searchablePull[count] = addSearchableUnit;
            count++;
        }
    }

    public Searchable searchCoincidence(String search) throws BestResultNotFound {
        int IndexObjectMaxCoincidences = 0;
        int maxCoincidence = 0;
        for (int i = 0; i < searchablePull.length; i++) {
            String str = searchablePull[i].searchTerm();
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
            return searchablePull[IndexObjectMaxCoincidences];
        }
    }
}
