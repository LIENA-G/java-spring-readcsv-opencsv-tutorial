package com.csvRead.Services.ReadWithoutAnnotation;
/*
Setting qualifier to ReadAsStringArray to bind this implementation class to the interface.in the controller use @Autowired with @Qualifier("ReadAsStringArray") for binding.
*/

import com.csvRead.Services.ReadWithoutAnnotation.ReadWithoutAnnotation;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service("ReadAllLines")
public class ReadAllLines implements ReadWithoutAnnotation {

    @Override
    public void read(File file) {

        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            try {
                List<String[]> records = csvReader.readAll();
                for (String[] record : records) {
                    System.out.println("Name :" + record[0]);
                    System.out.println("Email :" + record[1]);
                    System.out.println("Address :" + record[2]);
                }
            } catch (CsvException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
