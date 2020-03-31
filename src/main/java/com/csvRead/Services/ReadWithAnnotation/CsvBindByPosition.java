package com.csvRead.Services.ReadWithAnnotation;

import com.csvRead.Entities.UserBindByPosition;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service("CsvBindByPosition")
public class CsvBindByPosition implements ReadWithAnnotation {


    @Override
    public void read(File file) {
        try {
            List<UserBindByPosition> list= new CsvToBeanBuilder(new FileReader(file))
                    .withType(UserBindByPosition.class).build().parse();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
