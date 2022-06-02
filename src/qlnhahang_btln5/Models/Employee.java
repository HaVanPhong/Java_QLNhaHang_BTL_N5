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
public class Employee {
    private int idEmp;
    private String fullname;
    private String phone;
    private String gender;
    private String birthday;
    private String address;
    private float salary;
    private String position;

    public Employee(int idEmp, String fullname, String phone, String gender, String birthday, float salary,String address,String position) {
        this.idEmp = idEmp;
        this.fullname = fullname;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.salary = salary;
        this.position = position;
    }
    public Employee(String fullname, String phone, String gender, String birthday, float salary,String address,String position) {
        this.fullname = fullname;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.salary = salary;
        this.position = position;
    }
    public Employee() {
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }






    
    
}
