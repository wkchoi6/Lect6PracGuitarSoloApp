package com.example.lect6pracguitarsoloapp;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SoloAdapter2 extends BaseAdapter {
    List<GuitarSolo> adapterSolo2;
    int SelectedInd = -1;

    public SoloAdapter2(List<GuitarSolo> adapterSolo2, int selectedInd) {
        this.adapterSolo2 = adapterSolo2;
        SelectedInd = selectedInd;
    }

    public SoloAdapter2(List<GuitarSolo> adapterSolo2) {
        this.adapterSolo2 = adapterSolo2;
    }

    public List<GuitarSolo> getAdapterSolo2() {
        return adapterSolo2;
    }

    public void setAdapterSolo2(List<GuitarSolo> adapterSolo2) {
        this.adapterSolo2 = adapterSolo2;
        notifyDataSetChanged();
    }

    public int getSelectedInd() {
        return SelectedInd;
    }

    public void setSelectedInd(int selectedInd) {
        SelectedInd = selectedInd;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return adapterSolo2.size();
    }

    @Override
    public Object getItem(int i) {
        return adapterSolo2.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_guitarsolo2, viewGroup, false);
        }
        TextView txtViewSong2 = view.findViewById(R.id.txtViewSongItem);
        ImageView imgIcon = view.findViewById(R.id.imgIcon);
        ImageView imgPlayStop = view.findViewById(R.id.imgPlayStop);
        txtViewSong2.setText(adapterSolo2.get(i).getSoloName());
        imgIcon.setImageResource(adapterSolo2.get(i).getSoloPic());
        if (i == SelectedInd) {
            imgPlayStop.setImageResource(R.drawable.stop);
        }
        else {
            imgPlayStop.setImageResource(R.drawable.play);
        }
        txtViewSong2.setGravity(Gravity.CENTER_VERTICAL);
        return view;
    }
}
