package de.exxcellent.challenge;

import de.exxcellent.challenge.datamodel.DataModelWeather;
import de.exxcellent.challenge.fileloader.FileLoader;
import de.exxcellent.challenge.fileloader.FileLoaderFactory;
import de.exxcellent.challenge.queries.SmallestTemperatureSpreadQuery;
import de.exxcellent.challenge.queries.WeatherQuery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueryTest {
    private String weatherDataFileName;
    private FileLoader fileLoader;
    private DataModelWeather dataModelWeather;

    @Before
    public void setUp() throws Exception {
        weatherDataFileName = "weather.csv";
        fileLoader = FileLoaderFactory.getCsvFileLoader(weatherDataFileName);
        dataModelWeather = new DataModelWeather(fileLoader);
    }

    @Test
    public void dataModelNullTest() {
        WeatherQuery<String> weatherQuery = new SmallestTemperatureSpreadQuery(null);
        Assert.assertNull(weatherQuery.getResult());
    }

    @Test
    public void queryResultTest() {
        WeatherQuery<String> weatherQuery = new SmallestTemperatureSpreadQuery(dataModelWeather);
        Assert.assertEquals("14",weatherQuery.getResult());
    }
}
