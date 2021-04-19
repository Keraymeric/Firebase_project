package com.example.florian.fichiertexteandbddtest1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateDeleteJoueurActivity extends AppCompatActivity {

    private Joueur joueur;
    private Equipe equipe;
    private EditText editTextNomJoueur, editTextPrenomJoueur, editTextNumLicenceJoueur;
    private Button buttonModifierJoueur, buttonSupprimerJoueur, buttonRetourUpdateDeleteEquipe;
    private DatabaseHelper databaseHelper;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference firebaseReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_joueur);

        Intent intent = getIntent();
        joueur = (Joueur) intent.getSerializableExtra("joueur");
        equipe = (Equipe) intent.getSerializableExtra("equipe");

        databaseHelper = new DatabaseHelper(this);
        firebaseDatabase= FirebaseDatabase.getInstance();
        firebaseReference2 = firebaseDatabase.getReference().child("Joueurs").child(String.valueOf(equipe.getId()));

        editTextNomJoueur = (EditText)findViewById(R.id.editTextNomJoueur);
        editTextNomJoueur.setText(joueur.getNom_joueur());
        editTextPrenomJoueur = (EditText)findViewById(R.id.editTextPrenomJoueur);
        editTextPrenomJoueur.setText(joueur.getPrenom_joueur());
        editTextNumLicenceJoueur = (EditText)findViewById(R.id.editTextNumLicenceJoueur);
        editTextNumLicenceJoueur.setText(String.valueOf(joueur.getNum_licence_joueur()));
        buttonModifierJoueur = (Button)findViewById(R.id.buttonModifierJoueur);
        buttonSupprimerJoueur = (Button)findViewById(R.id.buttonSupprimerJoueur);
        buttonRetourUpdateDeleteEquipe = (Button)findViewById(R.id.buttonRetourUpdateDeleteEquipe);

        buttonModifierJoueur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateJoueur(joueur.getId(), editTextNomJoueur.getText().toString(), editTextPrenomJoueur.getText().toString(), editTextNumLicenceJoueur.getText().toString());
                firebaseReference2.child(String.valueOf(joueur.getId())).child("nom_joueur").setValue(editTextNomJoueur.getText().toString());
                firebaseReference2.child(String.valueOf(joueur.getId())).child("prenom_joueur").setValue(editTextPrenomJoueur.getText().toString());
                firebaseReference2.child(String.valueOf(joueur.getId())).child("num_licence_joueur").setValue(editTextNumLicenceJoueur.getText().toString());


                Toast.makeText(UpdateDeleteJoueurActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteJoueurActivity.this, UpdateDeleteEquipeActivity.class);
                intent.putExtra("equipe", equipe);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        /*buttonSupprimerJoueur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteJoueur(joueur.getId());
                Toast.makeText(UpdateDeleteJoueurActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteJoueurActivity.this,UpdateDeleteEquipeActivity.class);
                intent.putExtra("equipe", equipe);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });*/

        buttonSupprimerJoueur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(UpdateDeleteJoueurActivity.this);
                View promptView = layoutInflater.inflate(R.layout.supprimer_joueur_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(UpdateDeleteJoueurActivity.this);
                alertDialogBuilder.setView(promptView);


                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                databaseHelper.deleteJoueur(joueur.getId());
                                firebaseReference2.child(String.valueOf(joueur.getId())).removeValue();
                                Toast.makeText(UpdateDeleteJoueurActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(UpdateDeleteJoueurActivity.this,UpdateDeleteEquipeActivity.class);
                                intent.putExtra("equipe", equipe);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
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


        buttonRetourUpdateDeleteEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateDeleteJoueurActivity.this, UpdateDeleteEquipeActivity.class);
                intent.putExtra("equipe", equipe);
                startActivity(intent);
            }
        });
    }
}
