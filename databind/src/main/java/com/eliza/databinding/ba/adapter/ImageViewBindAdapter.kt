package com.eliza.databinding.ba.adapter

import android.graphics.Color
import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.android.databinding.R
import com.squareup.picasso.Picasso


class ImageViewBindAdapter {
    companion object {
        @JvmStatic // must be Static -->JvmStatic this true  static
        @BindingAdapter("app:Image") // ==> <ImageView     app:Image=""
        //need net permission
        fun setImage(imageView: ImageView, url: String) {
            if (!TextUtils.isEmpty(url)) {
                Picasso.get().load(url)
                    .placeholder(R.drawable.ic_whatshot_black_96dp)
                    .into(imageView)

                /*
                   or use:
                   Glide.with(imageView)
                          .load(url)
                          .into(imageView)*/
            } else {
                imageView.setBackgroundColor(Color.GRAY)
            }
        }

        @JvmStatic
        @BindingAdapter("app:Image")
        fun setImage(imageView: ImageView, url: Int) {
            imageView.setImageResource(url)
        }

        @JvmStatic
        @BindingAdapter("app:Image", "defaultImageRes", requireAll = false)
        fun setImage(imageView: ImageView, url: String, res: Int) {
            if (!TextUtils.isEmpty(url)) {
                Picasso.get().load(url)
                    .placeholder(R.drawable.ic_whatshot_black_96dp)
                    .into(imageView)

                /*
                   or use:
                   Glide.with(imageView)
                          .load(url)
                          .into(imageView)*/
            } else {
                imageView.setImageResource(res)

            }

        }
    }

}

/*
 if don't want  to use  @JvmStatic // must be Static
 just like this
 */
//File name + kt，对应的方法为static final
@BindingAdapter("Imagekt") // ==> <ImageView     app:ImageKt=""
fun setImageKt(imageView: ImageView, url: String) {
    if (!TextUtils.isEmpty(url)) {
        Glide.with(imageView)
            .load(url)
            .into(imageView)
    } else {
        imageView.setBackgroundColor(Color.GRAY)
    }
}