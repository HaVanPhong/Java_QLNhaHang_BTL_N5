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
import static qlnhahang_btln5.Controller.SQLProcessing.statement;
import qlnhahang_btln5.Models.Account;
import qlnhahang_btln5.Models.Employee;
/**
 *
 * @author duong
 */
public class EmployeeController {
    public static Employee GetEmployee(int idEmp){
        Employee emp = null;
        String sql = "select * from Employee where idEmp='"+idEmp+"'";
        try {
               ResultSet resultSet = statement.executeQuery(sql);
               if(resultSet.next()){
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
               }
           } catch (SQLException e) {
               System.out.println(e);
           }
        return emp;
    }
    public static ArrayList<Employee> GetAllEmployee(){
        ArrayList<Employee> listEmp = new ArrayList<>();
        String sql = "select * from Employee ";
        try {
               ResultSet resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   Employee emp = new Employee(
                           resultSet.getInt(1),
                           resultSet.getString(2),
                           resultSet.getString(3),
                           resultSet.getString(4),
                           resultSet.getString(5),
                           resultSet.getFloat(6),
                           resultSet.getString(7),
                           resultSet.getString(8) 
                   );
                   listEmp.add(emp);
               }
           } catch (SQLException e) {
               System.out.println(e);
           }
        return listEmp;
    }
    public static boolean CreateEmployee(Employee newEmp){
        String sql = "insert into Employee values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = SQLProcessing.conn.prepareStatement(sql);
            pstmt.setString(1,newEmp.getFullname());
            pstmt.setString(2,newEmp.getPhone());
            pstmt.setString(3,newEmp.getBirthday());
            pstmt.setString(4,newEmp.getGender());
            pstmt.setFloat(5,newEmp.getSalary());
            pstmt.setString(6,newEmp.getAddress());
            pstmt.setString(7,newEmp.getPosition());
            if(pstmt.executeUpdate() ==1 ){
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    public static boolean UpdateEmployee(Employee updateEmp){
        String sqlUpdate = "UPDATE Employee "
                            + "SET fullname = ?"
                            + " , phone = ?"
                            + " , birthday = ?"
                            + " , gender = ?"
                            + " , salary = ?"
                            + " , address = ?"
                            + " , position = ?"
                            + " WHERE idEmp = ?";
                            
        try {
            PreparedStatement pstmt = SQLProcessing.conn.prepareStatement(sqlUpdate);
            pstmt.setString(1,updateEmp.getFullname());
            pstmt.setString(2,updateEmp.getPhone());
            pstmt.setString(3,updateEmp.getBirthday());
            pstmt.setString(4,updateEmp.getGender());
            pstmt.setFloat(5,updateEmp.getSalary());
            pstmt.setString(6,updateEmp.getAddress());
            pstmt.setString(7,updateEmp.getPosition());
            pstmt.setInt(8,updateEmp.getIdEmp());
            if(pstmt.executeUpdate() > 0 ){
                return true;    
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    public static boolean DeleteEmployee(int idEmp){
        String sqlDelete = "Delete from  Employee where idEmp = ?";
                            
        try {
            PreparedStatement pstmt = SQLProcessing.conn.prepareStatement(sqlDelete);
            pstmt.setInt(1,idEmp);
            if(pstmt.executeUpdate() > 0 ){
                return true;    
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    public static ArrayList<Employee> SearchEmployee(String str){
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "Select * from  Employee where fullname like N'%"+str+"%'";
                            
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee emp = new Employee(
                           resultSet.getInt(1),
                           resultSet.getString(2),
                           resultSet.getString(3),
                           resultSet.getString(4),
                           resultSet.getString(5),
                           resultSet.getFloat(6),
                           resultSet.getString(7),
                           resultSet.getString(8)
                   );
                list.add(emp);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }

}
