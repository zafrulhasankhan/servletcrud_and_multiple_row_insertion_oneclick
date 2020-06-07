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
public class muluser {
    private String name;
 private String email;
  private String mobile;
  /*public muluser(String name, String email, String mobile) {
  super();
  
  this.name = name;
  this.email = email;
  this.mobile = mobile;
  
  
 }*/

    public String getName() {
        //this.name = name;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static void main(String[] args) {
        muluser m = new muluser();
        m.setName("asjk");
        System.out.println(m.getName());
        
    
  
}
}
