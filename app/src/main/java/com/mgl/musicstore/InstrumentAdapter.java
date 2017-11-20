package com.mgl.musicstore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Migs on 18/11/2017.
 */

class InstrumentAdapter extends BaseAdapter {
    private Context context;
    private Integer[] thumbsId = {
            R.drawable.instru_1,
            R.drawable.instru_2,
            R.drawable.instru_3,
            R.drawable.instru_4,
            R.drawable.instru_5,
            R.drawable.instru_6,
    };

    public InstrumentAdapter(Context context) {
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
            gridView = inflater.inflate(R.layout.instrument_item, null);
            ImageView imageView = (ImageView) gridView.findViewById(R.id.imgInstrumento);
            imageView.setImageResource(thumbsId[i]);
        } else {
            gridView = (View) view;
        }

        return gridView;
    }
}
