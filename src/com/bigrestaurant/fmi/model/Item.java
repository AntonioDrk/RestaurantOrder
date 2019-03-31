package com.bigrestaurant.fmi.model;

import org.jetbrains.annotations.Contract;

public class Item {

    private String name;
    private String description;

    private Price price;
    private Date dateAdded;

    private Integer timeToCook = -1;

    public Item(String name, Price price, Date dateAdded, Integer timeToCook) {
        this.name = name;
        this.price = price;
        this.dateAdded = dateAdded;
        this.timeToCook = timeToCook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price.getPrice();
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Integer getTimeToCook() {
        return timeToCook;
    }

    public void setTimeToCook(Integer timeToCook) {
        this.timeToCook = timeToCook;
    }
}
