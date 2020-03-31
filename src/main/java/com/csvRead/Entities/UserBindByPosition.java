package com.csvRead.Entities;


import com.opencsv.bean.CsvBindByPosition;

public class UserBindByPosition {
    @CsvBindByPosition(position = 0)
    private String Name;
    @CsvBindByPosition(position = 1)
    private String Email;
    @CsvBindByPosition(position = 2)
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
        return "UserBindByPosition{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
