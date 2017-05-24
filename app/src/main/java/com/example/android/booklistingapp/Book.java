package com.example.android.booklistingapp;

import java.io.Serializable;

/**
 * An {@link Book} object contains information related to a single book.
 */
public class Book implements Serializable {

    /** Title of the book */
    private String mTitle;

    /** Authors of the book */
    private String[] mAuthors;


    /** Website URL of the book */
    private String mUrl;

    /**
     * Constructs a new {@link Book} object.
     *
     * @param title title of the book
     * @param authors array of the book's author names
     * @param url the website URL to find more details about the book
     */
    public Book(String title, String[] authors, String url) {
        mTitle = title;
        mAuthors = authors;
        mUrl = url;
    }

    /**
     * Returns the title of the book.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the names of the authors of the book.
     */
    public String[] getAuthors() {
        return mAuthors;
    }

    /**
     * Returns the website URL to find more information about the book.
     */
    public String getUrl() {
        return mUrl;
    }
}
