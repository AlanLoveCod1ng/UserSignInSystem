package com.signin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "Users")
public class User {
    @Id
    @Column(name = "id",updatable = false)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "address")
    private String address;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "reg_date")
    private Date reg_date;

    @Column(name = "nation")
    private String nation;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "gender")
    private String gender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String language;

    public User(){

    }
    public User(long id, String userName, String password, String first_name, String second_name, String gender, String language,String address, Date birth_date, Date reg_date, String nation, String phone_number) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.first_name = first_name;
        this.second_name = second_name;
        this.gender = gender;
        this.language = language;
        this.address = address;
        this.birth_date = birth_date;
        this.reg_date = reg_date;
        this.nation = nation;
        this.phone_number = phone_number;
    }

    public User(String userName, String password,String first_name, String second_name, String gender, String language, String address, Date birth_date, Date reg_date, String nation, String phone_number) {
        this.userName = userName;
        this.password = password;
        this.first_name = first_name;
        this.second_name = second_name;
        this.gender = gender;
        this.language = language;
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
