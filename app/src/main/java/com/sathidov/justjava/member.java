package com.sathidov.justjava;
public class member {
    private String sEmail;
    private String sUesrname;
    private String sPassword;
    public member(String email,String username,String pasword){
        sEmail=email;
        sUesrname=username;
        sPassword=pasword;
    }
    public String getemail(){
        return sEmail;
        }
    public String getUesrname(){
        return sUesrname;
    }
    public String getPasword(){
        return sPassword;
    }

}
