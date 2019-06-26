package com.compliance.petrobras.apco.helper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private List<Integer> imgIds;
    private Context context;

    public ImageAdapter(List<Integer> imgIds, Context context) {
        this.imgIds = imgIds;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return imgIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = (ImageView) convertView;

        if(imageView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 233));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        imageView.setImageResource(imgIds.get(position));

        return imageView;
    }
}
