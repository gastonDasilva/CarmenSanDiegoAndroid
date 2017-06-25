package com.example.gaston.carmensandiego.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 25/6/2017.
 */

public class CasoRest implements Serializable{
    int id;
    PaisCompletoRest pais;
    List<String> paisesVisitados = new ArrayList<String>();
    List<String> paisesFallidos = new ArrayList<String>();

    public CasoRest(){}
    public CasoRest(int id, PaisCompletoRest p, List<String> paisesVi, List<String> paisesFall) {
        this.id = id;
        this.pais = p;
        this.paisesVisitados = paisesVi;
        this.paisesFallidos = paisesFall;
    }

    public int getId(){
        return id;
    }

    public PaisCompletoRest getPais(){
        return pais;
    }

    public List<String> getPaisesVisitados(){
        return paisesVisitados;
    }

    public  List<String> getPaisesFallidos(){
        return paisesFallidos;
    }

    public void setId(int id){
        this.id = id;
    }

    public void  setPais(PaisCompletoRest p){
        this.pais = p;
    }

    public void  setPaisesVisitados(List<String> list){
        this.paisesVisitados = list;
    }

    public  void setPaisesFallidos(List<String> list){
        this.paisesFallidos = list;
    }
    public String nombreDePaisesVisitados() {
        String res = "";
        for (String nombrePais : paisesVisitados) {
            if(res ==""){
                res = nombrePais;
            }else {
                res = res + " -> " + nombrePais;
            }
        }
        return res;
    }

    public void agregarPaisesVisitados(Pais p){
        paisesVisitados.add(p.getNombrePais());
    }
}
