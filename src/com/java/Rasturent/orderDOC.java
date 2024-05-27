package com.java.Rasturent;

import java.io.*;

public class orderDOC {
    private File orderfile;

    public orderDOC(){
        orderfile = new File("C:\\Users\\User\\IdeaProjects\\Rasturent.App\\src\\File\\database.txt");
    }


    public void addOrder(Order order){
        MyArray orders = loadAllOrderToFile();
        orders.add(order);
        writeAllOrderToFile(orders);
    }

    public MyArray ShowOrder(){
        return loadAllOrderToFile();
    }

    public void updateOrder(Order order){
        MyArray orders = loadAllOrderToFile();
        if(!orders.isEmpty()){
            for(int i=0;i<orders.getOrderCount();i++){
                Order uOrder = (Order) orders.get(i);
                if(order.getId() == uOrder.getId()){
                    uOrder.setName(order.getName());
                    uOrder.setPrice(order.getPrice());
                }
            }
        }
        writeAllOrderToFile(orders);
    }
   public void deleteOrder(int id){
        MyArray orders = loadAllOrderToFile();
        for(int i=0;i<orders.getOrderCount();i++){
            Order order = (Order) orders.get(i);
            if(order.getId() == id){
                orders.remove(i);
            }
        }
        writeAllOrderToFile(orders);
   }

   private void writeAllOrderToFile(MyArray orders){
        try(
                BufferedWriter writer = new BufferedWriter(new FileWriter(orderfile))
                ){
            if(!orders.isEmpty()){
                for(int i=0;i<orders.getOrderCount();i++){
                    Order order = (Order) orders.get(i);
                    writer.write(order.displayOrder());
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
   }
   private MyArray loadAllOrderToFile(){
        MyArray orders = new MyArray(50);
        try(
                BufferedReader reader = new BufferedReader(new FileReader(orderfile))
                ){
            String line;
            while((line = reader.readLine()) != null){
                String[] lines = line.split(" ");
                int id = Integer.parseInt(lines[0]);
                String name = lines[1];
                double price = Double.parseDouble(lines[2]);
                orders.add(new Order(id,name,price));
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
       return orders;
   }
}
