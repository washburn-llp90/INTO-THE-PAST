package com.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("numbers.txt"));
        ArrayList<Integer> list = new ArrayList();
        sorters sort = new sorters();

        while(scanner.hasNextLine()) {
            list.add(Integer.parseInt(scanner.nextLine()));
        }
        ArrayList<Integer> list2 = new ArrayList(list);
        ArrayList<Integer> list3 = new ArrayList(list);
        System.out.println(sort.insertion(list));
        System.out.println(sort.selection(list2));
        System.out.println(sort.bubble(list3));
    }
}