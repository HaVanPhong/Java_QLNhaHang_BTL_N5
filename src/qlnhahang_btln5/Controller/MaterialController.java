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
import static qlnhahang_btln5.Controller.SQLProcessing.statement;
import qlnhahang_btln5.Models.Material;
import qlnhahang_btln5.Models.Tables;

/**
 *
 * @author HaPhong
 */
public class MaterialController {
    public static int insertRecord(Material mat) {
        String sqlInsert = "insert into Material values (N'"+mat.getName()+"', "+mat.getQuantity()+", N'"+mat.getNote()+"')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
            return -1;
        }
    }
    
    public static List<Material> readAllRecord() {
        List<Material> mats = new ArrayList<>();
        String sql = "select * from Material";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Material mat = new Material(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getFloat(3),
                        resultSet.getString(4)                        
                );

                mats.add(mat);
            }
        } catch (SQLException e) {
            System.out.println("Error: read all material fail");
        }
        return mats;
    }
    
    public static Material getMaterial(int idMat) {
        Material mat = null;
        String sql = "select * from Material where idMat = '" + idMat + "'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                mat = new Material(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getFloat(3),
                    resultSet.getString(4)                        
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: get one material fail");
        }
        return mat;
    }
    
    public static int deleteRecord(int idMat) {
        String sqlDelete = "delete from Material where idMat = "+idMat+"";
        try {
            return statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static int updateRecord(Material mat) {
        String sqlUpdate =
                "update Material set name =N'"+mat.getName()+ "', quantity="+mat.getQuantity()+", note=N'"+mat.getNote()+"' where idMat ="+mat.getIdMat()+"";
        try {
            return statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
