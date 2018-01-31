package de.exxcellent.challenge;

import de.exxcellent.challenge.datamodel.DataModelFootball;
import de.exxcellent.challenge.datamodel.DataModelWeather;
import de.exxcellent.challenge.fileloader.FileLoader;
import de.exxcellent.challenge.fileloader.FileLoaderFactory;
import de.exxcellent.challenge.queries.FootballQuery;
import de.exxcellent.challenge.queries.SmallestGoalDifferenceQuery;
import de.exxcellent.challenge.queries.SmallestTemperatureSpreadQuery;
import de.exxcellent.challenge.queries.WeatherQuery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueryTest {
    private String weatherDataFileName;
    private String footballDataFileName;
    private FileLoader fileLoaderWeather;
    private FileLoader fileLoaderFootball;
    private DataModelWeather dataModelWeather;
    private DataModelFootball dataModelFootball;

    @Before
    public void setUp() throws Exception {
        weatherDataFileName = "weather.csv";
        fileLoaderWeather = FileLoaderFactory.getCsvFileLoader(weatherDataFileName);
        dataModelWeather = new DataModelWeather(fileLoaderWeather);

        footballDataFileName = "football.csv";
        fileLoaderFootball = FileLoaderFactory.getCsvFileLoader(footballDataFileName);
        dataModelFootball = new DataModelFootball(fileLoaderFootball);
    }

    @Test
    public void dataModelNullTest() {
        WeatherQuery<String> weatherQuery = new SmallestTemperatureSpreadQuery(null);
        Assert.assertNull(weatherQuery.getResult());

        FootballQuery<String> footballQuery = new SmallestGoalDifferenceQuery(null);
        Assert.assertNull(footballQuery.getResult());
    }

    @Test
    public void queryResultTest() {
        WeatherQuery<String> weatherQuery = new SmallestTemperatureSpreadQuery(dataModelWeather);
        Assert.assertEquals("14",weatherQuery.getResult());

        FootballQuery<String> footballQuery = new SmallestGoalDifferenceQuery(dataModelFootball);
        Assert.assertEquals("Liverpool",footballQuery.getResult());

    }
}
