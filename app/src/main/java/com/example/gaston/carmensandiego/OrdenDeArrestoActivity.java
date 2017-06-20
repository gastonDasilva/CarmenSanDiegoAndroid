package com.example.gaston.carmensandiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gaston.carmensandiego.model.Caso;
import com.example.gaston.carmensandiego.model.Villano;

public class OrdenDeArrestoActivity extends AppCompatActivity {
    public  final static String EXTRA_CASO = "com.example.gaston.carmensandiego.CASO";
    private Caso caso = new Caso();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden_de_arresto);

        Intent intent = getIntent(); // ver si esto funciona a la primera vez que se ejecuta
        Caso cas = (Caso)intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO);
        caso = cas;


        ((TextView) findViewById(R.id.carmenSanDiego_paisDondeEstoy)).setText(String.valueOf(caso.getPaisDondeEstoy().getNombrePais()));
    }

    public void pedirOrdenDeArresto(View view) {
       ///aca se deveria traer el villano que se selecciona con el selecetor
        Villano vil = new Villano();// ese villano no tendria que ser un new sino el que se obtiene del selector
        caso.setearOrdenDeArrestoAlVillano(vil);
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
}
