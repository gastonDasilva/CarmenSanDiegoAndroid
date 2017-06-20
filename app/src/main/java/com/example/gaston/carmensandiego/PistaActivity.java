package com.example.gaston.carmensandiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gaston.carmensandiego.model.Caso;

public class PistaActivity extends AppCompatActivity {
    public  final static String EXTRA_CASO = "com.example.gaston.carmensandiego.CASO";
    private Caso caso ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Caso cas = (Caso)intent.getSerializableExtra(OrdenDeArrestoActivity.EXTRA_CASO); // no se si andara bien esto
        // caso = cas  //esto no funciona ya que son distintas clases , hay que ver como traer el caso
        caso = cas;
        ((TextView) findViewById(R.id.carmenSanDiego_paisDondeEstoy)).setText(String.valueOf(caso.getPaisDondeEstoy().getNombrePais()));
        ((TextView) findViewById(R.id.carmenSanDiego_villanoAArrestar)).setText(String.valueOf(caso.getOrdenDeArrestoAlVillano().getNombre()));
        setContentView(R.layout.activity_pista);
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
}
