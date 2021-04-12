package com.example.florian.fichiertexteandbddtest1;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EquipeActivity extends AppCompatActivity {

    private Button buttonAjouterEquipe, buttonRetourAccueil,buttonImportFirebase,buttonAfficherFirebase;
    private ListView listView;
    private ArrayList<Equipe> equipeArrayList;
    private EquipeAdapter equipeAdapter;
    private DatabaseHelper databaseHelper;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference firebaseReference, firebaseReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe);

        buttonAjouterEquipe = (Button)findViewById(R.id.buttonAjouterEquipe);
        buttonRetourAccueil = (Button)findViewById(R.id.buttonRetourAccueil);
        buttonImportFirebase = findViewById(R.id.buttonFirebase);
        listView = (ListView)findViewById(R.id.lvEquipe);

        databaseHelper = new DatabaseHelper(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseReference = firebaseDatabase.getReference().child("Equipe");
        firebaseReference2 = firebaseDatabase.getReference().child("Joueurs");

        equipeArrayList = databaseHelper.getAllEquipe();
        equipeAdapter = new EquipeAdapter(this, equipeArrayList);
        listView.setAdapter(equipeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EquipeActivity.this, UpdateDeleteEquipeActivity.class);
                intent.putExtra("equipe", equipeArrayList.get(position));
                startActivity(intent);
            }
        });

        buttonImportFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteAllEquipe();
                equipeArrayList.clear();
                firebaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        List<String> keys= new ArrayList<>();
                        for (DataSnapshot keyNode : snapshot.getChildren()){
                            keys.add(keyNode.getKey());
                            Equipe equipe = keyNode.getValue(Equipe.class);

                            databaseHelper.addEquipe(equipe.getNom(),equipe.getNiveau());
                            equipeAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EquipeActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
                firebaseReference2.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> keys = new ArrayList<>();
                            for (DataSnapshot firstLevelSnapshot : task.getResult().getChildren()) {
                                for (DataSnapshot secondLevelSnapshot : firstLevelSnapshot.getChildren()) {
                                    String key = secondLevelSnapshot.getKey();
                                    keys.add(key);
                                    Joueur joueur = secondLevelSnapshot.getValue(Joueur.class);
                                    databaseHelper.addJoueur(
                                            joueur.getNom_joueur(),
                                            joueur.getPrenom_joueur(),
                                            joueur.getNum_licence_joueur(),
                                            joueur.getId_equipe_joueur()
                                    );
                                }
                            }
                        } else {
                        }
                    }
                });

                equipeAdapter.notifyDataSetChanged();
                Intent intent = new Intent(EquipeActivity.this,ImportActivity.class);
                startActivity(intent);
            }
        });

        buttonAjouterEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(EquipeActivity.this);
                View promptView = layoutInflater.inflate(R.layout.ajouter_equipe_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EquipeActivity.this);
                alertDialogBuilder.setView(promptView);

                final EditText editTextNomAjouterEquipeDialog = (EditText) promptView.findViewById(R.id.editTextNomAjouterEquipeDialog);
                final EditText editTextNiveauAjouterEquipeDialog = (EditText) promptView.findViewById(R.id.editTextNiveau);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                databaseHelper.addEquipe(editTextNomAjouterEquipeDialog.getText().toString(),editTextNiveauAjouterEquipeDialog.getText().toString());
                                Equipe equipe = databaseHelper.getLastEquipeInsert();
                                firebaseReference.child(String.valueOf(equipe.getId())).setValue(equipe);
                                Intent intent = new Intent(EquipeActivity.this, UpdateDeleteEquipeActivity.class);
                                intent.putExtra("equipe", equipe);
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

        buttonRetourAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_equipe);

        buttonAjouterEquipe = (Button)findViewById(R.id.buttonAjouterEquipe);
        buttonRetourAccueil = (Button)findViewById(R.id.buttonRetourAccueil);
        buttonImportFirebase = findViewById(R.id.buttonFirebase);
        listView = (ListView)findViewById(R.id.lvEquipe);

        databaseHelper = new DatabaseHelper(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseReference = firebaseDatabase.getReference().child("Equipe");

        equipeArrayList = databaseHelper.getAllEquipe();
        equipeAdapter = new EquipeAdapter(this, equipeArrayList);
        listView.setAdapter(equipeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EquipeActivity.this, UpdateDeleteEquipeActivity.class);
                intent.putExtra("equipe", equipeArrayList.get(position));
                startActivity(intent);
            }
        });

        buttonImportFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteAllEquipe();
                equipeArrayList.clear();
                firebaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        List<String> keys= new ArrayList<>();
                        for (DataSnapshot keyNode : snapshot.getChildren()){
                            keys.add(keyNode.getKey());
                            Equipe equipe = keyNode.getValue(Equipe.class);
                            databaseHelper.addEquipe(equipe.getNom(),equipe.getNiveau());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EquipeActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
                firebaseReference2.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> keys = new ArrayList<>();
                            for (DataSnapshot firstLevelSnapshot : task.getResult().getChildren()) {
                                for (DataSnapshot secondLevelSnapshot : firstLevelSnapshot.getChildren()) {
                                    String key = secondLevelSnapshot.getKey();
                                    keys.add(key);
                                    Joueur joueur = secondLevelSnapshot.getValue(Joueur.class);
                                    databaseHelper.addJoueur(
                                            joueur.getNom_joueur(),
                                            joueur.getPrenom_joueur(),
                                            joueur.getNum_licence_joueur(),
                                            joueur.getId_equipe_joueur()
                                    );
                                }
                            }
                        } else {
                        }
                    }
                });
                equipeAdapter.notifyDataSetChanged();
                Intent intent = new Intent(EquipeActivity.this,ImportActivity.class);
                startActivity(intent);

            }
        });

        buttonAjouterEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(EquipeActivity.this);
                View promptView = layoutInflater.inflate(R.layout.ajouter_equipe_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EquipeActivity.this);
                alertDialogBuilder.setView(promptView);

                final EditText editTextNomAjouterEquipeDialog =  promptView.findViewById(R.id.editTextNomAjouterEquipeDialog);
                final EditText editTextNiveauAjouterEquipeDialog =  promptView.findViewById(R.id.editTextNiveau);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                databaseHelper.addEquipe(editTextNomAjouterEquipeDialog.getText().toString(),editTextNiveauAjouterEquipeDialog.getText().toString());                                /*Intent intent = getIntent();
                                finish();
                                startActivity(intent);*/
                                Equipe equipe = databaseHelper.getLastEquipeInsert();
                                firebaseReference.child(String.valueOf(equipe.getId())).setValue(equipe);
                                Intent intent = new Intent(EquipeActivity.this, UpdateDeleteEquipeActivity.class);
                                intent.putExtra("equipe", equipe);
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

        buttonRetourAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_equipe);

        buttonAjouterEquipe = (Button)findViewById(R.id.buttonAjouterEquipe);
        buttonRetourAccueil = (Button)findViewById(R.id.buttonRetourAccueil);
        buttonImportFirebase = findViewById(R.id.buttonFirebase);
        listView = (ListView)findViewById(R.id.lvEquipe);

        databaseHelper = new DatabaseHelper(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseReference = firebaseDatabase.getReference().child("Equipe");

        equipeArrayList = databaseHelper.getAllEquipe();
        equipeAdapter = new EquipeAdapter(this, equipeArrayList);
        listView.setAdapter(equipeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EquipeActivity.this, UpdateDeleteEquipeActivity.class);
                intent.putExtra("equipe", equipeArrayList.get(position));
                startActivity(intent);
            }
        });

        buttonImportFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteAllEquipe();
                equipeArrayList.clear();
                firebaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        List<String> keys= new ArrayList<>();
                        for (DataSnapshot keyNode : snapshot.getChildren()){
                            keys.add(keyNode.getKey());
                            Equipe equipe = keyNode.getValue(Equipe.class);

                            databaseHelper.addEquipe(equipe.getNom(),equipe.getNiveau());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EquipeActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
                firebaseReference2.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> keys = new ArrayList<>();
                            for (DataSnapshot firstLevelSnapshot : task.getResult().getChildren()) {
                                for (DataSnapshot secondLevelSnapshot : firstLevelSnapshot.getChildren()) {
                                    String key = secondLevelSnapshot.getKey();
                                    keys.add(key);
                                    Joueur joueur = secondLevelSnapshot.getValue(Joueur.class);
                                    databaseHelper.addJoueur(
                                            joueur.getNom_joueur(),
                                            joueur.getPrenom_joueur(),
                                            joueur.getNum_licence_joueur(),
                                            joueur.getId_equipe_joueur()
                                    );
                                }
                            }
                        } else {
                        }
                    }
                });
                equipeAdapter.notifyDataSetChanged();
                Intent intent = new Intent(EquipeActivity.this,ImportActivity.class);
                startActivity(intent);
            }
        });

        buttonAjouterEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(EquipeActivity.this);
                View promptView = layoutInflater.inflate(R.layout.ajouter_equipe_dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EquipeActivity.this);
                alertDialogBuilder.setView(promptView);

                final EditText editTextNomAjouterEquipeDialog = (EditText) promptView.findViewById(R.id.editTextNomAjouterEquipeDialog);
                final EditText editTextNiveauAjouterEquipeDialog = (EditText) promptView.findViewById(R.id.editTextNiveau);

                alertDialogBuilder.setCancelable(false)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                databaseHelper.addEquipe(editTextNomAjouterEquipeDialog.getText().toString(),editTextNiveauAjouterEquipeDialog.getText().toString());
                                /*Intent intent = getIntent();
                                finish();
                                startActivity(intent);*/

                                Equipe equipe = databaseHelper.getLastEquipeInsert();
                                firebaseReference.child(String.valueOf(equipe.getId())).setValue(equipe);
                                Intent intent = new Intent(EquipeActivity.this, UpdateDeleteEquipeActivity.class);
                                intent.putExtra("equipe", equipe);
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

        buttonRetourAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EquipeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
