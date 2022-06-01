/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlnhahang_btln5.Controller;

import qlnhahang_btln5.Models.Dish;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static qlnhahang_btln5.Controller.SQLProcessing.statement;

/**
 * @author Admin
 */
public class DishController {
    public static Dish show(int id) {
        Dish dish = null;
        String sql = "select * from Dish where idDish = '" + id + "'";
        try {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                dish = new Dish(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3)
                );

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return dish;
    }

    public static List<Dish> index() {
        List<Dish> dishes = new ArrayList<>();
        String sql = "select * from Dish";
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Dish dish = new Dish(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3)
                );
                dishes.add(dish);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return dishes;
    }

    public static boolean store(Dish dish){
        String sql = "insert into Dish values(?,?)";
        try{
            PreparedStatement ps = SQLProcessing.conn.prepareStatement(sql);

            ps.setString(1, dish.getName());
            ps.setDouble(2, dish.getPrice());
            System.out.println(sql);
            if(ps.executeUpdate() > 0){
                return  true;
            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return  false;
    }

    public  static boolean update(Dish dish){
        String sql = "UPDATE Dish "
                + "SET name = ?"
                + " , price = ?"
                + " WHERE idDish = ?";
        try{
            PreparedStatement ps = SQLProcessing.conn.prepareStatement(sql);
            ps.setString(1, dish.getName());
            ps.setDouble(2, dish.getPrice());
            ps.setInt(3, dish.getIdDish());

            if(ps.executeUpdate() > 0){
                return  true;
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public  static boolean delete(int id){
        String sql = "Delete from Dish where idDish = ? ";
        try{
            PreparedStatement ps = SQLProcessing.conn.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate() > 0){
                return  true;
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return false;
    }

    public static List<Dish> search(String str){
        List<Dish> list = new ArrayList<>();
        System.out.println("str: "+ str);
        String sql = "select * from  Dish where name like N'%"+str+"%'";
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Dish dish = new Dish(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3)
                );
                list.add(dish);

            }
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
        return  list;
    }

}
