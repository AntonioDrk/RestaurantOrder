package com.bigrestaurant.fmi.model;

public class LiquidItem extends Item{

    private Float liquidAmount; // Measured in ml
    private Boolean alcoholic = false;
    private Float alcoholAmount = 0f;

    public LiquidItem(String name, Price price, Date dateAdded, Integer timeToCook, float liquidAmount) {
        super(name, price, dateAdded, timeToCook);
        this.liquidAmount = liquidAmount;
    }

    public LiquidItem(String name, Price price, Date dateAdded, Integer timeToCook, Float liquidAmount, Boolean alcoholic, Float alcoholAmount) {
        super(name, price, dateAdded, timeToCook);
        this.liquidAmount = liquidAmount;
        this.alcoholic = alcoholic;
        if( alcoholic )
            this.alcoholAmount = alcoholAmount;
    }
}
