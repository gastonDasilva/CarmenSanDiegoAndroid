package com.example.gaston.carmensandiego.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 18/6/2017.
 */

public class Villano implements Serializable{

	int id;
    String nombre;
    String sexo;
    List <String> senhasParticulares = new ArrayList<String>();
    List<String> hobbies = new ArrayList<String>();

    public Villano(){}
    public Villano(int id, String nombre, String sexo){
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
    }
    public Villano(int id, String nombre, String sexo, List<String> senha, List<String> hobbies){
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.senhasParticulares = senha;
        this.hobbies= hobbies;
    }


    public List<String> getHobbies(){
        return hobbies;
    }
    public List<String> getSenhasParticulares(){
        return senhasParticulares;
    }
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }

    public String getSexo(){
        return sexo;
    }

    public void agregarSeña(String seña){

        senhasParticulares.add(seña);
    }

    public void sacarSeña(String seña){

        senhasParticulares.remove(seña);
    }

    public void agregarHobbie (String h){

        hobbies.add(h);
    }

    public void  sacarHobbie(String h){
        hobbies.remove(h);
    }

}
