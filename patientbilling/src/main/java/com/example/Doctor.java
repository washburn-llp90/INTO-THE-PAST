package com.example;


public class Doctor extends Person{
    String specialization;

    public Doctor(String f, String l, String s){
        super(f, l);
        this.specialization = s;
    }
    public void setspec(String s){
        this.specialization = s;
    }
    public String getspec(){
        return specialization;
    }
}