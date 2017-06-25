package com.example.gaston.carmensandiego.model;

/**
 * Created by gaston on 25/6/2017.
 */

public class PaisRest {
    int id;
    String nombre;

    public PaisRest(){}
    public PaisRest(int id, String n) {
        this.id = id;
        this.nombre = n;
    }
    public PaisRest(Pais p ){
        this.id = p.getId();
        this.nombre = p.getNombrePais();
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String n){
        this.nombre = n;
    }
}

