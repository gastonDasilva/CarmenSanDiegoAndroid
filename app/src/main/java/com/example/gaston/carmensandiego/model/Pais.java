package com.example.gaston.carmensandiego.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 18/6/2017.
 */

public class Pais implements Serializable {

    int id;
    String nombrePais;
    List<String> caracteristicasDelPais = new ArrayList<String>();
    List <Pais> paisConexiones = new ArrayList<Pais>();
    List<LugarDeInteres> lugaresDeInteres= new ArrayList<LugarDeInteres>(); //limite son 3 lugares sin repetidos


        public Pais(){}

        public Pais(String nombre, int id)
        {
        this.nombrePais = nombre;
        this.id = id;
        }
         public int getId() {
            return id;
        }
        public List <LugarDeInteres> getlugaresDeInteres(){
		    return lugaresDeInteres;

	    }
        public void setNombrePais(String n){
        nombrePais= n;
        }

        public String getNombrePais(){
        return  nombrePais;
        }

        public void agregarCaracteristica(String c){
        caracteristicasDelPais.add(c);
        }

        public List <String> getCaracteristicasDelPais(){
        return caracteristicasDelPais;

        }

        public void sacarCaracteristica(String c){
        caracteristicasDelPais.remove(c);

        }

        public void agregarPaisConexion(Pais p){
        paisConexiones.add(p);
        }

         public void sacarPaisConexion(Pais p){
            paisConexiones.remove(p);
        }

         public List <Pais> getPaisConexion(){
            return paisConexiones;

        }
         public Boolean equals(LugarDeInteres l1, LugarDeInteres l2){
         return l1.nombreLugar() == l2.nombreLugar();
        }
    public void agregarLugarDeInteres(LugarDeInteres l){
        if (!lugaresDeInteres.contains(l) && lugaresDeInteres.size() <= 2 ){
        lugaresDeInteres.add(l);
        }
        else{
        if(lugaresDeInteres.contains(l)){
        throw new  /*UserException*/RuntimeException("Error el lugar de interes "+ l.nombreLugar()+ " ya esta en la lista" );
            }else
                {throw new /*UserException*/RuntimeException("Los lugares de interes deben ser Exactamente 3");
                }
        }
    }

    public void sacarLugarDeInteres(LugarDeInteres l){
        lugaresDeInteres.remove(l);
        }
}
