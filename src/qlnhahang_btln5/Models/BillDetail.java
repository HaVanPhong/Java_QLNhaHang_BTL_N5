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
public class BillDetail {
    private int idBill;
    private int idDish;
    private int quantity;

    public BillDetail(int idBill, int idDish, int quantity) {
        this.idBill = idBill;
        this.idDish = idDish;
        this.quantity = quantity;
    }

    public BillDetail() {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Dish getDish() {
        Dish dish = null;
        String sql = "select * from Dish where idDish = " + idDish;
        try {
            ResultSet resultSet = SQLProcessing.statement.executeQuery(sql);
            resultSet.next();
            dish = new Dish(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getDouble(3)
            );
        } catch (SQLException e) {
            System.out.println("Error get dish of bill detail: "+ e.getMessage());
        }

        return dish;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BillDetail other = (BillDetail) obj;
        if (this.idBill == other.idBill && this.idDish == other.idDish) {
            return true;
        }
        return false;
    }
    
    
}
