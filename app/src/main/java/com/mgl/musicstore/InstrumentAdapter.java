package com.mgl.musicstore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Created by Migs on 18/11/2017.
 */

class InstrumentAdapter extends BaseAdapter {
    private Context context;
    private List<Instrument> instrument;
    private Integer[] thumbsId = {
            R.drawable.instru_1,
            R.drawable.instru_2,
            R.drawable.instru_3,
            R.drawable.instru_4,
            R.drawable.instru_5,
            R.drawable.instru_6,
    };

    public InstrumentAdapter(Context context, List<Instrument> instrument) {
        this.context = context;
        this.instrument = instrument;
    }

    @Override
    public int getCount() {
        return instrument.size();
    }

    @Override
    public Object getItem(int i) {
        return instrument.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridView;

        LayoutInflater inflater = LayoutInflater.from(context);
        if (view == null) {
            gridView = inflater.inflate(R.layout.instrument_item, null);
            TextView modeloInstrumento = (TextView) gridView.findViewById(R.id.nomeInstrumento);
            TextView marcaInstrumento = (TextView) gridView.findViewById(R.id.marcaInstrumento);
            TextView precoInstrumento = (TextView) gridView.findViewById(R.id.valorInstrumento);

            modeloInstrumento.setText(this.instrument.get(i).getModelo());
            marcaInstrumento.setText(this.instrument.get(i).getMarca());
            precoInstrumento.setText(String.format(new Locale("pt", "BR"), "R$ %,.2f",this.instrument.get(i).getPreco()));
            ImageView imageView = (ImageView) gridView.findViewById(R.id.imgInstrumento);
            imageView.setImageResource(thumbsId[i]);
        } else {
            gridView = (View) view;
        }

        return gridView;
    }
}
