package com.bigrestaurant.fmi.model;

public class Date {
    private String zz;
    private String mm;
    private String aaaa;

    public Date(String zz, String mm, String aaaa) {
        this.zz = zz;
        this.mm = mm;
        this.aaaa = aaaa;
    }

    public String getDay() {
        return zz;
    }

    public String getMonth() {
        return mm;
    }

    public String getYear() {
        return aaaa;
    }

    @Override
    public String toString() {
        return zz + "/" + mm + "/" + aaaa;
    }
}
