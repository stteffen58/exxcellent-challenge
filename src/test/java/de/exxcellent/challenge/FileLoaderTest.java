package de.exxcellent.challenge;

import de.exxcellent.challenge.fileloader.FileLoader;
import de.exxcellent.challenge.fileloader.FileLoaderCsv;
import de.exxcellent.challenge.fileloader.FileLoaderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileLoaderTest {
    private String weatherDataFileName;
    private String filePath;

    @Before
    public void setUp() throws Exception {
        String resourcePath = "de/exxcellent/challenge/";
        ClassLoader classloader = FileLoaderFactory.class.getClassLoader();
        weatherDataFileName = "weather.csv";
        filePath = classloader.getResource(resourcePath + weatherDataFileName).getPath();

    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundTest() throws IOException {
        FileLoader fileLoader = new FileLoaderCsv("");
        fileLoader.loadData();
    }

    @Test
    public void fileFoundTest() throws IOException {
        FileLoader fileLoader = new FileLoaderCsv(filePath);
        String[][] data = fileLoader.loadData();
        Assert.assertNotNull(null,data);
    }

    @Test
    public void fileFactoryLoaderTest() throws IOException {
        FileLoader fileLoader = FileLoaderFactory.getCsvFileLoader(weatherDataFileName);
        String[][] data = fileLoader.loadData();
        Assert.assertNotNull(null,data);
    }
}
