package de.exxcellent.challenge.fileloader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;

/**
 * Implementation of FileLoader in order to load CSV files.
 */
public class FileLoaderCsv implements FileLoader {

    private String filePath;

    public FileLoaderCsv(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String[][] loadData() throws IOException {
        File csvData = new File(filePath);
        CSVParser parser = CSVParser.parse(new BufferedReader(new FileReader(csvData)), CSVFormat.RFC4180);
        int i = 0; // rows
        int j = 0; // columns
        List<CSVRecord> records = parser.getRecords();
        if(records.size() == 0) {
            return null;
        }
        String[][] items = new String[records.size()-1][records.get(0).size()];
        boolean skipHeader = false;
        for (CSVRecord csvRecord : records) {
            if (!skipHeader) {
                skipHeader = true;
                continue; // skip header
            }
            for (String s : csvRecord) {
                items[i][j] = s;
                j++;
            }
            j = 0;
            i++;
        }
        return items;
    }
}
