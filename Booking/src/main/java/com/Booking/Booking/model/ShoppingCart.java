package com.Booking.Booking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ShoppingCart  {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

   
    private Long userId;
    
    
    private ArrayList<Long> itemInCartList;


    public ShoppingCart(){
        
    }

    public ShoppingCart( Long userId, ArrayList<Long> itemInCartList) {
        this.userId =userId;
        this.itemInCartList = itemInCartList;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getItemInCartList() {
        return this.itemInCartList;
    }

    public void setItemInCartList(ArrayList<Long> ItemInCartList) {
        this.itemInCartList = ItemInCartList;
    }

    public void addOneItemInCart(Long adv){
        this.itemInCartList.add(adv);
    }

    public void removeOneItemInCart(Long adv){
        this.itemInCartList.remove(adv);
    }

    public void removeAllItems(){
        this.itemInCartList.clear();
    }

   

}