package de.exxcellent.challenge.datamodel;

import de.exxcellent.challenge.fileloader.FileLoader;

import java.io.IOException;

/**
 * Class for maintaining weather data.
 */
public class DataModelWeather extends DataModel {

    public DataModelWeather(FileLoader fileLoader) throws IOException {
        if(fileLoader != null) {
            this.data = fileLoader.loadData();
        }
    }

    @Override
    public void store(FileLoader fileLoader) throws IOException {
        if(fileLoader != null) {
            this.data = fileLoader.loadData();
        }
    }

    @Override
    public String[] retrieve(int row) {
        if(row >= getAmountRows() || data == null) {
            return null;
        }
        return data[row];
    }

    @Override
    public int getAmountRows() {
        if(data == null) {
            return 0;
        }
        return data.length;
    }
}
