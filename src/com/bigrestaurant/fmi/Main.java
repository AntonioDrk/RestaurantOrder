package com.bigrestaurant.fmi;

import com.bigrestaurant.fmi.services.OrderService;

public class Main {

    public static void main(String[] args) {
        OrderService orderService = OrderService.getInstance();
    }
}
