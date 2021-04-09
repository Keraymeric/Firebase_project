package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Set3 extends AppCompatActivity {

    //formation équipe A
    EditText set3Ap1;
    EditText set3Ap2;
    EditText set3Ap3;
    EditText set3Ap4;
    EditText set3Ap5;
    EditText set3Ap6;

    //formation équipe B
    EditText set3Bp1;
    EditText set3Bp2;
    EditText set3Bp3;
    EditText set3Bp4;
    EditText set3Bp5;
    EditText set3Bp6;

    //score
    EditText set3Ascore;
    EditText set3Bscore;

    //remplacement
    EditText set3RemplacementAp1;
    EditText set3RemplacementAp2;
    EditText set3RemplacementAp3;
    EditText set3RemplacementAp4;
    EditText set3RemplacementAp5;
    EditText set3RemplacementAp6;
    EditText set3RemplacementBp1;
    EditText set3RemplacementBp2;
    EditText set3RemplacementBp3;
    EditText set3RemplacementBp4;
    EditText set3RemplacementBp5;
    EditText set3RemplacementBp6;

    //Temps mort
    EditText set3ChronoDebutA;
    EditText set3ChronoDebutB;
    EditText set3ChronoFinA;
    EditText set3ChronoFinB;

    //bouton valider
    Button buttonSet3Valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set3);

        SharedPreferences loadSet3 = getSharedPreferences("set3",0);

        set3Ap1 = (EditText)findViewById(R.id.set3Ap1); set3Ap1.setText(loadSet3.getString("set3Ap1", ""));
        set3Ap2 = (EditText)findViewById(R.id.set3Ap2); set3Ap2.setText(loadSet3.getString("set3Ap2", ""));
        set3Ap3 = (EditText)findViewById(R.id.set3Ap3); set3Ap3.setText(loadSet3.getString("set3Ap3", ""));
        set3Ap4 = (EditText)findViewById(R.id.set3Ap4); set3Ap4.setText(loadSet3.getString("set3Ap4", ""));
        set3Ap5 = (EditText)findViewById(R.id.set3Ap5); set3Ap5.setText(loadSet3.getString("set3Ap5", ""));
        set3Ap6 = (EditText)findViewById(R.id.set3Ap6); set3Ap6.setText(loadSet3.getString("set3Ap6", ""));

        set3Bp1 = (EditText)findViewById(R.id.set3Bp1); set3Bp1.setText(loadSet3.getString("set3Bp1", ""));
        set3Bp2 = (EditText)findViewById(R.id.set3Bp2); set3Bp2.setText(loadSet3.getString("set3Bp2", ""));
        set3Bp3 = (EditText)findViewById(R.id.set3Bp3); set3Bp3.setText(loadSet3.getString("set3Bp3", ""));
        set3Bp4 = (EditText)findViewById(R.id.set3Bp4); set3Bp4.setText(loadSet3.getString("set3Bp4", ""));
        set3Bp5 = (EditText)findViewById(R.id.set3Bp5); set3Bp5.setText(loadSet3.getString("set3Bp5", ""));
        set3Bp6 = (EditText)findViewById(R.id.set3Bp6); set3Bp6.setText(loadSet3.getString("set3Bp6", ""));

        set3Ascore = (EditText)findViewById(R.id.set3Ascore); set3Ascore.setText(loadSet3.getString("set3Ascore", ""));
        set3Bscore = (EditText)findViewById(R.id.set3Bscore); set3Bscore.setText(loadSet3.getString("set3Bscore", ""));

        set3RemplacementAp1 = (EditText)findViewById(R.id.set3RemplacementAp1); set3RemplacementAp1.setText(loadSet3.getString("set3RemplacementAp1", ""));
        set3RemplacementAp2 = (EditText)findViewById(R.id.set3RemplacementAp2); set3RemplacementAp2.setText(loadSet3.getString("set3RemplacementAp2", ""));
        set3RemplacementAp3 = (EditText)findViewById(R.id.set3RemplacementAp3); set3RemplacementAp3.setText(loadSet3.getString("set3RemplacementAp3", ""));
        set3RemplacementAp4 = (EditText)findViewById(R.id.set3RemplacementAp4); set3RemplacementAp4.setText(loadSet3.getString("set3RemplacementAp4", ""));
        set3RemplacementAp5 = (EditText)findViewById(R.id.set3RemplacementAp5); set3RemplacementAp5.setText(loadSet3.getString("set3RemplacementAp5", ""));
        set3RemplacementAp6 = (EditText)findViewById(R.id.set3RemplacementAp6); set3RemplacementAp6.setText(loadSet3.getString("set3RemplacementAp6", ""));

        set3RemplacementBp1 = (EditText)findViewById(R.id.set3RemplacementBp1); set3RemplacementBp1.setText(loadSet3.getString("set3RemplacementBp1", ""));
        set3RemplacementBp2 = (EditText)findViewById(R.id.set3RemplacementBp2); set3RemplacementBp2.setText(loadSet3.getString("set3RemplacementBp2", ""));
        set3RemplacementBp3 = (EditText)findViewById(R.id.set3RemplacementBp3); set3RemplacementBp3.setText(loadSet3.getString("set3RemplacementBp3", ""));
        set3RemplacementBp4 = (EditText)findViewById(R.id.set3RemplacementBp4); set3RemplacementBp4.setText(loadSet3.getString("set3RemplacementBp4", ""));
        set3RemplacementBp5 = (EditText)findViewById(R.id.set3RemplacementBp5); set3RemplacementBp5.setText(loadSet3.getString("set3RemplacementBp5", ""));
        set3RemplacementBp6 = (EditText)findViewById(R.id.set3RemplacementBp6); set3RemplacementBp6.setText(loadSet3.getString("set3RemplacementBp6", ""));

        set3ChronoDebutA = (EditText)findViewById(R.id.set3ChronoDebutA); set3ChronoDebutA.setText(loadSet3.getString("set3ChronoDebutA", ""));
        set3ChronoDebutB = (EditText)findViewById(R.id.set3ChronoDebutB); set3ChronoDebutB.setText(loadSet3.getString("set3ChronoDebutB", ""));
        set3ChronoFinA = (EditText)findViewById(R.id.set3ChronoFinA); set3ChronoFinA.setText(loadSet3.getString("set3ChronoFinA", ""));
        set3ChronoFinB = (EditText)findViewById(R.id.set3ChronoFinB); set3ChronoFinB.setText(loadSet3.getString("set3ChronoFinB", ""));

        buttonSet3Valider = (Button)findViewById(R.id.buttonSet3Valider);

        buttonSet3Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences saveSet3 = getSharedPreferences("set3",0);
                SharedPreferences.Editor editorSet3 = saveSet3.edit();

                editorSet3.putString("set3Ap1", set3Ap1.getText().toString());
                editorSet3.putString("set3Ap2", set3Ap2.getText().toString());
                editorSet3.putString("set3Ap3", set3Ap3.getText().toString());
                editorSet3.putString("set3Ap4", set3Ap4.getText().toString());
                editorSet3.putString("set3Ap5", set3Ap5.getText().toString());
                editorSet3.putString("set3Ap6", set3Ap6.getText().toString());

                editorSet3.putString("set3Bp1", set3Bp1.getText().toString());
                editorSet3.putString("set3Bp2", set3Bp2.getText().toString());
                editorSet3.putString("set3Bp3", set3Bp3.getText().toString());
                editorSet3.putString("set3Bp4", set3Bp4.getText().toString());
                editorSet3.putString("set3Bp5", set3Bp5.getText().toString());
                editorSet3.putString("set3Bp6", set3Bp6.getText().toString());

                editorSet3.putString("set3Ascore", set3Ascore.getText().toString());
                editorSet3.putString("set3Bscore", set3Bscore.getText().toString());

                editorSet3.putString("set3RemplacementAp1", set3RemplacementAp1.getText().toString());
                editorSet3.putString("set3RemplacementAp2", set3RemplacementAp2.getText().toString());
                editorSet3.putString("set3RemplacementAp3", set3RemplacementAp3.getText().toString());
                editorSet3.putString("set3RemplacementAp4", set3RemplacementAp4.getText().toString());
                editorSet3.putString("set3RemplacementAp5", set3RemplacementAp5.getText().toString());
                editorSet3.putString("set3RemplacementAp6", set3RemplacementAp6.getText().toString());

                editorSet3.putString("set3RemplacementBp1", set3RemplacementBp1.getText().toString());
                editorSet3.putString("set3RemplacementBp2", set3RemplacementBp2.getText().toString());
                editorSet3.putString("set3RemplacementBp3", set3RemplacementBp3.getText().toString());
                editorSet3.putString("set3RemplacementBp4", set3RemplacementBp4.getText().toString());
                editorSet3.putString("set3RemplacementBp5", set3RemplacementBp5.getText().toString());
                editorSet3.putString("set3RemplacementBp6", set3RemplacementBp6.getText().toString());

                editorSet3.putString("set3ChronoDebutA", set3ChronoDebutA.getText().toString());
                editorSet3.putString("set3ChronoDebutB", set3ChronoDebutB.getText().toString());
                editorSet3.putString("set3ChronoFinA", set3ChronoFinA.getText().toString());
                editorSet3.putString("set3ChronoFinB", set3ChronoFinB.getText().toString());

                editorSet3.commit();

                Intent intent = new Intent(Set3.this, MatchActivity.class);
                startActivity(intent);
            }
        });



    }
}
