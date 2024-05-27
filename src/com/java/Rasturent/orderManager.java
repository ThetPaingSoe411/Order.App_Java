package com.java.Rasturent;

import java.util.Scanner;

public class orderManager {
    private Helper h;
    private orderDOC orderDOC;
    private Scanner input;
    public orderManager(){
        h = new Helper();
        input = new Scanner(System.in);
        orderDOC = new orderDOC();
    }
    public void Main(){
       h.banner("Welcom From App");
       while(true){
           System.out.println("1. add Order");
           System.out.println("2. Show OrderList");
           System.out.println("3. Show Order By OrderCode");
           System.out.println("4. Update Order");
           System.out.println("5. Delete Order");
           System.out.println("0 Exists");
           System.out.print("Enter your option : ");
           int option = input.nextInt();
           switch (option){
               case 1:
                   h.banner("Order");
                   Order();
                   break;
               case 2:
                   h.banner("OrderList");
                   show();
                   break;
               case 3:
                   h.banner("Order By OrderCode");
                   searchOrderById();
                   break;
               case 4:
                   h.banner("Update Order");
                   updateOrderById();
                   break;
               case 5:
                   h.banner("Delete Order");
                   deleteOrder();
                   break;
               case 0:
                   System.exit(0);
           }
       }
       }
  private void Order(){
        input.nextLine();
      System.out.print("Enter name : ");
      String name = input.nextLine();
      System.out.print("Enter price : ");
      double price = input.nextDouble();
      orderDOC.addOrder(new Order(generateId(),name,price));
      System.out.println("Order Add Success");
  }
  private void show(){
        MyArray orders = orderDOC.ShowOrder();
        for(int i=0;i<orders.getOrderCount();i++){
            Order order = (Order) orders.get(i);
            System.out.println(order.displayOrder());
        }
  }

  private void searchOrderById(){
      System.out.print("Enter code to search : ");
      int id = input.nextInt();
      MyArray orders = orderDOC.ShowOrder();
      if(!orders.isEmpty()){
          Order order = searchId(id);
          System.out.println(order.displayOrder());
      }
  }
  private void updateOrderById(){
      System.out.print("Enter id to update item : ");
      int id = input.nextInt();
      input.nextLine();
      Order order = searchId(id);
      System.out.println(order.displayOrder());
      System.out.print("Enter name to update : ");
      String updateName = input.nextLine();
      System.out.print("Enter price to update : ");
      double updatePrice = input.nextDouble();
      orderDOC.updateOrder(new Order(id,updateName,updatePrice));
      System.out.println("Order Updating Success");
  }

  private void deleteOrder(){
      System.out.print("Enter ordre id to delete : ");
      int id = input.nextInt();
      Order order = searchId(id);
      System.out.println(order.displayOrder());
      orderDOC.deleteOrder(id);
      System.out.println("Order deleting Success");
  }


 private Order searchId(int sId){
        Order order = null;
        MyArray orders = orderDOC.ShowOrder();
        for(int i=0;i<orders.getOrderCount();i++){
            Order sOrder = (Order) orders.get(i);
            if(sOrder.getId() == sId){
                order = sOrder;
                break;
            }
        }
        return order;
 }
    private int generateId(){
        MyArray orders = orderDOC.ShowOrder();
        if(!orders.isEmpty()){
            Order lastOrder = (Order) orders.get(orders.getOrderCount()-1);
            return lastOrder.getId()+1;
        }
        return 1001;
    }

}
