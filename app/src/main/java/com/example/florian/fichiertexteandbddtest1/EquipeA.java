package com.example.florian.fichiertexteandbddtest1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EquipeA extends AppCompatActivity {

    EditText numA1;
    EditText numA2;
    EditText numA3;
    EditText numA4;
    EditText numA5;
    EditText numA6;
    EditText numA7;
    EditText numA8;
    EditText numA9;
    EditText numA10;
    EditText numA11;
    EditText numA12;
    /*EditText numA13;
    EditText numA14;
    EditText numA15;*/

    Spinner capitaineEquipeA;

    Spinner nomA1;
    Spinner nomA2;
    Spinner nomA3;
    Spinner nomA4;
    Spinner nomA5;
    Spinner nomA6;
    Spinner nomA7;
    Spinner nomA8;
    Spinner nomA9;
    Spinner nomA10;
    Spinner nomA11;
    Spinner nomA12;
    Spinner nomA13;
    Spinner nomA14;
    Spinner nomA15;

    Button buttonEquipeAAjouterJoueur;

    Button buttonEquipeAValider;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe_a);

        databaseHelper = new DatabaseHelper(this);

        final SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
            if(nomEquipeA == ""){
                Intent intent = new Intent(EquipeA.this, MatchActivity.class);
                Toast.makeText(EquipeA.this, "Vous devez d'abord indiquer l'équipe A dans Préparatifs", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }


        final SharedPreferences loadEquipeA = getSharedPreferences("equipeA",0);

        numA1 = (EditText)findViewById(R.id.numA1); numA1.setText(loadEquipeA.getString("numA1", ""));
        numA2 = (EditText)findViewById(R.id.numA2); numA2.setText(loadEquipeA.getString("numA2", ""));
        numA3 = (EditText)findViewById(R.id.numA3); numA3.setText(loadEquipeA.getString("numA3", ""));
        numA4 = (EditText)findViewById(R.id.numA4); numA4.setText(loadEquipeA.getString("numA4", ""));
        numA5 = (EditText)findViewById(R.id.numA5); numA5.setText(loadEquipeA.getString("numA5", ""));
        numA6 = (EditText)findViewById(R.id.numA6); numA6.setText(loadEquipeA.getString("numA6", ""));
        numA7 = (EditText)findViewById(R.id.numA7); numA7.setText(loadEquipeA.getString("numA7", ""));
        numA8 = (EditText)findViewById(R.id.numA8); numA8.setText(loadEquipeA.getString("numA8", ""));
        numA9 = (EditText)findViewById(R.id.numA9); numA9.setText(loadEquipeA.getString("numA9", ""));
        numA10 = (EditText)findViewById(R.id.numA10); numA10.setText(loadEquipeA.getString("numA10", ""));
        numA11 = (EditText)findViewById(R.id.numA11); numA11.setText(loadEquipeA.getString("numA11", ""));
        numA12 = (EditText)findViewById(R.id.numA12); numA12.setText(loadEquipeA.getString("numA12", ""));
        /*numA13 = (EditText)findViewById(R.id.numA13); numA13.setText(loadEquipeA.getString("numA13", ""));
        numA14 = (EditText)findViewById(R.id.numA14); numA14.setText(loadEquipeA.getString("numA14", ""));
        numA15 = (EditText)findViewById(R.id.numA15); numA15.setText(loadEquipeA.getString("numA15", ""));*/


        final ArrayList<Joueur> lesJoueurs = databaseHelper.getAllJoueurOfEquipe(Integer.parseInt(loadPreparatif.getString("idEquipeA", "")));
        Joueur joueurVide = new Joueur(); //ajout d'une équipe vide pour le cas où l'équipe n'est pas encore choisie
        joueurVide.setNom_joueur(""); joueurVide.setPrenom_joueur(""); joueurVide.setNum_licence_joueur(" "); joueurVide.setId(-1);
        lesJoueurs.add(0, joueurVide);

        final JoueurAdapteur joueurAdapter = new JoueurAdapteur(this, lesJoueurs);

        //concernant le capitaine (rangé dans approbation)
        capitaineEquipeA = (Spinner)findViewById(R.id.capitaineEquipeA);
        capitaineEquipeA.setAdapter(joueurAdapter);
        final SharedPreferences loadApprobation = getSharedPreferences("approbation",0);
        String idCapitaineA = loadApprobation.getString("idCapitaineA", "");
        if(idCapitaineA != ""){
            capitaineEquipeA.setSelection(findPositionJoueurWithName(lesJoueurs, idCapitaineA));
        }


        nomA1 = (Spinner)findViewById(R.id.nomA1); nomA1.setAdapter(joueurAdapter);
        String idA1 = loadEquipeA.getString("idA1", "");
        if (idA1 != "") {
            nomA1.setSelection(findPositionJoueurWithName(lesJoueurs, idA1)); //faire getbyId(id) ->set numéro
        }
        nomA2 = (Spinner)findViewById(R.id.nomA2); nomA2.setAdapter(joueurAdapter);
        String idA2 = loadEquipeA.getString("idA2", "");
        if (idA2 != "") {
            nomA2.setSelection(findPositionJoueurWithName(lesJoueurs, idA2));
        }
        nomA3 = (Spinner)findViewById(R.id.nomA3); nomA3.setAdapter(joueurAdapter);
        String idA3 = loadEquipeA.getString("idA3", "");
        if (idA3 != "") {
            nomA3.setSelection(findPositionJoueurWithName(lesJoueurs, idA3));
        }
        nomA4 = (Spinner)findViewById(R.id.nomA4); nomA4.setAdapter(joueurAdapter);
        String idA4 = loadEquipeA.getString("idA4", "");
        if (idA4 != "") {
            nomA4.setSelection(findPositionJoueurWithName(lesJoueurs, idA4));
        }
        nomA5 = (Spinner)findViewById(R.id.nomA5); nomA5.setAdapter(joueurAdapter);
        String idA5 = loadEquipeA.getString("idA5", "");
        if (idA5 != "") {
            nomA5.setSelection(findPositionJoueurWithName(lesJoueurs, idA5));
        }
        nomA6 = (Spinner)findViewById(R.id.nomA6); nomA6.setAdapter(joueurAdapter);
        String idA6 = loadEquipeA.getString("idA6", "");
        if (idA6 != "") {
            nomA6.setSelection(findPositionJoueurWithName(lesJoueurs, idA6));
        }
        nomA7 = (Spinner)findViewById(R.id.nomA7); nomA7.setAdapter(joueurAdapter);
        String idA7 = loadEquipeA.getString("idA7", "");
        if (idA7 != "") {
            nomA7.setSelection(findPositionJoueurWithName(lesJoueurs, idA7));
        }
        nomA8 = (Spinner)findViewById(R.id.nomA8); nomA8.setAdapter(joueurAdapter);
        String idA8 = loadEquipeA.getString("idA8", "");
        if (idA8 != "") {
            nomA8.setSelection(findPositionJoueurWithName(lesJoueurs, idA8));
        }
        nomA9 = (Spinner)findViewById(R.id.nomA9); nomA9.setAdapter(joueurAdapter);
        String idA9 = loadEquipeA.getString("idA9", "");
        if (idA9 != "") {
            nomA9.setSelection(findPositionJoueurWithName(lesJoueurs, idA9));
        }
        nomA10 = (Spinner)findViewById(R.id.nomA10); nomA10.setAdapter(joueurAdapter);
        String idA10 = loadEquipeA.getString("idA10", "");
        if (idA10 != "") {
            nomA10.setSelection(findPositionJoueurWithName(lesJoueurs, idA10));
        }
        nomA11 = (Spinner)findViewById(R.id.nomA11); nomA11.setAdapter(joueurAdapter);
        String idA11 = loadEquipeA.getString("idA11", "");
        if (idA11 != "") {
            nomA11.setSelection(findPositionJoueurWithName(lesJoueurs, idA11));
        }
        nomA12 = (Spinner)findViewById(R.id.nomA12); nomA12.setAdapter(joueurAdapter);
        String idA12 = loadEquipeA.getString("idA12", "");
        if (idA12 != "") {
            nomA12.setSelection(findPositionJoueurWithName(lesJoueurs, idA12));
        }
        nomA13 = (Spinner)findViewById(R.id.nomA13); nomA13.setAdapter(joueurAdapter);
        String idA13 = loadEquipeA.getString("idA13", "");
        if (idA13 != "") {
            nomA13.setSelection(findPositionJoueurWithName(lesJoueurs, idA13));
        }
        nomA14 = (Spinner)findViewById(R.id.nomA14); nomA14.setAdapter(joueurAdapter);
        String idA14 = loadEquipeA.getString("idA14", "");
        if (idA14 != "") {
            nomA14.setSelection(findPositionJoueurWithName(lesJoueurs, idA14));
        }
        nomA15 = (Spinner)findViewById(R.id.nomA15); nomA15.setAdapter(joueurAdapter);
        String idA15 = loadEquipeA.getString("idA15", "");
        if (idA15 != "") {
            nomA15.setSelection(findPositionJoueurWithName(lesJoueurs, idA15));
        }

        buttonEquipeAAjouterJoueur = (Button)findViewById(R.id.buttonEquipeAAjouterJoueur);

        buttonEquipeAValider = (Button)findViewById(R.id.buttonEquipeAValider);

        buttonEquipeAValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences saveEquipeA = getSharedPreferences("equipeA",0);
                SharedPreferences.Editor editorEquipeA = saveEquipeA.edit();
                editorEquipeA.putString("numA1", numA1.getText().toString());
                editorEquipeA.putString("numA2", numA2.getText().toString());
                editorEquipeA.putString("numA3", numA3.getText().toString());
                editorEquipeA.putString("numA4", numA4.getText().toString());
                editorEquipeA.putString("numA5", numA5.getText().toString());
                editorEquipeA.putString("numA6", numA6.getText().toString());
                editorEquipeA.putString("numA7", numA7.getText().toString());
                editorEquipeA.putString("numA8", numA8.getText().toString());
                editorEquipeA.putString("numA9", numA9.getText().toString());
                editorEquipeA.putString("numA10", numA10.getText().toString());
                editorEquipeA.putString("numA11", numA11.getText().toString());
                editorEquipeA.putString("numA12", numA12.getText().toString());
                /*editorEquipeA.putString("numA13", numA13.getText().toString());
                editorEquipeA.putString("numA14", numA14.getText().toString());
                editorEquipeA.putString("numA15", numA15.getText().toString());*/

                editorEquipeA.putString("nomA1", lesJoueurs.get(nomA1.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA1.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA1", String.valueOf(lesJoueurs.get(nomA1.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA1", "" +  lesJoueurs.get(nomA1.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA2", lesJoueurs.get(nomA2.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA2.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA2", String.valueOf(lesJoueurs.get(nomA2.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA2", "" +  lesJoueurs.get(nomA2.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA3", lesJoueurs.get(nomA3.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA3.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA3", String.valueOf(lesJoueurs.get(nomA3.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA3", "" +  lesJoueurs.get(nomA3.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA4", lesJoueurs.get(nomA4.getSelectedItemPosition()).getNom_joueur()  + " " + lesJoueurs.get(nomA4.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA4", String.valueOf(lesJoueurs.get(nomA4.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA4", "" +  lesJoueurs.get(nomA4.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA5", lesJoueurs.get(nomA5.getSelectedItemPosition()).getNom_joueur()  + " " + lesJoueurs.get(nomA5.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA5", String.valueOf(lesJoueurs.get(nomA5.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA5", "" +  lesJoueurs.get(nomA5.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA6", lesJoueurs.get(nomA6.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA6.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA6", String.valueOf(lesJoueurs.get(nomA6.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA6", "" +  lesJoueurs.get(nomA6.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA7", lesJoueurs.get(nomA7.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA7.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA7", String.valueOf(lesJoueurs.get(nomA7.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA7", "" +  lesJoueurs.get(nomA7.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA8", lesJoueurs.get(nomA8.getSelectedItemPosition()).getNom_joueur()  + " " + lesJoueurs.get(nomA8.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA8", String.valueOf(lesJoueurs.get(nomA8.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA8", "" +  lesJoueurs.get(nomA8.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA9", lesJoueurs.get(nomA9.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA9.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA9", String.valueOf(lesJoueurs.get(nomA9.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA9", "" +  lesJoueurs.get(nomA9.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA10", lesJoueurs.get(nomA10.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA10.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA10", String.valueOf(lesJoueurs.get(nomA10.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA10", "" +  lesJoueurs.get(nomA10.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA11", lesJoueurs.get(nomA11.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA11.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA11", String.valueOf(lesJoueurs.get(nomA11.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA11", "" +  lesJoueurs.get(nomA11.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA12", lesJoueurs.get(nomA12.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA12.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA12", String.valueOf(lesJoueurs.get(nomA12.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA12", "" +  lesJoueurs.get(nomA12.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA13", lesJoueurs.get(nomA13.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA13.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA13", String.valueOf(lesJoueurs.get(nomA13.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA13", "" +  lesJoueurs.get(nomA13.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA14", lesJoueurs.get(nomA14.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA14.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA14", String.valueOf(lesJoueurs.get(nomA14.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA14", "" +  lesJoueurs.get(nomA14.getSelectedItemPosition()).getId());
                editorEquipeA.putString("nomA15", lesJoueurs.get(nomA15.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomA15.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeA.putString("numLicenceA15", String.valueOf(lesJoueurs.get(nomA15.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeA.putString("idA15", "" +  lesJoueurs.get(nomA15.getSelectedItemPosition()).getId());

                editorEquipeA.commit();

                //pour le capitaine
                SharedPreferences saveApprobation = getSharedPreferences("approbation",0);
                SharedPreferences.Editor editorApprobation = saveApprobation.edit();
                editorApprobation.putString("idCapitaineA","" + lesJoueurs.get(capitaineEquipeA.getSelectedItemPosition()).getId());
                editorApprobation.putString("nomCapitaineA","" + lesJoueurs.get(capitaineEquipeA.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(capitaineEquipeA.getSelectedItemPosition()).getPrenom_joueur());
                editorApprobation.putString("numLicenceCapitaineA", "" + lesJoueurs.get(capitaineEquipeA.getSelectedItemPosition()).getNum_licence_joueur());

                editorApprobation.commit();

                ArrayList<Integer> lesIdDesJoueursSelectiones = new ArrayList<Integer>();
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA1.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA2.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA3.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA4.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA5.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA6.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA7.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA8.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA9.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA10.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA11.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA12.getSelectedItemPosition()).getId());
                /*lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA13.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA14.getSelectedItemPosition()).getId());
                lesIdDesJoueursSelectiones.add(lesJoueurs.get(nomA15.getSelectedItemPosition()).getId());*/

                final SharedPreferences loadEquipeAAfter = getSharedPreferences("equipeA",0);
                ArrayList<String> lesNumDesJoueurs = new ArrayList<String>();
                for(int i=1; i<=12; i++){
                    lesNumDesJoueurs.add(loadEquipeAAfter.getString("numA"+i, ""));
                }



                if(isDoublonInArrayList(lesIdDesJoueursSelectiones)){
                    Toast.makeText(EquipeA.this, "Vous ne pouvez pas saisir deux fois le même joueur", Toast.LENGTH_LONG).show();
                }/*
                *//*else if(isDoublonInArrayListString(lesNumDesJoueurs)){
                    Toast.makeText(EquipeA.this, "Plusieurs joueurs ne peuvent pas avoir le même numéro", Toast.LENGTH_LONG).show();
                }*//*
                if(isJoueurWithoutNum(lesIdDesJoueursSelectiones, lesNumDesJoueurs)){
                    Toast.makeText(EquipeA.this, "Un des joueurs saisis n'a pas de numéro", Toast.LENGTH_LONG).show();
                }*/
                else{
                    Intent intent = new Intent(EquipeA.this, MatchActivity.class);
                    startActivity(intent);
                }

                //Intent intent = new Intent(EquipeA.this, MatchActivity.class);
                //startActivity(intent);
            }
        });



        buttonEquipeAAjouterJoueur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showInputDialog(databaseHelper, equipe, th);

                LayoutInflater layoutInflater = LayoutInflater.from(EquipeA.this);
                View promptView = layoutInflater.inflate(R.layout.ajouter_joueur_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EquipeA.this);
                alertDialogBuilder.setView(promptView);

                final EditText editTextNomAjouterJoueurDialog = (EditText) promptView.findViewById(R.id.editTextNomAjouterJoueurDialog);
                final EditText editTextPrenomAjouterJoueurDialog = (EditText) promptView.findViewById(R.id.editTextPrenomAjouterJoueurDialog);
                final EditText editTextNumLicenceAjouterJoueurDialog = (EditText) promptView.findViewById(R.id.editTextNumLicenceAjouterJoueurDialog);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
                                String idEquipeA = loadPreparatif.getString("idEquipeA", "");
                                databaseHelper.addJoueur(editTextNomAjouterJoueurDialog.getText().toString(), editTextPrenomAjouterJoueurDialog.getText().toString(), editTextNumLicenceAjouterJoueurDialog.getText().toString(), Integer.parseInt(idEquipeA));

                                //Faire ICI Pareil que valider
                                buttonEquipeAValider.performClick();

                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Annuler",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create an alert dialog
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

                //joueurAdapter.notifyDataSetChanged(); //TEST
            }
        });

    }

    private int findPositionJoueurWithName(ArrayList<Joueur> lesJoueurs, String id) {
        for (int i = 0; i < lesJoueurs.size(); i++) {
            if (lesJoueurs.get(i).getId() == Integer.parseInt(id)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isDoublonInArrayList(ArrayList<Integer> maListe){
        for(int i=0; i<maListe.size(); i++){
            int current = maListe.get(i);
            for(int j=i+1; j<maListe.size(); j++){
                if(current == maListe.get(j) && current !=-1){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isDoublonInArrayListString(ArrayList<String> maListe){
        for(int i=0; i<maListe.size(); i++){
            for(int j=i+1; j<maListe.size(); j++){
                if((maListe.get(i) != "") && (maListe.get(j) != "") && maListe.get(i) != null && maListe.get(j) != null ){
                    if(Integer.parseInt(maListe.get(i)) == Integer.parseInt(maListe.get(j))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isJoueurWithoutNum(ArrayList<Integer> joueursId, ArrayList<String> joueursNum){
        for(int i=0; i<joueursId.size(); i++){

                if((joueursId.get(i) != (-1)) && (joueursNum.get(i) == "")){
                    return true;
                }

        }
        return false;
    }
}
