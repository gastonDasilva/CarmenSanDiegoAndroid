package com.example.gaston.carmensandiego.model;

import android.icu.text.StringPrepParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 20/6/2017.
 */

public class DummyData {
    private List<Villano> expediente = new ArrayList<Villano>();
    private Caso caso ;

        public DummyData(){
            Villano elAleph = new Villano(2, "El Aleph","Masculino");
            elAleph.agregarSeña( " tiene el pelo rubio");
            elAleph.agregarSeña( "tiene ojos azules");
            elAleph.agregarSeña( " usa una collar de rubies ");
            elAleph.agregarSeña( " tenia una bufanda azul");
            elAleph.agregarHobbie("jugar al futbol");
            elAleph.agregarHobbie("ver anime");
            elAleph.agregarHobbie("escuchar musica de los 80");
            expediente.add(new Villano(5, "Carlos", "Masculino"));
            expediente.add(elAleph);
            expediente.add(new Villano(11, "Carmen San Diego","Femenino"));
            expediente.add(new Villano(13, "Igor Brodie","Masculino"));
            expediente.add(new Villano(17, "Juan Perez","Masculino"));

            Pais argentina = new Pais("Argentina",1);
            argentina.agregarCaracteristica("hablan Español");
            argentina.agregarCaracteristica("su bandera es celeste y blanca");
            argentina.agregarCaracteristica("Comen Asado");
            argentina.agregarCaracteristica("Su moneda es el Peso Argentino");
            LugarDeInteres embajadaArg = new Embajada(argentina);
            embajadaArg.setearInformante();
            LugarDeInteres clubArg = new Club(argentina);
            clubArg.setearInformante();
            LugarDeInteres bancoArg = new Club(argentina);
            bancoArg.setearInformante();
            argentina.agregarLugarDeInteres(embajadaArg);
            argentina.agregarLugarDeInteres(clubArg);
            argentina.agregarLugarDeInteres(bancoArg);
            Pais peru = new Pais("Peru",2);
            LugarDeInteres embajadaPeru = new Embajada(peru);
            embajadaPeru.setearOcupante();
            LugarDeInteres bancoPeru = new Banco(peru);
            bancoPeru.setearOcupante();
            LugarDeInteres bibliotecaPeru = new Biblioteca(peru);
            bibliotecaPeru.setearOcupante(elAleph);
            peru.agregarLugarDeInteres(embajadaPeru);
            peru.agregarLugarDeInteres(bancoPeru);
            peru.agregarLugarDeInteres(bibliotecaPeru);
            peru.agregarCaracteristica("hablan Español");
            peru.agregarCaracteristica("su bandera es roja y blanca");
            peru.agregarCaracteristica("Comen Palomas");
            peru.agregarCaracteristica("Su moneda es el Peso");
            //Pais españa = new Pais( "España",3);
            Pais bolivia = new Pais("Bolivia",4);
            bolivia.agregarLugarDeInteres(new Embajada(bolivia));
            bolivia.agregarLugarDeInteres(new Club(bolivia));
            bolivia.agregarLugarDeInteres(new Biblioteca(bolivia));
            Pais francia = new Pais("Francia",5);
            francia.agregarLugarDeInteres(new Embajada(francia));
            francia.agregarLugarDeInteres(new Club(francia));
            francia.agregarLugarDeInteres(new Biblioteca(francia));
            argentina.agregarPaisConexion(peru);
            argentina.agregarPaisConexion(francia);
            argentina.agregarPaisConexion(bolivia);
            bolivia.agregarPaisConexion(argentina);


            Caso cas= new Caso(5,"El gran robo",elAleph);
            cas.setearPaisDeLRobo(argentina);
            cas.setearPaisDondeEstoy(argentina);
            cas.agregarPaisPlanDeEscape(argentina);
            cas.agregarPaisPlanDeEscape(peru);
            cas.agregarPaisPlanDeEscape(francia);
            String reporteDelCaso = "A las 9 de la mañana en la ciudad de Banfield la comunidad científica fue conmovida al darse cuenta del "+
            " faltante de gran valor! El sarcófago del faraón Usermaatra-Meriamón Ramsés-Heqaiunu, mejor conocido como Ramsés III. "+
           "El criminal fue muy prolijo y la escena del crimen no contaba con pista alguna, "+
            "su misión como detective   es desifrar el responsable de tal crímen y apresarlo";
            cas.setearReporteCaso(reporteDelCaso);
            cas.setearobjetoRobado("tumba del faraón");
            caso = cas;
        }

        public Caso getCaso(){
            return caso;
        }

        public List<Villano> getExpediente(){
        return expediente;
        }

        public List<String> nombreDeLosVillanos () {
            List<String> nombres = new ArrayList<String>();
            for(Villano vil: expediente){
                nombres.add(vil.getNombre());
            }
            return nombres;
        }

        public  Villano dameVillano(String n){

            for(Villano vil : expediente){
                if(vil.getNombre() == n){
                    return vil;
                }
            }
            return  null;
        }
}
