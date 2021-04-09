package com.example.florian.fichiertexteandbddtest1;

import java.io.Serializable;

public class Equipe implements Serializable {

    private String nom_equipe;
    private String niveau_equipe;
    private int id_equipe;

    public Equipe() {
    }

    public Equipe(String nom_equipe, String niveau_equipe, int id_equipe) {
        this.nom_equipe = nom_equipe;
        this.niveau_equipe = niveau_equipe;
        this.id_equipe = id_equipe;
    }

    public String getNiveau(){return niveau_equipe;}
    public void setNiveau(String niveau_equipe){this.niveau_equipe=niveau_equipe;}

    public int getId(){return id_equipe;}
    public void setId(int id_equipe){this.id_equipe = id_equipe;}

    public String getNom(){return nom_equipe;}
    public void setNom(String nom_equipe){this.nom_equipe = nom_equipe;}
}
