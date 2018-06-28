/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.christiana.ics4u.u4;

import java.util.Objects;

/**
 *
 * @author 1wuchr
 */
public class Book {
    //Class contents 
    final static String[] GENRES = { "Fiction", "Non-Fiction"} ;
    final static String PUBLISHER = "GWP";
            
    //Class Variables 
    private static long lastID = 0;
    
    //Object variable 
    

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
    
    public int getGenreID() {
        return genreID;
    }
    
    public String getGenre() {
        
        return GENRES[genreID];
    }

    public void setGenreID(int genreID) {
        if (genreID <0 || genreID < GENRES.length-1){
            //UNKNOWN GENRE
            this.genreID = 0;
        }else{
            this.genreID = genreID;
        }
        //to foce the user to evaluate
    }
    private String author;//or
    private String[] authors;
    private long id; 
    private String title;
    private int pages;
    private int edition;
    private int genreID;

    
    
    //Constucturs 
    //First constuctre out empty 
    //Second type of construcutre that holds that id 
    public Book() {
    }
    
    public Book(long id) {
        this.id = id;
    }
    public Book(String title, int edition, String author) {
        this.title = title;
        this.edition = edition;
        this.author = author;
        //this.id = ++lastID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.edition != other.edition) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
    
    
    //IMPORTANT: the differenrce betweeen == and .equals 
    //IMPORTANT: primary Key this idetifies one object (it is like the id it 
    //dieranciates things that might look or have the same name
    //There is a SECONDARY KEY 

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", edition=" + edition + ", author=" + author + ", authors=" + authors + '}';
    }

    
    
    
    
    
   
    
    
    
}
