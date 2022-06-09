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
public class Equipment{
    private int idEquip;
    private String name;
    private int quantity;
    private String note;

    public Equipment(int idEquip, String name, int quantity, String note) {
        this.idEquip = idEquip;
        this.name = name;
        this.quantity = quantity;
        this.note = note;
    }
    public Equipment( String name, int quantity, String note) {
        this.name = name;
        this.quantity = quantity;
        this.note = note;
    }

    public Equipment() {
    }

    public int getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
   
    
}
