/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import qlnhahang_btln5.Models.Dish;


import java.util.List;
import static qlnhahang_btln5.Controller.SQLProcessing.statement;

/**
 *
 * @author ADMIN
 */
public class DishController {
    public static ArrayList<Dish> getAllDish() {
        ArrayList<Dish> listDish = new ArrayList<>();
        String sql = "select * from Dish";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Dish dish = new Dish(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3)
                );
                listDish.add(dish);
            }
        } catch (SQLException e) {
            System.out.println("Error get all dish: "+ e.getMessage());
        }
        
        return listDish;
    }
}
