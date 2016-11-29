package karelov.databinding.app.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import karelov.databinding.BR;
import karelov.databinding.R;
import karelov.databinding.app.app.DataBindingApplication;
import karelov.databinding.app.model.Book;
import karelov.databinding.app.model.BookDetails;
import karelov.databinding.databinding.ActivityBookDetailsBinding;


public class BookDetailsActivity extends AppCompatActivity {
    public static final String BOOK_POSITION = "BOOK_POSITION";
    public static final String TOTAL_COUNT = "totalCount";
    ActivityBookDetailsBinding binding;
    private BookDetails mBookDetails = new BookDetails();
    public int mBookPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupActionBar();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book_details);
        binding.rvBookComments.setLayoutManager(new LinearLayoutManager(this));
        mBookPosition = getIntent().getIntExtra(BOOK_POSITION, 0);
        Book book = (DataBindingApplication.getInstance()).getBooks().get(mBookPosition);
        mBookDetails.setVolumeInfo(book.getVolumeInfo());
        mBookDetails.setIndex(mBookPosition);
        mBookDetails.setComments(book.getCommentList());
        binding.setBookDetails(mBookDetails);
        binding.setVariable(BR.totalCount, getIntent().getIntExtra(TOTAL_COUNT, 0));
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void onShowNextBook(View view) {
        mBookPosition = mBookPosition + 1;
        showBook();
    }

    public void onShowPreviousBook(View view) {
        mBookPosition = mBookPosition - 1;
        showBook();
    }

    private void showBook() {
        binding.etComment.setText("");
        mBookDetails.setIndex(mBookPosition);
        Book book = (DataBindingApplication.getInstance()).getBooks().get(mBookPosition);
        book.newLineComment();
        mBookDetails.setVolumeInfo(book.getVolumeInfo());
        mBookDetails.setComments(book.getCommentList());
    }

}
