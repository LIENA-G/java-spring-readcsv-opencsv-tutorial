package com.csvRead.Services.ReadWithAnnotation;
/*
By simply defining a bean and annotating the fields, opencsv can do all of the rest. When we write "bean", that’s a loose approximation of the requirements. Actually, if you use annotations, opencsv uses reflection (not introspection) on reading, so all you need is a POJO (plain old Java object) that does not have to conform to the Java Bean Specification, but is required to be public and have a public nullary constructor. If getters and setters are present and accessible, they are used. Otherwise, opencsv bypasses access control restrictions to get to member variables.
Besides the basic mapping strategy, there are various mechanisms for processing certain kinds of data.-CsvBindByName: Maps a bean field to a field in the CSV file based on the name of the header for that field in the CSV input.
-CsvBindByPosition: Maps a bean field to a field in the CSV file based on the numerical position of the field in the CSV input.
-CsvBindAndSplitByName: Maps a Collection-based bean field to a field in the CSV file based on the name of the header for that field in the CSV input.
-CsvBindAndSplitByPosition: Maps a Collection-based bean field to a field in the CSV file based on the numerical position of the field in the CSV input.
-CsvBindAndJoinByName: Maps multiple input columns in the CSV file to one bean field based on the name of the headers for those fields in the CSV input.
-CsvBindAndJoinByPosition: Maps multiple input columns in the CSV file to one bean field based on the numerical positions of those fields in the CSV input.
-CsvDate: Must be applied to bean fields of date/time types for automatic conversion to work, and must be used in conjunction with one of the preceding six annotations.
-CsvNumber: May be applied to bean fields of a type derived from java.lang.Number, and when used must be used in conjunction with one of the first six annotations.
-CsvCustomBindByName: The same as CsvBindByName, but must provide its own data conversion class.
-CsvCustomBindByPosition: The same as CsvBindByPosition, but must provide its own data conversion class.
As you can infer, there are two strategies for annotating beans, depending on your input:
-Annotating by header name.
-Annotating by column position.

configuration for csv reader:
CsvToBean csvToBean = new CsvToBeanBuilder(new FileReader("yourfile.csv").withSeparator('\t').withQuoteChar('\'').build();

*/
import java.io.File;

public interface ReadWithAnnotation {
    public void read(File file);
}
