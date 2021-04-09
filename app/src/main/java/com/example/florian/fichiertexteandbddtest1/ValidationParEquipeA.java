package com.example.florian.fichiertexteandbddtest1;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;

public class ValidationParEquipeA extends AppCompatActivity {

    String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";

    //equipe A
    TextView textViewValidationNumB1;
    TextView textViewValidationNumB2;
    TextView textViewValidationNumB3;
    TextView textViewValidationNumB4;
    TextView textViewValidationNumB5;
    TextView textViewValidationNumB6;
    TextView textViewValidationNumB7;
    TextView textViewValidationNumB8;
    TextView textViewValidationNumB9;
    TextView textViewValidationNumB10;
    TextView textViewValidationNumB11;
    TextView textViewValidationNumB12;
    TextView textViewValidationNumB13;
    TextView textViewValidationNumB14;
    TextView textViewValidationNumB15;
    TextView textViewValidationNomB1;
    TextView textViewValidationNomB2;
    TextView textViewValidationNomB3;
    TextView textViewValidationNomB4;
    TextView textViewValidationNomB5;
    TextView textViewValidationNomB6;
    TextView textViewValidationNomB7;
    TextView textViewValidationNomB8;
    TextView textViewValidationNomB9;
    TextView textViewValidationNomB10;
    TextView textViewValidationNomB11;
    TextView textViewValidationNomB12;
    TextView textViewValidationNomB13;
    TextView textViewValidationNomB14;
    TextView textViewValidationNomB15;
    TextView textViewValidationNumLicenceB1;
    TextView textViewValidationNumLicenceB2;
    TextView textViewValidationNumLicenceB3;
    TextView textViewValidationNumLicenceB4;
    TextView textViewValidationNumLicenceB5;
    TextView textViewValidationNumLicenceB6;
    TextView textViewValidationNumLicenceB7;
    TextView textViewValidationNumLicenceB8;
    TextView textViewValidationNumLicenceB9;
    TextView textViewValidationNumLicenceB10;
    TextView textViewValidationNumLicenceB11;
    TextView textViewValidationNumLicenceB12;
    TextView textViewValidationNumLicenceB13;
    TextView textViewValidationNumLicenceB14;
    TextView textViewValidationNumLicenceB15;

