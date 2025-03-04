package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.searchable.Searchable;


import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class SearchEngine {
    private final Set<Searchable> searchablePull;

    public SearchEngine() {
        this.searchablePull = new HashSet<>();
    }

    public void add(Searchable addSearchableUnit) {
        this.searchablePull.add(addSearchableUnit);
    }

    public Set<Searchable> search(String searchTerm) {
        TreeSet<Searchable> searchResult = new TreeSet<>(new SearchPullComparator());
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
        Searchable ObjectOfMaxCoincidences = null;
        int maxCoincidence = 0;
        for (Searchable searchable : searchablePull) {
            String str = searchable.searchTerm();
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
                ObjectOfMaxCoincidences = searchable;
            }
        }
        if (maxCoincidence == 0) {
            throw new BestResultNotFound("По запросу \"" + search + "\" не найдено результатов.");
        } else {
            return ObjectOfMaxCoincidences;
        }
    }

    public void clear() {
        searchablePull.clear();
    }
}
