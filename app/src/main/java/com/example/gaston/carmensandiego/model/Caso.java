package com.example.gaston.carmensandiego.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 18/6/2017.
 */

public class Caso implements Serializable {
    private int id ;
    private Pais paisDondeEstoy;
    private String nombreCaso;
    private Villano responsable;
    private List<Pais> planDeEscape = new ArrayList<Pais>();
    private List<String> paisesVisitados = new ArrayList<String>();
    private String reporteDelCaso;
    private String objetoRobado;
    private Pais paisDelRobo;
    private Villano ordenDeArrestoAlVillano;

    public Caso(){}

    public Caso(String nombre, Villano vres){
        this.nombreCaso = nombre;
        this.responsable = vres;
        this.setearPaisDondeEstoy();// para arrancar en un pais
    }
    public Caso (int ids ,String nombre, Villano vres){
        this.nombreCaso = nombre;
        this.responsable = vres;
        this.id = ids;
        this.setearPaisDondeEstoy(); // para arrancar en un pais
    }
    public void setearReporteCaso(String s){
        reporteDelCaso = s;
    }

    public void setearobjetoRobado(String s){
        objetoRobado = s;
    }
    public List<Pais> getPlanDeEscape(){
        return planDeEscape;
    }

    public int getid(){
        return  id;
    }
    public Villano getOrdenDeArrestoAlVillano(){
        return  ordenDeArrestoAlVillano;
    }

    public Pais getPaisDondeEstoy(){
        return  paisDondeEstoy;
    }

    public void setearPaisDondeEstoy(){
        this.paisDondeEstoy = this.paisDelRobo;
    }

    public Villano getResponsable(){
        return responsable;
    }

    public void setearOrdenDeArrestoAlVillano(Villano villano) {
        ordenDeArrestoAlVillano = villano;
    }

    public String getNombreCaso(){
        return nombreCaso;
    }

    public void agregarPaisPlanDeEscape(Pais p){
        planDeEscape.add(p);
    }

    public void agregarPaisesVisitados(Pais p){
        paisesVisitados.add(p.getNombrePais());
    }

    public Pais getPaisDelRobo(){
        return paisDelRobo;
    }
    public void setearPaisDeLRobo (Pais p){
        paisDelRobo = p;
    }

    public String getReporteDelCaso(){
        return  reporteDelCaso;
    }
}
