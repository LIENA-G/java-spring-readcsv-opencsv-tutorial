package com.csvRead.Entities;
/*
The third field is a SortedSet of dates. Sorted for convenience, and a set to avoid clerical errors of double entry. For this field we have specified that the string separating elements of this list in the input is one or more semicolons. This string is always interpreted as a regular expression. Interestingly, in case we write these data out to a CSV file later, the elements of the list should be separated with a single semicolon. Perhaps someone is trying to convert the data from a older format or remove redundancies.
*/

import com.opencsv.bean.*;

import java.util.Date;
import java.util.List;
import java.util.SortedSet;

public class UserBindAndSplitByPosition {
    @CsvBindByPosition(position = 0)
    private String Name;
    @CsvBindByPosition(position = 1)
    private String Email;
    @CsvBindByPosition(position = 2)
    private String Address;
    @CsvBindAndSplitByPosition(position = 3, elementType = String.class)
    private List<String> PhoneNumbers;
    @CsvBindAndSplitByPosition(position = 4, elementType = Date.class, splitOn = ";+")
    @CsvDate(value="yyyy-MM-dd")
    SortedSet<Date> Dates;

    public List<String> getPhoneNumbers() {
        return PhoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        PhoneNumbers = phoneNumbers;
    }

    public SortedSet<Date> getDates() {
        return Dates;
    }

    public void setDates(SortedSet<Date> dates) {
        Dates = dates;
    }

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
        return "UserBindAndSplitByPosition{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumbers=" + PhoneNumbers +
                ", Dates=" + Dates +
                '}';
    }
}
