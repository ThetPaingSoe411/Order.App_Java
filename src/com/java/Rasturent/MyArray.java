package com.java.Rasturent;
import java.lang.*;
public class
MyArray {
    private Object[] orders;
    private int orderCount;

    public MyArray(int size){
        orders = new Object[size];
        orderCount =0;
    }
    public int getOrderCount(){
        return  orderCount;
    }
    public void add(Object data){
        if(orderCount < orders.length){
            orders[orderCount] =  data;
           orderCount++;
        }
    }
    public Object get(int id) {
        if (id >= 0 && id < orderCount) {
            return orders[id];
        }
        return null;
    }
    public void remove(int id){
        if(id >= 0 && id<orderCount){
            for(int i=id;i<orderCount;i++){
                orders[i] = orders[i+1];
            }
            orderCount--;
        }
    }


    public boolean isEmpty(){

        return orderCount ==0;
    }

}
