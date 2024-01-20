package com.example.slatkizalogaj.ui.pocetna;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.slatkizalogaj.R;

public class ImageAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImages = {R.drawable.torta, R.drawable.krofne, R.drawable.pletenica}; // Add your image resource IDs
    private String[] offers={"ponuda 1","ponuda 2", "ponuda 3"};

    public ImageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        FrameLayout frameLayout = new FrameLayout(mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        // Add ImageView for the image with rounded corners
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setImageResource(mImages[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setClipToOutline(true); // Enables clipping for rounded corners
//        imageView.setBackground(mContext.getResources().getDrawable(R.drawable.rounded_corners)); // Set rounded corners

        // Add TextView for the text
        TextView textView = new TextView(mContext);
        textView.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText(offers[position]); // Customize the text as needed
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.parseColor("#80000000")); // Semi-transparent background for better readability

        // Add the ImageView and TextView to the FrameLayout
        frameLayout.addView(imageView);
        frameLayout.addView(textView);

        // Add the FrameLayout to the container
        container.addView(frameLayout);

        return frameLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
