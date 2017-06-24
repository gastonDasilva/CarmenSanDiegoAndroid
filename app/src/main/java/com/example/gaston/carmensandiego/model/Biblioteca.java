package com.example.gaston.carmensandiego.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaston on 18/6/2017.
 */

public class Biblioteca extends LugarDeInteres implements Serializable {

    Pais paisProximoDestino;
    String CaracteristicaDelPaisDestino;
    String CaracteristicaDELasSeñasParticulares;

    public Biblioteca(Pais p) {
        super(p);
    }

    public Biblioteca() {
    }

    @Override
    public String nombreLugar() {
        return "Biblioteca";
    }

    @Override
    public String  procesarInformante() {
        return "Vi a alguien como describe!"+this.pistasRelacionadasConElDestinoDelVillano();
    }

    public String pistasRelacionadasConElDestinoDelVillano(){
        this.paisRandomDelDestino() ;
        this.caracteriscaDeLPaisDetinoRandom();
        return "creo haber oido que tenia planeado ir "+
                "a un pais con las siguientes caracteristicas: "+CaracteristicaDelPaisDestino+" . " +
                 "Ademas recuerdo que la persona tenia estas señas: "+ CaracteristicaDELasSeñasParticulares+ " . "+
                 "+ this.darPistaAdicionalDeHobbies()";
    }

    public String darPistaAdicionalDeHobbies() {
        //Esto retorna en un 50% de la veces una caracteristica ramdom de los hobbies del villano
        RandomExamples randomCarac = new RandomExamples();
        RandomExamples randomnumero = new RandomExamples();
        if (randomnumero.nextInt(2)== 1){// con esto hacemos la probabilidad del 50% osea si es 1 entra al if sino sale
            return " tambien recuerdo haberlo escuchado dicir que uno de sus hobbies es  "+randomCarac.randomInString(super.getCaso().getResponsable().getHobbies());
        }else{
            return "";

        }
    }

    public  void caracteriscaDeLPaisDetinoRandom(){
        // inicializa en los valores "CaracteristicaDelPaisDestino"con una caracteristica random del pais proximo pais del plan de escape del villano
        // "CaracteristicaDELasSeñasParticulares" caracteristicas random de las señas particulares del villano
        RandomExamples randomCarac = new RandomExamples();
        CaracteristicaDelPaisDestino = randomCarac.randomInString(paisProximoDestino.caracteristicasDelPais);
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
