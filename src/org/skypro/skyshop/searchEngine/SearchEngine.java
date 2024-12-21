package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.searchable.Searchable;

public class SearchEngine {
    Searchable[] searchablePull;
    static int count = 0;

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
        this.searchablePull[count] = addSearchableUnit;
        count++;
    }
}
