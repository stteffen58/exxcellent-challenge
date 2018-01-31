package de.exxcellent.challenge.queries;

import de.exxcellent.challenge.datamodel.DataModelWeather;

/**
 * Generic interface for querying weather data. Generic type specifies return type of getResult().
 * @param <T>
 */
public interface WeatherQuery<T> {
    /**
     * Executes calculation on data model.
     * @param dataModel
     */
    void execute(DataModelWeather dataModel);

    /**
     * Returns result of execution.
     * @return
     */
    T getResult();
}
