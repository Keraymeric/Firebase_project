package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Preparatif extends AppCompatActivity {

    EditText editTextDate;
    EditText editTextCompetition;
    EditText editTextCategorie;
    EditText editTextLieu;
    EditText editTextHeureDebut;
    EditText editTextNomEquipeA;
    EditText editTextNomEquipeB;

    EditText nomArbitre1;
    EditText numLicenceArbitre1;
    EditText clubDesigneArbitre1;
    EditText indemniteArbitre1;
    EditText nomArbitre2;
    EditText numLicenceArbitre2;

    Spinner spinnerNomEquipeA, spinnerNomEquipeB;

    Button buttonPreparatifValider;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparatif);

        databaseHelper = new DatabaseHelper(this);

        SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);

        editTextDate = (EditText) findViewById(R.id.editTextDate);
        editTextDate.setText(loadPreparatif.getString("date", ""));
        editTextCompetition = (EditText) findViewById(R.id.editTextCompetition);
        editTextCompetition.setText(loadPreparatif.getString("competition", ""));
        editTextCategorie = (EditText) findViewById(R.id.editTextCategorie);
        editTextCategorie.setText(loadPreparatif.getString("categorie", ""));
        editTextLieu = (EditText) findViewById(R.id.editTextLieu);
        editTextLieu.setText(loadPreparatif.getString("lieu", ""));
        editTextHeureDebut = (EditText) findViewById(R.id.editTextHeureDebut);
        editTextHeureDebut.setText(loadPreparatif.getString("heureDebut", ""));
        //editTextNomEquipeA = (EditText) findViewById(R.id.editTextNomEquipeA);
        //editTextNomEquipeA.setText(loadPreparatif.getString("nomEquipeA", ""));
        //editTextNomEquipeB = (EditText) findViewById(R.id.editTextNomEquipeB);
        //editTextNomEquipeB.setText(loadPreparatif.getString("nomEquipeB", ""));

        spinnerNomEquipeA = (Spinner) findViewById(R.id.spinnerNomEquipeA);
        spinnerNomEquipeB = (Spinner) findViewById(R.id.spinnerNomEquipeB);

        final ArrayList<Equipe> lesEquipes = databaseHelper.getAllEquipe();
        Equipe equipeVide = new Equipe(); //ajout d'une équipe vide pour le cas où l'équipe n'est pas encore choisie
        equipeVide.setNom("");
        lesEquipes.add(0, equipeVide);

        EquipeAdapter equipeAdapter = new EquipeAdapter(this, lesEquipes);

        spinnerNomEquipeA.setAdapter(equipeAdapter);
        String nA = loadPreparatif.getString("idEquipeA", "");
        if (nA != "") {
            for (int i = 0; i < lesEquipes.size(); i++) {
                if(lesEquipes.get(i).getId() ==  Integer.parseInt(nA)){
                    spinnerNomEquipeA.setSelection(i);
                }
            }

        }
        spinnerNomEquipeB.setAdapter(equipeAdapter);
        String idEquipeB = loadPreparatif.getString("idEquipeB", "");
        if (idEquipeB != "") {
            spinnerNomEquipeB.setSelection(findPositionEquipeWithName(lesEquipes, idEquipeB));
        }

        //Arbitres
        SharedPreferences loadResultat = getSharedPreferences("approbation",0);

        nomArbitre1 = (EditText)findViewById(R.id.nomArbitre1); nomArbitre1.setText(loadResultat.getString("nomArbitre1", ""));
        numLicenceArbitre1 = (EditText)findViewById(R.id.numLicenceArbitre1); numLicenceArbitre1.setText(loadResultat.getString("numLicenceArbitre1", ""));
        clubDesigneArbitre1 = (EditText)findViewById(R.id.clubDesigneArbitre1); clubDesigneArbitre1.setText(loadResultat.getString("clubDesigneArbitre1", ""));
        indemniteArbitre1 = (EditText)findViewById(R.id.indemniteArbitre1); indemniteArbitre1.setText(loadResultat.getString("indemniteArbitre1", ""));
        nomArbitre2 = (EditText)findViewById(R.id.nomArbitre2); nomArbitre2.setText(loadResultat.getString("nomArbitre2", ""));
        numLicenceArbitre2 = (EditText)findViewById(R.id.numLicenceArbitre2); numLicenceArbitre2.setText((loadResultat.getString("numLicenceArbitre2", "")));

        buttonPreparatifValider = (Button) findViewById(R.id.buttonPreparatifValider);

        buttonPreparatifValider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String date = editTextDate.getText().toString();
                    String competition = editTextCompetition.getText().toString();
                    String categorie = editTextCategorie.getText().toString();
                    String lieu = editTextLieu.getText().toString();
                    String heureDebut = editTextHeureDebut.getText().toString();
                    //String nomEquipeA = editTextNomEquipeA.getText().toString();
                    //String nomEquipeB = editTextNomEquipeB.getText().toString();

                    SharedPreferences savePreparatif = getSharedPreferences("preparatif", 0);
                    SharedPreferences.Editor editorPreparatif = savePreparatif.edit();
                    editorPreparatif.putString("date", date);
                    editorPreparatif.putString("competition", competition);
                    editorPreparatif.putString("categorie", categorie);
                    editorPreparatif.putString("lieu", lieu);
                    editorPreparatif.putString("heureDebut", heureDebut);
                    editorPreparatif.putString("nomEquipeA", lesEquipes.get(spinnerNomEquipeA.getSelectedItemPosition()).getNom());
                    editorPreparatif.putString("nomEquipeB", lesEquipes.get(spinnerNomEquipeB.getSelectedItemPosition()).getNom());
                    editorPreparatif.putString("idEquipeA", "" +  lesEquipes.get(spinnerNomEquipeA.getSelectedItemPosition()).getId());
                    editorPreparatif.putString("idEquipeB", "" +  lesEquipes.get(spinnerNomEquipeB.getSelectedItemPosition()).getId());
                    editorPreparatif.commit();

                    SharedPreferences saveApprobation = getSharedPreferences("approbation",0);
                    SharedPreferences.Editor editorApprobation = saveApprobation.edit();
                    editorApprobation.putString("nomArbitre1", nomArbitre1.getText().toString());
                    editorApprobation.putString("numLicenceArbitre1", numLicenceArbitre1.getText().toString());
                    editorApprobation.putString("clubDesigneArbitre1", clubDesigneArbitre1.getText().toString());
                    editorApprobation.putString("indemniteArbitre1", indemniteArbitre1.getText().toString());
                    editorApprobation.putString("nomArbitre2", nomArbitre2.getText().toString());
                    editorApprobation.putString("numLicenceArbitre2", numLicenceArbitre2.getText().toString());
                    editorApprobation.commit();


                    Intent intent = new Intent(Preparatif.this, MatchActivity.class);
                    startActivity(intent);

                }
        });

    }

    private int findPositionEquipeWithName(ArrayList<Equipe> lesEquipes, String id) {
        for (int i = 0; i < lesEquipes.size(); i++) {
            if (lesEquipes.get(i).getId() == Integer.parseInt(id)) {
                return i;
            }
        }
        return -1;
    }


    }

