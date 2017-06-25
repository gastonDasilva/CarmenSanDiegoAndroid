package com.example.gaston.carmensandiego.service;


import com.example.gaston.carmensandiego.model.CasoRest;
import com.example.gaston.carmensandiego.model.EmitirOrdenRequest;
import com.example.gaston.carmensandiego.model.Caso;
import com.example.gaston.carmensandiego.model.Pais;
import com.example.gaston.carmensandiego.model.PaisCompletoRest;
import com.example.gaston.carmensandiego.model.ViajeRequest;
import com.example.gaston.carmensandiego.model.Villano;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
/**
 * Created by gaston on 24/6/2017.
 */

public interface CarmenSanDiegoService {
    @GET("/villanos")
    void getVillanos(Callback<List<Villano>> callback);

    @GET("/pistaDelLugar/{lugar}") // No se si esto funcionara para ?lugar=xxx del xtrest
    void getPista(@retrofit.http.Path("lugar") String lugar, Callback<String> callback);

    @GET("/iniciarJuego") // Esto  devuelve un CasoRest creo, ver como hacer para pasarlo a Clase Caso
    void getCaso(Callback<CasoRest> callback);

    @POST("/viajar")
    void viajar(@Body ViajeRequest viajeRequest, Callback<CasoRest> callback);

    @POST("/emitirOrdenPara")
    void emitirOrden(@Body EmitirOrdenRequest ordenRequest, Callback<PaisCompletoRest> callback);

    @GET("//paises/{PaisId}") // No se si esto funcionara para ?lugar=xxx del xtrest
    void getPais(@retrofit.http.Path("PaisId") int id, Callback<Pais> callback);
}
