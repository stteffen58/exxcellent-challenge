package de.exxcellent.challenge.queries;

import de.exxcellent.challenge.datamodel.DataModelWeather;

/**
 * Calculates day which has smallest temperature spread (maxTemp - minTemp).
 */
public class SmallestTemperatureSpreadQuery implements WeatherQuery<String> {

    private String result;

    public SmallestTemperatureSpreadQuery(DataModelWeather dataModel) {
        execute(dataModel);
    }

    @Override
    public void execute(DataModelWeather dataModel) {
        if (dataModel != null) {
            String day = "";
            int temperatureSpread = Integer.valueOf(dataModel.retrieve(0)[1]) - Integer.valueOf(dataModel.retrieve(0)[2]);
            for(int i=1; i<dataModel.getAmountRows(); i++) {
                int spread = Integer.valueOf(dataModel.retrieve(i)[1]) - Integer.valueOf(dataModel.retrieve(i)[2]);
                if(spread < temperatureSpread) {
                    temperatureSpread = spread;
                    day = dataModel.retrieve(i)[0];
                }
            }
            this.result = day;
        }
    }

    @Override
    public String getResult() {
        return result;
    }


}
