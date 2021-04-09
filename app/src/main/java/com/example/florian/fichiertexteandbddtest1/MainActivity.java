package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button buttonEquipeEtJoueur, buttonMatch;
    TextView accueilCurrentMatch;
    Button buttonCredits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accueilCurrentMatch = (TextView)findViewById(R.id.accueilCurrentMatch);

        SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        if(nomEquipeA == "" || nomEquipeB == ""){
            accueilCurrentMatch.setVisibility(View.GONE);
        }
        else{
            accueilCurrentMatch.setVisibility(View.VISIBLE);
            accueilCurrentMatch.setText(nomEquipeA + " - " + nomEquipeB);
        }

        buttonEquipeEtJoueur = (Button)findViewById(R.id.buttonEquipesEtJoueurs);
        buttonMatch = (Button)findViewById(R.id.buttonMatch);

        buttonEquipeEtJoueur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EquipeActivity.class);
                startActivity(intent);
            }
        });

        buttonMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MatchActivity.class);
                startActivity(intent);
            }
        });

        buttonCredits = (Button) findViewById(R.id.buttonCredits);

        buttonCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        accueilCurrentMatch = (TextView)findViewById(R.id.accueilCurrentMatch);
        SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        if(nomEquipeA == "" || nomEquipeB == ""){
            accueilCurrentMatch.setVisibility(View.GONE);
        }
        else{
            accueilCurrentMatch.setVisibility(View.VISIBLE);
            accueilCurrentMatch.setText(nomEquipeA + " - " + nomEquipeB);
        }
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        accueilCurrentMatch = (TextView)findViewById(R.id.accueilCurrentMatch);
        SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        if(nomEquipeA == "" || nomEquipeB == ""){
            accueilCurrentMatch.setVisibility(View.GONE);
        }
        else{
            accueilCurrentMatch.setVisibility(View.VISIBLE);
            accueilCurrentMatch.setText(nomEquipeA + " - " + nomEquipeB);
        }
    }
}
