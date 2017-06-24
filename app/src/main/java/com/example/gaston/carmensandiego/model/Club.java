package com.example.gaston.carmensandiego.model;

import java.io.Serializable;

/**
 * Created by gaston on 18/6/2017.
 */

public class Club extends  LugarDeInteres implements Serializable {
    String primerCaracteristicaDELasSeñasParticulares;
    String segundaCaracteristicaDELasSeñasParticulares;

    public Club(Pais p) {
        super(p);
    }

    public Club() {
    }
    @Override
    public String nombreLugar() {
        return null;
    }

    @Override
    public String procesarInformante() {
        return "Vi a alguien como describe!" +this.pistasRelacionadasConElDestinoDelVillano();
    }

    public String pistasRelacionadasConElDestinoDelVillano(){
        this.caracteriscaDeLVillano();
            return " recuerdo que la persona tenia estas señas: "+primerCaracteristicaDELasSeñasParticulares+" , "+ segundaCaracteristicaDELasSeñasParticulares +
                    this.darPistaAdicionalDeHobbies();
    }

    public  void caracteriscaDeLVillano(){
        // inicializa en los valores:
        // "primerCaracteristicaDELasSeñasParticulares"con una caracteristicas random de las señas particulares del villano
        // "segundaCaracteristicaDELasSeñasParticulares" con una caracteristicas random de las señas particulares del villano
        RandomExamples randomCarac = new RandomExamples();
        primerCaracteristicaDELasSeñasParticulares = randomCarac.randomInString(super.getCaso().getResponsable().getSenhasParticulares());
        segundaCaracteristicaDELasSeñasParticulares = randomCarac.randomInString(super.getCaso().getResponsable().getSenhasParticulares());
    }

    public String darPistaAdicionalDeHobbies() {
        //Esto retorna en un 70% de la veces una caracteristica ramdom de los hobbies del villano
        RandomExamples randomCarac = new RandomExamples();
        RandomExamples randomnumero = new RandomExamples();
         int i = randomnumero.nextInt(3);
        if (i== 1 ||i== 2 ){// con este hacemos lo probabilidad del 70 % osea si es 1 o 2 entra al if sino sale
            return " Tambien recuerdo haberlo escuchado decir que uno de sus hobbies es "+randomCarac.randomInString(super.getCaso().getResponsable().getHobbies());
        }else{
            return "";

        }
    }
}
