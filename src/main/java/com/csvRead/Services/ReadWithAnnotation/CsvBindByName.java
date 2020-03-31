package com.csvRead.Services.ReadWithAnnotation;

import com.csvRead.Entities.UserBindByName;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service("CsvBindByName")
public class CsvBindByName implements ReadWithAnnotation {
    @Override
    public void read(File file) {
        try {
            List<UserBindByName> users = new CsvToBeanBuilder(new FileReader(file))
                    .withType(UserBindByName.class).build().parse();
            System.out.println(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
