package de.exxcellent.challenge.fileloader;


import java.io.IOException;

/**
 * Generic interface for loading files.
 */
public interface FileLoader {
    /**
     * Loads data from different file formats.
     *
     * @return 2-d array. First dimension is the row number,
     * second dimension column number.
     * @throws IOException
     */
    String[][] loadData() throws IOException;
}
