/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Models;

/**
 *
 * @author HaPhong
 */
public class Dish {
    protected int idDish;
    protected String name;
    protected double price;

    public Dish(int idDish, String name, double price) {
        this.idDish = idDish;
        this.name = name;
        this.price = price;
    }
    public Dish( String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Dish() {
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
    
    
    
}
