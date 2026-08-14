package com.example;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args){
        library library = new library();
        Scanner scanner = new Scanner(System.in);
        boolean x = true;
        try {
            while(x){
                library.openlibrary();
                System.out.println("====HI! Welcome to Lance's Library!====\nPress 1 to add a new book.\nPress 2 to view all books.\nPress 3 to change a book's details.\nPress 4 to scan a book's id.\nPress anything to exit.");
                switch(scanner.nextLine()){
                case"1":
                
                break;
                case"2":
                library.allbooks();
                break;
                case"3":
                while(true){
                    System.out.println("Please input the book's id. Press Return to leave edit mode");
                    String input = scanner.nextLine();
                    if(input.equalsIgnoreCase("return")){
                        break;
                    }
                    library.editbook(input);
                }
                break;
                case"4":
                while(true){
                    System.out.println("Please input the book's id. Press Return to leave scan mode");
                    String input = scanner.nextLine();
                    if(input.equalsIgnoreCase("return")){
                        break;
                    }
                    library.getbook(input);
                }
                break;
                default:
                x = false;
                break;
            }
            }
        } catch (FileNotFoundException error) {
            System.out.println("cannot find the library. please check.");
        } catch (NotAvailableException error) {
            System.out.println(error.getMessage());
        } catch (InputException error) {
            System.out.println(error.getMessage());
        }

    }

}