package com.example.florian.fichiertexteandbddtest1;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
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

public class ValidationParEquipeB extends AppCompatActivity {

    String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";

    //equipe A
    TextView textViewValidationNumA1;
    TextView textViewValidationNumA2;
    TextView textViewValidationNumA3;
    TextView textViewValidationNumA4;
    TextView textViewValidationNumA5;
    TextView textViewValidationNumA6;
    TextView textViewValidationNumA7;
    TextView textViewValidationNumA8;
    TextView textViewValidationNumA9;
    TextView textViewValidationNumA10;
    TextView textViewValidationNumA11;
    TextView textViewValidationNumA12;
    TextView textViewValidationNumA13;
    TextView textViewValidationNumA14;
    TextView textViewValidationNumA15;
    TextView textViewValidationNomA1;
    TextView textViewValidationNomA2;
    TextView textViewValidationNomA3;
    TextView textViewValidationNomA4;
    TextView textViewValidationNomA5;
    TextView textViewValidationNomA6;
    TextView textViewValidationNomA7;
    TextView textViewValidationNomA8;
    TextView textViewValidationNomA9;
    TextView textViewValidationNomA10;
    TextView textViewValidationNomA11;
    TextView textViewValidationNomA12;
    TextView textViewValidationNomA13;
    TextView textViewValidationNomA14;
    TextView textViewValidationNomA15;
    TextView textViewValidationNumLicenceA1;
    TextView textViewValidationNumLicenceA2;
    TextView textViewValidationNumLicenceA3;
    TextView textViewValidationNumLicenceA4;
    TextView textViewValidationNumLicenceA5;
    TextView textViewValidationNumLicenceA6;
    TextView textViewValidationNumLicenceA7;
    TextView textViewValidationNumLicenceA8;
    TextView textViewValidationNumLicenceA9;
    TextView textViewValidationNumLicenceA10;
    TextView textViewValidationNumLicenceA11;
    TextView textViewValidationNumLicenceA12;
    TextView textViewValidationNumLicenceA13;
    TextView textViewValidationNumLicenceA14;
    TextView textViewValidationNumLicenceA15;

