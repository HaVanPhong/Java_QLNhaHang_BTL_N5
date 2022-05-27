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
                System.out.println("");
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
                   System.out.println(emp.getFullname());
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
               if(resultSet.next()){
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
}
