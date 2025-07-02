package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> items = new ArrayList<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : items) {
            if (item.getStringRepresentation().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }
}