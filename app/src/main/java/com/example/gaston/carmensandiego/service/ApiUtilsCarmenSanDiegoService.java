package com.example.gaston.carmensandiego.service;

import retrofit.RestAdapter;

/**
 * Created by gaston on 25/6/2017.
 */

public class ApiUtilsCarmenSanDiegoService {

    public ApiUtilsCarmenSanDiegoService(){}

    public CarmenSanDiegoService createCarmenSanDiegoService() {
        //MMM código repetido, habría que modificar esto no?
        String SERVER_IP = "10.0.2.2"; //esta ip se usa para comunicarse con mi localhost en el emulador de Android Studio
        String SERVER_IP_GENY = "192.168.56.1";//esta ip se usa para comunicarse con mi localhost en el emulador de Genymotion
        String API_URL = "http://"+ SERVER_IP_GENY +":9000";

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        CarmenSanDiegoService carmenSanDiegoService = restAdapter.create(CarmenSanDiegoService.class);
        return carmenSanDiegoService;
    }
}
