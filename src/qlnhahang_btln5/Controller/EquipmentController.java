package qlnhahang_btln5.Controller;

import qlnhahang_btln5.Models.Dish;
import qlnhahang_btln5.Models.Equipment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static qlnhahang_btln5.Controller.SQLProcessing.statement;

public class EquipmentController {
    public static Equipment show(int id){
        Equipment equipment = null;
        String sql = "select * from Equipment where idEquip = '" + id+ "'";
        try{
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                equipment = new Equipment(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4)
                );
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return equipment;
    }

    public  static List<Equipment> index(){
        List<Equipment> list = new ArrayList<>();
        String sql = "select * from Equipment";
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Equipment equip = new Equipment(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4)
                );
                list.add(equip);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return list;
    }

    public static boolean store(Equipment equip){
        String sql  = "insert into Equipment values(?, ?, ?)";
        try{
            PreparedStatement ps = SQLProcessing.conn.prepareStatement(sql);
            ps.setString(1, equip.getName());
            ps.setDouble(2, equip.getPrice());
            ps.setInt(3, equip.getQuantity());
            if(ps.executeUpdate() > 0){
                return true;
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return false;
    }

    public static boolean update(Equipment equip){
        String sql = "UPDATE Equipment " + "SET name = ? " + ", price = ? " + ", quantity = ? " + "WHERE idEquip = ? ";
        try{
            PreparedStatement ps = SQLProcessing.conn.prepareStatement(sql);
            ps.setString(1, equip.getName());
            ps.setDouble(2, equip.getPrice());
            ps.setInt(3, equip.getQuantity());
            ps.setInt(4, equip.getIdEquip());
            System.out.println(sql);
            if(ps.executeUpdate() > 0){
                return  true;
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return false;
    }

    public  static boolean delete(int id){
        String sql = "Delete from Equipment where idEquip = ?";
        try{
            PreparedStatement ps = SQLProcessing.conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate() > 0){
                return  true;
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return false;
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
                        rs.getDouble(3),
                        rs.getInt(4)
                );
                list.add(equip);

            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return list;
    }
}
