package com.example.florian.fichiertexteandbddtest1;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;

public class Approbation extends AppCompatActivity {

    String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";

    /*EditText nomArbitre1;
    EditText numLicenceArbitre1;
    EditText clubDesigneArbitre1;
    EditText indemniteArbitre1;
    EditText nomArbitre2;
    EditText numLicenceArbitre2;*/
    /*EditText nomCapitaineA;
    EditText numLicenceCapitaineA;*/
    EditText nomCapitaineB;
    EditText numLicenceCapitaineB;

    EditText approbationRemarque;

    Button buttonApprobationValider;
    Button buttonRetour;
    Button buttonApprobationSignerArbitre1;
    Button buttonApprobationSignerArbitre2;
    Button buttonApprobationSignerCapitaineA;
    Button buttonApprobationSignerCapitaineB;

    ImageView imageViewSignatureArbitre1, imageViewSignatureArbitre2;
    ImageView imageViewSignatureCapitaineEquipeA, imageViewSignatureCapitaineEquipeB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approbation);

        SharedPreferences loadResultat = getSharedPreferences("approbation",0);

        /*nomArbitre1 = (EditText)findViewById(R.id.nomArbitre1); nomArbitre1.setText(loadResultat.getString("nomArbitre1", ""));
        numLicenceArbitre1 = (EditText)findViewById(R.id.numLicenceArbitre1); numLicenceArbitre1.setText(loadResultat.getString("numLicenceArbitre1", ""));
        clubDesigneArbitre1 = (EditText)findViewById(R.id.clubDesigneArbitre1); clubDesigneArbitre1.setText(loadResultat.getString("clubDesigneArbitre1", ""));
        indemniteArbitre1 = (EditText)findViewById(R.id.indemniteArbitre1); indemniteArbitre1.setText(loadResultat.getString("indemniteArbitre1", ""));
        nomArbitre2 = (EditText)findViewById(R.id.nomArbitre2); nomArbitre2.setText(loadResultat.getString("nomArbitre2", ""));
        numLicenceArbitre2 = (EditText)findViewById(R.id.numLicenceArbitre2); numLicenceArbitre2.setText((loadResultat.getString("numLicenceArbitre2", "")));*/
        /*nomCapitaineA = (EditText)findViewById(R.id.nomCapitaineA); nomCapitaineA.setText(loadResultat.getString("nomCapitaineA", ""));
        numLicenceCapitaineA = (EditText)findViewById(R.id.numLicenceCapitaineA); numLicenceCapitaineA.setText(loadResultat.getString("numLicenceCapitaineA", ""));*/
        /*nomCapitaineB = (EditText)findViewById(R.id.nomCapitaineB); nomCapitaineB.setText(loadResultat.getString("nomCapitaineB", ""));
        numLicenceCapitaineB = (EditText)findViewById(R.id.numLicenceCapitaineB); numLicenceCapitaineB.setText(loadResultat.getString("numLicenceCapitaineB", ""));*/

        approbationRemarque = (EditText)findViewById(R.id.approbationRemarque); approbationRemarque.setText(loadResultat.getString("remarque", ""));

        buttonApprobationValider = (Button)findViewById(R.id.buttonApprobationValider);
        buttonApprobationValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences saveApprobation = getSharedPreferences("approbation",0);
                SharedPreferences.Editor editorApprobation = saveApprobation.edit();
                /*editorApprobation.putString("nomArbitre1", nomArbitre1.getText().toString());
                editorApprobation.putString("numLicenceArbitre1", numLicenceArbitre1.getText().toString());
                editorApprobation.putString("clubDesigneArbitre1", clubDesigneArbitre1.getText().toString());
                editorApprobation.putString("indemniteArbitre1", indemniteArbitre1.getText().toString());
                editorApprobation.putString("nomArbitre2", nomArbitre2.getText().toString());
                editorApprobation.putString("numLicenceArbitre2", numLicenceArbitre2.getText().toString());*/
                /*editorApprobation.putString("nomCapitaineA", nomCapitaineA.getText().toString());
                editorApprobation.putString("numLicenceCapitaineA", numLicenceCapitaineA.getText().toString());*/
                /*editorApprobation.putString("nomCapitaineB", nomCapitaineB.getText().toString());
                editorApprobation.putString("numLicenceCapitaineB", numLicenceCapitaineB.getText().toString());*/

                editorApprobation.putString("remarque", approbationRemarque.getText().toString());

                editorApprobation.commit();

                Intent intent = new Intent(Approbation.this, MatchActivity.class);
                startActivity(intent);
            }
        });
        buttonRetour=(Button) findViewById(R.id.buttonRetour);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Approbation.this, MatchActivity.class);
                startActivity(intent);
            }
        });
        //concernant les signatures
        buttonApprobationSignerArbitre1 = (Button)findViewById(R.id.buttonApprobationSignerArbitre1);
        buttonApprobationSignerArbitre2 = (Button)findViewById(R.id.buttonApprobationSignerArbitre2);
        buttonApprobationSignerCapitaineA = (Button)findViewById(R.id.buttonApprobationSignerCapitaineA);
        buttonApprobationSignerCapitaineB = (Button)findViewById(R.id.buttonApprobationSignerCapitaineB);

        imageViewSignatureArbitre1 = (ImageView)findViewById(R.id.imageViewSignatureArbitre1);
        imageViewSignatureArbitre2 = (ImageView)findViewById(R.id.imageViewSignatureArbitre2);
        imageViewSignatureCapitaineEquipeA = (ImageView)findViewById(R.id.imageViewSignatureCapitaineEquipeA);
        imageViewSignatureCapitaineEquipeB = (ImageView)findViewById(R.id.imageViewSignatureCapitaineEquipeB);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        File file = new File(DIRECTORY);
        if (!file.exists()) {
            file.mkdir();
        }

        // Dialog Function
        dialog = new Dialog(Approbation.this);
        // Removing the features of Normal Dialogs
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_signature);
        dialog.setCancelable(true);

        buttonApprobationSignerArbitre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_action("signatureArbitre1");
            }
        });
        buttonApprobationSignerArbitre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_action("signatureArbitre2");
            }
        });
        buttonApprobationSignerCapitaineA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_action("signatureCapitaineA");
            }
        });
        buttonApprobationSignerCapitaineB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_action("signatureCapitaineB");
            }
        });


        //imageView
        ImageView imageViewSignatureArbitre1 = (ImageView)findViewById(R.id.imageViewSignatureArbitre1);
        File imgFileArbitre1 = new  File(DIRECTORY + "signatureArbitre1.png");
        if(imgFileArbitre1.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileArbitre1.getAbsolutePath());
            imageViewSignatureArbitre1.setImageBitmap(myBitmap);
        }
        ImageView imageViewSignatureArbitre2 = (ImageView)findViewById(R.id.imageViewSignatureArbitre2);
        File imgFileArbitre2 = new  File(DIRECTORY + "signatureArbitre2.png");
        if(imgFileArbitre2.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileArbitre2.getAbsolutePath());
            imageViewSignatureArbitre2.setImageBitmap(myBitmap);
        }
        ImageView imageViewSignatureCapitaineEquipeA = (ImageView)findViewById(R.id.imageViewSignatureCapitaineEquipeA);
        File imgFileCapitaineEquipeA = new  File(DIRECTORY + "signatureCapitaineA.png");
        if(imgFileCapitaineEquipeA.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileCapitaineEquipeA.getAbsolutePath());
            imageViewSignatureCapitaineEquipeA.setImageBitmap(myBitmap);
        }
        ImageView imageViewSignatureCapitaineEquipeB = (ImageView)findViewById(R.id.imageViewSignatureCapitaineEquipeB);
        File imgFileCapitaineEquipeB = new  File(DIRECTORY+ "signatureCapitaineB.png");
        if(imgFileCapitaineEquipeB.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFileCapitaineEquipeB.getAbsolutePath());
            imageViewSignatureCapitaineEquipeB.setImageBitmap(myBitmap);
        }

    }

    Button btn_get_sign, mClear, mGetSign, mCancel;
    LinearLayout mContent;
    Signature mSignature;
    Dialog dialog;
    Bitmap bitmap;
    View view;

    // Creating Separate Directory for saving Generated Images
    //String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";
    //String pic_name = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    String pic_name1 = "signatureArbitre1";
    //String StoredPath = DIRECTORY + pic_name + ".png";  //==> a changer suivant qui signe ?
    //String StoredPath = "/storage/emulated/0/Download/" + pic_name;
    String StoredPath1 = Environment.getExternalStorageDirectory().toString() + "/" + "signatureArbitre1" + ".png";
    // Function for Digital Signature

    public void dialog_action(String fileName) {

        final String fileNameFinal = fileName;

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
                mSignature.save(view, DIRECTORY + fileNameFinal + ".png");
                //mSignature.save(view, "/storage/emulated/0/Download/" + fileNameFinal + ".png");
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
