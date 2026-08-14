package com.example;


public class Patient extends Person {
    int patientID;
    int age;
    String attendingPhysician;

    public Patient(String f, String l, int ID, int age , String phy) {
        super(f, l);
        this.patientID = ID;
        this.age = age;
        this.attendingPhysician = phy;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAttendingPhysician() {
        return attendingPhysician;
    }

    public void setAttendingPhysician(String attendingPhysician) {
        this.attendingPhysician = attendingPhysician;
    }
    
    
    
}