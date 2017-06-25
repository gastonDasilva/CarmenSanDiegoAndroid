package com.example.gaston.carmensandiego.model;

/**
 * Created by gaston on 25/6/2017.
 */

public class LugarDeInteresRest {
    String nombre;
    String pista;
    Boolean informante;
    Boolean ocupante;
    Boolean cuidador;

    public LugarDeInteresRest(){}
    public LugarDeInteresRest(String n, String pista, Boolean inf, Boolean ocu,Boolean cui){
        this.nombre = n;
        this.pista = pista;
        this.informante = inf;
        this.ocupante = ocu;
        this.cuidador = cui;
    }
    public LugarDeInteresRest(LugarDeInteres l){
        this.nombre = l.nombreLugar();
        this.pista = l.procesar();
        this.informante = l.getInformante();
        this.ocupante = l.getOcupante();
        this.cuidador = l.getCuidador();
    }

    public Boolean getCuidador() {
        return cuidador;
    }

    public Boolean getInformante() {
        return informante;
    }

    public Boolean getOcupante() {
        return ocupante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPista() {
        return pista;
    }

    public void setCuidador(Boolean cuidador) {
        this.cuidador = cuidador;
    }

    public void setInformante(Boolean informante) {
        this.informante = informante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOcupante(Boolean ocupante) {
        this.ocupante = ocupante;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }
}

