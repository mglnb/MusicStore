package com.mgl.musicstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class OfferActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;
    private ImageView imageView;
    private TextView txtModelo;
    private TextView txtMarca;
    private TextView txtCor;
    private TextView txtPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        imageView = (ImageView)findViewById(R.id.imageView);
        edtNome = (EditText)findViewById(R.id.edtNome);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtTelefone = (EditText)findViewById(R.id.edtTelefone);
        txtModelo = (TextView) findViewById(R.id.txtModeloOffer);
        txtCor = (TextView) findViewById(R.id.txtCorOffer);
        txtPreco = (TextView) findViewById(R.id.txtPrecoOffer);

        Intent it = getIntent();

        int id = it.getIntExtra("id", -1);
        String modelo = it.getStringExtra("modelo");
        String marca = it.getStringExtra("marca");
        String preco = it.getStringExtra("preco");
        String cor = it.getStringExtra("cor");


        txtModelo.setText(modelo);
        txtCor.setText(cor);
        txtPreco.setText(preco);


    }
}
