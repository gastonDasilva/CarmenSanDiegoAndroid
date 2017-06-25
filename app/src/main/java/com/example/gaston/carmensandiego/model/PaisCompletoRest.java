package com.example.gaston.carmensandiego.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 25/6/2017.
 */

public class PaisCompletoRest implements Serializable {
    Integer id;
    String nombre;
    List<LugarDeInteresRest> lugares;
    List <PaisRest> conexiones;

    public PaisCompletoRest(){}
    public PaisCompletoRest(int id, String n, List<LugarDeInteresRest> lugares, List<PaisRest> paisesconexiones) {
        this.id = id;
        this.nombre = n;
        this.lugares = lugares;
        this.conexiones = paisesconexiones;
    }

    public PaisCompletoRest(Pais p){
        this.id = p.id;
        this.nombre = p.nombrePais;
        lugares = this.mapLugares(p);
        conexiones= this.mapPaisesConexiones(p);
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public List<LugarDeInteresRest> getLugares(){
        return lugares;
    }

    public  List <PaisRest> getConexiones(){
        return  conexiones;
    }

    public  void setId(int id){
        this.id = id;
    }

    public  void  setNombre(String n){
        this.nombre =n;
    }

    public void setLugares( List<LugarDeInteresRest> l){
        this.lugares = l;
    }

    public void setConexiones(List <PaisRest> l){
        this.conexiones = l;
    }

    public List<LugarDeInteresRest> mapLugares(Pais p){
        List<LugarDeInteresRest> res = new ArrayList<LugarDeInteresRest>();
        for (LugarDeInteres l: p.getlugaresDeInteres()){
            res.add( new LugarDeInteresRest(l));
        }
        return res;
    }
    public List<PaisRest> mapPaisesConexiones(Pais p){
        List<PaisRest> res = new ArrayList<PaisRest>();
        for (Pais pais: p.getPaisConexion()){
            res.add( new PaisRest(pais));
        }
        return res;
    }
}
