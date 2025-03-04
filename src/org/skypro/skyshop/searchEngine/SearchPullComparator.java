package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Comparator;

public class SearchPullComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        return -1 * Integer.compare(o1.searchName().length(), o2.searchName().length());
    }
}
