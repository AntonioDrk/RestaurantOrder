package com.bigrestaurant.fmi.model;

import java.util.Date;

public class FoodItem extends Item{

    private Float quantity; // In grams

    public FoodItem(String name, Price price, Date dateAdded, Integer timeToCook, Float quantity) {
        super(name, price, dateAdded, timeToCook);
        this.quantity = quantity;
    }

    public String toString(){
        return super.toString() + "  -  " + quantity.toString() + "g";
    }
}
