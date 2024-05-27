package com.java.Rasturent;

public class Helper {

    public void banner(String text){
        printMinus(text.length() * 2);
        System.out.println(text);
        printShart(text.length());
    }

    private void printShart(int count){
        for(int i=0; i<count;i++){
            System.out.print("#");
        }
        System.out.println();
    }
    private void printMinus(int count){
        for(int i=0;i<count;i++){
            System.out.print("-");
        }
        System.out.println();
    }

}
