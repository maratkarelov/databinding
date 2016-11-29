package karelov.databinding.app.Binding;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.List;

import karelov.databinding.app.adapter.CommentsRecyclerAdapter;

/**
 * Created by phanirajabhandari on 7/8/15.
 */
public class CustomBindingAdapter {


    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter("bind:visibilityOnIndex")
    public static void toggleVisibility(View view, int visiblity) {
        view.setVisibility(visiblity);
    }

    @BindingAdapter("bind:items")
    public  static void bindList(RecyclerView view, List<String> list) {
        CommentsRecyclerAdapter adapter = new CommentsRecyclerAdapter(list);
        view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
