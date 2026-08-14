package com.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        encryptlord encrypt = new encryptlord(scanner.nextLine());
        encrypt.turntobinary();
        for(int i = 0; i < 4; i++){
            System.out.println(encrypt.getparts(i));
        }
        System.out.println("\n");
        encrypt.pswdcycler();
        for(int i = 0; i < 4; i++){
            System.out.println(encrypt.getparts(i));
        }
        

    }
}