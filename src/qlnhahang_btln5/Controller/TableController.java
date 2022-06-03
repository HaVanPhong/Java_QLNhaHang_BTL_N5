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
import qlnhahang_btln5.Models.Tables;
/**
 *
 * @author duong
 */
public class TableController {
    public static Tables getTable(int idTb){
        Tables table = null;
        String sql = "select * from Tables where idTB='"+idTb+"'";
        try {
            System.out.println("");
           ResultSet resultSet = statement.executeQuery(sql);
           if(resultSet.next()){
               table = new Tables(
                    resultSet.getInt(1),
                    resultSet.getInt(2)
               );
           }
       } catch (SQLException e) {
           System.out.println(e);
       }
        return table;
    }
    public static ArrayList<Tables> getAllTable(){
        ArrayList<Tables> listTable = new ArrayList<>();
        String sql = "select * from Tables ";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                Tables table = new Tables(
                     resultSet.getInt(1),
                     resultSet.getInt(2)
                );
                listTable.add(table);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listTable;
    }
}
