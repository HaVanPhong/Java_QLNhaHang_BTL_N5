/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnhahang_btln5.Models;

/**
 *
 * @author HaPhong
 */
public class Bill {
    private int idBill;
    private String createdAt;
    private int idTb;
    private int idCus;
    private int idEmp;

    public Bill(int idBill, String createdAt, int idTB, int idCus, int idEmp) {
        this.idBill = idBill;
        this.createdAt = createdAt;
        this.idTb = idTB;
        this.idCus = idCus;
        this.idEmp = idEmp;
    }

    public Bill() {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getIdTb() {
        return idTb;
    }

    public void setIdTb(int idTB) {
        this.idTb = idTB;
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }
    
    
}
