package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Set4 extends AppCompatActivity {

    //formation équipe A
    EditText set4Ap1;
    EditText set4Ap2;
    EditText set4Ap3;
    EditText set4Ap4;
    EditText set4Ap5;
    EditText set4Ap6;

    //formation équipe B
    EditText set4Bp1;
    EditText set4Bp2;
    EditText set4Bp3;
    EditText set4Bp4;
    EditText set4Bp5;
    EditText set4Bp6;

    //score
    EditText set4Ascore;
    EditText set4Bscore;

    //bouton valider
    Button buttonSet4Valider;

    //remplacement
    EditText set4RemplacementAp1;
    EditText set4RemplacementAp2;
    EditText set4RemplacementAp3;
    EditText set4RemplacementAp4;
    EditText set4RemplacementAp5;
    EditText set4RemplacementAp6;
    EditText set4RemplacementBp1;
    EditText set4RemplacementBp2;
    EditText set4RemplacementBp3;
    EditText set4RemplacementBp4;
    EditText set4RemplacementBp5;
    EditText set4RemplacementBp6;

    //Temps mort
    EditText set4ChronoDebutA;
    EditText set4ChronoDebutB;
    EditText set4ChronoFinA;
    EditText set4ChronoFinB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set4);

        SharedPreferences loadSet4 = getSharedPreferences("set4",0);

        set4Ap1 = (EditText)findViewById(R.id.set4Ap1); set4Ap1.setText(loadSet4.getString("set4Ap1", ""));
        set4Ap2 = (EditText)findViewById(R.id.set4Ap2); set4Ap2.setText(loadSet4.getString("set4Ap2", ""));
        set4Ap3 = (EditText)findViewById(R.id.set4Ap3); set4Ap3.setText(loadSet4.getString("set4Ap3", ""));
        set4Ap4 = (EditText)findViewById(R.id.set4Ap4); set4Ap4.setText(loadSet4.getString("set4Ap4", ""));
        set4Ap5 = (EditText)findViewById(R.id.set4Ap5); set4Ap5.setText(loadSet4.getString("set4Ap5", ""));
        set4Ap6 = (EditText)findViewById(R.id.set4Ap6); set4Ap6.setText(loadSet4.getString("set4Ap6", ""));

        set4Bp1 = (EditText)findViewById(R.id.set4Bp1); set4Bp1.setText(loadSet4.getString("set4Bp1", ""));
        set4Bp2 = (EditText)findViewById(R.id.set4Bp2); set4Bp2.setText(loadSet4.getString("set4Bp2", ""));
        set4Bp3 = (EditText)findViewById(R.id.set4Bp3); set4Bp3.setText(loadSet4.getString("set4Bp3", ""));
        set4Bp4 = (EditText)findViewById(R.id.set4Bp4); set4Bp4.setText(loadSet4.getString("set4Bp4", ""));
        set4Bp5 = (EditText)findViewById(R.id.set4Bp5); set4Bp5.setText(loadSet4.getString("set4Bp5", ""));
        set4Bp6 = (EditText)findViewById(R.id.set4Bp6); set4Bp6.setText(loadSet4.getString("set4Bp6", ""));

        set4Ascore = (EditText)findViewById(R.id.set4Ascore); set4Ascore.setText(loadSet4.getString("set4Ascore", ""));
        set4Bscore = (EditText)findViewById(R.id.set4Bscore); set4Bscore.setText(loadSet4.getString("set4Bscore", ""));

        set4RemplacementAp1 = (EditText)findViewById(R.id.set4RemplacementAp1); set4RemplacementAp1.setText(loadSet4.getString("set4RemplacementAp1", ""));
        set4RemplacementAp2 = (EditText)findViewById(R.id.set4RemplacementAp2); set4RemplacementAp2.setText(loadSet4.getString("set4RemplacementAp2", ""));
        set4RemplacementAp3 = (EditText)findViewById(R.id.set4RemplacementAp3); set4RemplacementAp3.setText(loadSet4.getString("set4RemplacementAp3", ""));
        set4RemplacementAp4 = (EditText)findViewById(R.id.set4RemplacementAp4); set4RemplacementAp4.setText(loadSet4.getString("set4RemplacementAp4", ""));
        set4RemplacementAp5 = (EditText)findViewById(R.id.set4RemplacementAp5); set4RemplacementAp5.setText(loadSet4.getString("set4RemplacementAp5", ""));
        set4RemplacementAp6 = (EditText)findViewById(R.id.set4RemplacementAp6); set4RemplacementAp6.setText(loadSet4.getString("set4RemplacementAp6", ""));

        set4RemplacementBp1 = (EditText)findViewById(R.id.set4RemplacementBp1); set4RemplacementBp1.setText(loadSet4.getString("set4RemplacementBp1", ""));
        set4RemplacementBp2 = (EditText)findViewById(R.id.set4RemplacementBp2); set4RemplacementBp2.setText(loadSet4.getString("set4RemplacementBp2", ""));
        set4RemplacementBp3 = (EditText)findViewById(R.id.set4RemplacementBp3); set4RemplacementBp3.setText(loadSet4.getString("set4RemplacementBp3", ""));
        set4RemplacementBp4 = (EditText)findViewById(R.id.set4RemplacementBp4); set4RemplacementBp4.setText(loadSet4.getString("set4RemplacementBp4", ""));
        set4RemplacementBp5 = (EditText)findViewById(R.id.set4RemplacementBp5); set4RemplacementBp5.setText(loadSet4.getString("set4RemplacementBp5", ""));
        set4RemplacementBp6 = (EditText)findViewById(R.id.set4RemplacementBp6); set4RemplacementBp6.setText(loadSet4.getString("set4RemplacementBp6", ""));

        set4ChronoDebutA = (EditText)findViewById(R.id.set4ChronoDebutA); set4ChronoDebutA.setText(loadSet4.getString("set4ChronoDebutA", ""));
        set4ChronoDebutB = (EditText)findViewById(R.id.set4ChronoDebutB); set4ChronoDebutB.setText(loadSet4.getString("set4ChronoDebutB", ""));
        set4ChronoFinA = (EditText)findViewById(R.id.set4ChronoFinA); set4ChronoFinA.setText(loadSet4.getString("set4ChronoFinA", ""));
        set4ChronoFinB = (EditText)findViewById(R.id.set4ChronoFinB); set4ChronoFinB.setText(loadSet4.getString("set4ChronoFinB", ""));

        buttonSet4Valider = (Button)findViewById(R.id.buttonSet4Valider);

        buttonSet4Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences saveSet4 = getSharedPreferences("set4",0);
                SharedPreferences.Editor editorSet4 = saveSet4.edit();

                editorSet4.putString("set4Ap1", set4Ap1.getText().toString());
                editorSet4.putString("set4Ap2", set4Ap2.getText().toString());
                editorSet4.putString("set4Ap3", set4Ap3.getText().toString());
                editorSet4.putString("set4Ap4", set4Ap4.getText().toString());
                editorSet4.putString("set4Ap5", set4Ap5.getText().toString());
                editorSet4.putString("set4Ap6", set4Ap6.getText().toString());

                editorSet4.putString("set4Bp1", set4Bp1.getText().toString());
                editorSet4.putString("set4Bp2", set4Bp2.getText().toString());
                editorSet4.putString("set4Bp3", set4Bp3.getText().toString());
                editorSet4.putString("set4Bp4", set4Bp4.getText().toString());
                editorSet4.putString("set4Bp5", set4Bp5.getText().toString());
                editorSet4.putString("set4Bp6", set4Bp6.getText().toString());

                editorSet4.putString("set4Ascore", set4Ascore.getText().toString());
                editorSet4.putString("set4Bscore", set4Bscore.getText().toString());

                editorSet4.putString("set4RemplacementAp1", set4RemplacementAp1.getText().toString());
                editorSet4.putString("set4RemplacementAp2", set4RemplacementAp2.getText().toString());
                editorSet4.putString("set4RemplacementAp3", set4RemplacementAp3.getText().toString());
                editorSet4.putString("set4RemplacementAp4", set4RemplacementAp4.getText().toString());
                editorSet4.putString("set4RemplacementAp5", set4RemplacementAp5.getText().toString());
                editorSet4.putString("set4RemplacementAp6", set4RemplacementAp6.getText().toString());

                editorSet4.putString("set4RemplacementBp1", set4RemplacementBp1.getText().toString());
                editorSet4.putString("set4RemplacementBp2", set4RemplacementBp2.getText().toString());
                editorSet4.putString("set4RemplacementBp3", set4RemplacementBp3.getText().toString());
                editorSet4.putString("set4RemplacementBp4", set4RemplacementBp4.getText().toString());
                editorSet4.putString("set4RemplacementBp5", set4RemplacementBp5.getText().toString());
                editorSet4.putString("set4RemplacementBp6", set4RemplacementBp6.getText().toString());

                editorSet4.putString("set4ChronoDebutA", set4ChronoDebutA.getText().toString());
                editorSet4.putString("set4ChronoDebutB", set4ChronoDebutB.getText().toString());
                editorSet4.putString("set4ChronoFinA", set4ChronoFinA.getText().toString());
                editorSet4.putString("set4ChronoFinB", set4ChronoFinB.getText().toString());

                editorSet4.commit();

                Intent intent = new Intent(Set4.this, MatchActivity.class);
                startActivity(intent);
            }
        });

    }
}
