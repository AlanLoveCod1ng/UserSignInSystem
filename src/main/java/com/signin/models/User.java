package com.signin.models;

import java.sql.Date;

public class User {
    private long id;
    private String first_name;
    private String second_name;
    private String address;
    private Date birth_date;
    private Date reg_date;
    private String nation;
    private String phone_number;

    public User(long id, String first_name, String second_name, String address, Date birth_date, Date reg_date, String nation, String phone_number) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.address = address;
        this.birth_date = birth_date;
        this.reg_date = reg_date;
        this.nation = nation;
        this.phone_number = phone_number;
    }

    public User(String first_name, String second_name, String address, Date birth_date, Date reg_date, String nation, String phone_number) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.address = address;
        this.birth_date = birth_date;
        this.reg_date = reg_date;
        this.nation = nation;
        this.phone_number = phone_number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}