package com.zsgs.librarymanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Book {
   private String name;
    private String author;
    private int publication;
    private long id;
    private int edition;
    private int availability;
  //  private String journer;
   private int volume;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getAvailability() {
        return availability;
    }

    public int getisAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

//    public String getJourner() {
//        return journer;
//    }
//
//    public void setJourner(String journer) {
//        this.journer = journer;
//    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
