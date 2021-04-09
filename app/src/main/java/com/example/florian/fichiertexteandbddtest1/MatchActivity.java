package com.example.florian.fichiertexteandbddtest1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.util.Set;

public class MatchActivity extends AppCompatActivity {

    String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";

    Button buttonMatchRetourAccueille;
    Button buttonRecapitulatif;
    Button buttonPreparatif;
    Button buttonEquipeA;
    Button buttonEquipeB;
    Button buttonSet1;
    Button buttonSet2;
    Button buttonSet3;
    Button buttonSet4;
    Button buttonSet5;
    Button buttonResultat;
    Button buttonApprobation;
    Button buttonReinitialiser;

    Button buttonValidationEquipeA;
    Button buttonValidationEquipeB;

    TextView disableButton;
    TextView currentMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        buttonMatchRetourAccueille = (Button)findViewById(R.id.buttonMatchRetourAccueille);
        buttonRecapitulatif = (Button)findViewById(R.id.buttonRecapitulatif);
        buttonPreparatif = (Button)findViewById(R.id.buttonPreparatif);
        buttonEquipeA = (Button)findViewById(R.id.buttonEquipeA);
        buttonEquipeB = (Button)findViewById(R.id.buttonEquipeB);
        buttonSet1 = (Button)findViewById(R.id.buttonSet1);
        buttonSet2 = (Button)findViewById(R.id.buttonSet2);
        buttonSet3 = (Button)findViewById(R.id.buttonSet3);
        buttonSet4 = (Button)findViewById(R.id.buttonSet4);
        buttonSet5 = (Button)findViewById(R.id.buttonSet5);
        buttonResultat = (Button)findViewById(R.id.buttonResultat);
        buttonApprobation = (Button)findViewById(R.id.buttonApprobation);
        buttonReinitialiser = (Button)findViewById(R.id.buttonReinitialiser);

        buttonValidationEquipeA = (Button)findViewById(R.id.buttonValidationEquipeA);
        buttonValidationEquipeB = (Button)findViewById(R.id.buttonValidationEquipeB);

        SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        if(nomEquipeA == "" || nomEquipeB == ""){
            disableButton = (TextView)findViewById(R.id.disableButton);
            disableButton.setVisibility(View.VISIBLE);
            currentMatch = (TextView)findViewById(R.id.currentMatch);
            currentMatch.setVisibility(View.GONE);
            buttonEquipeA.setEnabled(false);
            buttonEquipeB.setEnabled(false);
            buttonValidationEquipeA.setEnabled(false);
            buttonValidationEquipeB.setEnabled(false);
            buttonSet1.setEnabled(false);
            buttonSet2.setEnabled(false);
            buttonSet3.setEnabled(false);
            buttonSet4.setEnabled(false);
            buttonSet5.setEnabled(false);
            buttonResultat.setEnabled(false);
            buttonApprobation.setEnabled(false);
        }
        else{
            disableButton = (TextView)findViewById(R.id.disableButton);
            disableButton.setVisibility(View.GONE);
            currentMatch = (TextView)findViewById(R.id.currentMatch);
            currentMatch.setVisibility(View.VISIBLE);
            currentMatch.setText(nomEquipeA + " - " + nomEquipeB);
            buttonEquipeA.setEnabled(true);
            buttonEquipeB.setEnabled(true);
            buttonValidationEquipeA.setEnabled(true);
            buttonValidationEquipeB.setEnabled(true);
            buttonSet1.setEnabled(true);
            buttonSet2.setEnabled(true);
            buttonSet3.setEnabled(true);
            buttonSet4.setEnabled(true);
            buttonSet5.setEnabled(true);
            buttonResultat.setEnabled(true);
            buttonApprobation.setEnabled(true);
        }

