package com.example.amine.ta3alom;

/**
 * Created by amine on 22-May-16.
 */
public class User {
    String username,nom,prenom;

    public User(){

    }
    public User(String username,String nom,String prenom){
        this.username=username;
        this.nom=nom;
        this.prenom=prenom;
    }

    public String getUsername() {
        return username;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
