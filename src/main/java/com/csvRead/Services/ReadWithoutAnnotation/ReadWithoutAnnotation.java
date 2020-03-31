package com.csvRead.Services.ReadWithoutAnnotation;
/*
configuration for csv reader:
CSVReader reader = new CSVReader(new FileReader("yourfile.csv"), '\t', '\'');
the second and third values are optional.

*/
import java.io.File;

public interface ReadWithoutAnnotation {
    public void read(File file);
}
