package com.bigrestaurant.fmi.model;

public class FoodItem extends Item{

    private Float quantity; // In grams

    public FoodItem(String name, Price price, Date dateAdded, Integer timeToCook, Float quantity) {
        super(name, price, dateAdded, timeToCook);
        this.quantity = quantity;
    }


}
