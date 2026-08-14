package com.example;
public class books {
    String name;
    String[] author;
    String date;

    public books(String n, String[] a, String d){
        this.name = n;
        this.author = a;
        this.date = d;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        String authorlist = "";
        for(String a: author){
            authorlist += (a + ", ");
        }
        return authorlist.substring(0, authorlist.length()-2);
    }

    public String getDate(){
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(String[] a){
        this.author = a;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}