package com.example.amine.ta3alom;

/**
 * Created by amine on 21-May-16.
 */
public class Chat {

    private String message;
    private String author;
    private String lu;
    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private Chat() {
    }

    Chat(String message, String author){//,String lu) {
        this.message = message;
        this.author = author;
        //this.lu=lu;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
   /* public String getLu() {return lu;
    }

    public void setLu(String lu) {
        this.lu = lu;
    }*/
}