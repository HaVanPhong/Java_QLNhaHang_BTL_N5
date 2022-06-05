/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import qlnhahang_btln5.Controller.SQLProcessing;

/**
 *
 * @author HaPhong
 */
public class ExpenseDetail {
    private int idExpDetail;
    private int idExp;
    private int idType;
    private String type;
    private int quantity;
    private double price;
    private String goodsName;
    

    public ExpenseDetail(int idExpDetail, int idExp, int idType, String type, int quantity, double price) {
        this.idExpDetail = idExpDetail;
        this.idExp = idExp;
        this.idType = idType;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }
    
     public ExpenseDetail(int idExpDetail, int idExp, int idType, String type, int quantity, double price, String goodsName) {
        this.idExpDetail = idExpDetail;
        this.idExp = idExp;
        this.idType = idType;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.goodsName = goodsName;
    }

    public ExpenseDetail() {
    }

    public int getIdExpDetail() {
        return idExpDetail;
    }

    public void setIdExpDetail(int idExpDetail) {
        this.idExpDetail = idExpDetail;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
