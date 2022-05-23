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
    private int price;
    private String type;
    private int idExp;
    private int idEquip;
    private int idMat;

    public ExpenseDetail(int idExpDetail, int quantity, int price, String type, int idExp, int idEquip, int idMat) {
        this.idExpDetail = idExpDetail;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.idExp = idExp;
        this.idEquip = idEquip;
        this.idMat = idMat;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public int getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    public int getIdMat() {
        return idMat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }
    
    
    
}
