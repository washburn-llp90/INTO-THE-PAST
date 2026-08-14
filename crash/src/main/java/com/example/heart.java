package com.example;
import java.util.ArrayList;
public class heart {
    public int[] LetterCount (String e) {
        int[] StringInput = new int[27];
        try {
        for(int a = 0; a < e.length(); a++) {
            char letter = e.toLowerCase().charAt(a);
            if (letter >= 'a' && letter <= 'z') {
                StringInput[(char)(letter - 97)]++;
            } else {
                StringInput[26]++;
            }
        }
        return StringInput;
        } catch (Exception x) {
            System.out.println("ERROR! It went wrong because of: " + x.getMessage());
            return StringInput;
        }
        
    }

    public String noduplicate(ArrayList<Integer> e) {
        StringBuilder output = new StringBuilder();
        for(int num : e){
            e.get(num);
            if((output.indexOf(String.valueOf(num))) != -1) {
                System.out.println("Dupe found!");
            } else {
                output.append(num + ", ");
        }
    }
    output.deleteCharAt(output.length() - 2);
    return output.toString();
    
}
}