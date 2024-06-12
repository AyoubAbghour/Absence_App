package com.example.absenceapp;

import java.time.LocalDateTime;

public class Stager {
    private String nom;
    private String prenom;
    private LocalDateTime date;
    private Boolean isChecked;

    public Stager(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.date = LocalDateTime.now();
        this.isChecked = false;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
