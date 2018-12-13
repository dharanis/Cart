package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {

    List<LineItem> items = null;


    public void addItem(Product product, int quantity){
        //item.setName();
        LineItem item = new LineItem(quantity,product);
        if(items == null) {
            items.add(item);
        }
        else{
            items.get(0).setQuantity(items.get(0).getQuantity()+quantity);
        }

    }

    public void decreaseQuantity(int quantity){

        if(items.get(0).getQuantity() ==1){
            items.remove(0);
        }
        else{
            items.get(0).setQuantity(items.get(0).getQuantity()-quantity);
        }
    }

    public double getDiscountedPrice(){
       double discountPrice = (items.get(0).getQuantity())*(items.get(0).getProduct().getPrice());
       items.get(0).setDiscountPrice(discountPrice);
       return discountPrice;
    }
    public int quantity()
    {
        int quantity=0;
        Iterator<LineItem> itr =items.iterator();
        while (itr.hasNext()){
            quantity +=itr.next().getQuantity();
        }
        return quantity;
    }

    public double getUnDiscountedPrice(){
        return items.get(0).getProduct().getPrice();
    }

    public double getTotalDiscountedPrice() {
        Iterator<LineItem> itr = items.iterator();
        double totalDiscountedPrice = 0.0;
        while (itr.hasNext()) {
            LineItem nextItem = itr.next();
            totalDiscountedPrice = totalDiscountedPrice + nextItem.getDiscountPrice();
        }
        return  totalDiscountedPrice;
    }
    public double getTotalPrice() {
        Iterator<LineItem> itr = items.iterator();
        double totalPrice = 0.0;
        while (itr.hasNext()) {
            LineItem nextItem = itr.next();
            totalPrice = totalPrice + nextItem.getProduct().getPrice();
        }
        return  totalPrice;
    }


    }


