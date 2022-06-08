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
public class Account{
    private int idUser;
    private String username;
    private String password;
    private String role;
    private int idEmp;
    public Account(int idUser, String username, String password,String role, int idEmp) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
        this.idEmp = idEmp;
    }
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getIdEmp() {
        return idEmp;
    }
    public Account(String username) {
        this.username = username;
    }
    public Account() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
