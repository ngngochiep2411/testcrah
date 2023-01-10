package com.example.myapplication;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

@SmartTable
public class UserInfo {

    @SmartColumn
    private String rank;
    @SmartColumn
    private String name;
    @SmartColumn
    private String age;
    @SmartColumn
    private String address;
    @SmartColumn
    private String phone;
    @SmartColumn
    private String email;
    @SmartColumn
    private String password;
    @SmartColumn
    private String height;

    public UserInfo(String rank, String name, String age, String address, String phone, String email, String password, String height) {
        this.rank = rank;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.height = height;
    }
}
