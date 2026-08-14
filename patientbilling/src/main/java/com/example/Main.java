package com.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("-------Welcome to Ateneo Clinic!-------\n Please Put in your firstmost and last name.");
        String name = scanner.nextLine();
        String[] splitname = name.trim().split(" ");
        String patientid = 50 + String.valueOf(Math.round(Math.random() *10000)) + 101;
        
        System.out.println("\n Hello, " + splitname[0] + "! Next, please put in your age: ");
        int age = Integer.parseInt(scanner.nextLine());



        System.out.println("\nNext, please put in the name of your doctor, ENTER and their specialization.");
        String docname = scanner.nextLine();
        String[] docsplitname = docname.trim().split(" ");
        String spec = scanner.nextLine();


        Doctor doctor = new Doctor(docsplitname[0], docsplitname[1], spec);
        Patient patient = new Patient(splitname[0], splitname[1], Integer.parseInt(patientid), age, doctor.displayName());

        double pharmacyCharges = 0.0;
        double fee = 0.0;
        double roomCharges = 0.0;


        try{
            System.out.println("now, input your doctor's fee. ");
            fee = Integer.parseInt(scanner.nextLine());
            while (true) {
                System.out.println("input your prescription cost. press 0 to leave.");
                double presc = Double.parseDouble(scanner.nextLine());
                if(presc == 0.0) { break;}
                System.out.println("how many?");
                int amount = Integer.parseInt(scanner.nextLine());
                presc *= amount;
                pharmacyCharges += presc;
            }
            System.out.println("--rooms!!!--\npress 1 for ward\npress 2 for semi-private\npress 3 for private\npress 4 for executive/suite");
            int roomchoice = Integer.parseInt(scanner.nextLine());
            switch(roomchoice){
                case 1:
                roomCharges = 900.0;
                break;
                case 2: roomCharges = 1400.0;
                break;
                case 3:roomCharges = 2500.0;
                break;
                case 4:roomCharges = 4500.0;
                break;
            }
            } catch (NumberFormatException error) {
                System.out.println("WHY DID YOU PUT IN A LETTER!?!?!\nHUH????\nRESTART BACK TO ZERO!!");
            }
            Billing billing = new Billing(patient.getPatientID(), pharmacyCharges, fee, roomCharges);
            System.out.println("====HOSPITAL BILLINGS FOR THE ATENEAN CLINICS=====\n");
            System.out.println("Patient ID: " + patient.getPatientID());
            System.out.println("Patient name: " + patient.displayName());
            System.out.println("Patient Age: " +patient.getAge());
            System.out.println("Assigned Doctor: " + doctor.displayName());
            System.out.println(doctor.getspec() + "\n");
            System.out.println("--charges--\n" + "pharmacy: " + billing.getPharmacyCharges());
            System.out.println("doctor's fee:" + billing.getDoctorsFee());
            System.out.println("room charges: " + billing.getRoomCharges());
            System.out.println("TOTAL: " + billing.total());

    }
}