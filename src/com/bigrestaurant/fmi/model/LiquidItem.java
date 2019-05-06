package com.bigrestaurant.fmi.model;

import java.util.Date;

public class LiquidItem extends Item{

    private Float liquidAmount; // Measured in ml
    private Boolean alcoholic = false;
    private Float alcoholAmount = 0f;

    public LiquidItem(String name, Price price, Date dateAdded, Integer timeToCook, Float liquidAmount, Boolean alcoholic, Float alcoholAmount) {
        super(name, price, dateAdded, timeToCook);
        this.liquidAmount = liquidAmount;
        this.alcoholic = alcoholic;
        if( alcoholic )
            this.alcoholAmount = alcoholAmount;
    }

    public String toString(){
        return super.toString() + "  -  " + liquidAmount.toString() + "ml";
    }
}
