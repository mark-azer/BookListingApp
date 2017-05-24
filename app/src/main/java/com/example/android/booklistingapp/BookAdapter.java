package com.example.android.booklistingapp;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class BookAdapter extends ArrayAdapter<Book> {

    /**
     * Constructs a new {@link BookAdapter}
     *
     * @param context context of the app
     * @param books the list of books, which is the data source of the adapter
     */
    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    /**
     * Returns a list item view that displays information about the book at the given position
     * in the list of books.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }

        // Find the book at the given position in the list of books
        Book currentBook = getItem(position);

        // Find the TextView with view ID book_title
        TextView titleView = (TextView) listItemView.findViewById(R.id.book_title);

        // Set the text of the Title View to the title of the current book
        titleView.setText(currentBook.getTitle());

        // Find the TextView with view ID book_authors
        TextView authorsView = (TextView) listItemView.findViewById(R.id.book_authors);

        // Get the array of author names for the current book
        String[] authors = currentBook.getAuthors();

        // Display a max of 3 authors
        String authorsText = "";
        if (authors.length <= 3) {
            for (int i = 0; i < authors.length; i++) {
                authorsText += authors[i];
                if (i == authors.length - 1) {
                    break;
                }
                authorsText += ", ";
            }
        } else {
            for (int i = 0; i < 3; i++) {
                authorsText += authors[i];
                if (i == 2) {
                    break;
                }
                authorsText += ", ";
            }
            authorsText += ",...";
        }

        // Set the text of the Authors View to the names of the authors of the current book separated by commas
        authorsView.setText(authorsText);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
