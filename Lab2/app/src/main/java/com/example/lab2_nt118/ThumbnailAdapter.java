package com.example.lab2_nt118;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    private final Context context;

    public ThumbnailAdapter(Context context) {
        super(context, 0, Thumbnail.values());
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    private View createView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_thumbnail, parent, false);
        }

        Thumbnail thumbnail = getItem(position);
        TextView tvName = convertView.findViewById(R.id.item_thumbnail_tv_name);
        ImageView ivThumbnail = convertView.findViewById(R.id.item_thumbnail_iv_thumbnail);

        tvName.setText(thumbnail.getName());
        ivThumbnail.setImageResource(thumbnail.getImg());

        return convertView;
    }
}
