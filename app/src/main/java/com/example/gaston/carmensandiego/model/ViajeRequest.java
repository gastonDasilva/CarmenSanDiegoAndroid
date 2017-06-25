package com.example.gaston.carmensandiego.model;

/**
 * Created by gaston on 25/6/2017.
 */

public class ViajeRequest {
    int destinoId;

    public ViajeRequest (){
        destinoId = 0;
    }

    public ViajeRequest (int destId){
        destinoId = destId;
    }

    public int getDestinoId(){
        return destinoId;
    }
}
