package de.exxcellent.challenge;

import de.exxcellent.challenge.datamodel.DataModelWeather;
import de.exxcellent.challenge.fileloader.FileLoaderFactory;
import de.exxcellent.challenge.queries.WeatherQuery;
import de.exxcellent.challenge.queries.SmallestTemperatureSpreadQuery;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

        // Your preparation code …
        DataModelWeather dataModel = null;
        try {
            dataModel = new DataModelWeather(FileLoaderFactory.getCsvFileLoader("weather.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        WeatherQuery<String> weatherQuery = new SmallestTemperatureSpreadQuery(dataModel);

        String dayWithSmallestTempSpread = weatherQuery.getResult();     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
