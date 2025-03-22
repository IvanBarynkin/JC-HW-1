package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Comparator;

public class SearchPullComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int l1 = o1.searchName().length();
        int l2 = o2.searchName().length();
        if (Integer.compare(l1, l2) == 0){
            return o1.compareTo(o2);
        }else{
            return Integer.compare(l1, l2);
        }
    }
}
