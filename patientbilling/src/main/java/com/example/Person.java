package com.example;


public class Person {
    String firstname;
    String lastname;
    
    public Person() {
        this.firstname = "John";
        this.lastname = "Doe";
    }

    public Person(String first, String last) {
        this.firstname = first;
        this.lastname = last;
    }

    public String displayName(){
        return firstname + " " + lastname;
    }

    public void setName(String first, String last) {
        firstname = first;
        lastname = last;
    }
    public String getfirstname() {
        return firstname;
    }
    public String getlastname() {
        return lastname;
    }
}