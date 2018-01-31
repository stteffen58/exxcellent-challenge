package de.exxcellent.challenge;

import de.exxcellent.challenge.datamodel.DataModelWeather;
import de.exxcellent.challenge.fileloader.FileLoader;
import de.exxcellent.challenge.fileloader.FileLoaderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DataModelTest {
    private String weatherDataFileName;
    private FileLoader fileLoader;

    @Before
    public void setUp() throws Exception {
        weatherDataFileName = "weather.csv";
        fileLoader = FileLoaderFactory.getCsvFileLoader(weatherDataFileName);
    }

    @Test
    public void createDataModelTestNull() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(null);
        Assert.assertNull(dataModelWeather.retrieve(0));
    }

    @Test
    public void createDataModelTest() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(fileLoader);
        Assert.assertNotNull(dataModelWeather.retrieve(0));
    }

    @Test
    public void indexOutOfBoundsTest() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(fileLoader);
        Assert.assertNull(dataModelWeather.retrieve(300));
    }

    @Test
    public void getAmountOfRowsTest() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(fileLoader);
        Assert.assertEquals(30,dataModelWeather.getAmountRows());
    }

    @Test
    public void getAmountOfRowsNullTest() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(null);
        Assert.assertEquals(0,dataModelWeather.getAmountRows());
    }
}
