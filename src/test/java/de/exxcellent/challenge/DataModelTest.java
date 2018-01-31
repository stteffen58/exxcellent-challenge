package de.exxcellent.challenge;

import de.exxcellent.challenge.datamodel.DataModelFootball;
import de.exxcellent.challenge.datamodel.DataModelWeather;
import de.exxcellent.challenge.fileloader.FileLoader;
import de.exxcellent.challenge.fileloader.FileLoaderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class DataModelTest {
    private String weatherDataFileName;
    private String footballDataFileName;
    private FileLoader fileLoaderWeather;
    private FileLoader fileLoaderFootball;


    @Before
    public void setUp() throws Exception {
        weatherDataFileName = "weather.csv";
        fileLoaderWeather = FileLoaderFactory.getCsvFileLoader(weatherDataFileName);

        footballDataFileName = "football.csv";
        fileLoaderFootball = FileLoaderFactory.getCsvFileLoader(footballDataFileName);
    }

    @Test
    public void createDataModelTestNull() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(null);
        Assert.assertNull(dataModelWeather.retrieve(0));

        DataModelFootball dataModelFootball = new DataModelFootball(null);
        Assert.assertNull(dataModelFootball.retrieve(0));
    }

    @Test
    public void createDataModelTest() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(fileLoaderWeather);
        Assert.assertNotNull(dataModelWeather.retrieve(0));

        DataModelFootball dataModelFootball = new DataModelFootball(fileLoaderFootball);
        Assert.assertNotNull(dataModelFootball.retrieve(0));
    }

    @Test
    public void indexOutOfBoundsTest() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(fileLoaderWeather);
        Assert.assertNull(dataModelWeather.retrieve(300));

        DataModelFootball dataModelFootball = new DataModelFootball(fileLoaderFootball);
        Assert.assertNull(dataModelFootball.retrieve(300));
    }

    @Test
    public void getAmountOfRowsTest() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(fileLoaderWeather);
        Assert.assertEquals(30,dataModelWeather.getAmountRows());

        DataModelFootball dataModelFootball = new DataModelFootball(fileLoaderFootball);
        Assert.assertEquals(20,dataModelFootball.getAmountRows());
    }

    @Test
    public void getAmountOfRowsNullTest() throws IOException {
        DataModelWeather dataModelWeather = new DataModelWeather(null);
        Assert.assertEquals(0,dataModelWeather.getAmountRows());

        DataModelFootball dataModelFootball = new DataModelFootball(null);
        Assert.assertEquals(0,dataModelFootball.getAmountRows());
    }
}
