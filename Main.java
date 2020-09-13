package com.company;
import java.io.*;
import java.util.*;

public class Main {
    private final static String file = "C:\\Users\\knopa\\Desktop\\text.txt";
    private static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) {
        read();
        print();
    }
    private static void read(){
        try (BufferedReader bf = new BufferedReader(new FileReader(new File(file)))){
            String line;
            while ((line = bf.readLine()) != null){
                List<String> wordsInLine = Arrays.asList(line.split("[0-9!@#$%^&*()~?<>;:,.\"'/`\\\n\t\r +-=]", 0));
                for (String word : wordsInLine){
                    String current = beautify(word);
                    if(incorrectString(current)){
                        continue;
                    }
                    words.add(current);
                }

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void print(){
        for(String word : words){
            System.out.print(word + " ");
        }
    }
    private static boolean incorrectString(String string){
        if(words.contains(string) || string.isEmpty()){
            return true;
        }
        for (int i = 0; i < string.length() - 1; i++){
            char first = string.charAt(i);
            for (int j = i + 1; j < string.length(); j++){
                if(first == string.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
    private static String beautify(String string){
        string = string.trim().toLowerCase();
        if(string.length() > 30){
            string = string.substring(0, 30);
        }
        return string;
    }
}
