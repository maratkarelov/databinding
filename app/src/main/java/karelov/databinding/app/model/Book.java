package karelov.databinding.app.model;

import android.databinding.ObservableArrayList;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mustafa Ali on 11/03/15.
 */
public class Book {
    private VolumeInfo volumeInfo;
    private List<String> commentList = new ArrayList<>();

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public List<String> getCommentList() {
        return commentList;
    }

    public void enterComment(String comment) {
        if (commentList.size() == 0) {
            commentList.add("");
        }
        int pos = commentList.size() - 1;
        commentList.set(pos, comment);
    }

    public void newLineComment() {
        if (commentList.size() == 0) {
            commentList.add("");
        } else {
            if (!TextUtils.isEmpty(commentList.get(commentList.size() - 1))) {
                commentList.add("");
            }
        }
    }
}
