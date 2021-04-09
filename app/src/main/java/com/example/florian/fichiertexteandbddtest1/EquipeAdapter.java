package com.example.florian.fichiertexteandbddtest1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EquipeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Equipe> equipeArrayList;

    //constructeur
    public EquipeAdapter(Context context, ArrayList<Equipe> equipeArrayList){
        this.context = context;
        this.equipeArrayList = equipeArrayList;
    }


    @Override
    public int getCount() {
        return equipeArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return equipeArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;


        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_equipe_item, null, true);

            holder.tvnom = (TextView) convertView.findViewById(R.id.lvItemEquipeNom);
            holder.tvnom2 = (TextView) convertView.findViewById(R.id.LvItemEquipeNiveau);
            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvnom.setText(equipeArrayList.get(position).getNom());
        holder.tvnom2.setText(equipeArrayList.get(position).getNiveau());
        return convertView;
    }

    private class ViewHolder {

        protected TextView tvnom2;
        protected TextView tvnom;
    }
}
