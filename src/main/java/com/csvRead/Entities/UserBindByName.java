package com.csvRead.Entities;

import com.opencsv.bean.CsvBindByName;

public class UserBindByName {
    @CsvBindByName(column = "User Name")
    private String Name;
    @CsvBindByName(column = "User Email")
    private String Email;
    @CsvBindByName
    private String Address;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "UserBindByName{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }

}
