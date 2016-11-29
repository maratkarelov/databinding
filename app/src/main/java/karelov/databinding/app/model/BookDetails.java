package karelov.databinding.app.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;


import java.util.ArrayList;
import java.util.List;

import karelov.databinding.BR;
import karelov.databinding.app.app.DataBindingApplication;


/**
 * Created by phanirajabhandari on 7/8/15.
 */
public class BookDetails extends BaseObservable {
    private VolumeInfo volumeInfo;
    private int index;
    private List<String> commentList = new ArrayList<>();

    @Bindable
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        notifyPropertyChanged(BR.index);
    }

    @Bindable
    public VolumeInfo getVolumeInfo() {
        return volumeInfo;

    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
        notifyPropertyChanged(BR.volumeInfo);
    }

    @Bindable
    public List<String> getCommentList() {
        return commentList;
    }

    public void setComments(List<String> comments) {
        commentList = comments;
        notifyPropertyChanged(BR.commentList);
    }

    @Bindable
    public TextWatcher getOnCommentChanged() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(editable.toString())) {
                    Book book = (DataBindingApplication.getInstance()).getBooks().get(index);
                    book.enterComment(editable.toString());
                    notifyPropertyChanged(BR.commentList);
                }
            }
        };

    }
}
