package com.example.gaston.carmensandiego.model;

import java.util.List;

/**
 * Created by gaston on 18/6/2017.
 */

public class Banco extends LugarDeInteres {
    Pais paisProximoDestino;
    String CaracteristicaDelPaisDestino;
    String CaracteristicaDELasSeñasParticulares;

    public Banco(Pais p) {
        super(p);
    }

    public Banco() {
    }

    @Override
    public String nombreLugar() {
        return "Banco";
    }

    @Override
    public String procesarInformante() {
        return "Vi a alguien como describe!"+this.pistasRelacionadasConElDestinoDelVillano();
    }

    public String pistasRelacionadasConElDestinoDelVillano(){
        this.paisRandomDelDestino();
        this.caracteriscaDeLPaisDetinoRandom();
        return  "creo haber oido que tenia planeado ir a " +
        "un pais con las siguientes caracteristicas: "+CaracteristicaDelPaisDestino+" . " +
        " Ademas recuerdo que la persona tenia estas señas: "+ CaracteristicaDELasSeñasParticulares ;
    }

    public  void caracteriscaDeLPaisDetinoRandom(){
        // inicializa en los valores:
        // "CaracteristicaDelPaisDestino"con una caracteristica random del pais proximo pais del plan de escape del villano
        // "CaracteristicaDELasSeñasParticulares" caracteristicas random de las señas particulares del villano
        RandomExamples randomCarac = new RandomExamples();
        CaracteristicaDelPaisDestino = randomCarac.randomInString(paisProximoDestino.getCaracteristicasDelPais());
        CaracteristicaDELasSeñasParticulares = randomCarac.randomInString(super.getCaso().getResponsable().getSenhasParticulares());
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
        return  null;
    }
}
