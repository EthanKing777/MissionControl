package Parsers.CSV.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSV_PARSER{
    public static void main(String[] args) {
        String csvFile = "Data/Open Rocket Export/test 1.csv";
        BufferedReader reader = null;
        String spliter = ",";

        try {
            reader = new BufferedReader(new FileReader(csvFile));
            String currentLine ="";
            while ((currentLine = reader.readLine()) != null) {

                String[] value = currentLine.split(spliter);

                System.out.println("Time: " + value[0]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}