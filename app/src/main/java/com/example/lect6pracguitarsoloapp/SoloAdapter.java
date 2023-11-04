package com.example.lect6pracguitarsoloapp;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class SoloAdapter extends BaseAdapter {
    List<GuitarSolo> adapterSolos;

    public SoloAdapter(List<GuitarSolo> adapterSolos) {
        this.adapterSolos = adapterSolos;
    }

    @Override
    public int getCount() {
        return adapterSolos.size();
    }

    @Override
    public Object getItem(int i) {
        return adapterSolos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_guitarsolo,viewGroup,false);
        }

        //populate
        TextView txtViewSolo = view.findViewById(R.id.txtViewSolo);
        txtViewSolo.setText(adapterSolos.get(i).getSoloName());

        //Drawable object creation with the song pic
        Drawable img = ContextCompat.getDrawable(viewGroup.getContext(),
                adapterSolos.get(i).getSoloPic());
        //set the bounds (size) of the drawable
        img.setBounds(0, 0, 80, 80);
        //set up compound drawables for textview
        txtViewSolo.setCompoundDrawables(img,null,null,null);
        txtViewSolo.setCompoundDrawablePadding(8);
        //return view
        return view;
    }
}
