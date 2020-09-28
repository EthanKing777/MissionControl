package parser;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;

public class CSV_PARSER{
    public static void main(String[] args) throws IOException {
        InputStream csvFile =  new FileInputStream ("Data/Open Rocket Export/test 1.csv");
        InputStreamReader input = new InputStreamReader(csvFile);
        CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(input);
        ArrayList<String> header = new ArrayList<>();
        for(CSVRecord record : csvParser) {
            if(record.getRecordNumber() == 3){
                for(String value : record){
                    header.add(value);
                }
            }
            System.out.println(header + "   ");
            for(String value : record){
                System.out.print(value +"   ");
            }
        }

    }
}