package com.example.florian.fichiertexteandbddtest1;

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
    private DatabaseReference mReference;
    private List<Equipe> equipes = new ArrayList<>();

    public FirebaseDatabaseHelper() {
        mDatabase= FirebaseDatabase.getInstance();
        mReference= mDatabase.getReference("Equipe");
    }
    public interface DataStatus{
        void DataIsLoaded(List<Equipe> equipes, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public void readEquipes(final DataStatus dataStatus){
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                equipes.clear();
                List<String> keys= new ArrayList<>();
                for(DataSnapshot keyNode: snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Equipe equipe = keyNode.getValue(Equipe.class);

                }
                dataStatus.DataIsLoaded(equipes, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}