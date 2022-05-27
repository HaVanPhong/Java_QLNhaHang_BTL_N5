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
public class Tables {
    private int idTB;
    private int tbNumber;
    public Tables(int idTB, int tbNumber) {
        this.idTB = idTB;
        this.tbNumber = tbNumber;
    }

    public Tables() {
    }

    public int getIdTB() {
        return idTB;
    }

    public void setIdTB(int idTB) {
        this.idTB = idTB;
    }

    public int getTbNumber() {
        return tbNumber;
    }

    public void setTbNumber(int tbNumber) {
        this.tbNumber = tbNumber;
    }
    
    
}

