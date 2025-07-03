package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();

    String getType();

    String getName();

    default String getStringRepresentation() {
        return getName() + " — тип " + getType();
    }

    default boolean matches(String text) {
        return getSearchTerm().toLowerCase().contains(text.toLowerCase());
    }
}



