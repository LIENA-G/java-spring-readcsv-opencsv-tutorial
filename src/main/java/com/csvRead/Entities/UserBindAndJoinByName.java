package com.csvRead.Entities;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;
import org.apache.commons.collections4.MultiValuedMap;
/*
Why openCsv choose to use s MultiValuedMap to implement this CsvBindAndJoinByName? Why not a simple List and everyone is happy? Two reasons: First, someone will want to know what the header was actually named on reading, and second, opencsv needs to know what the header is named when it writes beans to a CSV file. And really, at least for reading, a MultiValuedMap isn’t that cumbersome: Mostly you will want a list of all values, not caring about which header they were under, and that can simply be had by calling values() on the field.
*/
public class UserBindAndJoinByName {
    @CsvBindByName(column = "User Name")
    private String Name;
    @CsvBindAndJoinByName(column = "User Email",elementType =String.class)
    private MultiValuedMap<String, String> Email;
    @CsvBindAndJoinByName(elementType = String.class)
    private MultiValuedMap<String, String>  Address;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public MultiValuedMap<String, String> getEmail() {
        return Email;
    }

    public void setEmail(MultiValuedMap<String, String> email) {
        Email = email;
    }

    public MultiValuedMap<String, String> getAddress() {
        return Address;
    }

    public void setAddress(MultiValuedMap<String, String> address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "UserBindAndJoinByName{" +
                "Name='" + Name + '\'' +
                ", Email=" + Email +
                ", Address=" + Address +
                '}';
    }
}
