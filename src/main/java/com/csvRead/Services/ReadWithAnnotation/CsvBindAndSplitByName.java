package com.csvRead.Services.ReadWithAnnotation;

import com.csvRead.Entities.UserBindAndSplitByName;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service("CsvBindAndSplitByName")
public class CsvBindAndSplitByName implements ReadWithAnnotation {
    @Override
    public void read(File file) {
        try {
            List<UserBindAndSplitByName> list = new CsvToBeanBuilder(new FileReader(file))
                    .withType(UserBindAndSplitByName.class)
                    .build().parse();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
