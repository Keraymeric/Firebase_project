package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Set1 extends AppCompatActivity {

    //formation équipe A
    EditText set1Ap1;
    EditText set1Ap2;
    EditText set1Ap3;
    EditText set1Ap4;
    EditText set1Ap5;
    EditText set1Ap6;

    //formation équipe B
    EditText set1Bp1;
    EditText set1Bp2;
    EditText set1Bp3;
    EditText set1Bp4;
    EditText set1Bp5;
    EditText set1Bp6;

    //score
    EditText set1Ascore;
    EditText set1Bscore;

    //remplacement
    EditText set1RemplacementAp1;
    EditText set1RemplacementAp2;
    EditText set1RemplacementAp3;
    EditText set1RemplacementAp4;
    EditText set1RemplacementAp5;
    EditText set1RemplacementAp6;
    EditText set1RemplacementBp1;
    EditText set1RemplacementBp2;
    EditText set1RemplacementBp3;
    EditText set1RemplacementBp4;
    EditText set1RemplacementBp5;
    EditText set1RemplacementBp6;

    //Temps mort
    EditText set1ChronoDebutA;
    EditText set1ChronoDebutB;
    EditText set1ChronoFinA;
    EditText set1ChronoFinB;


    //bouton valider
    Button buttonSet1Valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set1);

        SharedPreferences loadSet1 = getSharedPreferences("set1",0);

        set1Ap1 = (EditText)findViewById(R.id.set1Ap1); set1Ap1.setText(loadSet1.getString("set1Ap1", ""));
        set1Ap2 = (EditText)findViewById(R.id.set1Ap2); set1Ap2.setText(loadSet1.getString("set1Ap2", ""));
        set1Ap3 = (EditText)findViewById(R.id.set1Ap3); set1Ap3.setText(loadSet1.getString("set1Ap3", ""));
        set1Ap4 = (EditText)findViewById(R.id.set1Ap4); set1Ap4.setText(loadSet1.getString("set1Ap4", ""));
        set1Ap5 = (EditText)findViewById(R.id.set1Ap5); set1Ap5.setText(loadSet1.getString("set1Ap5", ""));
        set1Ap6 = (EditText)findViewById(R.id.set1Ap6); set1Ap6.setText(loadSet1.getString("set1Ap6", ""));

        set1Bp1 = (EditText)findViewById(R.id.set1Bp1); set1Bp1.setText(loadSet1.getString("set1Bp1", ""));
        set1Bp2 = (EditText)findViewById(R.id.set1Bp2); set1Bp2.setText(loadSet1.getString("set1Bp2", ""));
        set1Bp3 = (EditText)findViewById(R.id.set1Bp3); set1Bp3.setText(loadSet1.getString("set1Bp3", ""));
        set1Bp4 = (EditText)findViewById(R.id.set1Bp4); set1Bp4.setText(loadSet1.getString("set1Bp4", ""));
        set1Bp5 = (EditText)findViewById(R.id.set1Bp5); set1Bp5.setText(loadSet1.getString("set1Bp5", ""));
        set1Bp6 = (EditText)findViewById(R.id.set1Bp6); set1Bp6.setText(loadSet1.getString("set1Bp6", ""));

        set1Ascore = (EditText)findViewById(R.id.set1Ascore); set1Ascore.setText(loadSet1.getString("set1Ascore", ""));
        set1Bscore = (EditText)findViewById(R.id.set1Bscore); set1Bscore.setText(loadSet1.getString("set1Bscore", ""));

        set1RemplacementAp1 = (EditText)findViewById(R.id.set1RemplacementAp1); set1RemplacementAp1.setText(loadSet1.getString("set1RemplacementAp1", ""));
        set1RemplacementAp2 = (EditText)findViewById(R.id.set1RemplacementAp2); set1RemplacementAp2.setText(loadSet1.getString("set1RemplacementAp2", ""));
        set1RemplacementAp3 = (EditText)findViewById(R.id.set1RemplacementAp3); set1RemplacementAp3.setText(loadSet1.getString("set1RemplacementAp3", ""));
        set1RemplacementAp4 = (EditText)findViewById(R.id.set1RemplacementAp4); set1RemplacementAp4.setText(loadSet1.getString("set1RemplacementAp4", ""));
        set1RemplacementAp5 = (EditText)findViewById(R.id.set1RemplacementAp5); set1RemplacementAp5.setText(loadSet1.getString("set1RemplacementAp5", ""));
        set1RemplacementAp6 = (EditText)findViewById(R.id.set1RemplacementAp6); set1RemplacementAp6.setText(loadSet1.getString("set1RemplacementAp6", ""));

        set1RemplacementBp1 = (EditText)findViewById(R.id.set1RemplacementBp1); set1RemplacementBp1.setText(loadSet1.getString("set1RemplacementBp1", ""));
        set1RemplacementBp2 = (EditText)findViewById(R.id.set1RemplacementBp2); set1RemplacementBp2.setText(loadSet1.getString("set1RemplacementBp2", ""));
        set1RemplacementBp3 = (EditText)findViewById(R.id.set1RemplacementBp3); set1RemplacementBp3.setText(loadSet1.getString("set1RemplacementBp3", ""));
        set1RemplacementBp4 = (EditText)findViewById(R.id.set1RemplacementBp4); set1RemplacementBp4.setText(loadSet1.getString("set1RemplacementBp4", ""));
        set1RemplacementBp5 = (EditText)findViewById(R.id.set1RemplacementBp5); set1RemplacementBp5.setText(loadSet1.getString("set1RemplacementBp5", ""));
        set1RemplacementBp6 = (EditText)findViewById(R.id.set1RemplacementBp6); set1RemplacementBp6.setText(loadSet1.getString("set1RemplacementBp6", ""));

        set1ChronoDebutA = (EditText)findViewById(R.id.set1ChronoDebutA); set1ChronoDebutA.setText(loadSet1.getString("set1ChronoDebutA", ""));
        set1ChronoDebutB = (EditText)findViewById(R.id.set1ChronoDebutB); set1ChronoDebutB.setText(loadSet1.getString("set1ChronoDebutB", ""));
        set1ChronoFinA = (EditText)findViewById(R.id.set1ChronoFinA); set1ChronoFinA.setText(loadSet1.getString("set1ChronoFinA", ""));
        set1ChronoFinB = (EditText)findViewById(R.id.set1ChronoFinB); set1ChronoFinB.setText(loadSet1.getString("set1ChronoFinB", ""));

        buttonSet1Valider = (Button)findViewById(R.id.buttonSet1Valider);

        buttonSet1Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences saveSet1 = getSharedPreferences("set1",0);
                SharedPreferences.Editor editorSet1 = saveSet1.edit();

                editorSet1.putString("set1Ap1", set1Ap1.getText().toString());
                editorSet1.putString("set1Ap2", set1Ap2.getText().toString());
                editorSet1.putString("set1Ap3", set1Ap3.getText().toString());
                editorSet1.putString("set1Ap4", set1Ap4.getText().toString());
                editorSet1.putString("set1Ap5", set1Ap5.getText().toString());
                editorSet1.putString("set1Ap6", set1Ap6.getText().toString());

                editorSet1.putString("set1Bp1", set1Bp1.getText().toString());
                editorSet1.putString("set1Bp2", set1Bp2.getText().toString());
                editorSet1.putString("set1Bp3", set1Bp3.getText().toString());
                editorSet1.putString("set1Bp4", set1Bp4.getText().toString());
                editorSet1.putString("set1Bp5", set1Bp5.getText().toString());
                editorSet1.putString("set1Bp6", set1Bp6.getText().toString());

                editorSet1.putString("set1Ascore", set1Ascore.getText().toString());
                editorSet1.putString("set1Bscore", set1Bscore.getText().toString());

                editorSet1.putString("set1RemplacementAp1", set1RemplacementAp1.getText().toString());
                editorSet1.putString("set1RemplacementAp2", set1RemplacementAp2.getText().toString());
                editorSet1.putString("set1RemplacementAp3", set1RemplacementAp3.getText().toString());
                editorSet1.putString("set1RemplacementAp4", set1RemplacementAp4.getText().toString());
                editorSet1.putString("set1RemplacementAp5", set1RemplacementAp5.getText().toString());
                editorSet1.putString("set1RemplacementAp6", set1RemplacementAp6.getText().toString());

                editorSet1.putString("set1RemplacementBp1", set1RemplacementBp1.getText().toString());
                editorSet1.putString("set1RemplacementBp2", set1RemplacementBp2.getText().toString());
                editorSet1.putString("set1RemplacementBp3", set1RemplacementBp3.getText().toString());
                editorSet1.putString("set1RemplacementBp4", set1RemplacementBp4.getText().toString());
                editorSet1.putString("set1RemplacementBp5", set1RemplacementBp5.getText().toString());
                editorSet1.putString("set1RemplacementBp6", set1RemplacementBp6.getText().toString());

                editorSet1.putString("set1ChronoDebutA", set1ChronoDebutA.getText().toString());
                editorSet1.putString("set1ChronoDebutB", set1ChronoDebutB.getText().toString());
                editorSet1.putString("set1ChronoFinA", set1ChronoFinA.getText().toString());
                editorSet1.putString("set1ChronoFinB", set1ChronoFinB.getText().toString());

                editorSet1.commit();

                Intent intent = new Intent(Set1.this, MatchActivity.class);
                startActivity(intent);
            }
        });



    }
}