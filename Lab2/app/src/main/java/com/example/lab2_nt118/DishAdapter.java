package com.example.lab2_nt118;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DishAdapter extends BaseAdapter {
    private final Context context;
    private final List<Dish> dishes;

    public DishAdapter(Context context, List<Dish> dishes) {
        this.context = context;
        this.dishes = dishes;
    }

    @Override
    public int getCount() {
        return dishes.size();
    }

    @Override
    public Object getItem(int position) {
        return dishes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_dish, parent, false);
        }

        Dish dish = (Dish) getItem(position);

        TextView tvName = convertView.findViewById(R.id.item_dish_tv_name);
        ImageView ivThumbnail = convertView.findViewById(R.id.item_dish_iv_thumbnail);
        ImageView ivPromotion = convertView.findViewById(R.id.item_dish_iv_promotion);

        tvName.setText(dish.getName());
        ivThumbnail.setImageResource(dish.getThumbnail());

        if (dish.hasPromotion()) {
            ivPromotion.setVisibility(View.VISIBLE);
        } else {
            ivPromotion.setVisibility(View.GONE);
        }

        return convertView;
    }
}
