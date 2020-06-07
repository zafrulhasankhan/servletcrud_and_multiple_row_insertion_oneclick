/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaCode;

/**
 *
 * @author Zafrul Hasan Nasim
 */
public class User {
    
    
   

    //public User() {
    //}
    public int getId() {
        return id;
    } private int id;
    private String name;
    private String email;
    private String mobileNo;


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + '}';
    }
    
    
}
