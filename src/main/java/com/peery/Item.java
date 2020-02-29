package com.peery;

import java.util.Objects;

public class Item {
    private String name;
    private double price;
    private boolean onSale;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Item(String name, double price, boolean onSale){
        this.name = name;
        this.price = price;
        this.onSale = onSale;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isOnSale(){
        return onSale;
    }
}
