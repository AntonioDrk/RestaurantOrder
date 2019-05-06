package com.bigrestaurant.fmi.model;

import java.util.ArrayList;
import java.util.Collections;

public class Order implements Comparable<Order>{
    private static long id = 0;
    private long orderId;
    private ArrayList<Item> orderedItems;

    public Order(ArrayList<Item> orderedItems) {
        this.orderedItems = orderedItems;
        orderId = Order.id;
        Order.id++;
    }

    public Float getTotalPrice() {
        Float totalPrice = 0f;
        for (Item i:orderedItems) {
            totalPrice += i.getPrice();
        }
        return totalPrice;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nOrder id: ");
        stringBuilder.append(id);
        stringBuilder.append('\n');
        for(Item item: orderedItems){
            stringBuilder.append(item.toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public long getOrderId() {
        return orderId;
    }

    public Float getTotalDuration(){
        Float totalTimeToCook = 0f;
        for(Item i:orderedItems){
            totalTimeToCook += i.getTimeToCook();
        }

        return totalTimeToCook;
    }

    public ArrayList<Item> getSortedItemsTime(){
        ArrayList<Item> sortedItemsTime = orderedItems;
        Collections.sort(sortedItemsTime);
        return sortedItemsTime;
    }

    @Override
    public int compareTo(Order o) {
        return this.getTotalDuration().compareTo(o.getTotalDuration());
    }
}
