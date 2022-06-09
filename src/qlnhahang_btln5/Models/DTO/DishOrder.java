/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Models.DTO;

import qlnhahang_btln5.Models.Dish;

/**
 *
 * @author HaPhong
 */
public class DishOrder extends Dish{
    
    private int quantity;
    
    public double getMoney(){
        return price*quantity;
    }
    
    public DishOrder(int quantity, int idDish, String name, double price) {
        super(idDish, name, price);
        this.quantity = quantity;
    }

    public DishOrder(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        DishOrder dishOrder= (DishOrder) obj;
        return this.idDish== dishOrder.getIdDish();
    }
    
    
    
    
}
