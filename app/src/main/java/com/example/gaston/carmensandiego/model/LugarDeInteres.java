package com.example.gaston.carmensandiego.model;

/**
 * Created by gaston on 18/6/2017.
 */

public abstract class LugarDeInteres {
    // Solo pueden ser Club,Embajada,Banco y Biblioteca
     private Boolean informante = false  ;//Solo puede haber una persona en el lugar, es decir que solo un booleano puede ser true
    private Boolean ocupante = false;
    private Boolean cuidador = true;
    private Pais paisLugar;
    private Villano vil = null; // indica si el villano esta en el lugar de interes o no
    private Caso cas ;// esto sirve para dar las pistas sobre el plan de escape del villano

		public LugarDeInteres(Pais p){
        paisLugar =p;
         }
    LugarDeInteres(){}

    public Boolean hayInformante() {
        return informante;
    }

    public Boolean hayOcupante() {
        return ocupante;
    }

    public Boolean hayCuidador() {
        return cuidador;
    }
    public Villano getVillano(){
       return vil;
    }
    public Caso getCaso(){
        return cas;
    }

    public Pais getPaisLugar(){
        return paisLugar;
    }

    public Boolean hayVillanoEnElLugar(){
        if(vil!= null){
            return true;
        }else{
            return false;
        }
    }


    public void setearVillanoEnLugar(Villano v){
        vil = v;
    }
    public abstract String nombreLugar();

    public void setearInformante() {
        // setea un true para que halla un informante en el lugar de interes
        if (this.hayCuidador() || this.hayOcupante()){
            System.out.println("Ya hay un individuo en el lugar" );
            this.cuidador = false;
            this.ocupante = false;
        }
        informante = true;
    }

    public void setearOcupante() {
        //setea un ocupante  que no es el villano  al lugar de interes
        if (this.hayCuidador() || this.hayInformante()){
            System.out.println("Ya hay un individuo en el lugar" );
            this.cuidador = false;
            this.informante = false;
        }
        this.ocupante = true;
    }

    public void setearOcupante(Villano villano) {
        //setea un ocupante que puede es el villano   al lugar de interes
        if (this.hayCuidador() || this.hayInformante()){
            System.out.println("Ya hay un individuo en el lugar" );
            this.cuidador = false;
            this.informante = false;
        }
        this.ocupante = true;
        this.vil = villano;
    }

    public void setearCuidador() {
        //setea un true para que halla un cuidador al lugar de interes
        if (this.hayInformante() || this.hayOcupante()){
            System.out.println("Ya hay un individuo en el lugar" );
            this.informante = false;
            this.ocupante = false;
        }
        this.cuidador = true;

    }

    public String procesarCuidador() {
        //Prop: verifica si hay un cuidador en el lugar y procesar
        return "CUIDADOR: Te equivocaste de pais bato, mejor volve por donde viniste";
    }

    public String procesarOcupante () {
        // si el villano esta en el lugar se lo detiene sino se le advierte al detective que el villano esta en la
        // ciudad
        String result;
        if (vil == null) {
            return "CUIDADO DETECTIVE! el villano esta en la ciudad";
        } else {
            if (cas.ordenDeArrestoAlVillano == null) {
                return "CUIDADO DETECTIVE!El villano escapo por no tener una orden de arresto";
            } else {
                result = "Alto!!" + cas.ordenDeArrestoAlVillano.nombre + " Queda Arrestado";
                if (cas.ordenDeArrestoAlVillano.nombre == cas.responsable.nombre) {
                    result = result + " CONGRATULATIONS WACHIN! Atrapaste al villano, Sos una bestia ";
                } else {
                    result = result + "FALLASTE, atrapaste a " + cas.ordenDeArrestoAlVillano.nombre + " Y ese loco no realizo el robo";
                }
            }
        }
        return result;
    }

    public abstract String procesarInformante();

    public String procesar(){
        if(this.hayCuidador()){
           return procesarCuidador();
        }else{
            if(this.hayOcupante()){
                return  procesarOcupante();
            }else{
                if(this.hayInformante()){
                    return   procesarInformante();
                }
            }
        }
        return "No hay Ninguna Persona en el lugar";
    }
    public void setearCaso(Caso c) {
        cas = c;
    }
}
