package com.example.gaston.carmensandiego.model;

import java.io.Serializable;

/**
 * Created by gaston on 25/6/2017.
 */

public class EmitirOrdenRequest implements Serializable{
    private int villanoId;
    private int casoId;

   public EmitirOrdenRequest (){
        villanoId = 0;
        casoId = 0;
    }

    public EmitirOrdenRequest (int vilId){
        villanoId = vilId;
    }
    public EmitirOrdenRequest (int vilId, int casId){
        villanoId = vilId;
        casoId = casId;
    }
}
