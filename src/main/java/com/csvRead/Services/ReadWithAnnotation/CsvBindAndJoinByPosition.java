package com.csvRead.Services.ReadWithAnnotation;

import com.csvRead.Entities.UserBindAndJoinByPosition;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service("CsvBindAndJoinByPosition")
public class CsvBindAndJoinByPosition implements ReadWithAnnotation {
    @Override
    public void read(File file) {
        try{
            List<UserBindAndJoinByPosition>users = new CsvToBeanBuilder(new FileReader(file))
                    .withType(UserBindAndJoinByPosition.class).withSkipLines(1)
                    .build().parse();
            System.out.println(users);

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
