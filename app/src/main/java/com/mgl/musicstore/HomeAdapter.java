package com.mgl.musicstore;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Migs on 20/11/2017.
 */

public class HomeAdapter extends BaseAdapter {
    protected Context context;
    private String[] news = {
            "Violão Folk Hofma HMF 250 Mahogany Fosco, Cordas de Aço, Elétrico e com Afinador",
            "Violão Clave Estudante Natural Fosco - Acústico, com Cordas de Nylon ",
            "Guitarra Strato Memphis MG 32 - Preta",
            "Teclado Casio CTK-7200 K2, 61 Teclas, c/Fonte Bivolt e Teclas Sensitivas",
    };
    private String[] price = {
            "R$ 800,00",
            "R$ 540,00",
            "R$ 180,00",
            "R$ 650,00",
    };
    private Integer[] thumbsId = {
            R.drawable.instru_4,
            R.drawable.instru_4,
            R.drawable.instru_3,
            R.drawable.instru_5
    };

    @Override
    public int getCount() {
        return thumbsId.length;
    }

    @Override
    public Object getItem(int i) {
        return thumbsId[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View listView;

        LayoutInflater inflater = LayoutInflater.from(context);
        if (view == null) {

            listView = inflater.inflate(R.layout.home_item, null);
            ImageView imageView = (ImageView) listView.findViewById(R.id.homeImg);
            imageView.setImageResource(thumbsId[i]);
            TextView homeTitle = (TextView) listView.findViewById(R.id.homeTitle);
            homeTitle.setText(news[i]);
            TextView desc = (TextView) listView.findViewById(R.id.homeDesc);
            desc.setText(price[i]);
        } else {
            listView = (View) view;
        }

        return listView;
    }
}
