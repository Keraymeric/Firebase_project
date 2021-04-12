package com.example.florian.fichiertexteandbddtest1;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference,mReference2;
    private List<Equipe> equipes = new ArrayList<>();

    public FirebaseDatabaseHelper() {
        mDatabase= FirebaseDatabase.getInstance();
        mReference= mDatabase.getReference("Equipe");
        mReference2= mDatabase.getReference("Joueurs");
    }

    public void importEquipes(final DatabaseHelper databaseHelper){
        mReference.addListenerForSingleValueEvent(new ValueEventListener() {
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
            }
        });
    }
    public void importJoueur(final DatabaseHelper databaseHelper){
        mReference2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Joueur joueur = keyNode.getValue(Joueur.class);
                    databaseHelper.addJoueur(joueur.getNom_joueur(),joueur.getPrenom_joueur(),joueur.getNum_licence_joueur(), Integer.parseInt(keyNode.getKey()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}