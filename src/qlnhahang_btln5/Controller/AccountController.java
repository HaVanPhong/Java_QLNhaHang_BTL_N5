/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static qlnhahang_btln5.Controller.SQLProcessing.statement;
import qlnhahang_btln5.Models.Account;

public class AccountController {
    public static List<Account> getAllAccount() {
           List<Account> accounts = new ArrayList<>();
           String sql = "select * from Account";
           try {
               ResultSet resultSet = statement.executeQuery(sql);
               while (resultSet.next()) {
                   Account acc = new Account(
                           resultSet.getInt(1),
                           resultSet.getString(2),
                           resultSet.getString(3),
                           resultSet.getString(4),
                           resultSet.getInt(5)
                   );

                   accounts.add(acc);
               }
           } catch (SQLException e) {
               System.out.println("Error get all account: "+ e.getMessage());
           }
           return accounts;
    }
    public static Account CheckLogin(String username,String password){
        Account cus = null;
        String sql = "select * from Account where username = '"+username+"' and password = '"+password+"'";
        try {
               ResultSet resultSet = statement.executeQuery(sql);
               if(resultSet.next()){
                   cus = new Account(
                           resultSet.getInt(1),
                           resultSet.getString(2),
                           resultSet.getString(3),
                           resultSet.getString(4),
                           resultSet.getInt(5)
                   );
               }
           } catch (SQLException e) {
               System.out.println(e);
           }
        return cus;
    }
    public static boolean CreateAccount(String username,String password,String role,int idEmp){
        String sql  = "insert into Account values( ? , ? , ? , ?)";
        try {
            PreparedStatement pstmt = SQLProcessing.conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,role);
            pstmt.setInt(4,idEmp);
            System.out.println(username+" "+password+"   "+role+"   "+idEmp);
            if(pstmt.executeUpdate() > 0 ){
                return true;    
            }
            System.out.println("số " +pstmt.executeUpdate());
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean DeleteAccountById(int idUser){
        String sqlDelete = "Delete from  Account where idUser = ?";                 
        try {
            PreparedStatement pstmt = SQLProcessing.conn.prepareStatement(sqlDelete);
            pstmt.setInt(1,idUser);
            if(pstmt.executeUpdate() > 0 ){
                return true;    
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
     public static boolean UpdateAccountById(int idUser,String username,String password,String role){
        String sqlUpdate = "UPDATE Account "
                            + "SET username = ?"
                            + " , password = ?"
                            + " WHERE idUser = ?";              
        try {
            PreparedStatement pstmt = SQLProcessing.conn.prepareStatement(sqlUpdate);
            pstmt.setInt(1,idUser);
            pstmt.setString(2,username);
            pstmt.setString(3,password);
            pstmt.setString(4,role);
            if(pstmt.executeUpdate() > 0 ){
                return true;    
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    public static Account getAccountByIdEmp(int idEmp){
        Account acc = null;
        String sql = "Select * from  Account where idEmp = '"+idEmp+"'";                    
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                acc = new Account(
                        resultSet.getInt(1),
                        resultSet.getString(2),  
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                );
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return acc;
    }
}
