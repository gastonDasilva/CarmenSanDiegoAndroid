package com.example.gaston.carmensandiego.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by gaston on 18/6/2017.
 */

public class Embajada extends  LugarDeInteres implements Serializable {

    Pais paisProximoDestino;
    String primerCaracteristicaDelPaisDestino;
    String segundaCaracteristicaDelPaisDestino;

	public Embajada (Pais p) {
        super(p);
    }

    public Embajada() {
    }

    @Override
    public String nombreLugar() {
        return "Embajada";
    }

    @Override
    public String procesarInformante() {
        return  "Vi a alguien como describe!"+this.pistasRelacionadasConElDestinoDelVillano();

    }

    public String pistasRelacionadasConElDestinoDelVillano(){

        this.paisRandomDelDestino();
        this.caracteriscaDeLPaisDetinoRandom();
       return  "creo haber oido que tenia planeado ir a "+
        "un pais con las siguientes caracteristicas: "+primerCaracteristicaDelPaisDestino+" , "+segundaCaracteristicaDelPaisDestino;
    }

    public  void caracteriscaDeLPaisDetinoRandom(){
        // inicializa en los valores "primerCaracteristicaDelPaisDestino" y
        // "segundaCaracteristicaDelPaisDestino" caracteristicas random del proximo pais del plan de escape del villano
        RandomExamples randomCaracPaisDestino = new RandomExamples();
        primerCaracteristicaDelPaisDestino = randomCaracPaisDestino.randomInString(paisProximoDestino.caracteristicasDelPais);
        segundaCaracteristicaDelPaisDestino = randomCaracPaisDestino.randomInString(paisProximoDestino.caracteristicasDelPais);
    }
    public void paisRandomDelDestino (){
        //obtiene el proximo pais del plan de escape
        paisProximoDestino = this.sacarElProximoDestinoDelPlanDeEscape(super.getPaisLugar(), super.getCaso().getPlanDeEscape());
    }

    public Pais sacarElProximoDestinoDelPlanDeEscape(Pais pais, List<Pais> planDeEscape) {
        // obtiene el pais siguiente del plan de escape desde el pais donde estoy parado
        for( int i = 0 ;i <= planDeEscape.size(); i++){
            if(planDeEscape.get(i).nombrePais ==pais.nombrePais ){
                return planDeEscape.get(i+1);
            }
        }
        return null;
    }
}
