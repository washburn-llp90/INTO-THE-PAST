package com.example;
import javax.swing.JOptionPane;

public class imperiallawn {
    public static void main(String[] args) {
        float l = Float.parseFloat(JOptionPane.showInputDialog("WELCOME! This lawn mowing season will last 30 weeks. \ninput your lawn's exact length"));
        float w = Float.parseFloat(JOptionPane.showInputDialog("input your lawn's exact width"));
        
        float SQ = (float) (l * w);
        double fee = weeklyFeeStructure(SQ);
        paymentChoice(fee);



    }

    public static double weeklyFeeStructure(float sq) {
        if(sq < 4000){
            return 250.00;
        } else if (sq < 6000) {
            return 350.00;
        } else {
            return 500.00;
        }
    }

    public static void paymentChoice(double fee){
        double a = 0.0;
        String choice = JOptionPane.showInputDialog("Press 1 for payment upfront. 2 for every 10 weeks. 3 for weekly payment.");
        switch(choice) {
            case "1":
                a = (20 * fee);
                break;
            case "2":
                fee = ((float)(float)(20 * fee) / 2) + 50;
                a = (float) fee * 2;
                break;
            case "3":
                fee += 30;
                choice = String.valueOf(20);
                a = (20 * fee);
                break;
        }

        JOptionPane.showMessageDialog(null, "NUMBER OF PAYMENTS MADE: " + choice + "\nAMOUNT PER PAYMENT: " + String.valueOf(fee) + "\nTOTAL COST OF THE SEASON: " + String.valueOf(a) );
    }
}