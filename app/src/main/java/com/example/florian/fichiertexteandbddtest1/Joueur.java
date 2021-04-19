package com.example.florian.fichiertexteandbddtest1;

import java.io.Serializable;

public class Joueur implements Serializable {

    private String nom_joueur;
    private String prenom_joueur;
    private String num_licence_joueur;
    private int id_equipe_joueur;
    private int id;


    public Joueur() {
    }

    public Joueur(String nom_joueur, String prenom_joueur, String num_licence_joueur, int id_equipe_joueur, int id) {
        this.nom_joueur = nom_joueur;
        this.prenom_joueur = prenom_joueur;
        this.num_licence_joueur = num_licence_joueur;
        this.id_equipe_joueur = id_equipe_joueur;
        this.id = id;
    }

    public String getNom_joueur() {
        return nom_joueur;
    }

    public void setNom_joueur(String nom_joueur) {
        this.nom_joueur = nom_joueur;
    }

    public String getPrenom_joueur() {
        return prenom_joueur;
    }

    public void setPrenom_joueur(String prenom_joueur) {
        this.prenom_joueur = prenom_joueur;
    }

    public String getNum_licence_joueur() {
        return num_licence_joueur;
    }

    public void setNum_licence_joueur(String num_licence_joueur) {
        this.num_licence_joueur = num_licence_joueur;
    }

    public int getId_equipe_joueur() {
        return id_equipe_joueur;
    }

    public void setId_equipe_joueur(int id_equipe_joueur) {
        this.id_equipe_joueur = id_equipe_joueur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