    Button buttonSignatureValidationParB;
    Button retourEquipeB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_par_equipe_b);
        retourEquipeB=(Button)findViewById(R.id.buttonRetourEquipeb);
        retourEquipeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ValidationParEquipeB.this, MatchActivity.class);
                startActivity(intent);
            }
        });
        //Equipe A
        textViewValidationNumA1 = (TextView)findViewById(R.id.textViewValidationNumA1);
        textViewValidationNumA2 = (TextView)findViewById(R.id.textViewValidationNumA2);
        textViewValidationNumA3 = (TextView)findViewById(R.id.textViewValidationNumA3);
        textViewValidationNumA4 = (TextView)findViewById(R.id.textViewValidationNumA4);
        textViewValidationNumA5 = (TextView)findViewById(R.id.textViewValidationNumA5);
        textViewValidationNumA6 = (TextView)findViewById(R.id.textViewValidationNumA6);
        textViewValidationNumA7 = (TextView)findViewById(R.id.textViewValidationNumA7);
        textViewValidationNumA8 = (TextView)findViewById(R.id.textViewValidationNumA8);
        textViewValidationNumA9 = (TextView)findViewById(R.id.textViewValidationNumA9);
        textViewValidationNumA10 = (TextView)findViewById(R.id.textViewValidationNumA10);
        textViewValidationNumA11 = (TextView)findViewById(R.id.textViewValidationNumA11);
        textViewValidationNumA12 = (TextView)findViewById(R.id.textViewValidationNumA12);
        textViewValidationNumA13 = (TextView)findViewById(R.id.textViewValidationNumA13);
        textViewValidationNumA14 = (TextView)findViewById(R.id.textViewValidationNumA14);
        textViewValidationNumA15 = (TextView)findViewById(R.id.textViewValidationNumA15);
        textViewValidationNomA1 = (TextView)findViewById(R.id.textViewValidationNomA1);
        textViewValidationNomA2 = (TextView)findViewById(R.id.textViewValidationNomA2);
        textViewValidationNomA3 = (TextView)findViewById(R.id.textViewValidationNomA3);
        textViewValidationNomA4 = (TextView)findViewById(R.id.textViewValidationNomA4);
        textViewValidationNomA5 = (TextView)findViewById(R.id.textViewValidationNomA5);
        textViewValidationNomA6 = (TextView)findViewById(R.id.textViewValidationNomA6);
        textViewValidationNomA7 = (TextView)findViewById(R.id.textViewValidationNomA7);
        textViewValidationNomA8 = (TextView)findViewById(R.id.textViewValidationNomA8);
        textViewValidationNomA9 = (TextView)findViewById(R.id.textViewValidationNomA9);
        textViewValidationNomA10 = (TextView)findViewById(R.id.textViewValidationNomA10);
        textViewValidationNomA11 = (TextView)findViewById(R.id.textViewValidationNomA11);
        textViewValidationNomA12 = (TextView)findViewById(R.id.textViewValidationNomA12);
        textViewValidationNomA13 = (TextView)findViewById(R.id.textViewValidationNomA13);
        textViewValidationNomA14 = (TextView)findViewById(R.id.textViewValidationNomA14);
        textViewValidationNomA15 = (TextView)findViewById(R.id.textViewValidationNomA15);
        textViewValidationNumLicenceA1 = (TextView)findViewById(R.id.textViewValidationNumLicenceA1);
        textViewValidationNumLicenceA2 = (TextView)findViewById(R.id.textViewValidationNumLicenceA2);
        textViewValidationNumLicenceA3 = (TextView)findViewById(R.id.textViewValidationNumLicenceA3);
        textViewValidationNumLicenceA4 = (TextView)findViewById(R.id.textViewValidationNumLicenceA4);
        textViewValidationNumLicenceA5 = (TextView)findViewById(R.id.textViewValidationNumLicenceA5);
        textViewValidationNumLicenceA6 = (TextView)findViewById(R.id.textViewValidationNumLicenceA6);
        textViewValidationNumLicenceA7 = (TextView)findViewById(R.id.textViewValidationNumLicenceA7);
        textViewValidationNumLicenceA8 = (TextView)findViewById(R.id.textViewValidationNumLicenceA8);
        textViewValidationNumLicenceA9 = (TextView)findViewById(R.id.textViewValidationNumLicenceA9);
        textViewValidationNumLicenceA10 = (TextView)findViewById(R.id.textViewValidationNumLicenceA10);
        textViewValidationNumLicenceA11 = (TextView)findViewById(R.id.textViewValidationNumLicenceA11);
        textViewValidationNumLicenceA12 = (TextView)findViewById(R.id.textViewValidationNumLicenceA12);
        textViewValidationNumLicenceA13 = (TextView)findViewById(R.id.textViewValidationNumLicenceA13);
        textViewValidationNumLicenceA14 = (TextView)findViewById(R.id.textViewValidationNumLicenceA14);
        textViewValidationNumLicenceA15 = (TextView)findViewById(R.id.textViewValidationNumLicenceA15);
        final SharedPreferences loadEquipeA = getSharedPreferences("equipeA",0);
        textViewValidationNumA1.setText(loadEquipeA.getString("numA1", ""));
        textViewValidationNumA2.setText(loadEquipeA.getString("numA2", ""));
        textViewValidationNumA3.setText(loadEquipeA.getString("numA3", ""));
        textViewValidationNumA4.setText(loadEquipeA.getString("numA4", ""));
        textViewValidationNumA5.setText(loadEquipeA.getString("numA5", ""));
        textViewValidationNumA6.setText(loadEquipeA.getString("numA6", ""));
        textViewValidationNumA7.setText(loadEquipeA.getString("numA7", ""));
        textViewValidationNumA8.setText(loadEquipeA.getString("numA8", ""));
        textViewValidationNumA9.setText(loadEquipeA.getString("numA9", ""));
        textViewValidationNumA10.setText(loadEquipeA.getString("numA10", ""));
        textViewValidationNumA11.setText(loadEquipeA.getString("numA11", ""));
        textViewValidationNumA12.setText(loadEquipeA.getString("numA12", ""));
        textViewValidationNumA13.setText(loadEquipeA.getString("numA13", ""));
        textViewValidationNumA14.setText(loadEquipeA.getString("numA14", ""));
        textViewValidationNumA15.setText(loadEquipeA.getString("numA15", ""));
        textViewValidationNomA1.setText(loadEquipeA.getString("nomA1", ""));
        textViewValidationNomA2.setText(loadEquipeA.getString("nomA2", ""));
        textViewValidationNomA3.setText(loadEquipeA.getString("nomA3", ""));
        textViewValidationNomA4.setText(loadEquipeA.getString("nomA4", ""));
        textViewValidationNomA5.setText(loadEquipeA.getString("nomA5", ""));
        textViewValidationNomA6.setText(loadEquipeA.getString("nomA6", ""));
        textViewValidationNomA7.setText(loadEquipeA.getString("nomA7", ""));
        textViewValidationNomA8.setText(loadEquipeA.getString("nomA8", ""));
        textViewValidationNomA9.setText(loadEquipeA.getString("nomA9", ""));
        textViewValidationNomA10.setText(loadEquipeA.getString("nomA10", ""));
        textViewValidationNomA11.setText(loadEquipeA.getString("nomA11", ""));
        textViewValidationNomA12.setText(loadEquipeA.getString("nomA12", ""));
        textViewValidationNomA13.setText(loadEquipeA.getString("nomA13", ""));
        textViewValidationNomA14.setText(loadEquipeA.getString("nomA14", ""));
        textViewValidationNomA15.setText(loadEquipeA.getString("nomA15", ""));
        textViewValidationNumLicenceA1.setText(loadEquipeA.getString("numLicenceA1", ""));
        textViewValidationNumLicenceA2.setText(loadEquipeA.getString("numLicenceA2", ""));
        textViewValidationNumLicenceA3.setText(loadEquipeA.getString("numLicenceA3", ""));
        textViewValidationNumLicenceA4.setText(loadEquipeA.getString("numLicenceA4", ""));
        textViewValidationNumLicenceA5.setText(loadEquipeA.getString("numLicenceA5", ""));
        textViewValidationNumLicenceA6.setText(loadEquipeA.getString("numLicenceA6", ""));
        textViewValidationNumLicenceA7.setText(loadEquipeA.getString("numLicenceA7", ""));
        textViewValidationNumLicenceA8.setText(loadEquipeA.getString("numLicenceA8", ""));
        textViewValidationNumLicenceA9.setText(loadEquipeA.getString("numLicenceA9", ""));
        textViewValidationNumLicenceA10.setText(loadEquipeA.getString("numLicenceA10", ""));
        textViewValidationNumLicenceA11.setText(loadEquipeA.getString("numLicenceA11", ""));
        textViewValidationNumLicenceA12.setText(loadEquipeA.getString("numLicenceA12", ""));
        textViewValidationNumLicenceA13.setText(loadEquipeA.getString("numLicenceA13", ""));
        textViewValidationNumLicenceA14.setText(loadEquipeA.getString("numLicenceA14", ""));
        textViewValidationNumLicenceA15.setText(loadEquipeA.getString("numLicenceA15", ""));

        //concerne la signature

        buttonSignatureValidationParB = (Button)findViewById(R.id.buttonSignatureValidationParB);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        File file = new File(DIRECTORY);
        if (!file.exists()) {
            file.mkdir();
        }

        // Dialog Function
        dialog = new Dialog(ValidationParEquipeB.this);
        // Removing the features of Normal Dialogs
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_signature);
        dialog.setCancelable(true);

        buttonSignatureValidationParB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_action();
            }
        });

        //imageView
        ImageView imageViewValidationSignatureEquipeB = (ImageView)findViewById(R.id.imageViewValidationSignatureEquipeB);
        File imgFile = new  File(DIRECTORY + "signatureValidationParEquipeB.png");
        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageViewValidationSignatureEquipeB.setImageBitmap(myBitmap);
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
    String pic_name = "signatureValidationParEquipeB";
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
                mSignature.save(view, DIRECTORY + "signatureValidationParEquipeB.png");
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
