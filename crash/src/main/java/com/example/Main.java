package com.example;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    heart heartless = new heart();
    System.out.println("what is your choice?");
    String input = scanner.nextLine();
    
    switch(input) {
        case"Letter":
            int i = 97;
            String words = JOptionPane.showInputDialog("input your words:");
            int[] letters = heartless.LetterCount(words);
            for(int n: letters) {
            System.out.println((char)i + " = " + n);
            i++;}
            break;
        case"duplicate":
            ArrayList<Integer> list = new ArrayList<>();
            while (true) {
                int num = Integer.parseInt(scanner.nextLine());
                list.add(num);
                if(num == 0) {
                    break;
                }
            }
            System.out.println(heartless.noduplicate(list));
            break;
        default:
            System.out.println("fym with that\nbro i just asked u your choice and you didnt even give me anything to choose.\nwtf is even " + input + " anyway????\nget out of my face or else imma call up the fucking opps" );
            break;

    }
    scanner.close();
}
}