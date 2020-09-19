package com.example.android.m_pariwahan;

public class Users {
    public String name;
    public String address;
    public String dob;
    public String reg;
    public String issue;
    public String validity;

    public Users() {

    }

    public Users(String name, String address, String dob, String reg, String issue, String validity) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.reg = reg;
        this.issue = issue;
        this.validity = validity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getReg(){
        return reg;
    }

    public void setReg(String reg){
        this.reg = reg;
    }

    public String getIssue() { return issue; }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

}