package de.exxcellent.challenge.queries;

import de.exxcellent.challenge.datamodel.DataModelFootball;

/**
 * Generic interface for querying football data. Generic type specifies return type of getResult().
 * @param <T>
 */
public interface FootballQuery<T> {

    /**
     * Executes calculation on data model.
     * @param dataModel
     */
    void execute(DataModelFootball dataModel);

    /**
     * Returns result of execution.
     * @return
     */
    T getResult();
}
