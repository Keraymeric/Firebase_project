package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Set2 extends AppCompatActivity {

    //formation équipe A
    EditText set2Ap1;
    EditText set2Ap2;
    EditText set2Ap3;
    EditText set2Ap4;
    EditText set2Ap5;
    EditText set2Ap6;

    //formation équipe B
    EditText set2Bp1;
    EditText set2Bp2;
    EditText set2Bp3;
    EditText set2Bp4;
    EditText set2Bp5;
    EditText set2Bp6;

    //score
    EditText set2Ascore;
    EditText set2Bscore;

    //remplacement
    EditText set2RemplacementAp1;
    EditText set2RemplacementAp2;
    EditText set2RemplacementAp3;
    EditText set2RemplacementAp4;
    EditText set2RemplacementAp5;
    EditText set2RemplacementAp6;
    EditText set2RemplacementBp1;
    EditText set2RemplacementBp2;
    EditText set2RemplacementBp3;
    EditText set2RemplacementBp4;
    EditText set2RemplacementBp5;
    EditText set2RemplacementBp6;

    //Temps mort
    EditText set2ChronoDebutA;
    EditText set2ChronoDebutB;
    EditText set2ChronoFinA;
    EditText set2ChronoFinB;

    //bouton valider
    Button buttonSet2Valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set2);

        SharedPreferences loadSet2 = getSharedPreferences("set2",0);

        set2Ap1 = (EditText)findViewById(R.id.set2Ap1); set2Ap1.setText(loadSet2.getString("set2Ap1", ""));
        set2Ap2 = (EditText)findViewById(R.id.set2Ap2); set2Ap2.setText(loadSet2.getString("set2Ap2", ""));
        set2Ap3 = (EditText)findViewById(R.id.set2Ap3); set2Ap3.setText(loadSet2.getString("set2Ap3", ""));
        set2Ap4 = (EditText)findViewById(R.id.set2Ap4); set2Ap4.setText(loadSet2.getString("set2Ap4", ""));
        set2Ap5 = (EditText)findViewById(R.id.set2Ap5); set2Ap5.setText(loadSet2.getString("set2Ap5", ""));
        set2Ap6 = (EditText)findViewById(R.id.set2Ap6); set2Ap6.setText(loadSet2.getString("set2Ap6", ""));

        set2Bp1 = (EditText)findViewById(R.id.set2Bp1); set2Bp1.setText(loadSet2.getString("set2Bp1", ""));
        set2Bp2 = (EditText)findViewById(R.id.set2Bp2); set2Bp2.setText(loadSet2.getString("set2Bp2", ""));
        set2Bp3 = (EditText)findViewById(R.id.set2Bp3); set2Bp3.setText(loadSet2.getString("set2Bp3", ""));
        set2Bp4 = (EditText)findViewById(R.id.set2Bp4); set2Bp4.setText(loadSet2.getString("set2Bp4", ""));
        set2Bp5 = (EditText)findViewById(R.id.set2Bp5); set2Bp5.setText(loadSet2.getString("set2Bp5", ""));
        set2Bp6 = (EditText)findViewById(R.id.set2Bp6); set2Bp6.setText(loadSet2.getString("set2Bp6", ""));

        set2Ascore = (EditText)findViewById(R.id.set2Ascore); set2Ascore.setText(loadSet2.getString("set2Ascore", ""));
        set2Bscore = (EditText)findViewById(R.id.set2Bscore); set2Bscore.setText(loadSet2.getString("set2Bscore", ""));

        set2RemplacementAp1 = (EditText)findViewById(R.id.set2RemplacementAp1); set2RemplacementAp1.setText(loadSet2.getString("set2RemplacementAp1", ""));
        set2RemplacementAp2 = (EditText)findViewById(R.id.set2RemplacementAp2); set2RemplacementAp2.setText(loadSet2.getString("set2RemplacementAp2", ""));
        set2RemplacementAp3 = (EditText)findViewById(R.id.set2RemplacementAp3); set2RemplacementAp3.setText(loadSet2.getString("set2RemplacementAp3", ""));
        set2RemplacementAp4 = (EditText)findViewById(R.id.set2RemplacementAp4); set2RemplacementAp4.setText(loadSet2.getString("set2RemplacementAp4", ""));
        set2RemplacementAp5 = (EditText)findViewById(R.id.set2RemplacementAp5); set2RemplacementAp5.setText(loadSet2.getString("set2RemplacementAp5", ""));
        set2RemplacementAp6 = (EditText)findViewById(R.id.set2RemplacementAp6); set2RemplacementAp6.setText(loadSet2.getString("set2RemplacementAp6", ""));

        set2RemplacementBp1 = (EditText)findViewById(R.id.set2RemplacementBp1); set2RemplacementBp1.setText(loadSet2.getString("set2RemplacementBp1", ""));
        set2RemplacementBp2 = (EditText)findViewById(R.id.set2RemplacementBp2); set2RemplacementBp2.setText(loadSet2.getString("set2RemplacementBp2", ""));
        set2RemplacementBp3 = (EditText)findViewById(R.id.set2RemplacementBp3); set2RemplacementBp3.setText(loadSet2.getString("set2RemplacementBp3", ""));
        set2RemplacementBp4 = (EditText)findViewById(R.id.set2RemplacementBp4); set2RemplacementBp4.setText(loadSet2.getString("set2RemplacementBp4", ""));
        set2RemplacementBp5 = (EditText)findViewById(R.id.set2RemplacementBp5); set2RemplacementBp5.setText(loadSet2.getString("set2RemplacementBp5", ""));
        set2RemplacementBp6 = (EditText)findViewById(R.id.set2RemplacementBp6); set2RemplacementBp6.setText(loadSet2.getString("set2RemplacementBp6", ""));

        set2ChronoDebutA = (EditText)findViewById(R.id.set2ChronoDebutA); set2ChronoDebutA.setText(loadSet2.getString("set2ChronoDebutA", ""));
        set2ChronoDebutB = (EditText)findViewById(R.id.set2ChronoDebutB); set2ChronoDebutB.setText(loadSet2.getString("set2ChronoDebutB", ""));
        set2ChronoFinA = (EditText)findViewById(R.id.set2ChronoFinA); set2ChronoFinA.setText(loadSet2.getString("set2ChronoFinA", ""));
        set2ChronoFinB = (EditText)findViewById(R.id.set2ChronoFinB); set2ChronoFinB.setText(loadSet2.getString("set2ChronoFinB", ""));

        buttonSet2Valider = (Button)findViewById(R.id.buttonSet2Valider);

        buttonSet2Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences saveSet2 = getSharedPreferences("set2",0);
                SharedPreferences.Editor editorSet2 = saveSet2.edit();

                editorSet2.putString("set2Ap1", set2Ap1.getText().toString());
                editorSet2.putString("set2Ap2", set2Ap2.getText().toString());
                editorSet2.putString("set2Ap3", set2Ap3.getText().toString());
                editorSet2.putString("set2Ap4", set2Ap4.getText().toString());
                editorSet2.putString("set2Ap5", set2Ap5.getText().toString());
                editorSet2.putString("set2Ap6", set2Ap6.getText().toString());

                editorSet2.putString("set2Bp1", set2Bp1.getText().toString());
                editorSet2.putString("set2Bp2", set2Bp2.getText().toString());
                editorSet2.putString("set2Bp3", set2Bp3.getText().toString());
                editorSet2.putString("set2Bp4", set2Bp4.getText().toString());
                editorSet2.putString("set2Bp5", set2Bp5.getText().toString());
                editorSet2.putString("set2Bp6", set2Bp6.getText().toString());

                editorSet2.putString("set2Ascore", set2Ascore.getText().toString());
                editorSet2.putString("set2Bscore", set2Bscore.getText().toString());

                editorSet2.putString("set2RemplacementAp1", set2RemplacementAp1.getText().toString());
                editorSet2.putString("set2RemplacementAp2", set2RemplacementAp2.getText().toString());
                editorSet2.putString("set2RemplacementAp3", set2RemplacementAp3.getText().toString());
                editorSet2.putString("set2RemplacementAp4", set2RemplacementAp4.getText().toString());
                editorSet2.putString("set2RemplacementAp5", set2RemplacementAp5.getText().toString());
                editorSet2.putString("set2RemplacementAp6", set2RemplacementAp6.getText().toString());

                editorSet2.putString("set2RemplacementBp1", set2RemplacementBp1.getText().toString());
                editorSet2.putString("set2RemplacementBp2", set2RemplacementBp2.getText().toString());
                editorSet2.putString("set2RemplacementBp3", set2RemplacementBp3.getText().toString());
                editorSet2.putString("set2RemplacementBp4", set2RemplacementBp4.getText().toString());
                editorSet2.putString("set2RemplacementBp5", set2RemplacementBp5.getText().toString());
                editorSet2.putString("set2RemplacementBp6", set2RemplacementBp6.getText().toString());

                editorSet2.putString("set2ChronoDebutA", set2ChronoDebutA.getText().toString());
                editorSet2.putString("set2ChronoDebutB", set2ChronoDebutB.getText().toString());
                editorSet2.putString("set2ChronoFinA", set2ChronoFinA.getText().toString());
                editorSet2.putString("set2ChronoFinB", set2ChronoFinB.getText().toString());

                editorSet2.commit();

                Intent intent = new Intent(Set2.this, MatchActivity.class);
                startActivity(intent);
            }
        });


    }
}


