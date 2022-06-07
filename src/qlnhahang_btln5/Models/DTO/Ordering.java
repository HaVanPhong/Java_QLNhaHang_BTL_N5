/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Models.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HaPhong
 */
public class Ordering {
    private int tbNumber;
    private List<DishOrder> dishOrders= new ArrayList<>();

    public Ordering(int tbNumber, List<DishOrder> dishOrders) {
        this.tbNumber = tbNumber;
        this.dishOrders = dishOrders;
    }

    public Ordering(int tbNumber) {
        this.tbNumber = tbNumber;
    }
    
    public Ordering() {
    }

    public int getTbNumber() {
        return tbNumber;
    }

    public void setTbNumber(int tbNumber) {
        this.tbNumber = tbNumber;
    }

    public List<DishOrder> getDishOrders() {
        return dishOrders;
    }

    public void setDishOrders(List<DishOrder> dishOrders) {
        this.dishOrders = dishOrders;
    }
    
    
    
}
