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
public class Material {
    private int idMat;
    private String name;
    private int quantity;
    private String dataImport;
    private String note;

    public Material(int idMat, String name, int quantity, String dataImport, String note) {
        this.idMat = idMat;
        this.name = name;
        this.quantity = quantity;
        this.dataImport = dataImport;
        this.note = note;
    }

    public Material() {
    }

    public int getIdMat() {
        return idMat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
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

    public String getDataImport() {
        return dataImport;
    }

    public void setDataImport(String dataImport) {
        this.dataImport = dataImport;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
