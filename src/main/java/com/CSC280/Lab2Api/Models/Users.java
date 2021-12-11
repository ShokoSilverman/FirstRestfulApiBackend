package com.CSC280.Lab2Api.Models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Users{

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String passWord;
    @ElementCollection
    private List<String> rolesList; //set this to list type and then change stuff in api to support it.


    public Users(String userName, String passWord, List<String> rolesList) {
        this.userName = userName;
        this.passWord = passWord;
        this.rolesList = rolesList;
    }

//    public Users(String userName, String passWord, String[] rolesList) {
//        this.id=id;
//        this.userName = userName;
//        this.passWord = passWord;
//        this.rolesList = rolesList;
//    }

    public Users(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String[] getRolesList() {
        String[] roleList = rolesList.toArray(new String[0]);
        return roleList;
    }

    public void setRolesList(String[] rolesList) {
        this.rolesList = Arrays.asList(rolesList);
    }

}
