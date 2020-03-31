package com.csvRead.Services.ReadWithAnnotation;

import com.csvRead.Entities.UserBindAndJoinByName;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service("CsvBindAndJoinByName")
public class CsvBindAndJoinByName implements ReadWithAnnotation{
    @Override
    public void read(File file) {
        try{
            List<UserBindAndJoinByName>  users= new CsvToBeanBuilder(new FileReader(file))
                    .withType(UserBindAndJoinByName.class)
                    .build().parse();
            System.out.println(users);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
