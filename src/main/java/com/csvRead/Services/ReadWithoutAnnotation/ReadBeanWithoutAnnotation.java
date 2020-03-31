package com.csvRead.Services.ReadWithoutAnnotation;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.csvRead.Entities.User;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service("ReadBeanWithoutAnnotation")
public class ReadBeanWithoutAnnotation implements ReadWithoutAnnotation {
    @Override
    public void read(File file) {
        try {
            FileReader reader=new FileReader(file);
            ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
            mappingStrategy.setType(User.class);
            String[] columns = new String[] {"Name", "Email", "Address"};
            mappingStrategy.setColumnMapping(columns);
            CsvToBean csv = new CsvToBean();
            List list = csv.parse(mappingStrategy, reader);
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