    Button buttonSignatureValidationParA;
    Button buttonRetour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_par_equipe_a);
        buttonRetour=(Button)findViewById(R.id.buttonRetourFeuilledeMatch);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ValidationParEquipeA.this, MatchActivity.class);
                startActivity(intent);
            }
        });
        //Equipe A
        textViewValidationNumB1 = (TextView)findViewById(R.id.textViewValidationNumB1);
        textViewValidationNumB2 = (TextView)findViewById(R.id.textViewValidationNumB2);
        textViewValidationNumB3 = (TextView)findViewById(R.id.textViewValidationNumB3);
        textViewValidationNumB4 = (TextView)findViewById(R.id.textViewValidationNumB4);
        textViewValidationNumB5 = (TextView)findViewById(R.id.textViewValidationNumB5);
        textViewValidationNumB6 = (TextView)findViewById(R.id.textViewValidationNumB6);
        textViewValidationNumB7 = (TextView)findViewById(R.id.textViewValidationNumB7);
        textViewValidationNumB8 = (TextView)findViewById(R.id.textViewValidationNumB8);
        textViewValidationNumB9 = (TextView)findViewById(R.id.textViewValidationNumB9);
        textViewValidationNumB10 = (TextView)findViewById(R.id.textViewValidationNumB10);
        textViewValidationNumB11 = (TextView)findViewById(R.id.textViewValidationNumB11);
        textViewValidationNumB12 = (TextView)findViewById(R.id.textViewValidationNumB12);
        textViewValidationNumB13 = (TextView)findViewById(R.id.textViewValidationNumB13);
        textViewValidationNumB14 = (TextView)findViewById(R.id.textViewValidationNumB14);
        textViewValidationNumB15 = (TextView)findViewById(R.id.textViewValidationNumB15);
        textViewValidationNomB1 = (TextView)findViewById(R.id.textViewValidationNomB1);
        textViewValidationNomB2 = (TextView)findViewById(R.id.textViewValidationNomB2);
        textViewValidationNomB3 = (TextView)findViewById(R.id.textViewValidationNomB3);
        textViewValidationNomB4 = (TextView)findViewById(R.id.textViewValidationNomB4);
        textViewValidationNomB5 = (TextView)findViewById(R.id.textViewValidationNomB5);
        textViewValidationNomB6 = (TextView)findViewById(R.id.textViewValidationNomB6);
        textViewValidationNomB7 = (TextView)findViewById(R.id.textViewValidationNomB7);
        textViewValidationNomB8 = (TextView)findViewById(R.id.textViewValidationNomB8);
        textViewValidationNomB9 = (TextView)findViewById(R.id.textViewValidationNomB9);
        textViewValidationNomB10 = (TextView)findViewById(R.id.textViewValidationNomB10);
        textViewValidationNomB11 = (TextView)findViewById(R.id.textViewValidationNomB11);
        textViewValidationNomB12 = (TextView)findViewById(R.id.textViewValidationNomB12);
        textViewValidationNomB13 = (TextView)findViewById(R.id.textViewValidationNomB13);
        textViewValidationNomB14 = (TextView)findViewById(R.id.textViewValidationNomB14);
        textViewValidationNomB15 = (TextView)findViewById(R.id.textViewValidationNomB15);
        textViewValidationNumLicenceB1 = (TextView)findViewById(R.id.textViewValidationNumLicenceB1);
        textViewValidationNumLicenceB2 = (TextView)findViewById(R.id.textViewValidationNumLicenceB2);
        textViewValidationNumLicenceB3 = (TextView)findViewById(R.id.textViewValidationNumLicenceB3);
        textViewValidationNumLicenceB4 = (TextView)findViewById(R.id.textViewValidationNumLicenceB4);
        textViewValidationNumLicenceB5 = (TextView)findViewById(R.id.textViewValidationNumLicenceB5);
        textViewValidationNumLicenceB6 = (TextView)findViewById(R.id.textViewValidationNumLicenceB6);
        textViewValidationNumLicenceB7 = (TextView)findViewById(R.id.textViewValidationNumLicenceB7);
        textViewValidationNumLicenceB8 = (TextView)findViewById(R.id.textViewValidationNumLicenceB8);
        textViewValidationNumLicenceB9 = (TextView)findViewById(R.id.textViewValidationNumLicenceB9);
        textViewValidationNumLicenceB10 = (TextView)findViewById(R.id.textViewValidationNumLicenceB10);
        textViewValidationNumLicenceB11 = (TextView)findViewById(R.id.textViewValidationNumLicenceB11);
        textViewValidationNumLicenceB12 = (TextView)findViewById(R.id.textViewValidationNumLicenceB12);
        textViewValidationNumLicenceB13 = (TextView)findViewById(R.id.textViewValidationNumLicenceB13);
        textViewValidationNumLicenceB14 = (TextView)findViewById(R.id.textViewValidationNumLicenceB14);
        textViewValidationNumLicenceB15 = (TextView)findViewById(R.id.textViewValidationNumLicenceB15);
        final SharedPreferences loadEquipeB = getSharedPreferences("equipeB",0);
        textViewValidationNumB1.setText(loadEquipeB.getString("numB1", ""));
        textViewValidationNumB2.setText(loadEquipeB.getString("numB2", ""));
        textViewValidationNumB3.setText(loadEquipeB.getString("numB3", ""));
        textViewValidationNumB4.setText(loadEquipeB.getString("numB4", ""));
        textViewValidationNumB5.setText(loadEquipeB.getString("numB5", ""));
        textViewValidationNumB6.setText(loadEquipeB.getString("numB6", ""));
        textViewValidationNumB7.setText(loadEquipeB.getString("numB7", ""));
        textViewValidationNumB8.setText(loadEquipeB.getString("numB8", ""));
        textViewValidationNumB9.setText(loadEquipeB.getString("numB9", ""));
        textViewValidationNumB10.setText(loadEquipeB.getString("numB10", ""));
        textViewValidationNumB11.setText(loadEquipeB.getString("numB11", ""));
        textViewValidationNumB12.setText(loadEquipeB.getString("numB12", ""));
        textViewValidationNumB13.setText(loadEquipeB.getString("numB13", ""));
        textViewValidationNumB14.setText(loadEquipeB.getString("numB14", ""));
        textViewValidationNumB15.setText(loadEquipeB.getString("numB15", ""));
        textViewValidationNomB1.setText(loadEquipeB.getString("nomB1", ""));
        textViewValidationNomB2.setText(loadEquipeB.getString("nomB2", ""));
        textViewValidationNomB3.setText(loadEquipeB.getString("nomB3", ""));
        textViewValidationNomB4.setText(loadEquipeB.getString("nomB4", ""));
        textViewValidationNomB5.setText(loadEquipeB.getString("nomB5", ""));
        textViewValidationNomB6.setText(loadEquipeB.getString("nomB6", ""));
        textViewValidationNomB7.setText(loadEquipeB.getString("nomB7", ""));
        textViewValidationNomB8.setText(loadEquipeB.getString("nomB8", ""));
        textViewValidationNomB9.setText(loadEquipeB.getString("nomB9", ""));
        textViewValidationNomB10.setText(loadEquipeB.getString("nomB10", ""));
        textViewValidationNomB11.setText(loadEquipeB.getString("nomB11", ""));
        textViewValidationNomB12.setText(loadEquipeB.getString("nomB12", ""));
        textViewValidationNomB13.setText(loadEquipeB.getString("nomB13", ""));
        textViewValidationNomB14.setText(loadEquipeB.getString("nomB14", ""));
        textViewValidationNomB15.setText(loadEquipeB.getString("nomB15", ""));
        textViewValidationNumLicenceB1.setText(loadEquipeB.getString("numLicenceB1", ""));
        textViewValidationNumLicenceB2.setText(loadEquipeB.getString("numLicenceB2", ""));
        textViewValidationNumLicenceB3.setText(loadEquipeB.getString("numLicenceB3", ""));
        textViewValidationNumLicenceB4.setText(loadEquipeB.getString("numLicenceB4", ""));
        textViewValidationNumLicenceB5.setText(loadEquipeB.getString("numLicenceB5", ""));
        textViewValidationNumLicenceB6.setText(loadEquipeB.getString("numLicenceB6", ""));
        textViewValidationNumLicenceB7.setText(loadEquipeB.getString("numLicenceB7", ""));
        textViewValidationNumLicenceB8.setText(loadEquipeB.getString("numLicenceB8", ""));
        textViewValidationNumLicenceB9.setText(loadEquipeB.getString("numLicenceB9", ""));
        textViewValidationNumLicenceB10.setText(loadEquipeB.getString("numLicenceB10", ""));
        textViewValidationNumLicenceB11.setText(loadEquipeB.getString("numLicenceB11", ""));
        textViewValidationNumLicenceB12.setText(loadEquipeB.getString("numLicenceB12", ""));
        textViewValidationNumLicenceB13.setText(loadEquipeB.getString("numLicenceB13", ""));
        textViewValidationNumLicenceB14.setText(loadEquipeB.getString("numLicenceB14", ""));
        textViewValidationNumLicenceB15.setText(loadEquipeB.getString("numLicenceB15", ""));

        //concerne la signature

        buttonSignatureValidationParA = (Button)findViewById(R.id.buttonSignatureValidationParA);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        File file = new File(DIRECTORY);
        if (!file.exists()) {
            file.mkdir();
        }

        // Dialog Function
        dialog = new Dialog(ValidationParEquipeA.this);
        // Removing the features of Normal Dialogs
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_signature);
        dialog.setCancelable(true);

        buttonSignatureValidationParA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_action();
            }
        });

        //imageView
        ImageView imageViewValidationSignatureEquipeA = (ImageView)findViewById(R.id.imageViewValidationSignatureEquipeA);
        File imgFile = new  File(DIRECTORY + "signatureValidationParEquipeA.png");
        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageViewValidationSignatureEquipeA.setImageBitmap(myBitmap);
        }

    }




    Button btn_get_sign, mClear, mGetSign, mCancel;
    LinearLayout mContent;
    Signature mSignature;
    Dialog dialog;
    Bitmap bitmap;
    View view;

    // Creating Separate Directory for saving Generated Images

    //String pic_name = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    String pic_name = "signatureValidationParEquipeA";
    //String StoredPath = DIRECTORY + pic_name + ".png";  //==> a changer suivant qui signe ?
    //String StoredPath = "/storage/emulated/0/Download/" + pic_name;
    String StoredPath = Environment.getExternalStorageDirectory().toString() + "/" + pic_name + ".png";
    // Function for Digital Signature

    public void dialog_action() {

        mContent = (LinearLayout) dialog.findViewById(R.id.linearLayout);
        mSignature = new Signature(getApplicationContext(), null, bitmap, mContent, mGetSign );
        mSignature.setBackgroundColor(Color.WHITE);
        // Dynamically generating Layout through java code
        mContent.addView(mSignature, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mClear = (Button) dialog.findViewById(R.id.clear);
        mGetSign = (Button) dialog.findViewById(R.id.getsign);
        //mGetSign.setEnabled(true);
        mCancel = (Button) dialog.findViewById(R.id.cancel);
        view = mContent;

        mClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("log_tag", "Panel Cleared");
                mSignature.clear();
                //mGetSign.setEnabled(true);
            }
        });

        mGetSign.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Log.v("log_tag", "Panel Saved");
                view.setDrawingCacheEnabled(true);
                mSignature.save(view, DIRECTORY + "signatureValidationParEquipeA.png");
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Successfully Saved", Toast.LENGTH_SHORT).show();
                // Calling the same class
                recreate();

            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("log_tag", "Panel Canceled");
                dialog.dismiss();
                // Calling the same class
                recreate();
            }
        });
        dialog.show();
    }
}
