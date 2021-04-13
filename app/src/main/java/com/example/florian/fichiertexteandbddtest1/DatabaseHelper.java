package com.example.florian.fichiertexteandbddtest1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "test2";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_EQUIPE = "equipe";
    private static final String TABLE_JOUEUR = "joueur";

    private static final String EQUIPE_KEY_ID = "id_equipe";
    private static final String EQUIPE_KEY_NOM = "nom_equipe";
    private static final String EQUIPE_KEY_NIVEAU = "niveau_equipe";

    private static final String JOUEUR_KEY_ID = "id";
    private static final String JOUEUR_KEY_NOM = "nom_joueur";
    private static final String JOUEUR_KEY_PRENOM = "prenom_joueur";
    private static final String JOUEUR_KEY_NUM_LICENCE = "num_licence_joueur";
    private static final String JOUEUR_KEY_EQUIPE = "id_equipe_joueur";


    //creation table équipe
    private static final String CREATE_TABLE_EQUIPE = "CREATE TABLE "
            + TABLE_EQUIPE + "(" + EQUIPE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + EQUIPE_KEY_NOM + " TEXT," + EQUIPE_KEY_NIVEAU + " TEXT);";

    //creation table joueur
    private static final String CREATE_TABLE_JOUEUR = "CREATE TABLE "
            + TABLE_JOUEUR + "(" + JOUEUR_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + JOUEUR_KEY_NOM + " TEXT,"
            + JOUEUR_KEY_PRENOM + " TEXT,"
            + JOUEUR_KEY_EQUIPE + " INT,"
            + JOUEUR_KEY_NUM_LICENCE + " INT,"
            + "FOREIGN KEY(" + JOUEUR_KEY_EQUIPE + ") REFERENCES " + TABLE_EQUIPE + "(id)"
            + ");";

    //constructeur
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_EQUIPE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_EQUIPE);
        db.execSQL(CREATE_TABLE_JOUEUR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_EQUIPE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + CREATE_TABLE_JOUEUR + "'");
        onCreate(db);
    }

    //=====================================
    //pour les équipes
    //=====================================

    //ajouter une équipe
    public void addEquipe(String nom_equipe,String niveau_equipe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EQUIPE_KEY_NOM, nom_equipe);
        values.put(EQUIPE_KEY_NIVEAU,niveau_equipe);
        db.insert(TABLE_EQUIPE, null, values);

    }

    //obtenir la liste des équipes
    public  ArrayList<Equipe> getAllEquipe() {
        ArrayList<Equipe> equipeArrayList = new ArrayList<Equipe>();

        String selectQuery = "SELECT * FROM " + TABLE_EQUIPE + " ORDER BY " + EQUIPE_KEY_NOM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Equipe equipe = new Equipe();
                equipe.setId(c.getInt(c.getColumnIndex(EQUIPE_KEY_ID)));
                equipe.setNom(c.getString(c.getColumnIndex(EQUIPE_KEY_NOM)));
                equipe.setNiveau(c.getString(c.getColumnIndex(EQUIPE_KEY_NIVEAU)));
                equipeArrayList.add(equipe);

            } while (c.moveToNext());

        }

        return equipeArrayList;
    }
    // supprimer toute les équipes

    //update une équipe
    public void updateEquipe(int id, String nom_equipe,String niveau_equipe){ //IL FAUDRA VERIFIER QU'ELLE EST PAS UTILISÉ DANS LA TABLE JOUEUR ?
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EQUIPE_KEY_NOM, nom_equipe);
        values.put(EQUIPE_KEY_NIVEAU,niveau_equipe);
        db.update(TABLE_EQUIPE, values, EQUIPE_KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteEquipe(int id){ //IL FAUDRA D'ABORD SUPPRIMER TOUS LES JOUEURS QU'ELLE CONTIENT
        SQLiteDatabase db = this.getWritableDatabase();
        //on supprime d'abord tous les joueur de l'équipe
        ArrayList<Joueur> lesJoueursDeLequipe = this.getAllJoueurOfEquipe(id);
        for(int i=0; i<lesJoueursDeLequipe.size(); i++){
            this.deleteJoueur(lesJoueursDeLequipe.get(i).getId());
        }
        db.delete(TABLE_EQUIPE, EQUIPE_KEY_ID + " = ?",new String[]{String.valueOf(id)});

    }
    public void deleteAllEquipe(){//Supprimer tous et recrée les tables
      SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_EQUIPE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_JOUEUR + "'");
        db.execSQL(CREATE_TABLE_EQUIPE);
        db.execSQL(CREATE_TABLE_JOUEUR);

    }
    public Equipe getEquipeById(int id){
        String selectQuery = "SELECT * FROM " + TABLE_EQUIPE + " WHERE " + EQUIPE_KEY_ID + " = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        c.moveToFirst();
        Equipe equipe = new Equipe();
        equipe.setId(c.getInt(c.getColumnIndex(EQUIPE_KEY_ID)));
        equipe.setNom(c.getString(c.getColumnIndex(EQUIPE_KEY_NOM)));

        return equipe;
    }

    public Equipe getLastEquipeInsert(){
        String selectQuery = "SELECT * FROM " + TABLE_EQUIPE + " ORDER BY " + EQUIPE_KEY_ID + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        c.moveToFirst();
        Equipe equipe = new Equipe();
        equipe.setId(c.getInt(c.getColumnIndex(EQUIPE_KEY_ID)));
        equipe.setNom(c.getString(c.getColumnIndex(EQUIPE_KEY_NOM)));
        equipe.setNiveau(c.getString(c.getColumnIndex(EQUIPE_KEY_NIVEAU)));
       ;
        return equipe;
    }
    public Joueur getLastJoueurInsert(int id_equipe){
        String selectQuery = "SELECT * FROM " + TABLE_JOUEUR + " WHERE " + JOUEUR_KEY_EQUIPE + " = " + id_equipe + " ORDER BY " + JOUEUR_KEY_ID + " DESC LIMIT 1";
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery,null);
        c.moveToFirst();
        Joueur joueur = new Joueur();
        joueur.setNom_joueur(c.getString(c.getColumnIndex(JOUEUR_KEY_NOM)));
        joueur.setPrenom_joueur(c.getString(c.getColumnIndex(JOUEUR_KEY_PRENOM)));
        joueur.setId(c.getInt(c.getColumnIndex(JOUEUR_KEY_ID)));
        joueur.setNum_licence_joueur(c.getInt(c.getColumnIndex(JOUEUR_KEY_NUM_LICENCE)));
        joueur.setId_equipe_joueur(c.getInt(c.getColumnIndex(JOUEUR_KEY_EQUIPE)));
        return joueur;
    }
    //=====================================
    //pour les joueurs
    //=====================================

    //ajouter un joueur
    public void addJoueur(String nom, String prenom, int numLicence, int id_equipe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(JOUEUR_KEY_NOM, nom);
        values.put(JOUEUR_KEY_PRENOM, prenom);
        values.put(JOUEUR_KEY_NUM_LICENCE, numLicence);
        values.put(JOUEUR_KEY_EQUIPE, id_equipe);
        db.insert(TABLE_JOUEUR, null, values);

    }

    //Obtenir tous les joueurs d'une équipe
    public ArrayList<Joueur> getAllJoueurOfEquipe(int id_equipe){
        ArrayList<Joueur> joueurArrayList = new ArrayList<Joueur>();

        String selectQuery = "SELECT * FROM " + TABLE_JOUEUR + " WHERE " + JOUEUR_KEY_EQUIPE + " = " + id_equipe + " ORDER BY " + JOUEUR_KEY_NOM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()){
            do{
                Joueur joueur = new Joueur();
                joueur.setId(c.getInt(c.getColumnIndex(JOUEUR_KEY_ID)));
                joueur.setNom_joueur(c.getString(c.getColumnIndex(JOUEUR_KEY_NOM)));
                joueur.setPrenom_joueur(c.getString(c.getColumnIndex(JOUEUR_KEY_PRENOM)));
                joueur.setNum_licence_joueur(c.getInt(c.getColumnIndex(JOUEUR_KEY_NUM_LICENCE)));
                //Y a-t-il besoin de faire un champs id_equipe dans joueur ?

                joueurArrayList.add(joueur);

            } while (c.moveToNext());
        }

        return joueurArrayList;
    }

    //update un joueur
    public void updateJoueur(int id, String nom, String prenom, int numLicence){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(JOUEUR_KEY_NOM, nom);
        values.put(JOUEUR_KEY_PRENOM, prenom);
        values.put(JOUEUR_KEY_NUM_LICENCE, numLicence);
        db.update(TABLE_JOUEUR, values, JOUEUR_KEY_ID + " = ?", new String[]{String.valueOf(id)});

    }

    //supprimer un joueur
    public void deleteJoueur(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_JOUEUR, JOUEUR_KEY_ID + " = ?",new String[]{String.valueOf(id)});

    }


    public Joueur getJoueurByID(int id){
        String selectQuery = "SELECT * FROM " + TABLE_JOUEUR + " WHERE " + JOUEUR_KEY_ID + " = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        Joueur joueur = new Joueur();
        joueur.setId(c.getInt(c.getColumnIndex(JOUEUR_KEY_ID)));
        joueur.setNom_joueur(c.getString(c.getColumnIndex(JOUEUR_KEY_NOM)));
        joueur.setPrenom_joueur(c.getString(c.getColumnIndex(JOUEUR_KEY_PRENOM)));
        joueur.setNum_licence_joueur(c.getInt(c.getColumnIndex(JOUEUR_KEY_NUM_LICENCE)));
        //joueur.setEquipeId(c.getString(c.getColumnIndex(JOUEUR_KEY_EQUIPE)));

        return joueur;
    }

}
