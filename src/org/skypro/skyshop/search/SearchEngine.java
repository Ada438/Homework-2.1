package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
        this.size = 0;
    }

    public void add(Searchable item) {
        if (size < items.length) {
            items[size++] = item;
        }
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] results = new Searchable[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results[count++] = items[i];
            }
        }

        Searchable[] trimmed = new Searchable[count];
        System.arraycopy(results, 0, trimmed, 0, count);
        return trimmed;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        int maxCount = 0;
        Searchable bestMatch = null;

        for (int i = 0; i < size; i++) {
            String term = items[i].getSearchTerm();
            int count = countOccurrences(term.toLowerCase(), search.toLowerCase());
            if (count > maxCount) {
                maxCount = count;
                bestMatch = items[i];
            }
        }

        if (bestMatch == null || maxCount == 0) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }
}