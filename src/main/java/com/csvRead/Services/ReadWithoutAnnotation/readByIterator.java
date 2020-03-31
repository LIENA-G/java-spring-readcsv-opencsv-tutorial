package com.csvRead.Services.ReadWithoutAnnotation;
/*
Setting qualifier to ReadAsStringArray to bind this implementation class to the interface.in the controller use @Autowired with @Qualifier("ReadAsStringArray") for binding.
*/

import com.csvRead.Services.ReadWithoutAnnotation.ReadWithoutAnnotation;
import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service("readByIterator")
public class readByIterator implements ReadWithoutAnnotation {

    @Override
    public void read(File file) {

        try {
            CSVIterator csvIterator = new CSVIterator(new CSVReader(new FileReader(file)));
            for (CSVIterator it = csvIterator; it.hasNext(); ) {
                String[] record = it.next();
                System.out.println("Name :" + record[0]);
                System.out.println("Email :" + record[1]);
                System.out.println("Address :" + record[2]);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }



    }
}
