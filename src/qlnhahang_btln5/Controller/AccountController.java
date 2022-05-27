/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static qlnhahang_btln5.Controller.SQLProcessing.statement;
import qlnhahang_btln5.Models.Account;

/**
 *
 * @author HaPhong
 *//**
 *
 * @author HaPhong
 */
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
        String sql  = "insert into Account values('"+username+"','"+password+"','"+role+"','"+idEmp+"')";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            return true;  
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
