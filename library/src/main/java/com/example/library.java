package com.example;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

class InputException extends Exception{
    public InputException(String message){
        super(message);
    }
}

class NotAvailableException extends Exception{
    public NotAvailableException(String message){
        super(message);
    }
}

public class library {
    HashMap<String, books> library = new HashMap<>();
    Scanner input = new Scanner(System.in);
    public void openlibrary() throws FileNotFoundException{
        Scanner filereader = new Scanner(new FileReader("library.txt"));
        
        while(filereader.hasNext()){
            String[] parts = filereader.nextLine().split("\\|\\|");
            String[] bookdetail = parts[1].split("\\+");
            String[] authors = bookdetail[1].split(", ");
            
            books book = new books(bookdetail[0],authors, bookdetail[2]);
            library.put(parts[0], book);
        }
        filereader.close();
        System.out.println();
    }

    public void getbook(String bookid) throws NotAvailableException{
        if(library.containsKey(bookid)) {
            books getbook = library.get(bookid);
            System.out.println("==============\nBook name: " + getbook.getName());
            System.out.println("Author: " + getbook.getAuthor());
            System.out.println("Date published: " + getbook.getDate());
        } else {
            throw new NotAvailableException("No such book exists.");
        }
    }
    
    public void allbooks() throws NotAvailableException{
        System.out.println("<<<ALL BOOKS>>>");
        for(Map.Entry<String, books> b: library.entrySet()){
            getbook(b.getKey());
            System.out.println("Book ID: " + b.getKey());
        }
    }

    public void editbook(String bookid) throws InputException, NotAvailableException{
        if(library.containsKey(bookid)) {
            books getbook = library.get(bookid);
            StringBuilder authorlist = new StringBuilder();

            System.out.println("Enter the new name of the book.");
            getbook.setName(input.nextLine());

            
            
            System.out.println("Enter the authors. Press X to wrap up.");
            while(true){
                String i = input.nextLine();
                if(i.equalsIgnoreCase("X")){
                    break;
                } else if (i.length() >= 30) {
                    throw new InputException("Author name too long.");
                }
                authorlist.append(i+ ", ");
            }
            String[] authorarray = authorlist.toString().substring(0, authorlist.length()-2).split(", ");
            getbook.setAuthors(authorarray);



            getbook.setDate(dateinput());

            System.out.println(getbook.getName());
                for(String e: authorarray){
                System.out.println(e);
                }
            System.out.println(getbook.getDate());
        } else {
            throw new NotAvailableException("No such book exists.");
        }
        
    }
    public boolean leaporcommon(int year) { // false if common, true if leap
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0); }
    
    public String dateinput() throws InputException{
        StringBuilder date = new StringBuilder();
        try{
                System.out.println("Enter the year the book has been published: ");
                int year = Integer.parseInt(input.nextLine());
                if(year > 9999 || year < 0){
                    throw new InputException("year not valid");
                }


                System.out.println("Enter the month the book has been published: ");
                int mon = Integer.parseInt(input.nextLine());
                if(mon > 12 || mon < 0){
                    throw new InputException("Month not valid.");
                }

                System.out.println("Enter the day the book has been published: ");
                int day = Integer.parseInt(input.nextLine());
                if (day < 0) {
                    throw new InputException("day not valid: below zero");
                } else if((mon == 2 && leaporcommon(year)) && day > 29){
                    throw new InputException("day not valid: beyond month");
                } else if((mon == 2 && !leaporcommon(year) && day > 28)){
                    throw new InputException("day not valid: beyond month");
                } else if ((mon == 4 || mon == 6 || mon == 9 || mon == 11) && day > 30) {
                    throw new InputException("day not valid: beyond month");
                } else if (day > 31) {
                    throw new InputException("day not valid: beyond month");
                }
                System.out.println(date);
                date.append(String.valueOf(mon) + "/" + String.valueOf(day) + "/" + String.valueOf(year));
            } catch (NumberFormatException error){
                System.out.println("integer numbers only allowed.");
            }

        return date.toString();
    }
}

