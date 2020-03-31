package com.csvRead.Services.ReadWithoutAnnotation;
/*
Setting qualifier to ReadAsStringArray to bind this implementation class to the interface.in the controller use @Autowired with @Qualifier("ReadAsStringArray") for binding.
*/

import com.csvRead.Services.ReadWithoutAnnotation.ReadWithoutAnnotation;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service("ReadAsStringArray")
public class ReadAsStringArray implements ReadWithoutAnnotation {

    @Override
    public void read(File file) {

        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] nextLine;
            while ((nextLine=csvReader.readNext())!=null){
                System.out.println("Name :" + nextLine[0]);
                System.out.println("Email :" + nextLine[1]);
                System.out.println("Address :" + nextLine[2]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
