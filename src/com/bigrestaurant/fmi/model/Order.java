package com.bigrestaurant.fmi.model;

import java.util.ArrayList;

public class Order {
    private static long id = 0;
    private long orderId;
    private Float totalPrice = 0f;
    private ArrayList<Item> orderedItems;

    public Order(ArrayList<Item> orderedItems) {
        this.orderedItems = orderedItems;
        orderId = Order.id;
        Order.id++;
    }

    public Float getTotalPrice() {
        for (Item i:orderedItems) {
            totalPrice += i.getPrice();
        }
        return totalPrice;
    }

    public long getOrderId() {
        return orderId;
    }
}
