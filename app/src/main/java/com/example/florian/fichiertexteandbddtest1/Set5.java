package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Set5 extends AppCompatActivity {

    //formation équipe A
    EditText set5Ap1;
    EditText set5Ap2;
    EditText set5Ap3;
    EditText set5Ap4;
    EditText set5Ap5;
    EditText set5Ap6;

    //formation équipe B
    EditText set5Bp1;
    EditText set5Bp2;
    EditText set5Bp3;
    EditText set5Bp4;
    EditText set5Bp5;
    EditText set5Bp6;

    //score
    EditText set5Ascore;
    EditText set5Bscore;

    //remplacement
    EditText set5RemplacementAp1;
    EditText set5RemplacementAp2;
    EditText set5RemplacementAp3;
    EditText set5RemplacementAp4;
    EditText set5RemplacementAp5;
    EditText set5RemplacementAp6;
    EditText set5RemplacementBp1;
    EditText set5RemplacementBp2;
    EditText set5RemplacementBp3;
    EditText set5RemplacementBp4;
    EditText set5RemplacementBp5;
    EditText set5RemplacementBp6;

    //Temps mort
    EditText set5ChronoDebutA;
    EditText set5ChronoDebutB;
    EditText set5ChronoFinA;
    EditText set5ChronoFinB;

    //bouton valider
    Button buttonSet5Valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set5);

        SharedPreferences loadSet5 = getSharedPreferences("set5",0);

        set5Ap1 = (EditText)findViewById(R.id.set5Ap1); set5Ap1.setText(loadSet5.getString("set5Ap1", ""));
        set5Ap2 = (EditText)findViewById(R.id.set5Ap2); set5Ap2.setText(loadSet5.getString("set5Ap2", ""));
        set5Ap3 = (EditText)findViewById(R.id.set5Ap3); set5Ap3.setText(loadSet5.getString("set5Ap3", ""));
        set5Ap4 = (EditText)findViewById(R.id.set5Ap4); set5Ap4.setText(loadSet5.getString("set5Ap4", ""));
        set5Ap5 = (EditText)findViewById(R.id.set5Ap5); set5Ap5.setText(loadSet5.getString("set5Ap5", ""));
        set5Ap6 = (EditText)findViewById(R.id.set5Ap6); set5Ap6.setText(loadSet5.getString("set5Ap6", ""));

        set5Bp1 = (EditText)findViewById(R.id.set5Bp1); set5Bp1.setText(loadSet5.getString("set5Bp1", ""));
        set5Bp2 = (EditText)findViewById(R.id.set5Bp2); set5Bp2.setText(loadSet5.getString("set5Bp2", ""));
        set5Bp3 = (EditText)findViewById(R.id.set5Bp3); set5Bp3.setText(loadSet5.getString("set5Bp3", ""));
        set5Bp4 = (EditText)findViewById(R.id.set5Bp4); set5Bp4.setText(loadSet5.getString("set5Bp4", ""));
        set5Bp5 = (EditText)findViewById(R.id.set5Bp5); set5Bp5.setText(loadSet5.getString("set5Bp5", ""));
        set5Bp6 = (EditText)findViewById(R.id.set5Bp6); set5Bp6.setText(loadSet5.getString("set5Bp6", ""));

        set5Ascore = (EditText)findViewById(R.id.set5Ascore); set5Ascore.setText(loadSet5.getString("set5Ascore", ""));
        set5Bscore = (EditText)findViewById(R.id.set5Bscore); set5Bscore.setText(loadSet5.getString("set5Bscore", ""));

        set5RemplacementAp1 = (EditText)findViewById(R.id.set5RemplacementAp1); set5RemplacementAp1.setText(loadSet5.getString("set5RemplacementAp1", ""));
        set5RemplacementAp2 = (EditText)findViewById(R.id.set5RemplacementAp2); set5RemplacementAp2.setText(loadSet5.getString("set5RemplacementAp2", ""));
        set5RemplacementAp3 = (EditText)findViewById(R.id.set5RemplacementAp3); set5RemplacementAp3.setText(loadSet5.getString("set5RemplacementAp3", ""));
        set5RemplacementAp4 = (EditText)findViewById(R.id.set5RemplacementAp4); set5RemplacementAp4.setText(loadSet5.getString("set5RemplacementAp4", ""));
        set5RemplacementAp5 = (EditText)findViewById(R.id.set5RemplacementAp5); set5RemplacementAp5.setText(loadSet5.getString("set5RemplacementAp5", ""));
        set5RemplacementAp6 = (EditText)findViewById(R.id.set5RemplacementAp6); set5RemplacementAp6.setText(loadSet5.getString("set5RemplacementAp6", ""));

        set5RemplacementBp1 = (EditText)findViewById(R.id.set5RemplacementBp1); set5RemplacementBp1.setText(loadSet5.getString("set5RemplacementBp1", ""));
        set5RemplacementBp2 = (EditText)findViewById(R.id.set5RemplacementBp2); set5RemplacementBp2.setText(loadSet5.getString("set5RemplacementBp2", ""));
        set5RemplacementBp3 = (EditText)findViewById(R.id.set5RemplacementBp3); set5RemplacementBp3.setText(loadSet5.getString("set5RemplacementBp3", ""));
        set5RemplacementBp4 = (EditText)findViewById(R.id.set5RemplacementBp4); set5RemplacementBp4.setText(loadSet5.getString("set5RemplacementBp4", ""));
        set5RemplacementBp5 = (EditText)findViewById(R.id.set5RemplacementBp5); set5RemplacementBp5.setText(loadSet5.getString("set5RemplacementBp5", ""));
        set5RemplacementBp6 = (EditText)findViewById(R.id.set5RemplacementBp6); set5RemplacementBp6.setText(loadSet5.getString("set5RemplacementBp6", ""));

        set5ChronoDebutA = (EditText)findViewById(R.id.set5ChronoDebutA); set5ChronoDebutA.setText(loadSet5.getString("set5ChronoDebutA", ""));
        set5ChronoDebutB = (EditText)findViewById(R.id.set5ChronoDebutB); set5ChronoDebutB.setText(loadSet5.getString("set5ChronoDebutB", ""));
        set5ChronoFinA = (EditText)findViewById(R.id.set5ChronoFinA); set5ChronoFinA.setText(loadSet5.getString("set5ChronoFinA", ""));
        set5ChronoFinB = (EditText)findViewById(R.id.set5ChronoFinB); set5ChronoFinB.setText(loadSet5.getString("set5ChronoFinB", ""));


        buttonSet5Valider = (Button)findViewById(R.id.buttonSet5Valider);

        buttonSet5Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences saveSet5 = getSharedPreferences("set5",0);
                SharedPreferences.Editor editorSet5 = saveSet5.edit();

                editorSet5.putString("set5Ap1", set5Ap1.getText().toString());
                editorSet5.putString("set5Ap2", set5Ap2.getText().toString());
                editorSet5.putString("set5Ap3", set5Ap3.getText().toString());
                editorSet5.putString("set5Ap4", set5Ap4.getText().toString());
                editorSet5.putString("set5Ap5", set5Ap5.getText().toString());
                editorSet5.putString("set5Ap6", set5Ap6.getText().toString());

                editorSet5.putString("set5Bp1", set5Bp1.getText().toString());
                editorSet5.putString("set5Bp2", set5Bp2.getText().toString());
                editorSet5.putString("set5Bp3", set5Bp3.getText().toString());
                editorSet5.putString("set5Bp4", set5Bp4.getText().toString());
                editorSet5.putString("set5Bp5", set5Bp5.getText().toString());
                editorSet5.putString("set5Bp6", set5Bp6.getText().toString());

                editorSet5.putString("set5Ascore", set5Ascore.getText().toString());
                editorSet5.putString("set5Bscore", set5Bscore.getText().toString());

                editorSet5.putString("set5RemplacementAp1", set5RemplacementAp1.getText().toString());
                editorSet5.putString("set5RemplacementAp2", set5RemplacementAp2.getText().toString());
                editorSet5.putString("set5RemplacementAp3", set5RemplacementAp3.getText().toString());
                editorSet5.putString("set5RemplacementAp4", set5RemplacementAp4.getText().toString());
                editorSet5.putString("set5RemplacementAp5", set5RemplacementAp5.getText().toString());
                editorSet5.putString("set5RemplacementAp6", set5RemplacementAp6.getText().toString());

                editorSet5.putString("set5RemplacementBp1", set5RemplacementBp1.getText().toString());
                editorSet5.putString("set5RemplacementBp2", set5RemplacementBp2.getText().toString());
                editorSet5.putString("set5RemplacementBp3", set5RemplacementBp3.getText().toString());
                editorSet5.putString("set5RemplacementBp4", set5RemplacementBp4.getText().toString());
                editorSet5.putString("set5RemplacementBp5", set5RemplacementBp5.getText().toString());
                editorSet5.putString("set5RemplacementBp6", set5RemplacementBp6.getText().toString());

                editorSet5.putString("set5ChronoDebutA", set5ChronoDebutA.getText().toString());
                editorSet5.putString("set5ChronoDebutB", set5ChronoDebutB.getText().toString());
                editorSet5.putString("set5ChronoFinA", set5ChronoFinA.getText().toString());
                editorSet5.putString("set5ChronoFinB", set5ChronoFinB.getText().toString());

                editorSet5.commit();

                Intent intent = new Intent(Set5.this, MatchActivity.class);
                startActivity(intent);
            }
        });


    }
}
