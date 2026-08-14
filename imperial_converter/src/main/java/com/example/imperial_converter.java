package com.example;

import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayList;


class InvalidNumberException extends Exception{
    public InvalidNumberException(String message){
        super(message);
    }
}


public class imperial_converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> binary = new ArrayList<>();
        while(true){
            System.out.println("put any number");
            try{
                int number = Integer.parseInt(scanner.nextLine());
                if (number == 000){
                    break;
                }
                System.out.println("Put a number from 2-9 only.");
                int base = Integer.parseInt(scanner.nextLine());
                if (base > 9 || base < 2 ){
                throw new InvalidNumberException("A NUMBER FROM 2-9 ONLY.");}
                binary.add(convert(number, base));
                
            } catch (NumberFormatException error){
                System.out.println("NO LETTERS OR SYMBOLS. 2-9 ONLY.");
            } catch (InvalidNumberException error){
                System.out.println(error.getMessage());
            }
            
            }

            System.out.println("\n+++++++++");
            for(String e: binary){
                System.out.println(e);
            }
            
        

    }


    public static String convert(int ref, int base){
        Stack stack = new Stack<>();
        StringBuilder string = new StringBuilder();
        while(ref > 0){
        int binery = (ref % base);
        ref/= base;
        stack.push(binery);
        }

        while(!stack.isEmpty()){
            string.append(stack.pop());
        }

        return string.toString();
    }
}