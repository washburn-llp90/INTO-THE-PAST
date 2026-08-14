package com.example;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        String[] wordshelves = new String[4];
        FileWriter writer = new FileWriter("shittext.txt", true);
        Scanner scanner = new Scanner(new FileReader("shittext.txt"));
        while(true){
            String input = JOptionPane.showInputDialog("type in your shit");
            if(input.equalsIgnoreCase("exit")) {
                writer.close();
                break;
            } else {
                writer.append(input).append("\n");
            }
        }
        while(scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();

        for(int i = 0; i < 4; i++){
            wordshelves[i] = "";
        }
        for(String e: words){
            if (e.length() % 2 != 0 && "revelation".indexOf(e.charAt(e.length() / 2)) != -1) {
                wordshelves[1] += (e + " ");
            } else if (e.length() > 5 && "apocrypha".indexOf(e.charAt(e.length() - 1)) == -1) {
                wordshelves[2] += (e + " ");
            } else if (e.length() > 5 && "apocrypha".indexOf(e.charAt(e.length() - 1)) != -1) {
                wordshelves[0] += (e + " ");
            } else {
                wordshelves[3] += (e + " ");
            }
        }
        int g = 1;
        for(String f: wordshelves) {
            System.out.println("G"+ g+ ": " + f);
            g++;
        }
    }
}