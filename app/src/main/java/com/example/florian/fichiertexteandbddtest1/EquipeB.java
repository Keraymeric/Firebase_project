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

public class EquipeB extends AppCompatActivity {

    EditText numB1;
    EditText numB2;
    EditText numB3;
    EditText numB4;
    EditText numB5;
    EditText numB6;
    EditText numB7;
    EditText numB8;
    EditText numB9;
    EditText numB10;
    EditText numB11;
    EditText numB12;
    /*EditText numB13;
    EditText numB14;
    EditText numB15;*/

    Spinner capitaineEquipeB;

    Spinner nomB1;
    Spinner nomB2;
    Spinner nomB3;
    Spinner nomB4;
    Spinner nomB5;
    Spinner nomB6;
    Spinner nomB7;
    Spinner nomB8;
    Spinner nomB9;
    Spinner nomB10;
    Spinner nomB11;
    Spinner nomB12;
    Spinner nomB13;
    Spinner nomB14;
    Spinner nomB15;

    Button buttonEquipeBAjouterJoueur;

    Button buttonEquipeBValider;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe_b);

        databaseHelper = new DatabaseHelper(this);

        final SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        if(nomEquipeB == ""){
            Intent intent = new Intent(EquipeB.this, MatchActivity.class);
            Toast.makeText(EquipeB.this, "Vous devez d'abord indiquer l'équipe A dans Préparatifs", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }


        final SharedPreferences loadEquipeB = getSharedPreferences("equipeB",0);

        numB1 = (EditText)findViewById(R.id.numB1); numB1.setText(loadEquipeB.getString("numB1", ""));
        numB2 = (EditText)findViewById(R.id.numB2); numB2.setText(loadEquipeB.getString("numB2", ""));
        numB3 = (EditText)findViewById(R.id.numB3); numB3.setText(loadEquipeB.getString("numB3", ""));
        numB4 = (EditText)findViewById(R.id.numB4); numB4.setText(loadEquipeB.getString("numB4", ""));
        numB5 = (EditText)findViewById(R.id.numB5); numB5.setText(loadEquipeB.getString("numB5", ""));
        numB6 = (EditText)findViewById(R.id.numB6); numB6.setText(loadEquipeB.getString("numB6", ""));
        numB7 = (EditText)findViewById(R.id.numB7); numB7.setText(loadEquipeB.getString("numB7", ""));
        numB8 = (EditText)findViewById(R.id.numB8); numB8.setText(loadEquipeB.getString("numB8", ""));
        numB9 = (EditText)findViewById(R.id.numB9); numB9.setText(loadEquipeB.getString("numB9", ""));
        numB10 = (EditText)findViewById(R.id.numB10); numB10.setText(loadEquipeB.getString("numB10", ""));
        numB11 = (EditText)findViewById(R.id.numB11); numB11.setText(loadEquipeB.getString("numB11", ""));
        numB12 = (EditText)findViewById(R.id.numB12); numB12.setText(loadEquipeB.getString("numB12", ""));
        /*numB13 = (EditText)findViewById(R.id.numB13); numB13.setText(loadEquipeB.getString("numB13", ""));
        numB14 = (EditText)findViewById(R.id.numB14); numB14.setText(loadEquipeB.getString("numB14", ""));
        numB15 = (EditText)findViewById(R.id.numB15); numB15.setText(loadEquipeB.getString("numB15", ""));*/


        final ArrayList<Joueur> lesJoueurs = databaseHelper.getAllJoueurOfEquipe(Integer.parseInt(loadPreparatif.getString("idEquipeB", "")));
        Joueur joueurVide = new Joueur(); //ajout d'une équipe vide pour le cas où l'équipe n'est pas encore choisie
        joueurVide.setNom_joueur(""); joueurVide.setPrenom_joueur(""); joueurVide.setNum_licence_joueur(0);
        lesJoueurs.add(0, joueurVide);

        final JoueurAdapteur joueurAdapter = new JoueurAdapteur(this, lesJoueurs);

        //concernant le capitaine (rangé dans approbation)
        capitaineEquipeB = (Spinner)findViewById(R.id.capitaineEquipeB);
        capitaineEquipeB.setAdapter(joueurAdapter);
        final SharedPreferences loadApprobation = getSharedPreferences("approbation",0);
        String idCapitaineB = loadApprobation.getString("idCapitaineB", "");
        if(idCapitaineB != ""){
            capitaineEquipeB.setSelection(findPositionJoueurWithName(lesJoueurs, idCapitaineB));
        }

        nomB1 = (Spinner)findViewById(R.id.nomB1); nomB1.setAdapter(joueurAdapter);
        String idB1 = loadEquipeB.getString("idB1", "");
        if (idB1 != "") {
            nomB1.setSelection(findPositionJoueurWithName(lesJoueurs, idB1));
        }
        nomB2 = (Spinner)findViewById(R.id.nomB2); nomB2.setAdapter(joueurAdapter);
        String idB2 = loadEquipeB.getString("idB2", "");
        if (idB2 != "") {
            nomB2.setSelection(findPositionJoueurWithName(lesJoueurs, idB2));
        }
        nomB3 = (Spinner)findViewById(R.id.nomB3); nomB3.setAdapter(joueurAdapter);
        String idB3 = loadEquipeB.getString("idB3", "");
        if (idB3 != "") {
            nomB3.setSelection(findPositionJoueurWithName(lesJoueurs, idB3));
        }
        nomB4 = (Spinner)findViewById(R.id.nomB4); nomB4.setAdapter(joueurAdapter);
        String idB4 = loadEquipeB.getString("idB4", "");
        if (idB4 != "") {
            nomB4.setSelection(findPositionJoueurWithName(lesJoueurs, idB4));
        }
        nomB5 = (Spinner)findViewById(R.id.nomB5); nomB5.setAdapter(joueurAdapter);
        String idB5 = loadEquipeB.getString("idB5", "");
        if (idB5 != "") {
            nomB5.setSelection(findPositionJoueurWithName(lesJoueurs, idB5));
        }
        nomB6 = (Spinner)findViewById(R.id.nomB6); nomB6.setAdapter(joueurAdapter);
        String idB6 = loadEquipeB.getString("idB6", "");
        if (idB6 != "") {
            nomB6.setSelection(findPositionJoueurWithName(lesJoueurs, idB6));
        }
        nomB7 = (Spinner)findViewById(R.id.nomB7); nomB7.setAdapter(joueurAdapter);
        String idB7 = loadEquipeB.getString("idB7", "");
        if (idB7 != "") {
            nomB7.setSelection(findPositionJoueurWithName(lesJoueurs, idB7));
        }
        nomB8 = (Spinner)findViewById(R.id.nomB8); nomB8.setAdapter(joueurAdapter);
        String idB8 = loadEquipeB.getString("idB8", "");
        if (idB8 != "") {
            nomB8.setSelection(findPositionJoueurWithName(lesJoueurs, idB8));
        }
        nomB9 = (Spinner)findViewById(R.id.nomB9); nomB9.setAdapter(joueurAdapter);
        String idB9 = loadEquipeB.getString("idB9", "");
        if (idB9 != "") {
            nomB9.setSelection(findPositionJoueurWithName(lesJoueurs, idB9));
        }
        nomB10 = (Spinner)findViewById(R.id.nomB10); nomB10.setAdapter(joueurAdapter);
        String idB10 = loadEquipeB.getString("idB10", "");
        if (idB10 != "") {
            nomB10.setSelection(findPositionJoueurWithName(lesJoueurs, idB10));
        }
        nomB11 = (Spinner)findViewById(R.id.nomB11); nomB11.setAdapter(joueurAdapter);
        String idB11 = loadEquipeB.getString("idB11", "");
        if (idB11 != "") {
            nomB11.setSelection(findPositionJoueurWithName(lesJoueurs, idB11));
        }
        nomB12 = (Spinner)findViewById(R.id.nomB12); nomB12.setAdapter(joueurAdapter);
        String idB12 = loadEquipeB.getString("idB12", "");
        if (idB12 != "") {
            nomB12.setSelection(findPositionJoueurWithName(lesJoueurs, idB12));
        }
        nomB13 = (Spinner)findViewById(R.id.nomB13); nomB13.setAdapter(joueurAdapter);
        String idB13 = loadEquipeB.getString("idB13", "");
        if (idB13 != "") {
            nomB13.setSelection(findPositionJoueurWithName(lesJoueurs, idB13));
        }
        nomB14 = (Spinner)findViewById(R.id.nomB14); nomB14.setAdapter(joueurAdapter);
        String idB14 = loadEquipeB.getString("idB14", "");
        if (idB14 != "") {
            nomB14.setSelection(findPositionJoueurWithName(lesJoueurs, idB14));
        }
        nomB15 = (Spinner)findViewById(R.id.nomB15); nomB15.setAdapter(joueurAdapter);
        String idB15 = loadEquipeB.getString("idB15", "");
        if (idB15 != "") {
            nomB15.setSelection(findPositionJoueurWithName(lesJoueurs, idB15));
        }

        buttonEquipeBAjouterJoueur = (Button)findViewById(R.id.buttonEquipeBAjouterJoueur);

        buttonEquipeBValider = (Button)findViewById(R.id.buttonEquipeBValider);

        buttonEquipeBValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences saveEquipeB = getSharedPreferences("equipeB",0);
                SharedPreferences.Editor editorEquipeB = saveEquipeB.edit();
                editorEquipeB.putString("numB1", numB1.getText().toString());
                editorEquipeB.putString("numB2", numB2.getText().toString());
                editorEquipeB.putString("numB3", numB3.getText().toString());
                editorEquipeB.putString("numB4", numB4.getText().toString());
                editorEquipeB.putString("numB5", numB5.getText().toString());
                editorEquipeB.putString("numB6", numB6.getText().toString());
                editorEquipeB.putString("numB7", numB7.getText().toString());
                editorEquipeB.putString("numB8", numB8.getText().toString());
                editorEquipeB.putString("numB9", numB9.getText().toString());
                editorEquipeB.putString("numB10", numB10.getText().toString());
                editorEquipeB.putString("numB11", numB11.getText().toString());
                editorEquipeB.putString("numB12", numB12.getText().toString());
                /*editorEquipeB.putString("numB13", numB13.getText().toString());
                editorEquipeB.putString("numB14", numB14.getText().toString());
                editorEquipeB.putString("numB15", numB15.getText().toString());*/

                editorEquipeB.putString("nomB1", lesJoueurs.get(nomB1.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB1.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB1", String.valueOf(lesJoueurs.get(nomB1.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB1", "" +  lesJoueurs.get(nomB1.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB2", lesJoueurs.get(nomB2.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB2.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB2", String.valueOf(lesJoueurs.get(nomB2.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB2", "" +  lesJoueurs.get(nomB2.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB3", lesJoueurs.get(nomB3.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB3.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB3", String.valueOf(lesJoueurs.get(nomB3.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB3", "" +  lesJoueurs.get(nomB3.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB4", lesJoueurs.get(nomB4.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB4.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB4", String.valueOf(lesJoueurs.get(nomB4.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB4", "" +  lesJoueurs.get(nomB4.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB5", lesJoueurs.get(nomB5.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB5.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB5", String.valueOf(lesJoueurs.get(nomB5.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB5", "" +  lesJoueurs.get(nomB5.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB6", lesJoueurs.get(nomB6.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB6.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB6", String.valueOf(lesJoueurs.get(nomB6.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB6", "" +  lesJoueurs.get(nomB6.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB7", lesJoueurs.get(nomB7.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB7.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB7", String.valueOf(lesJoueurs.get(nomB7.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB7", "" +  lesJoueurs.get(nomB7.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB8", lesJoueurs.get(nomB8.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB8.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB8", String.valueOf(lesJoueurs.get(nomB8.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB8", "" +  lesJoueurs.get(nomB8.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB9", lesJoueurs.get(nomB9.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB9.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB9", String.valueOf(lesJoueurs.get(nomB9.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB9", "" +  lesJoueurs.get(nomB9.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB10", lesJoueurs.get(nomB10.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB10.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB10", String.valueOf(lesJoueurs.get(nomB10.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB10", "" +  lesJoueurs.get(nomB10.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB11", lesJoueurs.get(nomB11.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB11.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB11", String.valueOf(lesJoueurs.get(nomB11.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB11", "" +  lesJoueurs.get(nomB11.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB12", lesJoueurs.get(nomB12.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB12.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB12", String.valueOf(lesJoueurs.get(nomB12.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB12", "" +  lesJoueurs.get(nomB12.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB13", lesJoueurs.get(nomB13.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB13.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB13", String.valueOf(lesJoueurs.get(nomB13.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB13", "" +  lesJoueurs.get(nomB13.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB14", lesJoueurs.get(nomB14.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB14.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB14", String.valueOf(lesJoueurs.get(nomB14.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB14", "" +  lesJoueurs.get(nomB14.getSelectedItemPosition()).getId());
                editorEquipeB.putString("nomB15", lesJoueurs.get(nomB15.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(nomB15.getSelectedItemPosition()).getPrenom_joueur());
                editorEquipeB.putString("numLicenceB15", String.valueOf(lesJoueurs.get(nomB15.getSelectedItemPosition()).getNum_licence_joueur()));
                editorEquipeB.putString("idB15", "" +  lesJoueurs.get(nomB15.getSelectedItemPosition()).getId());

                editorEquipeB.commit();

                //pour le capitaine
                SharedPreferences saveApprobation = getSharedPreferences("approbation",0);
                SharedPreferences.Editor editorApprobation = saveApprobation.edit();
                editorApprobation.putString("idCapitaineB","" + lesJoueurs.get(capitaineEquipeB.getSelectedItemPosition()).getId());
                editorApprobation.putString("nomCapitaineB","" + lesJoueurs.get(capitaineEquipeB.getSelectedItemPosition()).getNom_joueur() + " " + lesJoueurs.get(capitaineEquipeB.getSelectedItemPosition()).getPrenom_joueur());
                editorApprobation.putString("numLicenceCapitaineB", "" + lesJoueurs.get(capitaineEquipeB.getSelectedItemPosition()).getNum_licence_joueur());

                editorApprobation.commit();

                Intent intent = new Intent(EquipeB.this, MatchActivity.class);
                startActivity(intent);
            }
        });



        buttonEquipeBAjouterJoueur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showInputDialog(databaseHelper, equipe, th);

                LayoutInflater layoutInflater = LayoutInflater.from(EquipeB.this);
                View promptView = layoutInflater.inflate(R.layout.ajouter_joueur_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EquipeB.this);
                alertDialogBuilder.setView(promptView);

                final EditText editTextNomAjouterJoueurDialog = (EditText) promptView.findViewById(R.id.editTextNomAjouterJoueurDialog);
                final EditText editTextPrenomAjouterJoueurDialog = (EditText) promptView.findViewById(R.id.editTextPrenomAjouterJoueurDialog);
                final EditText editTextNumLicenceAjouterJoueurDialog = (EditText) promptView.findViewById(R.id.editTextNumLicenceAjouterJoueurDialog);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
                                String idEquipeB = loadPreparatif.getString("idEquipeB", "");
                                databaseHelper.addJoueur(editTextNomAjouterJoueurDialog.getText().toString(), editTextPrenomAjouterJoueurDialog.getText().toString(), Integer.parseInt(editTextNumLicenceAjouterJoueurDialog.getText().toString()), Integer.parseInt(idEquipeB));

                                //Faire ICI Pareil que valider
                                buttonEquipeBValider.performClick();

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
}
