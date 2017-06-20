package com.example.gaston.carmensandiego.model;

import java.util.List;
import java.util.Random;

/**
 * Created by gaston on 18/6/2017.
 */

public class RandomExamples {
    static Random random = new Random();

    /*public <T> randomIn(List<T> lista) {
       return lista.get(random.nextInt(lista.size()));
    }*/

    public String randomInString(List<String> lista) {
        return lista.get(random.nextInt(lista.size()));
    }

    public  int nextInt(int i){
        return random.nextInt(i);
    }
}
