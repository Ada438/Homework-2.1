package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size < items.length) {
            items[size] = item;
            size++;
        } else {
            System.out.println("SearchEngine is full");
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (int i = 0; i < size && count < 5; i++) {
            if (items[i].getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results[count++] = items[i];
            }
        }
        return results;
    }
}
