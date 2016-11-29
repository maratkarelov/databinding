package karelov.databinding.app.app;

import android.app.Application;


import java.util.List;

import karelov.databinding.BuildConfig;
import karelov.databinding.app.model.Book;
import timber.log.Timber;

/**
 * Created by Mustafa Ali on 11/03/15.
 */
public class DataBindingApplication extends Application {
    private static DataBindingApplication sInstance;
    private List<Book> mBooks;

    public static DataBindingApplication getInstance() {
        if (sInstance == null) {
            sInstance = new DataBindingApplication();
        }
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public List<Book> getBooks() {
        return mBooks;
    }

    public void setBooks(List<Book> mResultsist) {
        this.mBooks = mResultsist;
    }

}