        buttonMatchRetourAccueille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonRecapitulatif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, Recapitulatif.class);
                startActivity(intent);
            }
        });

        buttonPreparatif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, Preparatif.class);
                startActivity(intent);
            }
        });

        buttonEquipeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, EquipeA.class);
                startActivity(intent);
            }
        });

        buttonEquipeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, EquipeB.class);
                startActivity(intent);
            }
        });

        buttonSet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, Set1.class);
                startActivity(intent);
            }
        });

        buttonSet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, Set2.class);
                startActivity(intent);
            }
        });

        buttonSet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, Set3.class);
                startActivity(intent);
            }
        });

        buttonSet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, Set4.class);
                startActivity(intent);
            }
        });

        buttonSet5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, Set5.class);
                startActivity(intent);
            }
        });

        buttonApprobation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, Approbation.class);
                startActivity(intent);
            }
        });

        buttonResultat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, Resultat.class);
                startActivity(intent);
            }
        });

        buttonValidationEquipeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, ValidationParEquipeB.class);
                startActivity(intent);
            }
        });

        buttonValidationEquipeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchActivity.this, ValidationParEquipeA.class);
                startActivity(intent);
            }
        });

        /*SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        if(nomEquipeA == ""){
            buttonEquipeA.setEnabled(false);
        }
        else{buttonEquipeA.setEnabled(true);}
        if(nomEquipeB == ""){
            buttonEquipeB.setEnabled(false);
        }
        else{buttonEquipeA.setEnabled(true);}*/

        buttonReinitialiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(MatchActivity.this);
                View promptView = layoutInflater.inflate(R.layout.reinitialiser_match_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MatchActivity.this);
                alertDialogBuilder.setView(promptView);


                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Réinitialiser", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                SharedPreferences preparatif = getSharedPreferences("preparatif", 0);
                                SharedPreferences.Editor editorPreparatif = preparatif.edit();
                                editorPreparatif.clear();
                                editorPreparatif.commit();

                                SharedPreferences saveEquipeA = getSharedPreferences("equipeA",0);
                                SharedPreferences.Editor editorEquipeA = saveEquipeA.edit();
                                editorEquipeA.clear();
                                editorEquipeA.commit();

                                SharedPreferences saveEquipeB = getSharedPreferences("equipeB",0);
                                SharedPreferences.Editor editorEquipeB = saveEquipeB.edit();
                                editorEquipeB.clear();
                                editorEquipeB.commit();

                                SharedPreferences saveSet1 = getSharedPreferences("set1",0);
                                SharedPreferences.Editor editorSet1 = saveSet1.edit();
                                editorSet1.clear();
                                editorSet1.commit();

                                SharedPreferences saveSet2 = getSharedPreferences("set2",0);
                                SharedPreferences.Editor editorSet2 = saveSet2.edit();
                                editorSet2.clear();
                                editorSet2.commit();

                                SharedPreferences saveSet3 = getSharedPreferences("set3",0);
                                SharedPreferences.Editor editorSet3 = saveSet3.edit();
                                editorSet3.clear();
                                editorSet3.commit();

                                SharedPreferences saveSet4 = getSharedPreferences("set4",0);
                                SharedPreferences.Editor editorSet4 = saveSet4.edit();
                                editorSet4.clear();
                                editorSet4.commit();

                                SharedPreferences saveSet5 = getSharedPreferences("set5",0);
                                SharedPreferences.Editor editorSet5 = saveSet5.edit();
                                editorSet5.clear();
                                editorSet5.commit();

                                SharedPreferences saveApprobation = getSharedPreferences("approbation",0);
                                SharedPreferences.Editor editorApprobation = saveApprobation.edit();
                                editorApprobation.clear();
                                editorApprobation.commit();

                                SharedPreferences saveResultat = getSharedPreferences("resultat",0);
                                SharedPreferences.Editor editorResultat = saveResultat.edit();
                                editorResultat.clear();
                                editorResultat.commit();

                                Intent intent = new Intent(MatchActivity.this, MatchActivity.class);
                                startActivity(intent);

                                File fileSignatureValidationParEquipeA = new File(DIRECTORY + "signatureValidationParEquipeA.png");
                                fileSignatureValidationParEquipeA.delete();
                                File fileSignatureValidationParEquipeB = new File(DIRECTORY + "signatureValidationParEquipeB.png");
                                fileSignatureValidationParEquipeB.delete();
                                File fileSignatureArbitre1 = new File(DIRECTORY + "signatureArbitre1.png");
                                fileSignatureArbitre1.delete();
                                File fileSignatureArbitre2 = new File(DIRECTORY + "signatureArbitre2.png");
                                fileSignatureArbitre2.delete();
                                File fileSignatureCapitaineA = new File(DIRECTORY + "signatureCapitaineA.png");
                                fileSignatureCapitaineA.delete();
                                File fileSignatureCapitaineB = new File(DIRECTORY + "signatureCapitaineB.png");
                                fileSignatureCapitaineB.delete();
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
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        if(nomEquipeA == "" || nomEquipeB == ""){
            disableButton = (TextView)findViewById(R.id.disableButton);
            disableButton.setVisibility(View.VISIBLE);
            currentMatch = (TextView)findViewById(R.id.currentMatch);
            currentMatch.setVisibility(View.GONE);
            buttonEquipeA.setEnabled(false);
            buttonEquipeB.setEnabled(false);
            buttonValidationEquipeA.setEnabled(false);
            buttonValidationEquipeB.setEnabled(false);
            buttonSet1.setEnabled(false);
            buttonSet2.setEnabled(false);
            buttonSet3.setEnabled(false);
            buttonSet4.setEnabled(false);
            buttonSet5.setEnabled(false);
            buttonResultat.setEnabled(false);
            buttonApprobation.setEnabled(false);
        }
        else{
            disableButton = (TextView)findViewById(R.id.disableButton);
            disableButton.setVisibility(View.GONE);
            currentMatch = (TextView)findViewById(R.id.currentMatch);
            currentMatch.setVisibility(View.VISIBLE);
            currentMatch.setText(nomEquipeA + " - " + nomEquipeB);
            buttonEquipeA.setEnabled(true);
            buttonEquipeB.setEnabled(true);
            buttonValidationEquipeA.setEnabled(true);
            buttonValidationEquipeB.setEnabled(true);
            buttonSet1.setEnabled(true);
            buttonSet2.setEnabled(true);
            buttonSet3.setEnabled(true);
            buttonSet4.setEnabled(true);
            buttonSet5.setEnabled(true);
            buttonResultat.setEnabled(true);
            buttonApprobation.setEnabled(true);
        }
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        if(nomEquipeA == "" || nomEquipeB == ""){
            disableButton = (TextView)findViewById(R.id.disableButton);
            disableButton.setVisibility(View.VISIBLE);
            currentMatch = (TextView)findViewById(R.id.currentMatch);
            currentMatch.setVisibility(View.GONE);
            buttonEquipeA.setEnabled(false);
            buttonEquipeB.setEnabled(false);
            buttonValidationEquipeA.setEnabled(false);
            buttonValidationEquipeB.setEnabled(false);
            buttonSet1.setEnabled(false);
            buttonSet2.setEnabled(false);
            buttonSet3.setEnabled(false);
            buttonSet4.setEnabled(false);
            buttonSet5.setEnabled(false);
            buttonResultat.setEnabled(false);
            buttonApprobation.setEnabled(false);
        }
        else{
            disableButton = (TextView)findViewById(R.id.disableButton);
            disableButton.setVisibility(View.GONE);
            currentMatch = (TextView)findViewById(R.id.currentMatch);
            currentMatch.setVisibility(View.VISIBLE);
            currentMatch.setText(nomEquipeA + " - " + nomEquipeB);
            buttonEquipeA.setEnabled(true);
            buttonEquipeB.setEnabled(true);
            buttonValidationEquipeA.setEnabled(true);
            buttonValidationEquipeB.setEnabled(true);
            buttonSet1.setEnabled(true);
            buttonSet2.setEnabled(true);
            buttonSet3.setEnabled(true);
            buttonSet4.setEnabled(true);
            buttonSet5.setEnabled(true);
            buttonResultat.setEnabled(true);
            buttonApprobation.setEnabled(true);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        SharedPreferences loadPreparatif = getSharedPreferences("preparatif", 0);
        String nomEquipeA = loadPreparatif.getString("nomEquipeA", "");
        String nomEquipeB = loadPreparatif.getString("nomEquipeB", "");
        if(nomEquipeA == "" || nomEquipeB == ""){
            disableButton = (TextView)findViewById(R.id.disableButton);
            disableButton.setVisibility(View.VISIBLE);
            currentMatch = (TextView)findViewById(R.id.currentMatch);
            currentMatch.setVisibility(View.GONE);
            buttonEquipeA.setEnabled(false);
            buttonEquipeB.setEnabled(false);
            buttonValidationEquipeA.setEnabled(false);
            buttonValidationEquipeB.setEnabled(false);
            buttonSet1.setEnabled(false);
            buttonSet2.setEnabled(false);
            buttonSet3.setEnabled(false);
            buttonSet4.setEnabled(false);
            buttonSet5.setEnabled(false);
            buttonResultat.setEnabled(false);
            buttonApprobation.setEnabled(false);
        }
        else{
            disableButton = (TextView)findViewById(R.id.disableButton);
            disableButton.setVisibility(View.GONE);
            currentMatch = (TextView)findViewById(R.id.currentMatch);
            currentMatch.setVisibility(View.VISIBLE);
            currentMatch.setText(nomEquipeA + " - " + nomEquipeB);
            buttonEquipeA.setEnabled(true);
            buttonEquipeB.setEnabled(true);
            buttonValidationEquipeA.setEnabled(true);
            buttonValidationEquipeB.setEnabled(true);
            buttonSet1.setEnabled(true);
            buttonSet2.setEnabled(true);
            buttonSet3.setEnabled(true);
            buttonSet4.setEnabled(true);
            buttonSet5.setEnabled(true);
            buttonResultat.setEnabled(true);
            buttonApprobation.setEnabled(true);
        }
    }

}
