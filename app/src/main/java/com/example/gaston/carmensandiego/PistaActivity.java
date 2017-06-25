package com.example.gaston.carmensandiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaston.carmensandiego.model.Caso;
import com.example.gaston.carmensandiego.model.CasoRest;
import com.example.gaston.carmensandiego.model.LugarDeInteres;
import com.example.gaston.carmensandiego.model.LugarDeInteresRest;
import com.example.gaston.carmensandiego.model.Pais;
import com.example.gaston.carmensandiego.service.ApiUtilsCarmenSanDiegoService;
import com.example.gaston.carmensandiego.service.CarmenSanDiegoService;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PistaActivity extends AppCompatActivity {
    public  final static String EXTRA_CASO = "com.example.gaston.carmensandiego.CASO";
    private CasoRest caso ;
    private ListView list;
    private LugarDeInteresAdapter  adapter;
    private ApiUtilsCarmenSanDiegoService serv = new ApiUtilsCarmenSanDiegoService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista);
        list = (ListView)findViewById(R.id.carmenSanDiego_listViewLugaresDeInteres);
        Intent intent = getIntent();
        CasoRest cas = (CasoRest)intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO);
        caso = cas;
        List<LugarDeInteresRest> model = caso.getPais().getLugares();
        adapter = new LugarDeInteresAdapter(this,model);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    LugarDeInteresRest lugar = (LugarDeInteresRest) adapter.getItem(i);
                    //devolverPista(lugar);
                    obtenerPista(lugar);
                    Toast.makeText(PistaActivity.this, "Retornar Pista De:"+lugar.getNombre(), Toast.LENGTH_LONG).show();
                }catch(Exception e){ e.printStackTrace();}
            }
        });
        ((TextView) findViewById(R.id.carmenSanDiego_paisDondeEstoy)).setText(String.valueOf(caso.getPais().getNombre()));
        //((TextView) findViewById(R.id.carmenSanDiego_villanoAArrestar)).setText(String.valueOf(caso.getOrdenDeArrestoAlVillano().getNombre()));
        // LO MISMO QUE EN VIAJAR ACTIVITY
    }

        // Falta hacer que se vean los lugares del lugar como botones y asi al hacer click se pueda ver la pista de lugar
    public void ordenDeArresto(View view) {
        Intent intent = new Intent(this, OrdenDeArrestoActivity.class);

        intent.putExtra(EXTRA_CASO, caso);
        startActivity(intent);

    }

    public void viajar(View view) {
        Intent intent = new Intent(this, ViajarActivity.class);

        intent.putExtra(EXTRA_CASO, caso);
        startActivity(intent);

    }

    private void obtenerPista(LugarDeInteresRest lugar) {// Este metodo devuelve un CasoRest creo ver como hacer para pasarlo a Clase Caso
        ((TextView) findViewById(R.id.carmenSanDiego_nombreLugar)).setText(lugar.getNombre());
        CarmenSanDiegoService carmenSanDiegoService = serv.createCarmenSanDiegoService();
        carmenSanDiegoService.getPista(lugar.getNombre(),new Callback<String>() {
            @Override
            public void success(String pista, Response response) {
                pista(pista);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }
    /*public void devolverPista(LugarDeInteres l){
        ((TextView) findViewById(R.id.carmenSanDiego_nombreLugar)).setText(l.nombreLugar());
        ((TextView) findViewById(R.id.carmenSanDiego_pistaLugar)).setText(l.procesar());
    }*/
    public void pista(String l){
        ((TextView) findViewById(R.id.carmenSanDiego_pistaLugar)).setText(l);
    }
}
