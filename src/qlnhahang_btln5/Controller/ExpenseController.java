/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import qlnhahang_btln5.Models.Expense;


import java.util.List;
import static qlnhahang_btln5.Controller.SQLProcessing.statement;
import qlnhahang_btln5.Models.ExpenseDetail;
import qlnhahang_btln5.Models.Expense;


/**
 *
 * @author ADMIN
 */
public class ExpenseController {
    public static Expense getExpense(int idExp){
        Expense expense = null;
        String sql = "select * from Expense where idExp='"+idExp+"'";
        try {
               ResultSet resultSet = statement.executeQuery(sql);
               if(resultSet.next()){
                    expense = new Expense(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3)
                   );
               }
           } catch (SQLException e) {
               System.out.println(e);
           }
        return expense;
    }
    
    public static ArrayList<Expense> getAllExpense() {
        ArrayList<Expense> listExpense = new ArrayList<>();
        String sql = "select * from Expense";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Expense expense = new Expense(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)
                );
                listExpense.add(expense);
            }
        } catch (SQLException e) {
            System.out.println("Error get all expense: "+ e.getMessage());
        }
        
        return listExpense;
    }
    
    public static ArrayList<Expense> getAllExpense(Date from, Date to) {
        ArrayList<Expense> listExpense = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String whereDate = "";
        if(from == null) {
            whereDate = to == null ? "" : " where createdAt <= '" + formatter.format(to) + "'";
        } else {
            whereDate = to == null ? " where createdAt >= '" + formatter.format(from) + "'" 
                    :" where createdAt >= '" + formatter.format(from) +"' and createdAt <= '"
                    + formatter.format(to) + "'";

        }

        String sql = "select * from Expense" + whereDate;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Expense expense = new Expense(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3)
                );
                listExpense.add(expense);
            }
        } catch (SQLException e) {
            System.out.println("Error get all expense: "+ e.getMessage());
        }
        
        return listExpense;
    }
    
    public static boolean createExpense(int idEmp, List<ExpenseDetail> listDetail){
        String sqlCreateExpense = "insert into Expense(idEmp) values (?)";
        String sqlCreateDetail = "insert into Expensedetail(idExp, idType, type, quantity, price) values (?, ?, ?, ?, ?)";
        String sqlUpdateMaterial = "update Material set quantity = quantity + ? where idMat = ?";
        String sqlUpdateEquipment = "update Equipment set quantity = quantity + ? where idEquip = ?";
        
        boolean isSuccess = true;
        try {
            SQLProcessing.conn.setAutoCommit(false);
            PreparedStatement preCreateExpense = SQLProcessing.conn.prepareStatement(sqlCreateExpense, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement preCreateDetail = SQLProcessing.conn.prepareStatement(sqlCreateDetail);
            PreparedStatement preUpdateMaterial = SQLProcessing.conn.prepareStatement(sqlUpdateMaterial);
            PreparedStatement preUpdateEquipment = SQLProcessing.conn.prepareStatement(sqlUpdateEquipment);

            preCreateExpense.setNull(1, java.sql.Types.NULL);           
            
            if(idEmp > 0) {
                preCreateExpense.setInt(1, idEmp);
            }
            
            int affectedRows = preCreateExpense.executeUpdate();
            
            if(affectedRows == 0) {
                throw new Exception("Create expense failed.");
            }
            
            int idExpense = -1;
            ResultSet generatedKeys = preCreateExpense.getGeneratedKeys();

            if(generatedKeys.next()) {
                idExpense = generatedKeys.getInt(1);
            } else {
                throw new Exception("Cannot find expense id");
            }
            
            preCreateDetail.setInt(1, idExpense);
            for(ExpenseDetail detail : listDetail) {
                preCreateDetail.setInt(2, detail.getIdType());
                preCreateDetail.setString(3, detail.getType());
                preCreateDetail.setInt(4, detail.getQuantity());
                preCreateDetail.setDouble(5, detail.getPrice());
                if(detail.getType().equalsIgnoreCase("Material")) {
                    preUpdateMaterial.setInt(1, detail.getQuantity());
                    preUpdateMaterial.setInt(2, detail.getIdType());
                    preUpdateMaterial.executeUpdate();
                } else {
                    preUpdateEquipment.setInt(1, detail.getQuantity());
                    preUpdateEquipment.setInt(2, detail.getIdType());
                    preUpdateEquipment.executeUpdate();
                }
                preCreateDetail.executeUpdate();
            }

            SQLProcessing.conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                SQLProcessing.conn.rollback();
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
            }
            isSuccess = false;
        }finally {
            try {
                SQLProcessing.conn.setAutoCommit(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return isSuccess;
    }
    
     public static boolean updateExpense(int idExp, int idEmp, List<ExpenseDetail> listDetail){
        String sqlUpdateExpense = "update Expense set idEmp = ? where idExp = ?";
        String sqlCreateDetail = "insert into Expensedetail(idExp, idType, type, quantity, price) values (?, ?, ?, ?, ?)";
        String sqlDeleteDetail = "delete from Expensedetail where idExp = ?";
        String sqlUpdateMaterial = "update Material set quantity = quantity + ? where idMat = ?";
        String sqlUpdateEquipment = "update Equipment set quantity = quantity + ? where idEquip = ?";
        
        boolean isSuccess = true;
        try {
            SQLProcessing.conn.setAutoCommit(false);
            Expense expense = ExpenseController.getExpense(idExp);
            PreparedStatement preUpdateExpense = SQLProcessing.conn.prepareStatement(sqlUpdateExpense);
            PreparedStatement preCreateDetail = SQLProcessing.conn.prepareStatement(sqlCreateDetail);   
            PreparedStatement preDeleteDetail = SQLProcessing.conn.prepareStatement(sqlDeleteDetail);
            PreparedStatement preUpdateMaterial = SQLProcessing.conn.prepareStatement(sqlUpdateMaterial);
            PreparedStatement preUpdateEquipment = SQLProcessing.conn.prepareStatement(sqlUpdateEquipment);

            preUpdateExpense.setNull(1, java.sql.Types.NULL);          
            
            if(idEmp > 0) {
                preUpdateExpense.setInt(1, idEmp);
            }
 
            preUpdateExpense.setInt(2, idExp);
            int affectedRows = preUpdateExpense.executeUpdate();
            
            if(affectedRows == 0) {
                throw new Exception("Update expense failed.");
            }
            
            List<ExpenseDetail> listMaterialDetails = expense.getDetailsMaterial();
            List<ExpenseDetail> listEquipDetails = expense.getDetailsEquipment();
          
            for(ExpenseDetail detail : listMaterialDetails ) {
                preUpdateMaterial.setInt(1, -1 * detail.getQuantity());
                preUpdateMaterial.setInt(2, detail.getIdType());
                preUpdateMaterial.executeUpdate();
            }
            
            for(ExpenseDetail detail : listEquipDetails ) {
                preUpdateEquipment.setInt(1, -1 * detail.getQuantity());
                preUpdateEquipment.setInt(2, detail.getIdType());
                preUpdateEquipment.executeUpdate();
            }
            
            preDeleteDetail.setInt(1, idExp);
            preDeleteDetail.executeUpdate();
            
            preCreateDetail.setInt(1, idExp);
            for(ExpenseDetail detail : listDetail) {
                preCreateDetail.setInt(2, detail.getIdType());
                preCreateDetail.setString(3, detail.getType());
                preCreateDetail.setInt(4, detail.getQuantity());
                preCreateDetail.setDouble(5, detail.getPrice());
                 if(detail.getType().equalsIgnoreCase("Material")) {
                    preUpdateMaterial.setInt(1, detail.getQuantity());
                    preUpdateMaterial.setInt(2, detail.getIdType());
                    preUpdateMaterial.executeUpdate();
                } else {
                    preUpdateEquipment.setInt(1, detail.getQuantity());
                    preUpdateEquipment.setInt(2, detail.getIdType());
                    preUpdateEquipment.executeUpdate();
                }
                preCreateDetail.executeUpdate();
            }

            SQLProcessing.conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                SQLProcessing.conn.rollback();
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
            }
            isSuccess = false;
        }finally {
            try {
                SQLProcessing.conn.setAutoCommit(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return isSuccess;
    }
    
     public static boolean deleteExpense(int idExp) {
        String sqlDeleteExpense = "delete from Expense where idExp = ?";
        String sqlDeleteDetail = "delete from Expensedetail where idExp = ?";
        String sqlUpdateMaterial = "update Material set quantity = quantity + ? where idMat = ?";
        String sqlUpdateEquipment = "update Equipment set quantity = quantity + ? where idEquip = ?";
        
        boolean isSuccess = true;
        try {
            SQLProcessing.conn.setAutoCommit(false);
            PreparedStatement preDeleteExpense = SQLProcessing.conn.prepareStatement(sqlDeleteExpense);
            PreparedStatement preDeleteDetail = SQLProcessing.conn.prepareStatement(sqlDeleteDetail);
            PreparedStatement preUpdateMaterial = SQLProcessing.conn.prepareStatement(sqlUpdateMaterial);
            PreparedStatement preUpdateEquipment = SQLProcessing.conn.prepareStatement(sqlUpdateEquipment);
            
            Expense expense = ExpenseController.getExpense(idExp);
            List<ExpenseDetail> listMaterialDetails = expense.getDetailsMaterial();
            List<ExpenseDetail> listEquipDetails = expense.getDetailsEquipment();
          
            for(ExpenseDetail detail : listMaterialDetails ) {
                preUpdateMaterial.setInt(1, -1 * detail.getQuantity());
                preUpdateMaterial.setInt(2, detail.getIdType());
                preUpdateMaterial.executeUpdate();
            }
            
            for(ExpenseDetail detail : listEquipDetails ) {
                preUpdateEquipment.setInt(1, -1 * detail.getQuantity());
                preUpdateEquipment.setInt(2, detail.getIdType());
                preUpdateEquipment.executeUpdate();
            }
            
            preDeleteExpense.setInt(1, idExp);
            preDeleteDetail.setInt(1, idExp);

            preDeleteDetail.executeUpdate();

            preDeleteExpense.executeUpdate();
            
            SQLProcessing.conn.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                SQLProcessing.conn.rollback();
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
            }
            isSuccess = false;
        }finally {
            try {
                SQLProcessing.conn.setAutoCommit(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return isSuccess;
     }
}
