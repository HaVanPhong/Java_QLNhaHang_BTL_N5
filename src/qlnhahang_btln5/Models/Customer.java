/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Models;

import java.util.List;

/**
 *
 * @author HaPhong
 */
public class Customer {
    private int idCus;
    private String fullname;
    private String phone;

    public Customer(int idCus, String fullname, String phone) {
        this.idCus = idCus;
        this.fullname = fullname;
        this.phone = phone;
    }
   
    public Customer() {
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
