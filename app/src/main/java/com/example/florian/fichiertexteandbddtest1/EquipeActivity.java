package com.example.florian.fichiertexteandbddtest1;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EquipeActivity extends AppCompatActivity {

    private Button buttonAjouterEquipe, buttonRetourAccueil;
    private ListView listView;
    private ArrayList<Equipe> equipeArrayList;
    private EquipeAdapter equipeAdapter;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe);

        buttonAjouterEquipe = (Button)findViewById(R.id.buttonAjouterEquipe);
        buttonRetourAccueil = (Button)findViewById(R.id.buttonRetourAccueil);
        listView = (ListView)findViewById(R.id.lvEquipe);

        databaseHelper = new DatabaseHelper(this);

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

                equipeAdapter.notifyDataSetChanged(); //TEST
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
        listView = (ListView)findViewById(R.id.lvEquipe);

        databaseHelper = new DatabaseHelper(this);

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
                                databaseHelper.addEquipe(editTextNomAjouterEquipeDialog.getText().toString(),editTextNiveauAjouterEquipeDialog.getText().toString());                                /*Intent intent = getIntent();
                                finish();
                                startActivity(intent);*/
                                Equipe equipe = databaseHelper.getLastEquipeInsert();
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

                equipeAdapter.notifyDataSetChanged(); //TEST
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
        listView = (ListView)findViewById(R.id.lvEquipe);

        databaseHelper = new DatabaseHelper(this);

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

                equipeAdapter.notifyDataSetChanged(); //TEST
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
