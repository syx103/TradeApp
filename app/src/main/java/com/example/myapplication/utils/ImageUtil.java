package com.example.myapplication.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class ImageUtil {
    @BindingAdapter({"imageUrl"})
    public static void GlideLoadImage(ImageView imageView, String url) {
        if (url != null) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .error(R.drawable.load_error)
                    .into(imageView);
        }
    }
}
