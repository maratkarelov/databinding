package karelov.databinding.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mustafa Ali on 11/03/15.
 */
public class SearchResults {
    public int totalItems;
    @SerializedName("items")
    public List<Book> books;
}
