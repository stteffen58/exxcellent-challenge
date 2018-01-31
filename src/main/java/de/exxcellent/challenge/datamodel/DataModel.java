package de.exxcellent.challenge.datamodel;

import de.exxcellent.challenge.fileloader.FileLoader;

import java.io.IOException;

/**
 * Generic interface for maintaining loaded data.
 */
public abstract class DataModel {
    protected String[][] data;

    /**
     * stores data from file loader
     * @param fileLoader
     * @throws IOException
     */
    public abstract void store(FileLoader fileLoader) throws IOException;

    /**
     * returns row specified by parameter.
     * @param row
     * @return
     */
    public abstract String[] retrieve(int row);

    /**
     * returns the amount of rows in total.
     * @return
     */
    public abstract int getAmountRows();
}
