package org.skypro.skyshop.search;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class SearchEngine {
    private final Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String text) {
        Set<Searchable> result = new TreeSet<>(new SearchableComparator());
        for (Searchable s : items) {
            if (s.getName().toLowerCase().contains(text.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }
}