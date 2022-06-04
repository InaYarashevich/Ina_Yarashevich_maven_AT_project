package utils;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    public static void main(String[] args) {

        File file = new File("C:/Users/IT0054/Desktop/template.csv");
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"address", "source_id", "entity_id", "mention_content_type", "mention_content", "image_hash",
                    "url_backlink", "action", "to_approve", "other"};
            writer.writeNext(header);
            for (int i = 1; i < 100; i++) {
                String[] data1 = {"asdf", "215", "", "", "content", "", "", "Add", "TRUE", ""};
                writer.writeNext(data1);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
