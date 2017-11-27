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

public interface OfferService {
    // no POST deve-se colocar o nome do WebService PHP que irá receber os dados
    // cada campo do WS de inclusão deve ser indicado no Field
    // gravaProposta é o nome dado para a chamada do método
    @FormUrlEncoded
    @POST("create_compra.php")
    Call<Offer> save(@Field("nome") String nome,
                                   @Field("email") String email,
                                   @Field("telefone") String telefone,
                                   @Field("instrumento_id") int instrumento_id);
}
