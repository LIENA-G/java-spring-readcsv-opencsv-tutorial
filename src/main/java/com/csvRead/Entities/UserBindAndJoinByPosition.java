package com.csvRead.Entities;


import com.opencsv.bean.CsvBindAndJoinByPosition;
import com.opencsv.bean.CsvBindByPosition;
import org.apache.commons.collections4.MultiValuedMap;

/*
note that in this example is that for CsvBindAndJoinByPosition, the index type to MultiValuedMap must be Integer. Values are saved under the index of the column position they were found in
*/
public class UserBindAndJoinByPosition {
    @CsvBindByPosition(position = 0)
    private String Name;
    @CsvBindAndJoinByPosition(position = "1,4,5",elementType =String.class)
    private MultiValuedMap<Integer, String> Email;
    @CsvBindAndJoinByPosition(position = "2,3",elementType = String.class)
    private MultiValuedMap<Integer, String>  Address;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public MultiValuedMap<Integer, String> getEmail() {
        return Email;
    }

    public void setEmail(MultiValuedMap<Integer, String> email) {
        Email = email;
    }

    public MultiValuedMap<Integer, String> getAddress() {
        return Address;
    }

    public void setAddress(MultiValuedMap<Integer, String> address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "UserBindAndJoinByPosition{" +
                "Name='" + Name + '\'' +
                ", Email=" + Email +
                ", Address=" + Address +
                '}';
    }
}
