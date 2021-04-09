package com.example.florian.fichiertexteandbddtest1;

import java.io.Serializable;

public class Joueur implements Serializable {

    private String nom, prenom, num_licence;
    private int id;
    private int num_joueur;

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public int getNum_joueur(){return num_joueur;}
    public void setNum_joueur(int num_joueur){this.num_joueur = num_joueur;}

    public String getNom(){return nom;}
    public void setNom(String nom){this.nom = nom;}

    public String getPrenom(){return prenom;}
    public void setPrenom(String prenom){this.prenom = prenom;}

    public String getNum_licence(){return num_licence;}
    public void setNum_licence(String num_licence){this.num_licence = num_licence;}

}
