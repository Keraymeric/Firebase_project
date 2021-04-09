package com.example.florian.fichiertexteandbddtest1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Recapitulatif extends AppCompatActivity {

    String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";

    //préparatif
    TextView textViewDate;
    TextView textViewCompetition;
    TextView textViewCategorie;
    TextView textViewLieu;
    TextView textViewHeureDebut;
    TextView textViewHeureFin;

    TextView textViewNomEquipeA;
    TextView textViewNomEquipeB;

    //equipe A
    TextView textViewNumA1;
    TextView textViewNumA2;
    TextView textViewNumA3;
    TextView textViewNumA4;
    TextView textViewNumA5;
    TextView textViewNumA6;
    TextView textViewNumA7;
    TextView textViewNumA8;
    TextView textViewNumA9;
    TextView textViewNumA10;
    TextView textViewNumA11;
    TextView textViewNumA12;
    /*TextView textViewNumA13;
    TextView textViewNumA14;
    TextView textViewNumA15;*/
    TextView textViewNomA1;
    TextView textViewNomA2;
    TextView textViewNomA3;
    TextView textViewNomA4;
    TextView textViewNomA5;
    TextView textViewNomA6;
    TextView textViewNomA7;
    TextView textViewNomA8;
    TextView textViewNomA9;
    TextView textViewNomA10;
    TextView textViewNomA11;
    TextView textViewNomA12;
    TextView textViewNomA13;
    TextView textViewNomA14;
    TextView textViewNomA15;
    TextView textViewNumLicenceA1;
    TextView textViewNumLicenceA2;
    TextView textViewNumLicenceA3;
    TextView textViewNumLicenceA4;
    TextView textViewNumLicenceA5;
    TextView textViewNumLicenceA6;
    TextView textViewNumLicenceA7;
    TextView textViewNumLicenceA8;
    TextView textViewNumLicenceA9;
    TextView textViewNumLicenceA10;
    TextView textViewNumLicenceA11;
    TextView textViewNumLicenceA12;
    TextView textViewNumLicenceA13;
    TextView textViewNumLicenceA14;
    TextView textViewNumLicenceA15;

    //equipe B
    TextView textViewNumB1;
    TextView textViewNumB2;
    TextView textViewNumB3;
    TextView textViewNumB4;
    TextView textViewNumB5;
    TextView textViewNumB6;
    TextView textViewNumB7;
    TextView textViewNumB8;
    TextView textViewNumB9;
    TextView textViewNumB10;
    TextView textViewNumB11;
    TextView textViewNumB12;
    /*TextView textViewNumB13;
    TextView textViewNumB14;
    TextView textViewNumB15;*/
    TextView textViewNomB1;
    TextView textViewNomB2;
    TextView textViewNomB3;
    TextView textViewNomB4;
    TextView textViewNomB5;
    TextView textViewNomB6;
    TextView textViewNomB7;
    TextView textViewNomB8;
    TextView textViewNomB9;
    TextView textViewNomB10;
    TextView textViewNomB11;
    TextView textViewNomB12;
    TextView textViewNomB13;
    TextView textViewNomB14;
    TextView textViewNomB15;
    TextView textViewNumLicenceB1;
    TextView textViewNumLicenceB2;
    TextView textViewNumLicenceB3;
    TextView textViewNumLicenceB4;
    TextView textViewNumLicenceB5;
    TextView textViewNumLicenceB6;
    TextView textViewNumLicenceB7;
    TextView textViewNumLicenceB8;
    TextView textViewNumLicenceB9;
    TextView textViewNumLicenceB10;
    TextView textViewNumLicenceB11;
    TextView textViewNumLicenceB12;
    TextView textViewNumLicenceB13;
    TextView textViewNumLicenceB14;
    TextView textViewNumLicenceB15;

    //textSet1
    TextView textViewSet1Ap1;
    TextView textViewSet1Ap2;
    TextView textViewSet1Ap3;
    TextView textViewSet1Ap4;
    TextView textViewSet1Ap5;
    TextView textViewSet1Ap6;
    TextView textViewSet1Bp1;
    TextView textViewSet1Bp2;
    TextView textViewSet1Bp3;
    TextView textViewSet1Bp4;
    TextView textViewSet1Bp5;
    TextView textViewSet1Bp6;
    TextView textViewSet1Ascore;
    TextView textViewSet1Bscore;

    TextView textViewSet1RemplacementAp1;
    TextView textViewSet1RemplacementAp2;
    TextView textViewSet1RemplacementAp3;
    TextView textViewSet1RemplacementAp4;
    TextView textViewSet1RemplacementAp5;
    TextView textViewSet1RemplacementAp6;
    TextView textViewSet1RemplacementBp1;
    TextView textViewSet1RemplacementBp2;
    TextView textViewSet1RemplacementBp3;
    TextView textViewSet1RemplacementBp4;
    TextView textViewSet1RemplacementBp5;
    TextView textViewSet1RemplacementBp6;

    TextView textViewTempsMort1Set1A;
    TextView textViewTempsMort2Set1A;
    TextView textViewTempsMort1Set1B;
    TextView textViewTempsMort2Set1B;

    //textSet2
    TextView textViewSet2Ap1;
    TextView textViewSet2Ap2;
    TextView textViewSet2Ap3;
    TextView textViewSet2Ap4;
    TextView textViewSet2Ap5;
    TextView textViewSet2Ap6;
    TextView textViewSet2Bp1;
    TextView textViewSet2Bp2;
    TextView textViewSet2Bp3;
    TextView textViewSet2Bp4;
    TextView textViewSet2Bp5;
    TextView textViewSet2Bp6;
    TextView textViewSet2Ascore;
    TextView textViewSet2Bscore;

    TextView textViewSet2RemplacementAp1;
    TextView textViewSet2RemplacementAp2;
    TextView textViewSet2RemplacementAp3;
    TextView textViewSet2RemplacementAp4;
    TextView textViewSet2RemplacementAp5;
    TextView textViewSet2RemplacementAp6;
    TextView textViewSet2RemplacementBp1;
    TextView textViewSet2RemplacementBp2;
    TextView textViewSet2RemplacementBp3;
    TextView textViewSet2RemplacementBp4;
    TextView textViewSet2RemplacementBp5;
    TextView textViewSet2RemplacementBp6;

    TextView textViewTempsMort1Set2A;
    TextView textViewTempsMort2Set2A;
    TextView textViewTempsMort1Set2B;
    TextView textViewTempsMort2Set2B;

    //textSet3
    TextView textViewSet3Ap1;
    TextView textViewSet3Ap2;
    TextView textViewSet3Ap3;
    TextView textViewSet3Ap4;
    TextView textViewSet3Ap5;
    TextView textViewSet3Ap6;
    TextView textViewSet3Bp1;
    TextView textViewSet3Bp2;
    TextView textViewSet3Bp3;
    TextView textViewSet3Bp4;
    TextView textViewSet3Bp5;
    TextView textViewSet3Bp6;
    TextView textViewSet3Ascore;
    TextView textViewSet3Bscore;

    TextView textViewSet3RemplacementAp1;
    TextView textViewSet3RemplacementAp2;
    TextView textViewSet3RemplacementAp3;
    TextView textViewSet3RemplacementAp4;
    TextView textViewSet3RemplacementAp5;
    TextView textViewSet3RemplacementAp6;
    TextView textViewSet3RemplacementBp1;
    TextView textViewSet3RemplacementBp2;
    TextView textViewSet3RemplacementBp3;
    TextView textViewSet3RemplacementBp4;
    TextView textViewSet3RemplacementBp5;
    TextView textViewSet3RemplacementBp6;

    TextView textViewTempsMort1Set3A;
    TextView textViewTempsMort2Set3A;
    TextView textViewTempsMort1Set3B;
    TextView textViewTempsMort2Set3B;

    //textSet4
    TextView textViewSet4Ap1;
    TextView textViewSet4Ap2;
    TextView textViewSet4Ap3;
    TextView textViewSet4Ap4;
    TextView textViewSet4Ap5;
    TextView textViewSet4Ap6;
    TextView textViewSet4Bp1;
    TextView textViewSet4Bp2;
    TextView textViewSet4Bp3;
    TextView textViewSet4Bp4;
    TextView textViewSet4Bp5;
    TextView textViewSet4Bp6;
    TextView textViewSet4Ascore;
    TextView textViewSet4Bscore;

    TextView textViewSet4RemplacementAp1;
    TextView textViewSet4RemplacementAp2;
    TextView textViewSet4RemplacementAp3;
    TextView textViewSet4RemplacementAp4;
    TextView textViewSet4RemplacementAp5;
    TextView textViewSet4RemplacementAp6;
    TextView textViewSet4RemplacementBp1;
    TextView textViewSet4RemplacementBp2;
    TextView textViewSet4RemplacementBp3;
    TextView textViewSet4RemplacementBp4;
    TextView textViewSet4RemplacementBp5;
    TextView textViewSet4RemplacementBp6;

    TextView textViewTempsMort1Set4A;
    TextView textViewTempsMort2Set4A;
    TextView textViewTempsMort1Set4B;
    TextView textViewTempsMort2Set4B;

    //textSet5
    TextView textViewSet5Ap1;
    TextView textViewSet5Ap2;
    TextView textViewSet5Ap3;
    TextView textViewSet5Ap4;
    TextView textViewSet5Ap5;
    TextView textViewSet5Ap6;
    TextView textViewSet5Bp1;
    TextView textViewSet5Bp2;
    TextView textViewSet5Bp3;
    TextView textViewSet5Bp4;
    TextView textViewSet5Bp5;
    TextView textViewSet5Bp6;
    TextView textViewSet5Ascore;
    TextView textViewSet5Bscore;

    TextView textViewSet5RemplacementAp1;
    TextView textViewSet5RemplacementAp2;
    TextView textViewSet5RemplacementAp3;
    TextView textViewSet5RemplacementAp4;
    TextView textViewSet5RemplacementAp5;
    TextView textViewSet5RemplacementAp6;
    TextView textViewSet5RemplacementBp1;
    TextView textViewSet5RemplacementBp2;
    TextView textViewSet5RemplacementBp3;
    TextView textViewSet5RemplacementBp4;
    TextView textViewSet5RemplacementBp5;
    TextView textViewSet5RemplacementBp6;

    TextView textViewTempsMort1Set5A;
    TextView textViewTempsMort2Set5A;
    TextView textViewTempsMort1Set5B;
    TextView textViewTempsMort2Set5B;

    //Résultat
    TextView textViewResultat;

    //Remarques
    TextView textViewRemarque;

    //Approbation
    TextView textViewNomArbitre1;
    TextView textViewNumLicenceArbitre1;
    TextView textViewClubDesigneArbitre1;
    TextView textViewIndemniteArbitre1;
    TextView textViewNomArbitre2;
    TextView textViewNumLicenceArbitre2;
    TextView textViewNomCapitaineA;
    TextView textViewNumLicenceCapitaineA;
    TextView textViewNomCapitaineB;
    TextView textViewNumLicenceCapitaineB;

    //génération du pdf
    Button buttonRecapitulatifCreerPdf, buttonRecapitulatifEmailPdf;

    //les signatures
    ImageView recapitulatifSignatureA, recapitulatifSignatureB;
    ImageView recapitulatifSignatureArbitre1, recapitulatifSignatureArbitre2;
    ImageView recapitulatifSignatureCapitaineA, recapitulatifSignatureCapitaineB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recapitulatif);

        //préparatif
        textViewDate = (TextView)findViewById(R.id.textViewDate);
        textViewCompetition = (TextView)findViewById(R.id.textViewCompetition);
        textViewCategorie = (TextView)findViewById(R.id.textViewCategorie);
        textViewLieu = (TextView)findViewById(R.id.textViewLieu);
        textViewHeureDebut = (TextView)findViewById(R.id.textViewHeureDebut);
        textViewHeureFin = (TextView)findViewById(R.id.textViewHeureFin);
        final SharedPreferences loadPreparatif = getSharedPreferences("preparatif",0);
        String date = loadPreparatif.getString("date", "");
        String competition = loadPreparatif.getString("competition", "");
        String categorie = loadPreparatif.getString("categorie", "");
        String lieu = loadPreparatif.getString("lieu", "");
        String heureDebut = loadPreparatif.getString("heureDebut", "");
        textViewDate.setText("Date : " + date);
        textViewCompetition.setText("Compétition : " + competition);
        textViewCategorie.setText("Catégorie : " + categorie);
        textViewLieu.setText("Lieu : " + lieu);
        textViewHeureDebut.setText("Heure début : " + heureDebut);

        textViewNomEquipeA = (TextView)findViewById(R.id.textViewNomEquipeA);
        textViewNomEquipeB = (TextView)findViewById(R.id.textViewNomEquipeB);
        textViewNomEquipeA.setText("Équipe A : " + loadPreparatif.getString("nomEquipeA", ""));
        textViewNomEquipeB.setText("Équipe B : " + loadPreparatif.getString("nomEquipeB", ""));

        //Equipe A
        textViewNumA1 = (TextView)findViewById(R.id.textViewNumA1);
        textViewNumA2 = (TextView)findViewById(R.id.textViewNumA2);
        textViewNumA3 = (TextView)findViewById(R.id.textViewNumA3);
        textViewNumA4 = (TextView)findViewById(R.id.textViewNumA4);
        textViewNumA5 = (TextView)findViewById(R.id.textViewNumA5);
        textViewNumA6 = (TextView)findViewById(R.id.textViewNumA6);
        textViewNumA7 = (TextView)findViewById(R.id.textViewNumA7);
        textViewNumA8 = (TextView)findViewById(R.id.textViewNumA8);
        textViewNumA9 = (TextView)findViewById(R.id.textViewNumA9);
        textViewNumA10 = (TextView)findViewById(R.id.textViewNumA10);
        textViewNumA11 = (TextView)findViewById(R.id.textViewNumA11);
        textViewNumA12 = (TextView)findViewById(R.id.textViewNumA12);
        /*textViewNumA13 = (TextView)findViewById(R.id.textViewNumA13);
        textViewNumA14 = (TextView)findViewById(R.id.textViewNumA14);
        textViewNumA15 = (TextView)findViewById(R.id.textViewNumA15);*/
        textViewNomA1 = (TextView)findViewById(R.id.textViewNomA1);
        textViewNomA2 = (TextView)findViewById(R.id.textViewNomA2);
        textViewNomA3 = (TextView)findViewById(R.id.textViewNomA3);
        textViewNomA4 = (TextView)findViewById(R.id.textViewNomA4);
        textViewNomA5 = (TextView)findViewById(R.id.textViewNomA5);
        textViewNomA6 = (TextView)findViewById(R.id.textViewNomA6);
        textViewNomA7 = (TextView)findViewById(R.id.textViewNomA7);
        textViewNomA8 = (TextView)findViewById(R.id.textViewNomA8);
        textViewNomA9 = (TextView)findViewById(R.id.textViewNomA9);
        textViewNomA10 = (TextView)findViewById(R.id.textViewNomA10);
        textViewNomA11 = (TextView)findViewById(R.id.textViewNomA11);
        textViewNomA12 = (TextView)findViewById(R.id.textViewNomA12);
        textViewNomA13 = (TextView)findViewById(R.id.textViewNomA13);
        textViewNomA14 = (TextView)findViewById(R.id.textViewNomA14);
        textViewNomA15 = (TextView)findViewById(R.id.textViewNomA15);
        textViewNumLicenceA1 = (TextView)findViewById(R.id.textViewNumLicenceA1);
        textViewNumLicenceA2 = (TextView)findViewById(R.id.textViewNumLicenceA2);
        textViewNumLicenceA3 = (TextView)findViewById(R.id.textViewNumLicenceA3);
        textViewNumLicenceA4 = (TextView)findViewById(R.id.textViewNumLicenceA4);
        textViewNumLicenceA5 = (TextView)findViewById(R.id.textViewNumLicenceA5);
        textViewNumLicenceA6 = (TextView)findViewById(R.id.textViewNumLicenceA6);
        textViewNumLicenceA7 = (TextView)findViewById(R.id.textViewNumLicenceA7);
        textViewNumLicenceA8 = (TextView)findViewById(R.id.textViewNumLicenceA8);
        textViewNumLicenceA9 = (TextView)findViewById(R.id.textViewNumLicenceA9);
        textViewNumLicenceA10 = (TextView)findViewById(R.id.textViewNumLicenceA10);
        textViewNumLicenceA11 = (TextView)findViewById(R.id.textViewNumLicenceA11);
        textViewNumLicenceA12 = (TextView)findViewById(R.id.textViewNumLicenceA12);
        textViewNumLicenceA13 = (TextView)findViewById(R.id.textViewNumLicenceA13);
        textViewNumLicenceA14 = (TextView)findViewById(R.id.textViewNumLicenceA14);
        textViewNumLicenceA15 = (TextView)findViewById(R.id.textViewNumLicenceA15);
        final SharedPreferences loadEquipeA = getSharedPreferences("equipeA",0);
        textViewNumA1.setText(loadEquipeA.getString("numA1", ""));
        textViewNumA2.setText(loadEquipeA.getString("numA2", ""));
        textViewNumA3.setText(loadEquipeA.getString("numA3", ""));
        textViewNumA4.setText(loadEquipeA.getString("numA4", ""));
        textViewNumA5.setText(loadEquipeA.getString("numA5", ""));
        textViewNumA6.setText(loadEquipeA.getString("numA6", ""));
        textViewNumA7.setText(loadEquipeA.getString("numA7", ""));
        textViewNumA8.setText(loadEquipeA.getString("numA8", ""));
        textViewNumA9.setText(loadEquipeA.getString("numA9", ""));
        textViewNumA10.setText(loadEquipeA.getString("numA10", ""));
        textViewNumA11.setText(loadEquipeA.getString("numA11", ""));
        textViewNumA12.setText(loadEquipeA.getString("numA12", ""));
       /* textViewNumA13.setText(loadEquipeA.getString("numA13", ""));
        textViewNumA14.setText(loadEquipeA.getString("numA14", ""));
        textViewNumA15.setText(loadEquipeA.getString("numA15", ""));*/
        textViewNomA1.setText(loadEquipeA.getString("nomA1", ""));
        textViewNomA2.setText(loadEquipeA.getString("nomA2", ""));
        textViewNomA3.setText(loadEquipeA.getString("nomA3", ""));
        textViewNomA4.setText(loadEquipeA.getString("nomA4", ""));
        textViewNomA5.setText(loadEquipeA.getString("nomA5", ""));
        textViewNomA6.setText(loadEquipeA.getString("nomA6", ""));
        textViewNomA7.setText(loadEquipeA.getString("nomA7", ""));
        textViewNomA8.setText(loadEquipeA.getString("nomA8", ""));
        textViewNomA9.setText(loadEquipeA.getString("nomA9", ""));
        textViewNomA10.setText(loadEquipeA.getString("nomA10", ""));
        textViewNomA11.setText(loadEquipeA.getString("nomA11", ""));
        textViewNomA12.setText(loadEquipeA.getString("nomA12", ""));
        textViewNomA13.setText(loadEquipeA.getString("nomA13", ""));
        textViewNomA14.setText(loadEquipeA.getString("nomA14", ""));
        textViewNomA15.setText(loadEquipeA.getString("nomA15", ""));
        textViewNumLicenceA1.setText(loadEquipeA.getString("numLicenceA1", ""));
        textViewNumLicenceA2.setText(loadEquipeA.getString("numLicenceA2", ""));
        textViewNumLicenceA3.setText(loadEquipeA.getString("numLicenceA3", ""));
        textViewNumLicenceA4.setText(loadEquipeA.getString("numLicenceA4", ""));
        textViewNumLicenceA5.setText(loadEquipeA.getString("numLicenceA5", ""));
        textViewNumLicenceA6.setText(loadEquipeA.getString("numLicenceA6", ""));
        textViewNumLicenceA7.setText(loadEquipeA.getString("numLicenceA7", ""));
        textViewNumLicenceA8.setText(loadEquipeA.getString("numLicenceA8", ""));
        textViewNumLicenceA9.setText(loadEquipeA.getString("numLicenceA9", ""));
        textViewNumLicenceA10.setText(loadEquipeA.getString("numLicenceA10", ""));
        textViewNumLicenceA11.setText(loadEquipeA.getString("numLicenceA11", ""));
        textViewNumLicenceA12.setText(loadEquipeA.getString("numLicenceA12", ""));
        textViewNumLicenceA13.setText(loadEquipeA.getString("numLicenceA13", ""));
        textViewNumLicenceA14.setText(loadEquipeA.getString("numLicenceA14", ""));
        textViewNumLicenceA15.setText(loadEquipeA.getString("numLicenceA15", ""));

        //equipe B
        textViewNumB1 = (TextView)findViewById(R.id.textViewNumB1);
        textViewNumB2 = (TextView)findViewById(R.id.textViewNumB2);
        textViewNumB3 = (TextView)findViewById(R.id.textViewNumB3);
        textViewNumB4 = (TextView)findViewById(R.id.textViewNumB4);
        textViewNumB5 = (TextView)findViewById(R.id.textViewNumB5);
        textViewNumB6 = (TextView)findViewById(R.id.textViewNumB6);
        textViewNumB7 = (TextView)findViewById(R.id.textViewNumB7);
        textViewNumB8 = (TextView)findViewById(R.id.textViewNumB8);
        textViewNumB9 = (TextView)findViewById(R.id.textViewNumB9);
        textViewNumB10 = (TextView)findViewById(R.id.textViewNumB10);
        textViewNumB11 = (TextView)findViewById(R.id.textViewNumB11);
        textViewNumB12 = (TextView)findViewById(R.id.textViewNumB12);
        /*textViewNumB13 = (TextView)findViewById(R.id.textViewNumB13);
        textViewNumB14 = (TextView)findViewById(R.id.textViewNumB14);
        textViewNumB15 = (TextView)findViewById(R.id.textViewNumB15);*/
        textViewNomB1 = (TextView)findViewById(R.id.textViewNomB1);
        textViewNomB2 = (TextView)findViewById(R.id.textViewNomB2);
        textViewNomB3 = (TextView)findViewById(R.id.textViewNomB3);
        textViewNomB4 = (TextView)findViewById(R.id.textViewNomB4);
        textViewNomB5 = (TextView)findViewById(R.id.textViewNomB5);
        textViewNomB6 = (TextView)findViewById(R.id.textViewNomB6);
        textViewNomB7 = (TextView)findViewById(R.id.textViewNomB7);
        textViewNomB8 = (TextView)findViewById(R.id.textViewNomB8);
        textViewNomB9 = (TextView)findViewById(R.id.textViewNomB9);
        textViewNomB10 = (TextView)findViewById(R.id.textViewNomB10);
        textViewNomB11 = (TextView)findViewById(R.id.textViewNomB11);
        textViewNomB12 = (TextView)findViewById(R.id.textViewNomB12);
        textViewNomB13 = (TextView)findViewById(R.id.textViewNomB13);
        textViewNomB14 = (TextView)findViewById(R.id.textViewNomB14);
        textViewNomB15 = (TextView)findViewById(R.id.textViewNomB15);
        textViewNumLicenceB1 = (TextView)findViewById(R.id.textViewNumLicenceB1);
        textViewNumLicenceB2 = (TextView)findViewById(R.id.textViewNumLicenceB2);
        textViewNumLicenceB3 = (TextView)findViewById(R.id.textViewNumLicenceB3);
        textViewNumLicenceB4 = (TextView)findViewById(R.id.textViewNumLicenceB4);
        textViewNumLicenceB5 = (TextView)findViewById(R.id.textViewNumLicenceB5);
        textViewNumLicenceB6 = (TextView)findViewById(R.id.textViewNumLicenceB6);
        textViewNumLicenceB7 = (TextView)findViewById(R.id.textViewNumLicenceB7);
        textViewNumLicenceB8 = (TextView)findViewById(R.id.textViewNumLicenceB8);
        textViewNumLicenceB9 = (TextView)findViewById(R.id.textViewNumLicenceB9);
        textViewNumLicenceB10 = (TextView)findViewById(R.id.textViewNumLicenceB10);
        textViewNumLicenceB11 = (TextView)findViewById(R.id.textViewNumLicenceB11);
        textViewNumLicenceB12 = (TextView)findViewById(R.id.textViewNumLicenceB12);
        textViewNumLicenceB13 = (TextView)findViewById(R.id.textViewNumLicenceB13);
        textViewNumLicenceB14 = (TextView)findViewById(R.id.textViewNumLicenceB14);
        textViewNumLicenceB15 = (TextView)findViewById(R.id.textViewNumLicenceB15);
        final SharedPreferences loadEquipeB = getSharedPreferences("equipeB",0);
        textViewNumB1.setText(loadEquipeB.getString("numB1", ""));
        textViewNumB2.setText(loadEquipeB.getString("numB2", ""));
        textViewNumB3.setText(loadEquipeB.getString("numB3", ""));
        textViewNumB4.setText(loadEquipeB.getString("numB4", ""));
        textViewNumB5.setText(loadEquipeB.getString("numB5", ""));
        textViewNumB6.setText(loadEquipeB.getString("numB6", ""));
        textViewNumB7.setText(loadEquipeB.getString("numB7", ""));
        textViewNumB8.setText(loadEquipeB.getString("numB8", ""));
        textViewNumB9.setText(loadEquipeB.getString("numB9", ""));
        textViewNumB10.setText(loadEquipeB.getString("numB10", ""));
        textViewNumB11.setText(loadEquipeB.getString("numB11", ""));
        textViewNumB12.setText(loadEquipeB.getString("numB12", ""));
        /*textViewNumB13.setText(loadEquipeB.getString("numB13", ""));
        textViewNumB14.setText(loadEquipeB.getString("numB14", ""));
        textViewNumB15.setText(loadEquipeB.getString("numB15", ""));*/
        textViewNomB1.setText(loadEquipeB.getString("nomB1", ""));
        textViewNomB2.setText(loadEquipeB.getString("nomB2", ""));
        textViewNomB3.setText(loadEquipeB.getString("nomB3", ""));
        textViewNomB4.setText(loadEquipeB.getString("nomB4", ""));
        textViewNomB5.setText(loadEquipeB.getString("nomB5", ""));
        textViewNomB6.setText(loadEquipeB.getString("nomB6", ""));
        textViewNomB7.setText(loadEquipeB.getString("nomB7", ""));
        textViewNomB8.setText(loadEquipeB.getString("nomB8", ""));
        textViewNomB9.setText(loadEquipeB.getString("nomB9", ""));
        textViewNomB10.setText(loadEquipeB.getString("nomB10", ""));
        textViewNomB11.setText(loadEquipeB.getString("nomB11", ""));
        textViewNomB12.setText(loadEquipeB.getString("nomB12", ""));
        textViewNomB13.setText(loadEquipeB.getString("nomB13", ""));
        textViewNomB14.setText(loadEquipeB.getString("nomB14", ""));
        textViewNomB15.setText(loadEquipeB.getString("nomB15", ""));
        textViewNumLicenceB1.setText(loadEquipeB.getString("numLicenceB1", ""));
        textViewNumLicenceB2.setText(loadEquipeB.getString("numLicenceB2", ""));
        textViewNumLicenceB3.setText(loadEquipeB.getString("numLicenceB3", ""));
        textViewNumLicenceB4.setText(loadEquipeB.getString("numLicenceB4", ""));
        textViewNumLicenceB5.setText(loadEquipeB.getString("numLicenceB5", ""));
        textViewNumLicenceB6.setText(loadEquipeB.getString("numLicenceB6", ""));
        textViewNumLicenceB7.setText(loadEquipeB.getString("numLicenceB7", ""));
        textViewNumLicenceB8.setText(loadEquipeB.getString("numLicenceB8", ""));
        textViewNumLicenceB9.setText(loadEquipeB.getString("numLicenceB9", ""));
        textViewNumLicenceB10.setText(loadEquipeB.getString("numLicenceB10", ""));
        textViewNumLicenceB11.setText(loadEquipeB.getString("numLicenceB11", ""));
        textViewNumLicenceB12.setText(loadEquipeB.getString("numLicenceB12", ""));
        textViewNumLicenceB13.setText(loadEquipeB.getString("numLicenceB13", ""));
        textViewNumLicenceB14.setText(loadEquipeB.getString("numLicenceB14", ""));
        textViewNumLicenceB15.setText(loadEquipeB.getString("numLicenceB15", ""));


        //set1
        textViewSet1Ap1 = (TextView)findViewById(R.id.textViewSet1Ap1);
        textViewSet1Ap2 = (TextView)findViewById(R.id.textViewSet1Ap2);
        textViewSet1Ap3 = (TextView)findViewById(R.id.textViewSet1Ap3);
        textViewSet1Ap4 = (TextView)findViewById(R.id.textViewSet1Ap4);
        textViewSet1Ap5 = (TextView)findViewById(R.id.textViewSet1Ap5);
        textViewSet1Ap6 = (TextView)findViewById(R.id.textViewSet1Ap6);
        textViewSet1Bp1 = (TextView)findViewById(R.id.textViewSet1Bp1);
        textViewSet1Bp2 = (TextView)findViewById(R.id.textViewSet1Bp2);
        textViewSet1Bp3 = (TextView)findViewById(R.id.textViewSet1Bp3);
        textViewSet1Bp4 = (TextView)findViewById(R.id.textViewSet1Bp4);
        textViewSet1Bp5 = (TextView)findViewById(R.id.textViewSet1Bp5);
        textViewSet1Bp6 = (TextView)findViewById(R.id.textViewSet1Bp6);
        textViewSet1Ascore = (TextView)findViewById(R.id.textViewSet1Ascore);
        textViewSet1Bscore = (TextView)findViewById(R.id.textViewSet1Bscore);

        textViewSet1RemplacementAp1 = (TextView)findViewById(R.id.textViewSet1RemplacementAp1);
        textViewSet1RemplacementAp2 = (TextView)findViewById(R.id.textViewSet1RemplacementAp2);
        textViewSet1RemplacementAp3 = (TextView)findViewById(R.id.textViewSet1RemplacementAp3);
        textViewSet1RemplacementAp4 = (TextView)findViewById(R.id.textViewSet1RemplacementAp4);
        textViewSet1RemplacementAp5 = (TextView)findViewById(R.id.textViewSet1RemplacementAp5);
        textViewSet1RemplacementAp6 = (TextView)findViewById(R.id.textViewSet1RemplacementAp6);
        textViewSet1RemplacementBp1 = (TextView)findViewById(R.id.textViewSet1RemplacementBp1);
        textViewSet1RemplacementBp2 = (TextView)findViewById(R.id.textViewSet1RemplacementBp2);
        textViewSet1RemplacementBp3 = (TextView)findViewById(R.id.textViewSet1RemplacementBp3);
        textViewSet1RemplacementBp4 = (TextView)findViewById(R.id.textViewSet1RemplacementBp4);
        textViewSet1RemplacementBp5 = (TextView)findViewById(R.id.textViewSet1RemplacementBp5);
        textViewSet1RemplacementBp6 = (TextView)findViewById(R.id.textViewSet1RemplacementBp6);

        textViewTempsMort1Set1A = (TextView)findViewById(R.id.textViewTempsMort1Set1A);
        textViewTempsMort2Set1A = (TextView)findViewById(R.id.textViewTempsMort2Set1A);
        textViewTempsMort1Set1B = (TextView)findViewById(R.id.textViewTempsMort1Set1B);
        textViewTempsMort2Set1B = (TextView)findViewById(R.id.textViewTempsMort2Set1B);

        final SharedPreferences loadSet1 = getSharedPreferences("set1",0);
        textViewSet1Ap1.setText(loadSet1.getString("set1Ap1", ""));
        textViewSet1Ap2.setText(loadSet1.getString("set1Ap2", ""));
        textViewSet1Ap3.setText(loadSet1.getString("set1Ap3", ""));
        textViewSet1Ap4.setText(loadSet1.getString("set1Ap4", ""));
        textViewSet1Ap5.setText(loadSet1.getString("set1Ap5", ""));
        textViewSet1Ap6.setText(loadSet1.getString("set1Ap6", ""));
        textViewSet1Bp1.setText(loadSet1.getString("set1Bp1", ""));
        textViewSet1Bp2.setText(loadSet1.getString("set1Bp2", ""));
        textViewSet1Bp3.setText(loadSet1.getString("set1Bp3", ""));
        textViewSet1Bp4.setText(loadSet1.getString("set1Bp4", ""));
        textViewSet1Bp5.setText(loadSet1.getString("set1Bp5", ""));
        textViewSet1Bp6.setText(loadSet1.getString("set1Bp6", ""));
        textViewSet1Ascore.setText(loadSet1.getString("set1Ascore", ""));
        textViewSet1Bscore.setText(loadSet1.getString("set1Bscore", ""));

        textViewSet1RemplacementAp1.setText(loadSet1.getString("set1RemplacementAp1", ""));
        textViewSet1RemplacementAp2.setText(loadSet1.getString("set1RemplacementAp2", ""));
        textViewSet1RemplacementAp3.setText(loadSet1.getString("set1RemplacementAp3", ""));
        textViewSet1RemplacementAp4.setText(loadSet1.getString("set1RemplacementAp4", ""));
        textViewSet1RemplacementAp5.setText(loadSet1.getString("set1RemplacementAp5", ""));
        textViewSet1RemplacementAp6.setText(loadSet1.getString("set1RemplacementAp6", ""));
        textViewSet1RemplacementBp1.setText(loadSet1.getString("set1RemplacementBp1", ""));
        textViewSet1RemplacementBp2.setText(loadSet1.getString("set1RemplacementBp2", ""));
        textViewSet1RemplacementBp3.setText(loadSet1.getString("set1RemplacementBp3", ""));
        textViewSet1RemplacementBp4.setText(loadSet1.getString("set1RemplacementBp4", ""));
        textViewSet1RemplacementBp5.setText(loadSet1.getString("set1RemplacementBp5", ""));
        textViewSet1RemplacementBp6.setText(loadSet1.getString("set1RemplacementBp6", ""));

        textViewTempsMort1Set1A.setText(loadSet1.getString("set1ChronoDebutA", ""));
        textViewTempsMort2Set1A.setText(loadSet1.getString("set1ChronoFinA", ""));
        textViewTempsMort1Set1B.setText(loadSet1.getString("set1ChronoDebutB", ""));
        textViewTempsMort2Set1B.setText(loadSet1.getString("set1ChronoFinB", ""));

        //set2
        textViewSet2Ap1 = (TextView)findViewById(R.id.textViewSet2Ap1);
        textViewSet2Ap2 = (TextView)findViewById(R.id.textViewSet2Ap2);
        textViewSet2Ap3 = (TextView)findViewById(R.id.textViewSet2Ap3);
        textViewSet2Ap4 = (TextView)findViewById(R.id.textViewSet2Ap4);
        textViewSet2Ap5 = (TextView)findViewById(R.id.textViewSet2Ap5);
        textViewSet2Ap6 = (TextView)findViewById(R.id.textViewSet2Ap6);
        textViewSet2Bp1 = (TextView)findViewById(R.id.textViewSet2Bp1);
        textViewSet2Bp2 = (TextView)findViewById(R.id.textViewSet2Bp2);
        textViewSet2Bp3 = (TextView)findViewById(R.id.textViewSet2Bp3);
        textViewSet2Bp4 = (TextView)findViewById(R.id.textViewSet2Bp4);
        textViewSet2Bp5 = (TextView)findViewById(R.id.textViewSet2Bp5);
        textViewSet2Bp6 = (TextView)findViewById(R.id.textViewSet2Bp6);
        textViewSet2Ascore = (TextView)findViewById(R.id.textViewSet2Ascore);
        textViewSet2Bscore = (TextView)findViewById(R.id.textViewSet2Bscore);

        textViewSet2RemplacementAp1 = (TextView)findViewById(R.id.textViewSet2RemplacementAp1);
        textViewSet2RemplacementAp2 = (TextView)findViewById(R.id.textViewSet2RemplacementAp2);
        textViewSet2RemplacementAp3 = (TextView)findViewById(R.id.textViewSet2RemplacementAp3);
        textViewSet2RemplacementAp4 = (TextView)findViewById(R.id.textViewSet2RemplacementAp4);
        textViewSet2RemplacementAp5 = (TextView)findViewById(R.id.textViewSet2RemplacementAp5);
        textViewSet2RemplacementAp6 = (TextView)findViewById(R.id.textViewSet2RemplacementAp6);
        textViewSet2RemplacementBp1 = (TextView)findViewById(R.id.textViewSet2RemplacementBp1);
        textViewSet2RemplacementBp2 = (TextView)findViewById(R.id.textViewSet2RemplacementBp2);
        textViewSet2RemplacementBp3 = (TextView)findViewById(R.id.textViewSet2RemplacementBp3);
        textViewSet2RemplacementBp4 = (TextView)findViewById(R.id.textViewSet2RemplacementBp4);
        textViewSet2RemplacementBp5 = (TextView)findViewById(R.id.textViewSet2RemplacementBp5);
        textViewSet2RemplacementBp6 = (TextView)findViewById(R.id.textViewSet2RemplacementBp6);

        textViewTempsMort1Set2A = (TextView)findViewById(R.id.textViewTempsMort1Set2A);
        textViewTempsMort2Set2A = (TextView)findViewById(R.id.textViewTempsMort2Set2A);
        textViewTempsMort1Set2B = (TextView)findViewById(R.id.textViewTempsMort1Set2B);
        textViewTempsMort2Set2B = (TextView)findViewById(R.id.textViewTempsMort2Set2B);

        final SharedPreferences loadSet2 = getSharedPreferences("set2",0);
        textViewSet2Ap1.setText(loadSet2.getString("set2Ap1", ""));
        textViewSet2Ap2.setText(loadSet2.getString("set2Ap2", ""));
        textViewSet2Ap3.setText(loadSet2.getString("set2Ap3", ""));
        textViewSet2Ap4.setText(loadSet2.getString("set2Ap4", ""));
        textViewSet2Ap5.setText(loadSet2.getString("set2Ap5", ""));
        textViewSet2Ap6.setText(loadSet2.getString("set2Ap6", ""));
        textViewSet2Bp1.setText(loadSet2.getString("set2Bp1", ""));
        textViewSet2Bp2.setText(loadSet2.getString("set2Bp2", ""));
        textViewSet2Bp3.setText(loadSet2.getString("set2Bp3", ""));
        textViewSet2Bp4.setText(loadSet2.getString("set2Bp4", ""));
        textViewSet2Bp5.setText(loadSet2.getString("set2Bp5", ""));
        textViewSet2Bp6.setText(loadSet2.getString("set2Bp6", ""));
        textViewSet2Ascore.setText(loadSet2.getString("set2Ascore", ""));
        textViewSet2Bscore.setText(loadSet2.getString("set2Bscore", ""));

        textViewSet2RemplacementAp1.setText(loadSet2.getString("set2RemplacementAp1", ""));
        textViewSet2RemplacementAp2.setText(loadSet2.getString("set2RemplacementAp2", ""));
        textViewSet2RemplacementAp3.setText(loadSet2.getString("set2RemplacementAp3", ""));
        textViewSet2RemplacementAp4.setText(loadSet2.getString("set2RemplacementAp4", ""));
        textViewSet2RemplacementAp5.setText(loadSet2.getString("set2RemplacementAp5", ""));
        textViewSet2RemplacementAp6.setText(loadSet2.getString("set2RemplacementAp6", ""));
        textViewSet2RemplacementBp1.setText(loadSet2.getString("set2RemplacementBp1", ""));
        textViewSet2RemplacementBp2.setText(loadSet2.getString("set2RemplacementBp2", ""));
        textViewSet2RemplacementBp3.setText(loadSet2.getString("set2RemplacementBp3", ""));
        textViewSet2RemplacementBp4.setText(loadSet2.getString("set2RemplacementBp4", ""));
        textViewSet2RemplacementBp5.setText(loadSet2.getString("set2RemplacementBp5", ""));
        textViewSet2RemplacementBp6.setText(loadSet2.getString("set2RemplacementBp6", ""));

        textViewTempsMort1Set2A.setText(loadSet2.getString("set2ChronoDebutA", ""));
        textViewTempsMort2Set2A.setText(loadSet2.getString("set2ChronoFinA", ""));
        textViewTempsMort1Set2B.setText(loadSet2.getString("set2ChronoDebutB", ""));
        textViewTempsMort2Set2B.setText(loadSet2.getString("set2ChronoFinB", ""));

        //set3
        textViewSet3Ap1 = (TextView)findViewById(R.id.textViewSet3Ap1);
        textViewSet3Ap2 = (TextView)findViewById(R.id.textViewSet3Ap2);
        textViewSet3Ap3 = (TextView)findViewById(R.id.textViewSet3Ap3);
        textViewSet3Ap4 = (TextView)findViewById(R.id.textViewSet3Ap4);
        textViewSet3Ap5 = (TextView)findViewById(R.id.textViewSet3Ap5);
        textViewSet3Ap6 = (TextView)findViewById(R.id.textViewSet3Ap6);
        textViewSet3Bp1 = (TextView)findViewById(R.id.textViewSet3Bp1);
        textViewSet3Bp2 = (TextView)findViewById(R.id.textViewSet3Bp2);
        textViewSet3Bp3 = (TextView)findViewById(R.id.textViewSet3Bp3);
        textViewSet3Bp4 = (TextView)findViewById(R.id.textViewSet3Bp4);
        textViewSet3Bp5 = (TextView)findViewById(R.id.textViewSet3Bp5);
        textViewSet3Bp6 = (TextView)findViewById(R.id.textViewSet3Bp6);
        textViewSet3Ascore = (TextView)findViewById(R.id.textViewSet3Ascore);
        textViewSet3Bscore = (TextView)findViewById(R.id.textViewSet3Bscore);

        textViewSet3RemplacementAp1 = (TextView)findViewById(R.id.textViewSet3RemplacementAp1);
        textViewSet3RemplacementAp2 = (TextView)findViewById(R.id.textViewSet3RemplacementAp2);
        textViewSet3RemplacementAp3 = (TextView)findViewById(R.id.textViewSet3RemplacementAp3);
        textViewSet3RemplacementAp4 = (TextView)findViewById(R.id.textViewSet3RemplacementAp4);
        textViewSet3RemplacementAp5 = (TextView)findViewById(R.id.textViewSet3RemplacementAp5);
        textViewSet3RemplacementAp6 = (TextView)findViewById(R.id.textViewSet3RemplacementAp6);
        textViewSet3RemplacementBp1 = (TextView)findViewById(R.id.textViewSet3RemplacementBp1);
        textViewSet3RemplacementBp2 = (TextView)findViewById(R.id.textViewSet3RemplacementBp2);
        textViewSet3RemplacementBp3 = (TextView)findViewById(R.id.textViewSet3RemplacementBp3);
        textViewSet3RemplacementBp4 = (TextView)findViewById(R.id.textViewSet3RemplacementBp4);
        textViewSet3RemplacementBp5 = (TextView)findViewById(R.id.textViewSet3RemplacementBp5);
        textViewSet3RemplacementBp6 = (TextView)findViewById(R.id.textViewSet3RemplacementBp6);

        textViewTempsMort1Set3A = (TextView)findViewById(R.id.textViewTempsMort1Set3A);
        textViewTempsMort2Set3A = (TextView)findViewById(R.id.textViewTempsMort2Set3A);
        textViewTempsMort1Set3B = (TextView)findViewById(R.id.textViewTempsMort1Set3B);
        textViewTempsMort2Set3B = (TextView)findViewById(R.id.textViewTempsMort2Set3B);

        final SharedPreferences loadSet3 = getSharedPreferences("set3",0);
        textViewSet3Ap1.setText(loadSet3.getString("set3Ap1", ""));
        textViewSet3Ap2.setText(loadSet3.getString("set3Ap2", ""));
        textViewSet3Ap3.setText(loadSet3.getString("set3Ap3", ""));
        textViewSet3Ap4.setText(loadSet3.getString("set3Ap4", ""));
        textViewSet3Ap5.setText(loadSet3.getString("set3Ap5", ""));
        textViewSet3Ap6.setText(loadSet3.getString("set3Ap6", ""));
        textViewSet3Bp1.setText(loadSet3.getString("set3Bp1", ""));
        textViewSet3Bp2.setText(loadSet3.getString("set3Bp2", ""));
        textViewSet3Bp3.setText(loadSet3.getString("set3Bp3", ""));
        textViewSet3Bp4.setText(loadSet3.getString("set3Bp4", ""));
        textViewSet3Bp5.setText(loadSet3.getString("set3Bp5", ""));
        textViewSet3Bp6.setText(loadSet3.getString("set3Bp6", ""));
        textViewSet3Ascore.setText(loadSet3.getString("set3Ascore", ""));
        textViewSet3Bscore.setText(loadSet3.getString("set3Bscore", ""));

        textViewSet3RemplacementAp1.setText(loadSet3.getString("set3RemplacementAp1", ""));
        textViewSet3RemplacementAp2.setText(loadSet3.getString("set3RemplacementAp2", ""));
        textViewSet3RemplacementAp3.setText(loadSet3.getString("set3RemplacementAp3", ""));
        textViewSet3RemplacementAp4.setText(loadSet3.getString("set3RemplacementAp4", ""));
        textViewSet3RemplacementAp5.setText(loadSet3.getString("set3RemplacementAp5", ""));
        textViewSet3RemplacementAp6.setText(loadSet3.getString("set3RemplacementAp6", ""));
        textViewSet3RemplacementBp1.setText(loadSet3.getString("set3RemplacementBp1", ""));
        textViewSet3RemplacementBp2.setText(loadSet3.getString("set3RemplacementBp2", ""));
        textViewSet3RemplacementBp3.setText(loadSet3.getString("set3RemplacementBp3", ""));
        textViewSet3RemplacementBp4.setText(loadSet3.getString("set3RemplacementBp4", ""));
        textViewSet3RemplacementBp5.setText(loadSet3.getString("set3RemplacementBp5", ""));
        textViewSet3RemplacementBp6.setText(loadSet3.getString("set3RemplacementBp6", ""));

        textViewTempsMort1Set3A.setText(loadSet3.getString("set3ChronoDebutA", ""));
        textViewTempsMort2Set3A.setText(loadSet3.getString("set3ChronoFinA", ""));
        textViewTempsMort1Set3B.setText(loadSet3.getString("set3ChronoDebutB", ""));
        textViewTempsMort2Set3B.setText(loadSet3.getString("set3ChronoFinB", ""));


        //set4
        textViewSet4Ap1 = (TextView)findViewById(R.id.textViewSet4Ap1);
        textViewSet4Ap2 = (TextView)findViewById(R.id.textViewSet4Ap2);
        textViewSet4Ap3 = (TextView)findViewById(R.id.textViewSet4Ap3);
        textViewSet4Ap4 = (TextView)findViewById(R.id.textViewSet4Ap4);
        textViewSet4Ap5 = (TextView)findViewById(R.id.textViewSet4Ap5);
        textViewSet4Ap6 = (TextView)findViewById(R.id.textViewSet4Ap6);
        textViewSet4Bp1 = (TextView)findViewById(R.id.textViewSet4Bp1);
        textViewSet4Bp2 = (TextView)findViewById(R.id.textViewSet4Bp2);
        textViewSet4Bp3 = (TextView)findViewById(R.id.textViewSet4Bp3);
        textViewSet4Bp4 = (TextView)findViewById(R.id.textViewSet4Bp4);
        textViewSet4Bp5 = (TextView)findViewById(R.id.textViewSet4Bp5);
        textViewSet4Bp6 = (TextView)findViewById(R.id.textViewSet4Bp6);
        textViewSet4Ascore = (TextView)findViewById(R.id.textViewSet4Ascore);
        textViewSet4Bscore = (TextView)findViewById(R.id.textViewSet4Bscore);

        textViewSet4RemplacementAp1 = (TextView)findViewById(R.id.textViewSet4RemplacementAp1);
        textViewSet4RemplacementAp2 = (TextView)findViewById(R.id.textViewSet4RemplacementAp2);
        textViewSet4RemplacementAp3 = (TextView)findViewById(R.id.textViewSet4RemplacementAp3);
        textViewSet4RemplacementAp4 = (TextView)findViewById(R.id.textViewSet4RemplacementAp4);
        textViewSet4RemplacementAp5 = (TextView)findViewById(R.id.textViewSet4RemplacementAp5);
        textViewSet4RemplacementAp6 = (TextView)findViewById(R.id.textViewSet4RemplacementAp6);
        textViewSet4RemplacementBp1 = (TextView)findViewById(R.id.textViewSet4RemplacementBp1);
        textViewSet4RemplacementBp2 = (TextView)findViewById(R.id.textViewSet4RemplacementBp2);
        textViewSet4RemplacementBp3 = (TextView)findViewById(R.id.textViewSet4RemplacementBp3);
        textViewSet4RemplacementBp4 = (TextView)findViewById(R.id.textViewSet4RemplacementBp4);
        textViewSet4RemplacementBp5 = (TextView)findViewById(R.id.textViewSet4RemplacementBp5);
        textViewSet4RemplacementBp6 = (TextView)findViewById(R.id.textViewSet4RemplacementBp6);

        textViewTempsMort1Set4A = (TextView)findViewById(R.id.textViewTempsMort1Set4A);
        textViewTempsMort2Set4A = (TextView)findViewById(R.id.textViewTempsMort2Set4A);
        textViewTempsMort1Set4B = (TextView)findViewById(R.id.textViewTempsMort1Set4B);
        textViewTempsMort2Set4B = (TextView)findViewById(R.id.textViewTempsMort2Set4B);

        final SharedPreferences loadSet4 = getSharedPreferences("set4",0);
        textViewSet4Ap1.setText(loadSet4.getString("set4Ap1", ""));
        textViewSet4Ap2.setText(loadSet4.getString("set4Ap2", ""));
        textViewSet4Ap3.setText(loadSet4.getString("set4Ap3", ""));
        textViewSet4Ap4.setText(loadSet4.getString("set4Ap4", ""));
        textViewSet4Ap5.setText(loadSet4.getString("set4Ap5", ""));
        textViewSet4Ap6.setText(loadSet4.getString("set4Ap6", ""));
        textViewSet4Bp1.setText(loadSet4.getString("set4Bp1", ""));
        textViewSet4Bp2.setText(loadSet4.getString("set4Bp2", ""));
        textViewSet4Bp3.setText(loadSet4.getString("set4Bp3", ""));
        textViewSet4Bp4.setText(loadSet4.getString("set4Bp4", ""));
        textViewSet4Bp5.setText(loadSet4.getString("set4Bp5", ""));
        textViewSet4Bp6.setText(loadSet4.getString("set4Bp6", ""));
        textViewSet4Ascore.setText(loadSet4.getString("set4Ascore", ""));
        textViewSet4Bscore.setText(loadSet4.getString("set4Bscore", ""));

        textViewSet4RemplacementAp1.setText(loadSet4.getString("set4RemplacementAp1", ""));
        textViewSet4RemplacementAp2.setText(loadSet4.getString("set4RemplacementAp2", ""));
        textViewSet4RemplacementAp3.setText(loadSet4.getString("set4RemplacementAp3", ""));
        textViewSet4RemplacementAp4.setText(loadSet4.getString("set4RemplacementAp4", ""));
        textViewSet4RemplacementAp5.setText(loadSet4.getString("set4RemplacementAp5", ""));
        textViewSet4RemplacementAp6.setText(loadSet4.getString("set4RemplacementAp6", ""));
        textViewSet4RemplacementBp1.setText(loadSet4.getString("set4RemplacementBp1", ""));
        textViewSet4RemplacementBp2.setText(loadSet4.getString("set4RemplacementBp2", ""));
        textViewSet4RemplacementBp3.setText(loadSet4.getString("set4RemplacementBp3", ""));
        textViewSet4RemplacementBp4.setText(loadSet4.getString("set4RemplacementBp4", ""));
        textViewSet4RemplacementBp5.setText(loadSet4.getString("set4RemplacementBp5", ""));
        textViewSet4RemplacementBp6.setText(loadSet4.getString("set4RemplacementBp6", ""));

        textViewTempsMort1Set4A.setText(loadSet4.getString("set4ChronoDebutA", ""));
        textViewTempsMort2Set4A.setText(loadSet4.getString("set4ChronoFinA", ""));
        textViewTempsMort1Set4B.setText(loadSet4.getString("set4ChronoDebutB", ""));
        textViewTempsMort2Set4B.setText(loadSet4.getString("set4ChronoFinB", ""));


        //set5
        textViewSet5Ap1 = (TextView)findViewById(R.id.textViewSet5Ap1);
        textViewSet5Ap2 = (TextView)findViewById(R.id.textViewSet5Ap2);
        textViewSet5Ap3 = (TextView)findViewById(R.id.textViewSet5Ap3);
        textViewSet5Ap4 = (TextView)findViewById(R.id.textViewSet5Ap4);
        textViewSet5Ap5 = (TextView)findViewById(R.id.textViewSet5Ap5);
        textViewSet5Ap6 = (TextView)findViewById(R.id.textViewSet5Ap6);
        textViewSet5Bp1 = (TextView)findViewById(R.id.textViewSet5Bp1);
        textViewSet5Bp2 = (TextView)findViewById(R.id.textViewSet5Bp2);
        textViewSet5Bp3 = (TextView)findViewById(R.id.textViewSet5Bp3);
        textViewSet5Bp4 = (TextView)findViewById(R.id.textViewSet5Bp4);
        textViewSet5Bp5 = (TextView)findViewById(R.id.textViewSet5Bp5);
        textViewSet5Bp6 = (TextView)findViewById(R.id.textViewSet5Bp6);
        textViewSet5Ascore = (TextView)findViewById(R.id.textViewSet5Ascore);
        textViewSet5Bscore = (TextView)findViewById(R.id.textViewSet5Bscore);

        textViewSet5RemplacementAp1 = (TextView)findViewById(R.id.textViewSet5RemplacementAp1);
        textViewSet5RemplacementAp2 = (TextView)findViewById(R.id.textViewSet5RemplacementAp2);
        textViewSet5RemplacementAp3 = (TextView)findViewById(R.id.textViewSet5RemplacementAp3);
        textViewSet5RemplacementAp4 = (TextView)findViewById(R.id.textViewSet5RemplacementAp4);
        textViewSet5RemplacementAp5 = (TextView)findViewById(R.id.textViewSet5RemplacementAp5);
        textViewSet5RemplacementAp6 = (TextView)findViewById(R.id.textViewSet5RemplacementAp6);
        textViewSet5RemplacementBp1 = (TextView)findViewById(R.id.textViewSet5RemplacementBp1);
        textViewSet5RemplacementBp2 = (TextView)findViewById(R.id.textViewSet5RemplacementBp2);
        textViewSet5RemplacementBp3 = (TextView)findViewById(R.id.textViewSet5RemplacementBp3);
        textViewSet5RemplacementBp4 = (TextView)findViewById(R.id.textViewSet5RemplacementBp4);
        textViewSet5RemplacementBp5 = (TextView)findViewById(R.id.textViewSet5RemplacementBp5);
        textViewSet5RemplacementBp6 = (TextView)findViewById(R.id.textViewSet5RemplacementBp6);

        textViewTempsMort1Set5A = (TextView)findViewById(R.id.textViewTempsMort1Set5A);
        textViewTempsMort2Set5A = (TextView)findViewById(R.id.textViewTempsMort2Set5A);
        textViewTempsMort1Set5B = (TextView)findViewById(R.id.textViewTempsMort1Set5B);
        textViewTempsMort2Set5B = (TextView)findViewById(R.id.textViewTempsMort2Set5B);

        final SharedPreferences loadSet5 = getSharedPreferences("set5",0);
        textViewSet5Ap1.setText(loadSet5.getString("set5Ap1", ""));
        textViewSet5Ap2.setText(loadSet5.getString("set5Ap2", ""));
        textViewSet5Ap3.setText(loadSet5.getString("set5Ap3", ""));
        textViewSet5Ap4.setText(loadSet5.getString("set5Ap4", ""));
        textViewSet5Ap5.setText(loadSet5.getString("set5Ap5", ""));
        textViewSet5Ap6.setText(loadSet5.getString("set5Ap6", ""));
        textViewSet5Bp1.setText(loadSet5.getString("set5Bp1", ""));
        textViewSet5Bp2.setText(loadSet5.getString("set5Bp2", ""));
        textViewSet5Bp3.setText(loadSet5.getString("set5Bp3", ""));
        textViewSet5Bp4.setText(loadSet5.getString("set5Bp4", ""));
        textViewSet5Bp5.setText(loadSet5.getString("set5Bp5", ""));
        textViewSet5Bp6.setText(loadSet5.getString("set5Bp6", ""));
        textViewSet5Ascore.setText(loadSet5.getString("set5Ascore", ""));
        textViewSet5Bscore.setText(loadSet5.getString("set5Bscore", ""));

        textViewSet5RemplacementAp1.setText(loadSet5.getString("set5RemplacementAp1", ""));
        textViewSet5RemplacementAp2.setText(loadSet5.getString("set5RemplacementAp2", ""));
        textViewSet5RemplacementAp3.setText(loadSet5.getString("set5RemplacementAp3", ""));
        textViewSet5RemplacementAp4.setText(loadSet5.getString("set5RemplacementAp4", ""));
        textViewSet5RemplacementAp5.setText(loadSet5.getString("set5RemplacementAp5", ""));
        textViewSet5RemplacementAp6.setText(loadSet5.getString("set5RemplacementAp6", ""));
        textViewSet5RemplacementBp1.setText(loadSet5.getString("set5RemplacementBp1", ""));
        textViewSet5RemplacementBp2.setText(loadSet5.getString("set5RemplacementBp2", ""));
        textViewSet5RemplacementBp3.setText(loadSet5.getString("set5RemplacementBp3", ""));
        textViewSet5RemplacementBp4.setText(loadSet5.getString("set5RemplacementBp4", ""));
        textViewSet5RemplacementBp5.setText(loadSet5.getString("set5RemplacementBp5", ""));
        textViewSet5RemplacementBp6.setText(loadSet5.getString("set5RemplacementBp6", ""));

        textViewTempsMort1Set5A.setText(loadSet5.getString("set5ChronoDebutA", ""));
        textViewTempsMort2Set5A.setText(loadSet5.getString("set5ChronoFinA", ""));
        textViewTempsMort1Set5B.setText(loadSet5.getString("set5ChronoDebutB", ""));
        textViewTempsMort2Set5B.setText(loadSet5.getString("set5ChronoFinB", ""));

        //Résultat
        textViewResultat = (TextView)findViewById(R.id.textViewResultat);
        final SharedPreferences loadResultat = getSharedPreferences("resultat",0);
        textViewResultat.setText("RÉSULTAT : " + loadResultat.getString("vainqueur", "....") + " bat " + loadResultat.getString("vaincu", "....") + " par " + loadResultat.getString("nbSetVainqueur", "....") + " sets à " + loadResultat.getString("nbSetVaincu", "...."));

        textViewHeureFin.setText("Heure fin : " + loadResultat.getString("heureFin", ""));

        //Remarques
        textViewRemarque = (TextView)findViewById(R.id.textViewRemarque);
        final SharedPreferences loadApprobation = getSharedPreferences("approbation",0);
        textViewRemarque.setText("Remarques et sanctions : "+loadApprobation.getString("remarque", ""));


        //Approbation
        textViewNomArbitre1 = (TextView)findViewById(R.id.textViewNomArbitre1);
        textViewNumLicenceArbitre1 = (TextView) findViewById(R.id.textViewNumLicenceArbitre1);
        textViewClubDesigneArbitre1  = (TextView) findViewById(R.id.textViewClubDesigneArbitre1);
        textViewIndemniteArbitre1  = (TextView) findViewById(R.id.textViewIndemniteArbitre1);
        textViewNomArbitre2  = (TextView) findViewById(R.id.textViewNomArbitre2);
        textViewNumLicenceArbitre2  = (TextView) findViewById(R.id.textViewNumLicenceArbitre2);
        textViewNomCapitaineA  = (TextView) findViewById(R.id.textViewNomCapitaineA);
        textViewNumLicenceCapitaineA  = (TextView) findViewById(R.id.textViewNumLicenceCapitaineA);
        textViewNomCapitaineB = (TextView) findViewById(R.id.textViewNomCapitaineB);
        textViewNumLicenceCapitaineB = (TextView) findViewById(R.id.textViewNumLicenceCapitaineB);
        //final SharedPreferences loadApprobation = getSharedPreferences("approbation",0);
        textViewNomArbitre1.setText(loadApprobation.getString("nomArbitre1", ""));
        textViewNumLicenceArbitre1.setText(loadApprobation.getString("numLicenceArbitre1", ""));
        textViewClubDesigneArbitre1.setText(loadApprobation.getString("clubDesigneArbitre1", ""));
        textViewIndemniteArbitre1.setText(loadApprobation.getString("indemniteArbitre1", "") + " €/équipe");
        textViewNomArbitre2.setText(loadApprobation.getString("nomArbitre2", ""));
        textViewNumLicenceArbitre2.setText(loadApprobation.getString("numLicenceArbitre2", ""));
        textViewNomCapitaineA.setText(loadApprobation.getString("nomCapitaineA", ""));
        textViewNumLicenceCapitaineA.setText(loadApprobation.getString("numLicenceCapitaineA", ""));
        textViewNomCapitaineB.setText(loadApprobation.getString("nomCapitaineB", ""));
        textViewNumLicenceCapitaineB.setText(loadApprobation.getString("numLicenceCapitaineB", ""));


        //les signatures

        File file = new File(DIRECTORY);
        if (!file.exists()) {
            file.mkdir();
        }

        recapitulatifSignatureA = (ImageView)findViewById(R.id.recapitulatifSignatureA);
        File imgFileSignatureA = new File(DIRECTORY + "signatureValidationParEquipeB" + ".png");
        if(imgFileSignatureA.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileSignatureA.getAbsolutePath());
            recapitulatifSignatureA.setImageBitmap(myBitmap);
        }
        recapitulatifSignatureB = (ImageView)findViewById(R.id.recapitulatifSignatureB);
        File imgFileSignatureB = new File(DIRECTORY + "signatureValidationParEquipeA" + ".png");
        if(imgFileSignatureB.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileSignatureB.getAbsolutePath());
            recapitulatifSignatureB.setImageBitmap(myBitmap);
        }

        recapitulatifSignatureArbitre1 = (ImageView)findViewById(R.id.recapitulatifSignatureArbitre1);
        File imgFileSignatureArbitre1 = new File(DIRECTORY + "signatureArbitre1" + ".png");
        if(imgFileSignatureArbitre1.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileSignatureArbitre1.getAbsolutePath());
            recapitulatifSignatureArbitre1.setImageBitmap(myBitmap);
        }
        recapitulatifSignatureArbitre2 = (ImageView)findViewById(R.id.recapitulatifSignatureArbitre2);
        File imgFileSignatureArbitre2 = new File(DIRECTORY + "signatureArbitre2" + ".png");
        if(imgFileSignatureArbitre2.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileSignatureArbitre2.getAbsolutePath());
            recapitulatifSignatureArbitre2.setImageBitmap(myBitmap);
        }

        recapitulatifSignatureCapitaineA = (ImageView)findViewById(R.id.recapitulatifSignatureCapitaineA);
        File imgFileSignatureCapitaineA = new File(DIRECTORY + "signatureCapitaineA" + ".png");
        if(imgFileSignatureCapitaineA.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileSignatureCapitaineA.getAbsolutePath());
            recapitulatifSignatureCapitaineA.setImageBitmap(myBitmap);
        }
        recapitulatifSignatureCapitaineB = (ImageView)findViewById(R.id.recapitulatifSignatureCapitaineB);
        File imgFileSignatureCapitaineB = new File(DIRECTORY + "signatureCapitaineB" + ".png");
        if(imgFileSignatureCapitaineB.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileSignatureCapitaineB.getAbsolutePath());
            recapitulatifSignatureCapitaineB.setImageBitmap(myBitmap);
        }

        //génération du pdf
        buttonRecapitulatifCreerPdf = (Button)findViewById(R.id.buttonRecapitulatifCreerPdf);
        buttonRecapitulatifCreerPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomEA = loadPreparatif.getString("nomEquipeA", "equipeA");
                nomEA = nomEA.replace(" ", "");
                nomEA = nomEA.replace("/", "");
                String nomEB = loadPreparatif.getString("nomEquipeB", "equipeB");
                nomEB = nomEB.replace(" ", "");
                nomEB = nomEB.replace("/", "");
                String pdfName = nomEA + "-" + nomEB;
                CreatePDF.createPdf(pdfName, loadPreparatif, loadEquipeA, loadEquipeB, loadSet1, loadSet2, loadSet3, loadSet4, loadSet5, loadResultat, loadApprobation, Recapitulatif.this);
                Toast.makeText(Recapitulatif.this, "Le PDF à bien été crée", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRecapitulatifEmailPdf = (Button)findViewById(R.id.buttonRecapitulatifEmailPdf);
        buttonRecapitulatifEmailPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on creer le PDF avant de l'envoyer
                CreatePDF.createPdf("monPDF", loadPreparatif, loadEquipeA, loadEquipeB, loadSet1, loadSet2, loadSet3, loadSet4, loadSet5, loadResultat, loadApprobation, Recapitulatif.this);

                String filename="monPDF.pdf";
                File filelocation = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename);
                Uri path = Uri.fromFile(filelocation);
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                // set the type to 'email'
                emailIntent .setType("vnd.android.cursor.dir/email");
                //String to[] = {"asd@gmail.com"};
                //emailIntent .putExtra(Intent.EXTRA_EMAIL, to);
                // the attachment
                emailIntent .putExtra(Intent.EXTRA_STREAM, path);
                // the mail subject
                emailIntent .putExtra(Intent.EXTRA_SUBJECT, "Feuille de match : " + loadPreparatif.getString("nomEquipeA", "") + " - " + loadPreparatif.getString("nomEquipeB", "") + " " + loadPreparatif.getString("date", ""));
                startActivity(Intent.createChooser(emailIntent , "Envoyer pas email"));
            }
        });
    }
}
