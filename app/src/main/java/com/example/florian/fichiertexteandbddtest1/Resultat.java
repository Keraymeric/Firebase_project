package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Resultat extends AppCompatActivity {

    /*EditText equipeVainqueure;
    EditText equipeVaincu;*/
    EditText nbSetVainqueure;
    EditText nbSetVaincu;

    Spinner equipeVainqueure;
    Spinner equipeVaincu;

    EditText editHeureFin;

    Button buttonResultatValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        //on récuper les deux équipes sous forme de liste d'Euquipe pour faire un adapteur
        SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        Equipe equipeA = new Equipe(); equipeA.setNom(nomEquipeA); equipeA.setId(1);
        Equipe equipeB = new Equipe(); equipeB.setNom(nomEquipeB); equipeB.setId(2);
        Equipe equipeVide = new Equipe(); equipeVide.setNom(""); equipeVide.setId(-1);

        final ArrayList<Equipe> lesEquipes = new ArrayList<Equipe>();
        lesEquipes.add(equipeVide);
        lesEquipes.add(equipeA);
        lesEquipes.add(equipeB);

        EquipeAdapter equipeAdapter = new EquipeAdapter(this, lesEquipes);

        SharedPreferences loadResultat = getSharedPreferences("resultat",0);

        final Spinner equipeVainqueure = (Spinner)findViewById(R.id.equipeVainqueure);
        equipeVainqueure.setAdapter(equipeAdapter);
        String nomVainqueure = loadResultat.getString("vainqueur", "");
        String idVainqueure = loadResultat.getString("idVainqueur", "");
        if (nomVainqueure != "") {
            equipeVainqueure.setSelection(findPositionEquipeWithName(lesEquipes, idVainqueure)); //faire getbyId(id) ->set numéro
        }

        final Spinner equipeVaincu = (Spinner)findViewById(R.id.equipeVaincu);
        equipeVaincu.setAdapter(equipeAdapter);
        String nomVaincu = loadResultat.getString("vaincu", "");
        String idVaincu = loadResultat.getString("idVaincu", "");
        if (nomVaincu != "") {
            equipeVaincu.setSelection(findPositionEquipeWithName(lesEquipes, idVaincu)); //faire getbyId(id) ->set numéro
        }


        /*equipeVainqueure = (EditText)findViewById(R.id.equipeVainqueure); equipeVainqueure.setText(loadResultat.getString("vainqueur", ""));
        equipeVaincu = (EditText)findViewById(R.id.equipeVaincu); equipeVaincu.setText(loadResultat.getString("vaincu", ""));*/
        nbSetVainqueure = (EditText)findViewById(R.id.nbSetVainqueure); nbSetVainqueure.setText(loadResultat.getString("nbSetVainqueur", ""));
        nbSetVaincu = (EditText)findViewById(R.id.nbSetVaincu); nbSetVaincu.setText(loadResultat.getString("nbSetVaincu", ""));

        editHeureFin = (EditText)findViewById(R.id.editHeureFin); editHeureFin.setText(loadResultat.getString("heureFin", ""));

        buttonResultatValider = (Button)findViewById(R.id.buttonResultatValider);
        buttonResultatValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences saveResultat = getSharedPreferences("resultat",0);
                SharedPreferences.Editor editorResultat = saveResultat.edit();
                /*editorResultat.putString("vainqueur", equipeVainqueure.getText().toString());
                editorResultat.putString("vaincu", equipeVaincu.getText().toString());*/

                editorResultat.putString("idVainqueur", "" + lesEquipes.get(equipeVainqueure.getSelectedItemPosition()).getId());
                editorResultat.putString("idVaincu", "" + lesEquipes.get(equipeVaincu.getSelectedItemPosition()).getId());
                editorResultat.putString("vainqueur", lesEquipes.get(equipeVainqueure.getSelectedItemPosition()).getNom());
                editorResultat.putString("vaincu", lesEquipes.get(equipeVaincu.getSelectedItemPosition()).getNom());

                editorResultat.putString("nbSetVainqueur", nbSetVainqueure.getText().toString());
                editorResultat.putString("nbSetVaincu", nbSetVaincu.getText().toString());
                editorResultat.putString("heureFin", editHeureFin.getText().toString());
                editorResultat.commit();

                Intent intent = new Intent(Resultat.this, MatchActivity.class);
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
