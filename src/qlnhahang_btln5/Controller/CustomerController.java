/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static qlnhahang_btln5.Controller.SQLProcessing.statement;
import qlnhahang_btln5.Models.Customer;
/**
 *
 * @author duong
 */
public class CustomerController {
    public static Customer getCustomer(int idCus){
        Customer customer = null;
        String sql = "select * from Customer where idCus='"+idCus+"'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                customer = new Customer(
                     resultSet.getInt(1),
                     resultSet.getString(2),
                     resultSet.getString(3)
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return customer;
    }
    public static ArrayList<Customer> getAllCustomer(){
        ArrayList<Customer> listCus = new ArrayList<>();
        String sql = "select * from Customer ";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                Customer customer = new Customer(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3) 
                );
                listCus.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listCus;
    }
    
    //ké
    public static Customer getCustomerByPhone(String phone){
        Customer customer = null;
        String sql = "select * from Customer where phone='"+phone+"'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                customer = new Customer(
                     resultSet.getInt(1),
                     resultSet.getString(2),
                     resultSet.getString(3)
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return customer;
    }
}
