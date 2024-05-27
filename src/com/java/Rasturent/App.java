package com.java.Rasturent;

import java.util.Scanner;

public class App {
    private static authorizeManager authorizeManager;
    private static Scanner input;
    public static void main(String[] args) {
        Helper h = new Helper();
        text();
    }

    public static void text() {
        input = new Scanner(System.in);
        authorizeManager = new authorizeManager();
        System.out.println("Reasturant App");
        System.out.println("==================");
        int option;
        do{
            System.out.println("1. login");
            System.out.println("2. Registor");
            System.out.println("0. Exists");
            System.out.print("Enter your option : ");
             option = input.nextInt();
            if (option == 1) {
                authorizeManager.login();
            } else if (option == 2) {
                authorizeManager.Registor();
            }else if(option == 0){
                System.out.println("Program exists...");
            } else {
                System.out.println("Invalid option .Try again.....");
            }
        }while(option != 0);
        }
    }



