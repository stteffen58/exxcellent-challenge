package de.exxcellent.challenge;

import de.exxcellent.challenge.datamodel.DataModelFootball;
import de.exxcellent.challenge.datamodel.DataModelWeather;
import de.exxcellent.challenge.fileloader.FileLoaderFactory;
import de.exxcellent.challenge.queries.FootballQuery;
import de.exxcellent.challenge.queries.SmallestGoalDifferenceQuery;
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
        String day = "";
        String team = "";
        try {
            WeatherQuery<String> weatherQuery = new SmallestTemperatureSpreadQuery(
                    new DataModelWeather(FileLoaderFactory.getCsvFileLoader("weather.csv")));
            FootballQuery<String> footballQuery = new SmallestGoalDifferenceQuery(
                    new DataModelFootball(FileLoaderFactory.getCsvFileLoader("football.csv")));
            day = weatherQuery.getResult();
            team = footballQuery.getResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String dayWithSmallestTempSpread = day;     // Your day analysis function call …
        String teamWithSmallesGoalSpread = team; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
