package com.bigrestaurant.fmi.model;

public class Price {
    Float price;
    Float discountAmount = 0f;

    public Price(Float price) {
        this.price = price;
    }

    public Price(Float price, Float discountAmount) {
        this.price = price;
        this.discountAmount = discountAmount;
    }

    public Float getPrice(){
        if(discountAmount == 0){
            return price;
        }else{
            return price - (price * discountAmount) ;
        }
    }

    public Float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Float discountAmount) {
        this.discountAmount = discountAmount;
    }
}
