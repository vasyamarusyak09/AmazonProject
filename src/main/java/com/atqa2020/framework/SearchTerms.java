package com.atqa2020.framework;

public enum SearchTerms {

    LAPTOP("laptop"),
    TABLET("tablet"),
    VACUUM_CLEANER("vacuum cleaner"),
    MOUSE("mouse");

    private final String searchTerm;

    SearchTerms(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }
}
