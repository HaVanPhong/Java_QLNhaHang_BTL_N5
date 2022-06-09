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
    private String ghiChu;
    
    public Tables(int idTB, int tbNumber, String ghiChu) {
        this.idTB = idTB;
        this.tbNumber = tbNumber;
        this.ghiChu= ghiChu;
    }

    public Tables() {
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
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
    
    public String getTbName() {
        return "Bàn " + tbNumber;
    }

    public void setTbNumber(int tbNumber) {
        this.tbNumber = tbNumber;
    }

    @Override
    public String toString() {
        return "" +  tbNumber;
    }
    
    
}

