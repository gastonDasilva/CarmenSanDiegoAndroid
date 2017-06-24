package com.example.gaston.carmensandiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gaston.carmensandiego.model.Caso;
import com.example.gaston.carmensandiego.model.DummyData;
import com.example.gaston.carmensandiego.model.Villano;

public class OrdenDeArrestoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public  final static String EXTRA_CASO = "com.example.gaston.carmensandiego.CASO";
    private DummyData dummy = new DummyData();
    private Caso caso ;//= dummy.getCaso();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden_de_arresto);
        Intent intent = getIntent();
        if (intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO) != null) {
            caso = (Caso)intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO);
        } else {
            caso = dummy.getCaso();
        }
        /*Intent intent = getIntent(); // ver si esto funciona a la primera vez que se ejecuta
        Caso cas = (Caso)intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO);
        caso = cas;*/
        Spinner spinner = (Spinner) findViewById(R.id.villanos_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dummy.nombreDeLosVillanos());

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
        Villano vil = new Villano();// ese villano no tendria que ser un new sino el que se obtiene del selector
        Spinner spinner = (Spinner) findViewById(R.id.villanos_spinner);
       // caso.setearOrdenDeArrestoAlVillano(vil);
        ((TextView) findViewById(R.id.carmenSanDiego_villanoAArrestar)).setText(String.valueOf(caso.getOrdenDeArrestoAlVillano().getNombre()));
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Spinner spinner = (Spinner) findViewById(R.id.villanos_spinner);
        String nombreVillano = (String) spinner.getItemAtPosition(position);
         Villano vil = dummy.dameVillano(nombreVillano);
        caso.setearOrdenDeArrestoAlVillano(vil);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
