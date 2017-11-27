package com.mgl.musicstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OfferActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;
    private ImageView imageView;
    private TextView txtModelo;
    private TextView txtMarca;
    private TextView txtCor;
    private TextView txtPreco;
    private Button btnCadastrar;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        imageView = (ImageView) findViewById(R.id.imageView);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        txtModelo = (TextView) findViewById(R.id.txtModeloOffer);
        txtCor = (TextView) findViewById(R.id.txtCorOffer);
        txtPreco = (TextView) findViewById(R.id.txtPrecoOffer);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrarInteresse);

        Intent it = getIntent();

        id = it.getIntExtra("id", -1);
        String modelo = it.getStringExtra("modelo");
        String marca = it.getStringExtra("marca");
        double preco = it.getDoubleExtra("preco", -1);
        String cor = it.getStringExtra("cor");


        txtModelo.setText(modelo);
        txtCor.setText(cor);
        txtPreco.setText(String.format(new Locale("pt", "BR"), "R$ %,.2f", preco));


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();
                String telefone = edtTelefone.getText().toString();

                if(nome.trim().isEmpty() || email.trim().isEmpty() || telefone.trim().isEmpty()) {
                    Toast.makeText(OfferActivity.this, "Preencha todos campos", Toast.LENGTH_SHORT).show();
                    edtNome.requestFocus();
                    return;
                }

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.3.2/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                OfferService service = retrofit.create(OfferService.class);

                final Call offer = service.save(nome, email, telefone, id);

                offer.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        if(response.isSuccessful()) {
                            Toast.makeText(OfferActivity.this, "Interesse registrado", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(OfferActivity.this, "Erro!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
