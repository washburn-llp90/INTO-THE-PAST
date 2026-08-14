package com.example;
import java.util.HashMap;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hashmap test!!");
        HashMap<Integer, String> list = new HashMap<>();

        while(true){
            String name = JOptionPane.showInputDialog("PUT IN YOUR NAME:").trim();
            if(name.equalsIgnoreCase("exit")) {
                break;
            }
            int id = Integer.parseInt("20" + (int) (Math.random() * 10000));
            System.out.println(id);
            list.put(id, name);
            JOptionPane.showMessageDialog(null, "name: " + name + " id: " + id );
        }

        
        Integer input = Integer.parseInt(JOptionPane.showInputDialog("input your id number"));
        if(list.get(input) != null) {
            JOptionPane.showMessageDialog(null, "welcome, " + list.get(input));
        } else{
            JOptionPane.showMessageDialog(null, "wrong p5assword.");
        }
        
    }
}