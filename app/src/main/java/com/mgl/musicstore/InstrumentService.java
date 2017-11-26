package com.mgl.musicstore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Miguel on 25/11/2017.
 */

public interface InstrumentService {
    // nome do WebService que irá retornar a lista de dados
    @GET("index.php")
    Call<List<Instrument>> getAll();

    // no POST deve-se colocar o nome do WebService PHP que irá receber os dados
    // cada campo do WS de inclusão deve ser indicado no Field
    // gravaProposta é o nome dado para a chamada do método
    @FormUrlEncoded
    @POST("create.php")
    Call<Instrument> save(@Field("modelo") String modelo,
                                   @Field("marca") String marca,
                                   @Field("categoria") String categoria,
                                   @Field("preco") double preco,
                                   @Field("cor") String cor);
}
