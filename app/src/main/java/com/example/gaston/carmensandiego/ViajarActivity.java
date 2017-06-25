package com.example.gaston.carmensandiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaston.carmensandiego.model.Caso;
import com.example.gaston.carmensandiego.model.CasoRest;
import com.example.gaston.carmensandiego.model.EmitirOrdenRequest;
import com.example.gaston.carmensandiego.model.Pais;
import com.example.gaston.carmensandiego.model.PaisCompletoRest;
import com.example.gaston.carmensandiego.model.PaisRest;
import com.example.gaston.carmensandiego.model.ViajeRequest;
import com.example.gaston.carmensandiego.service.ApiUtilsCarmenSanDiegoService;
import com.example.gaston.carmensandiego.service.CarmenSanDiegoService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ViajarActivity extends AppCompatActivity {
    public  final static String EXTRA_CASO = "com.example.gaston.carmensandiego.CASO";
    private CasoRest caso ;
    private ListView list;
    private PaisAdapter  adapter;
    private ApiUtilsCarmenSanDiegoService serv = new ApiUtilsCarmenSanDiegoService();
    private Pais paisViajar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajar);
        list = (ListView)findViewById(R.id.carmenSanDiego_listViewViajar);
        Intent intent = getIntent();
        CasoRest cas = (CasoRest)intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO); // no se si andara bien esto
       // caso = cas  //esto no funciona ya que son distintas clases , hay que ver como traer el caso
        caso = cas;
        String nombrePaisDondeEstoy = String.valueOf(caso.getPais().getNombre());
        List<PaisRest> model = caso.getPais().getConexiones();
        adapter = new PaisAdapter(this,model);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try {
                    PaisRest pais = (PaisRest) adapter.getItem(i);
                    viajar(pais);
                    Toast.makeText(ViajarActivity.this, "Viajas A:"+pais.getNombre(), Toast.LENGTH_LONG).show();
                }catch(Exception e){ e.printStackTrace();}
            }
        });
        String nombreDePaisesVisitados = caso.nombreDePaisesVisitados();
        ((TextView) findViewById(R.id.carmenSanDiego_paisDondeEstoy2)).setText(nombrePaisDondeEstoy);
        //((TextView) findViewById(R.id.carmenSanDiego_villanoAArrestar)).setText(String.valueOf(caso.getOrdenDeArrestoAlVillano().getNombre()));
        // VER COMO PASAR EL NOMBRE DEL VILLANO A ARRESTAR. UNA IDEA PUEDE SER DE AGREGAR UN ATRIBUTO String que sea
        // el nombre del villano a arrestar
        ((TextView) findViewById(R.id.carmenSanDiego_paisesRecorridos)).setText(nombreDePaisesVisitados);
    }

    public void ordenDeArresto(View view) {
        Intent intent = new Intent(this, OrdenDeArrestoActivity.class);

        intent.putExtra(EXTRA_CASO, caso);
        startActivity(intent);

    }

    public void pista(View view) {
        Intent intent = new Intent(this, PistaActivity.class);

        intent.putExtra(EXTRA_CASO, caso);
        startActivity(intent);

    }
    private void viajar(PaisRest p) {
        obtenerPais(p.getId());
        caso.setPais(new PaisCompletoRest(this.paisViajar));
        caso.agregarPaisesVisitados(this.paisViajar);
        CarmenSanDiegoService carmenSanDiegoService = serv.createCarmenSanDiegoService();
        ViajeRequest viaje = new ViajeRequest(p.getId());
        carmenSanDiegoService.viajar(viaje, new Callback<CasoRest>() {
            @Override
            public void success(CasoRest Caso, Response response) {
                Log.e("Viaje A : ", caso.getPais().getNombre());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    private void obtenerPais(int paisId){
        CarmenSanDiegoService carmenSanDiegoService = serv.createCarmenSanDiegoService();
        carmenSanDiegoService.getPais(paisId, new Callback<Pais>() {
            @Override
            public void success(Pais pais, Response response) {
                setearPais(pais);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void setearPais(Pais p) {
        paisViajar = p;
    }
    /*public void viajar (Pais p){
        caso.setearPaisDondeEstoy(p);
        caso.agregarPaisesVisitados(p);
    }*/
}
