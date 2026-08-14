package com.example;


public class Billing {
    int patientID;
    double pharmacyCharges;
    double doctorsFee;
    double roomCharges;

    public Billing(int patientID, double pharmacyCharges, double doctorsFee, double roomCharges) {
        this.patientID = patientID;
        this.pharmacyCharges = pharmacyCharges;
        this.doctorsFee = doctorsFee;
        this.roomCharges = roomCharges;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public double getPharmacyCharges() {
        return pharmacyCharges;
    }

    public void setPharmacyCharges(double pharmacyCharges) {
        this.pharmacyCharges = pharmacyCharges;
    }

    public double getDoctorsFee() {
        return doctorsFee;
    }

    public void setDoctorsFee(double doctorsFee) {
        this.doctorsFee = doctorsFee;
    }

    public double getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }
    
    public double total(){
        return pharmacyCharges + doctorsFee + roomCharges;
    }
    
}