package com.example.gaston.carmensandiego;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.gaston.carmensandiego.model.LugarDeInteres;
import com.example.gaston.carmensandiego.model.LugarDeInteresRest;
import com.example.gaston.carmensandiego.model.Pais;

import java.util.List;

/**
 * Created by gaston on 24/6/2017.
 */

public class LugarDeInteresAdapter  extends BaseAdapter {
    private Context context;
    private List<LugarDeInteresRest> lista;

    public LugarDeInteresAdapter(Context context , List<LugarDeInteresRest> lista){
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
            view = layoutInflater.inflate(R.layout.item_lugar,null);
        }
        Button boton = (Button)view.findViewById(R.id.carmenSanDiego_item_lugar);
        boton.setText(lista.get(i).getNombre());
        return view;
    }
}
