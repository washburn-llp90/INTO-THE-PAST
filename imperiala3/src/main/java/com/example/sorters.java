package com.example;
import java.util.ArrayList;

public class sorters {
    public static long insertion(ArrayList<Integer> list) {
    int a, b, temp;
    long count = 0;
    for (a = 1; a < list.size(); a++) {
        temp = list.get(a);
        for(b = a-1; b >= 0; b--) {
            count++; 
            if(list.get(b) > temp) {
                list.set(b + 1, list.get(b));
            } else {
                break;
            }
        }
        list.set(b + 1, temp);
    }
    return count;
}
    public static long selection(ArrayList<Integer> list) {
    int a, b, smallest, temp;
    long count = 0;

    for(a = 0; a < list.size() - 1; a++) {
        smallest = a;
        for(b = a + 1; b < list.size(); b++) { 
            if (list.get(b) < list.get(smallest)) {
                smallest = b; 
            }
        }
        
        temp = list.get(a);
        list.set(a, list.get(smallest));
        list.set(smallest, temp);
        count++; 
    }
    return count;
    }

    public static long bubble(ArrayList<Integer> list) {
    int a, b, temp;
    long count = 0;
    boolean swapped;

    for (a = 0; a < list.size() - 1; a++) {
        swapped = false;
        for (b = list.size() - 1; b > a; b--) {
            if (list.get(b - 1) > list.get(b)) {
                temp = list.get(b - 1);
                list.set(b - 1, list.get(b));
                list.set(b, temp);
                count++;
                swapped = true; 
            }
        }

        if (!swapped) {
            break; 
        }
    }
    return count;
}

    
}
