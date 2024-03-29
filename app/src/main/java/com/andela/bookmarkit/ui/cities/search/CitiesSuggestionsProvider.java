package com.andela.bookmarkit.ui.cities.search;


import android.content.SearchRecentSuggestionsProvider;

public class CitiesSuggestionsProvider extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY = "com.andela.bookmarkit.ui.cities.search.CitiesSuggestionsProvider";
    public static final int MODE = DATABASE_MODE_QUERIES;

    public CitiesSuggestionsProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
