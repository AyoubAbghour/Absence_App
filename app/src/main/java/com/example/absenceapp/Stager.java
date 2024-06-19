package com.example.absenceapp;

import java.time.LocalDateTime;

public class Stager {
    public int contour;
    public   String groupe;
    public  String  matriculeEtudiant;
    public String nom;
    private final String prenom;
    public  String nomPrenom;
    private LocalDateTime date;
    private Boolean isChecked;

    // Default constructor is necessary for Firestore


    public Stager( String groupe, String matriculeEtudiant, String nom, String nomPrenom, String prenom,int contour) {
        this.groupe = groupe;
        this.matriculeEtudiant = matriculeEtudiant;
        this.nom = nom;
        this.nomPrenom = nomPrenom;
        this.prenom = prenom;
        this.date = LocalDateTime.now();
        this.isChecked = false;
        this.contour=contour;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return  nom;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}

