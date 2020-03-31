package com.csvRead.Services.ReadWithAnnotation;

import com.csvRead.Entities.UserBindAndSplitByPosition;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service("CsvBindAndSplitByPosition")
public class CsvBindAndSplitByPosition implements ReadWithAnnotation {
    @Override
    public void read(File file) {
        try {
            List<UserBindAndSplitByPosition> list = new CsvToBeanBuilder(new FileReader(file))
                    .withType(UserBindAndSplitByPosition.class).withSkipLines(1)
                    .build().parse();
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
