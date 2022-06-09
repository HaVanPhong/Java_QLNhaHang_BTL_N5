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
import qlnhahang_btln5.Models.Equipment;
import qlnhahang_btln5.Models.Tables;

/**
 *
 * @author HaPhong
 */
public class EquipmentController {
    public static int insertRecord(Equipment equip) {
        String sqlInsert = "insert into Equipment values (N'"+equip.getName()+"', "+equip.getQuantity()+", N'"+equip.getNote()+"')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            System.out.println("Error: "+ e.getMessage());
            return -1;
        }
    }
    
    public static List<Equipment> readAllRecord() {
        List<Equipment> equips = new ArrayList<>();
        String sql = "select * from Equipment";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Equipment equip = new Equipment(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)                        
                );

                equips.add(equip);
            }
        } catch (SQLException e) {
            System.out.println("Error: read all equiperial fail");
        }
        return equips;
    }
    
    public static Equipment getEquipment(int idEquip) {
        Equipment equip = null;
        String sql = "select * from Equipment where idEquip = '" + idEquip + "'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                equip = new Equipment(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4)                        
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: get one equiperial fail");
        }
        return equip;
    }
    
    public static int deleteRecord(int idEquip) {
        String sqlDelete = "delete from Equipment where idEquip = "+idEquip+"";
        try {
            return statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static int updateRecord(Equipment equip) {
        String sqlUpdate =
                "update Equipment set name =N'"+equip.getName()+ "', quantity="+equip.getQuantity()+", note=N'"+equip.getNote()+"' where idEquip ="+equip.getIdEquip()+"";
        try {
            return statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static List<Equipment> search(String str){
        List<Equipment> list = new ArrayList<>();
        System.out.println("str:" +str );
        String sql = "select * from Equipment where name like N'%"+str+"%'";
        try{
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Equipment equip = new Equipment(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
                list.add(equip);

            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return list;
    }
}
