package com.example.florian.fichiertexteandbddtest1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class JoueurAdapteur extends BaseAdapter {

    private Context context;
    private ArrayList<Joueur> joueurArrayList;

    //constructeur
    public JoueurAdapteur(Context context, ArrayList<Joueur> joueurArrayList){
        this.context = context;
        this.joueurArrayList = joueurArrayList;
    }

    @Override
    public int getCount() {
        return joueurArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return joueurArrayList.get(position);
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
            convertView = inflater.inflate(R.layout.lv_joueur_item, null, true);

            holder.tvnom = (TextView) convertView.findViewById(R.id.lvItemJoueurNom);
            holder.tvprenom = (TextView) convertView.findViewById(R.id.lvItemJoueurPrenom);
            holder.tvnumLicence = (TextView) convertView.findViewById(R.id.lvItemJoueurNumLicence);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvnom.setText(""+joueurArrayList.get(position).getNom());
        holder.tvprenom.setText(""+joueurArrayList.get(position).getPrenom());
        holder.tvnumLicence.setText(""+joueurArrayList.get(position).getNum_licence());

        return convertView;
    }


    private class ViewHolder {

        protected TextView tvnom, tvprenom, tvnumLicence;
    }
}
