package org.skypro.skyshop.search;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> items = new TreeSet<>(Comparator.comparing(Searchable::getName));

    public void add(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String text) {
        return items.stream()
                .filter(s -> s.getStringRepresentation().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Searchable::getName))));
    }
}

