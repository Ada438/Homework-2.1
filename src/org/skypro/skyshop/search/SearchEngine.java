package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> items = new ArrayList<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Map<String, Searchable> search(String text) {
        Map<String, Searchable> result = new TreeMap<>();
        for (Searchable s : items) {
            if (s.matches(text)) {
                result.put(s.getName(), s);
            }
        }
        return result;
    }

}