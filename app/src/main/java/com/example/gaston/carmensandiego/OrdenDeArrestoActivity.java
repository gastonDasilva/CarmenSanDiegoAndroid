package com.example.gaston.carmensandiego;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaston.carmensandiego.model.Caso;
import com.example.gaston.carmensandiego.model.CasoRest;
import com.example.gaston.carmensandiego.model.DummyData;
import com.example.gaston.carmensandiego.model.EmitirOrdenRequest;
import com.example.gaston.carmensandiego.model.PaisCompletoRest;
import com.example.gaston.carmensandiego.model.Villano;
import com.example.gaston.carmensandiego.service.ApiUtilsCarmenSanDiegoService;
import com.example.gaston.carmensandiego.service.CarmenSanDiegoService;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class OrdenDeArrestoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public  final static String EXTRA_CASO = "com.example.gaston.carmensandiego.CASO";
    private DummyData dummy = new DummyData();
    private Caso caso = dummy.getCaso();
    //private CasoRest caso;
    private List<Villano> villanos = new ArrayList<Villano>();
    private ApiUtilsCarmenSanDiegoService serv = new ApiUtilsCarmenSanDiegoService();
    private Villano villanoAArrestar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden_de_arresto);
        //obtenerVillanos();
        Intent intent = getIntent();
        //if (intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO) != null) {
          //  caso = (CasoRest)intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO);
        //} else {
            //caso = dummy.getCaso();
            //obtenerCaso();
        //}
        /*Intent intent = getIntent(); // ver si esto funciona a la primera vez que se ejecuta
        Caso cas = (Caso)intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO);
        caso = cas;*/
        Spinner spinner = (Spinner) findViewById(R.id.villanos_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,/*nombreDeVillanos()*/dummy.nombreDeLosVillanos());

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        String nombrePaisDondeEstoy = String.valueOf(caso.getPaisDondeEstoy().getNombrePais());
        ((TextView) findViewById(R.id.carmenSanDiego_paisDondeEstoy)).setText(nombrePaisDondeEstoy);

        spinner.setOnItemSelectedListener(this);



    }

    public void pedirOrdenDeArresto(View view) {
        ///aca se deveria traer el villano que se selecciona con el selecetor
        Spinner spinner = (Spinner) findViewById(R.id.villanos_spinner);
        ((TextView) findViewById(R.id.carmenSanDiego_villanoAArrestar)).setText(String.valueOf(caso.getOrdenDeArrestoAlVillano().getNombre()));
        Toast.makeText(OrdenDeArrestoActivity.this, "Orden emitida A:" + caso.getOrdenDeArresto().getNombre(), Toast.LENGTH_LONG).show();
        /*((TextView) findViewById(R.id.carmenSanDiego_villanoAArrestar)).setText(String.valueOf(this.villanoAArrestar.getNombre()));
        Toast.makeText(OrdenDeArrestoActivity.this, "Orden emitida A:" + this.villanoAArrestar.getNombre(), Toast.LENGTH_LONG).show();
        */
        //emitirOrden(this.villanoAArrestar, caso.getid());
    }

    public void viajar(View view) {
        Intent intent = new Intent(this, ViajarActivity.class);
        intent.putExtra(EXTRA_CASO, caso);
        startActivity(intent);

    }

    public void pista(View view) {
        Intent intent = new Intent(this, PistaActivity.class);

        intent.putExtra(EXTRA_CASO, caso);
        startActivity(intent);

    }
/*
    private void obtenerVillanos() {
        CarmenSanDiegoService carmenSanDiegoService =  serv.createCarmenSanDiegoService();
        carmenSanDiegoService.getVillanos(new Callback<List<Villano>>() {
            @Override
            public void success(List<Villano> villanos, Response response) {
                System.out.print("entro al success");
                agregarVillanos(villanos);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    private void obtenerCaso() {// Este metodo devuelve un CasoRest creo ver como hacer para pasarlo a Clase Caso
        CarmenSanDiegoService carmenSanDiegoService = serv.createCarmenSanDiegoService();
        carmenSanDiegoService.getCaso(new Callback<CasoRest>() {
            @Override
            public void success(CasoRest caso, Response response) {
                setearCaso(caso);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    private void emitirOrden(Villano vil, int idCas) {
        CarmenSanDiegoService carmenSanDiegoService = serv.createCarmenSanDiegoService();
        //EmitirOrdenRequest orden = new EmitirOrdenRequest(caso.getid(), caso.getOrdenDeArresto().getId());
        EmitirOrdenRequest orden = new EmitirOrdenRequest(vil.getId(),idCas);
        carmenSanDiegoService.emitirOrden(orden,new Callback<PaisCompletoRest>() {
            @Override
            public void success(PaisCompletoRest p, Response response) {
                //Log.e("Orden De Arresto para ", caso.getVillanoAArrestar.getNombre());
                setearPaisAlCaso(p);

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }*//*
    private void mostrarVillano(CasoRest caso) {
        this.caso = caso;
    }
    private void setearCaso(CasoRest caso) {
        this.caso = caso;
    }

    private void setearPaisAlCaso(PaisCompletoRest p) {
        caso.setPais(p);
    }
    private void agregarVillanos(List<Villano> villanos) {
        this.villanos = villanos;
    }
*/
    private List<String> nombreDeVillanos(){
        List<String> nombres = new ArrayList<String>();
        for(Villano vil : villanos){
            nombres.add(vil.getNombre());
        }
        return nombres;
    }

    /*private CarmenSanDiegoService createCarmenSanDiegoService() {
        //MMM código repetido, habría que modificar esto no?
        String SERVER_IP = "10.0.2.2"; //esta ip se usa para comunicarse con mi localhost en el emulador de Android Studio
        String SERVER_IP_GENY = "192.168.56.1";//esta ip se usa para comunicarse con mi localhost en el emulador de Genymotion
        String API_URL = "http://"+ SERVER_IP_GENY +":9000";

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        CarmenSanDiegoService carmenSanDiegoService = restAdapter.create(CarmenSanDiegoService.class);
        return carmenSanDiegoService;
    }*/
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Spinner spinner = (Spinner) findViewById(R.id.villanos_spinner);
        String nombreVillano = (String) spinner.getItemAtPosition(position);
        Villano vil = dummy.dameVillano(nombreVillano);
       // Villano vil = dameVillano(nombreVillano);
        caso.setearOrdenDeArrestoAlVillano(vil);
        //setearVillaAArrestar(vil);
        //emitirOrden(vil,caso.getId());
    }

    private void setearVillaAArrestar(Villano v){
        this.villanoAArrestar = v;
    }
    private Villano dameVillano(String nombreVil){
        for(Villano vil : villanos){
            if(vil.getNombre() == nombreVil){
                return vil;
            }
        }
        return  null;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
