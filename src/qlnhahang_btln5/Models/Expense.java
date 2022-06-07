/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import qlnhahang_btln5.Controller.SQLProcessing;

/**
 *
 * @author HaPhong
 */
public class Expense {
    private int idExp;
    private int idEmp;
    private String createdAt;

    public Expense(int idExp, int idEmp, String createdAt) {
        this.idExp = idExp;
        this.idEmp = idEmp;
        this.createdAt = createdAt;
    }

    public Expense() {
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }
    
    public Employee getEmployee() {
        Employee emp = null;
        System.out.println(idEmp);
        String sql = "select * from Employee where idEmp = '" + idEmp+ "'";
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
            System.out.println("Error get employee of expense: "+ e.getMessage());
        }
        
        return emp;
    }
    
    public List<ExpenseDetail> getExpenseDetails() {
        List<ExpenseDetail> listExpenseDetail = new ArrayList<>();
        String sql = "select * from Expensedetail where idExp = '" + idExp + "'";
        try {
            ResultSet resultSet = SQLProcessing.statement.executeQuery(sql);
            while (resultSet.next()) {
                ExpenseDetail expenseDetail = new ExpenseDetail(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getDouble(6)
                );
                listExpenseDetail.add(expenseDetail);
            }
        } catch (SQLException e) {
            System.out.println("Error get all expense detail: "+ e.getMessage());
        }
        
        return listExpenseDetail;
    }
    
     public List<ExpenseDetail> getDetailsMaterial() {
        List<ExpenseDetail> listExpenseDetail = new ArrayList<>();
        String sql = "select * from Expensedetail inner join Material on Expensedetail.idType = Material.idMat where idExp = '" + idExp + "' and type='Material'";
        
        try {
            ResultSet resultSet = SQLProcessing.statement.executeQuery(sql);
            while (resultSet.next()) {
                ExpenseDetail expenseDetail = new ExpenseDetail(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getDouble(6),
                        resultSet.getString(8)
                );
                listExpenseDetail.add(expenseDetail);
            }
        } catch (SQLException e) {
            System.out.println("Error get all expense detail: "+ e.getMessage());
        }
        
        return listExpenseDetail;
    }
    
     public List<ExpenseDetail> getDetailsEquipment() {
        List<ExpenseDetail> listExpenseDetail = new ArrayList<>();
        String sql = "select * from Expensedetail inner join Equipment on Expensedetail.idType = Equipment.idEquip where idExp = '" + idExp + "' and type='Equipment'";
        
        try {
            ResultSet resultSet = SQLProcessing.statement.executeQuery(sql);
            while (resultSet.next()) {
                ExpenseDetail expenseDetail = new ExpenseDetail(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getDouble(6),
                        resultSet.getString(8)
                );
                listExpenseDetail.add(expenseDetail);
            }
        } catch (SQLException e) {
            System.out.println("Error get all expense detail: "+ e.getMessage());
        }
        
        return listExpenseDetail;
    }
}
