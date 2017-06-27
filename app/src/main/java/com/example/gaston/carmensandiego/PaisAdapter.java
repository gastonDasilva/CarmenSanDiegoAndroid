package com.example.gaston.carmensandiego;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.gaston.carmensandiego.model.Pais;
import com.example.gaston.carmensandiego.model.PaisRest;

import java.util.List;

/**
 * Created by gaston on 24/6/2017.
 */

public class PaisAdapter extends BaseAdapter {
    private Context context;
    private  List<Pais> lista;

    public PaisAdapter(Context context , List<Pais> lista){
        this.context = context;
        this.lista = lista;
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item,null);
        }
            /*Button*/ TextView boton = (TextView) view.findViewById(R.id.carmenSanDiego_item_pais);
            boton.setText(lista.get(i).getNombrePais());
        return view;
    }
}
