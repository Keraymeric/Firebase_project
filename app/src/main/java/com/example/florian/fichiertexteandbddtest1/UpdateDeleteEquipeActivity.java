package com.example.florian.fichiertexteandbddtest1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateDeleteEquipeActivity extends AppCompatActivity {

    private Equipe equipe;
    private EditText editTextNomEquipe, editTextNiveauEquipe;
    private Button buttonModifierEquipe, buttonSupprimerEquipe, buttonAjouterJoueurEquipe, buttonRetourEquipe;
    private DatabaseHelper databaseHelper;
    private ListView listView;
    private ArrayList<Joueur> joueurArrayList;
    private JoueurAdapteur joueurAdapter;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference firebaseReference,firebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_equipe);
        Intent intent = getIntent();
        equipe = (Equipe) intent.getSerializableExtra("equipe");

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseRef= firebaseDatabase.getReference().child("Equipe").child(String.valueOf(equipe.getId()));
        firebaseReference = firebaseDatabase.getReference().child("Joueurs").child(String.valueOf(equipe.getId()));
        databaseHelper = new DatabaseHelper(this);

        editTextNiveauEquipe=findViewById(R.id.editTextNiveauEquipe);
        editTextNomEquipe = findViewById(R.id.editTextNomEquipe);
        buttonModifierEquipe = findViewById(R.id.buttonModifierEquipe);
        buttonSupprimerEquipe = findViewById(R.id.buttonSupprimerEquipe);
        buttonAjouterJoueurEquipe = findViewById(R.id.buttonAjouterJoueurEquipe);
        buttonRetourEquipe = findViewById(R.id.buttonRetourEquipe);

        editTextNomEquipe.setText(equipe.getNom());
        editTextNiveauEquipe.setText(equipe.getNiveau());

        //concernant la liste view de joueurs
        listView = (ListView)findViewById(R.id.lv_joueur);

        joueurArrayList = databaseHelper.getAllJoueurOfEquipe(equipe.getId());
        joueurAdapter = new JoueurAdapteur(this, joueurArrayList);
        listView.setAdapter(joueurAdapter);
        //modification de joueur en cliquant dessus
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(UpdateDeleteEquipeActivity.this, UpdateDeleteJoueurActivity.class);
                intent.putExtra("joueur", joueurArrayList.get(position));
                intent.putExtra("equipe", equipe);
                startActivity(intent);
            }
        });



        buttonModifierEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateEquipe(equipe.getId(), editTextNomEquipe.getText().toString(),editTextNiveauEquipe.getText().toString());
                firebaseRef.child("niveau").setValue(editTextNiveauEquipe.getText().toString());
                firebaseRef.child("nom").setValue(editTextNomEquipe.getText().toString());
                Toast.makeText(UpdateDeleteEquipeActivity.this, "Succès de la mise à jour", Toast.LENGTH_SHORT).show();
                //Intent intent = getIntent();
                //startActivity(intent);
                //Intent intent = new Intent(UpdateDeleteEquipeActivity.this,MainActivity.class);
                /*Intent intent = new Intent(UpdateDeleteEquipeActivity.this,UpdateDeleteEquipeActivity.class);
                Equipe nouvelleEquipe = databaseHelper.getEquipeById(equipe.getId());
                intent.putExtra("equipe", nouvelleEquipe);*/
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
            }
        });


        /*buttonSupprimerEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteEquipe(equipe.getId());
                Toast.makeText(UpdateDeleteEquipeActivity.this, "L'équipe à bien été supprimée", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteEquipeActivity.this,EquipeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });*/

        buttonSupprimerEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(UpdateDeleteEquipeActivity.this);
                View promptView = layoutInflater.inflate(R.layout.supprimer_equipe_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(UpdateDeleteEquipeActivity.this);
                alertDialogBuilder.setView(promptView);


                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                databaseHelper.deleteEquipe(equipe.getId());
                                firebaseRef.removeValue();
                                firebaseReference.removeValue();
                                Toast.makeText(UpdateDeleteEquipeActivity.this, "L'équipe à bien été supprimée", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(UpdateDeleteEquipeActivity.this,EquipeActivity.class);
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



        buttonAjouterJoueurEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showInputDialog(databaseHelper, equipe, th);

                LayoutInflater layoutInflater = LayoutInflater.from(UpdateDeleteEquipeActivity.this);
                View promptView = layoutInflater.inflate(R.layout.ajouter_joueur_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(UpdateDeleteEquipeActivity.this);
                alertDialogBuilder.setView(promptView);

                final EditText editTextNomAjouterJoueurDialog = (EditText) promptView.findViewById(R.id.editTextNomAjouterJoueurDialog);
                final EditText editTextPrenomAjouterJoueurDialog = (EditText) promptView.findViewById(R.id.editTextPrenomAjouterJoueurDialog);
                final EditText editTextNumLicenceAjouterJoueurDialog = (EditText) promptView.findViewById(R.id.editTextNumLicenceAjouterJoueurDialog);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //resultText.setText("Hello, " + editText.getText());
                                //ON AJOUTE LE JOUEUR DANS LA BASE DE DONNEES //il faut lier le joueur avec l'équipe !
                                databaseHelper.addJoueur(editTextNomAjouterJoueurDialog.getText().toString(), editTextPrenomAjouterJoueurDialog.getText().toString(), editTextNumLicenceAjouterJoueurDialog.getText().toString(), equipe.getId());
                                Joueur joueur = databaseHelper.getLastJoueurInsert(equipe.getId());
                                firebaseReference.child(String.valueOf(joueur.getId())).setValue(joueur);
                                //IL FAUT METTRE A JOUR L'ADAPTER
                                //adapter.notifyDataSetChanged(); ?
                                //joueurAdapter.notifyDataSetChanged(); //TEST
                                //Intent intent = new Intent(context, UpdateDeleteEquipeActivity.class);
                                //startActivity(intent);
                                Intent intent = getIntent();
                                finish();
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

                joueurAdapter.notifyDataSetChanged(); //TEST
            }
        });


        buttonRetourEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateDeleteEquipeActivity.this, EquipeActivity.class);
                startActivity(intent);
            }
        });
    }
}
