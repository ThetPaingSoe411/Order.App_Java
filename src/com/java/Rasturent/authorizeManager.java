package com.java.Rasturent;

import java.util.Scanner;

public class authorizeManager {
    private Helper h;
    private authorizeDOC authorizeDOC;
    private orderManager orderManager;
    private Scanner input;

    public authorizeManager(){
        h = new Helper();
        authorizeDOC = new authorizeDOC();
        orderManager = new orderManager();
        input = new Scanner(System.in);
    }

    public void login(){

        h.banner("Login Page");
        MyArray authorizes = authorizeDOC.displayAuthorize();
        System.out.print("Enter name : ");
        String name = input.nextLine();
        System.out.print("Enter password : ");
        String password = input.nextLine();
       if(!authorizes.isEmpty()){
           for(int i=0;i<authorizes.getOrderCount();i++) {
               Authorize authorize = (Authorize) authorizes.get(i);
              if(authorize.getId() != authorize.getId()){
                  System.out.println("User Accout not found! Please Try again.....");
              }else{
                  while (name.equals(authorize.getName()) && password.equals(authorize.getPassword())) {
                      System.out.println("Login Success");
                      orderManager.Main();
                      break;
                  }
              }
           }
       }else{
           System.out.println("There is no users account.....");
       }
    }
    public void Registor(){
        h.banner("Registor Page");
        System.out.print("Enter name : ");
        String name = input.nextLine();
        System.out.print("Enter email : ");
        String email = input.nextLine();
        System.out.print("Enter password : ");
        String password = input.nextLine();
        System.out.print("Enter confirmPassord : ");
        String confirmPassword = input.nextLine();
     if(password.equals(confirmPassword)){
         authorizeDOC.addAuthorize(new Authorize(generateId(),name,email,password,confirmPassword));
         System.out.println("Account Creation Success...");
     }else{
         System.out.println("Password and confirmPassword are not equal.....");
     }
    }

    private int generateId(){
        MyArray authorizes = authorizeDOC.displayAuthorize();
        if(!authorizes.isEmpty()){
            Authorize lastAuthorize = (Authorize) authorizes.get(authorizes.getOrderCount()-1);
            return lastAuthorize.getId()+1;
        }
        return 1;
    }


}
