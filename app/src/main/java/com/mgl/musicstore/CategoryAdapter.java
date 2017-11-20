package com.mgl.musicstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Migs on 18/11/2017.
 */

class CategoryAdapter extends BaseAdapter {
    private Context context;
    private Integer[] thumbsId = {
            R.drawable.category_1,
            R.drawable.category_2,
            R.drawable.category_3,
            R.drawable.category_4,
            R.drawable.category_2
    };

    private String[] titles = {
            "Guitarras", "Baixos", "Teclados", "Pedaleiras", "Violões"
    };


    public CategoryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return thumbsId.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridView;

        LayoutInflater inflater = LayoutInflater.from(context);
        if (view == null) {
            gridView = inflater.inflate(R.layout.category_item, null);
            ImageView imageView = (ImageView) gridView.findViewById(R.id.imgCategory);
            imageView.setImageResource(thumbsId[i]);
            TextView title = (TextView) gridView.findViewById(R.id.titleCategory);
            title.setText(titles[i]);
        } else {
            gridView = (View) view;
        }

        return gridView;
    }
}
