/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import qlnhahang_btln5.Controller.SQLProcessing;

/**
 *
 * @author HaPhong
 */
public class Bill {
    private int idBill;
    private int idTb;
    private int idCus;
    private int idEmp;
    private double total;
    private String createdAt;


    public Bill(int idBill, int idTB, int idCus, int idEmp, double total, String createdAt) {
        this.idBill = idBill;
        this.idTb = idTB;
        this.idCus = idCus;
        this.idEmp = idEmp;
        this.total = total;
        this.createdAt = createdAt;
    }

    public Bill() {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getIdTb() {
        return idTb;
    }

    public void setIdTb(int idTB) {
        this.idTb = idTB;
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    public Tables getTable() {
        Tables table = null;
        String sql = "select * from Tables where idTB = " + idTb;
        try {
            ResultSet resultSet = SQLProcessing.statement.executeQuery(sql);
            resultSet.next();
            table = new Tables(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getString(3)
            );
        } catch (SQLException e) {
            System.out.println("Error get table of bill: "+ e.getMessage());
        }
        
        return table;
    }
    
    public Employee getEmployee() {
        Employee emp = null;
        String sql = "select * from Employee where idEmp = " + idEmp;
        try {
            ResultSet resultSet = SQLProcessing.statement.executeQuery(sql);
            resultSet.next();
            emp = new Employee(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getFloat(6),
                resultSet.getString(7),
                resultSet.getString(8)
            );
        } catch (SQLException e) {
            System.out.println("Error get employee of bill: "+ e.getMessage());
        }
        
        return emp;
    }
    
    public Customer getCustomer() {
        Customer cus = null;
        String sql = "select * from Customer where idCus = " + idCus;
        try {
            ResultSet resultSet = SQLProcessing.statement.executeQuery(sql);
            resultSet.next();
            cus = new Customer(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3)
            );
        } catch (SQLException e) {
            System.out.println("Error get customer of bill: "+ e.getMessage());
        }
        
        return cus;
    }
    
     public ArrayList<BillDetail> getBillDetails() {
        ArrayList<BillDetail> listBillDetail = new ArrayList<>();
        String sql = "select * from Billdetail where idBill = '" + idBill + "'";
        try {
            ResultSet resultSet = SQLProcessing.statement.executeQuery(sql);
            while (resultSet.next()) {
                BillDetail billDetail = new BillDetail(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                );
                listBillDetail.add(billDetail);
            }
        } catch (SQLException e) {
            System.out.println("Error get all bill detail: "+ e.getMessage());
        }
        
        return listBillDetail;
    }
}
