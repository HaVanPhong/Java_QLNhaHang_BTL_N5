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
public class ExpenseDetail {
    private int idExpDetail;
    private int quantity;
    private double price;
    private String type;
    private int idExp;
    private int id_type;

    public ExpenseDetail(int idExpDetail, int quantity, double price, String type, int idExp, int id_type) {
        this.idExpDetail = idExpDetail;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.idExp = idExp;
        this.id_type = id_type;
    }

    public ExpenseDetail() {
    }

    public int getIdExpDetail() {
        return idExpDetail;
    }

    public void setIdExpDetail(int idExpDetail) {
        this.idExpDetail = idExpDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int idEquip) {
        this.id_type = idEquip;
    }
    
    
}
