package com.peery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {

    List<LineItem> items = new ArrayList<>();
    public List getItems() {
        return Collections.emptyList();
    }


    public double getTotalPrice() {
        double totalPrice = 0.0;

        for (LineItem lineItem: items){
            totalPrice += lineItem.item.getPrice() * lineItem.quantity;
        }
        return totalPrice;
    }

    public void addItem(Item item) {
        items.add(new LineItem(item,1));
    }

    public void addItem(Item item, int quantity){
        items.add(new LineItem(item, quantity));
    }

    public List itemizedList() {
        List<String> itemizedList = new ArrayList<>();

        for (LineItem lineItem : items) {
            itemizedList.add(lineItem.item.getName() + " - $" + lineItem.item.getPrice());
        }
        return itemizedList;
    }

        public List<String> ItemQuantities() {
            List<String> quantities = new ArrayList<>();

            for(LineItem lineItem : items){
                quantities.add(lineItem.toString());
            }
            return quantities;
        }


    public List<String> onSaleItems(){
        List<String> onSaleItems = new ArrayList<>();

        for(LineItem lineItem : items){
            if(lineItem.item.isOnSale()){
                onSaleItems.add(lineItem.item.getName() + " - $" + lineItem.item.getPrice());
            }
        }
        return onSaleItems;
    }

     class LineItem {

          Item item;
          int quantity;

         public LineItem(Item item, int quantity) {
             this.item = item;
             this.quantity = quantity;
         }

         @Override
         public String toString(){
             return item.getName() + " - " + quantity;
         }
    }
}
