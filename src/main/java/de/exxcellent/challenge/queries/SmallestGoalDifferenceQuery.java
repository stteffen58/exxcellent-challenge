package de.exxcellent.challenge.queries;

import de.exxcellent.challenge.datamodel.DataModelFootball;

/**
 * Calculates name of the team with smallest difference of scored goals and received goals (goals - goals allowed).
 */
public class SmallestGoalDifferenceQuery implements FootballQuery<String> {
    private String result;

    public SmallestGoalDifferenceQuery(DataModelFootball dataModel) {
        execute(dataModel);
    }

    @Override
    public void execute(DataModelFootball dataModel) {
        if (dataModel != null) {
            String team = "";
            int goalDifference = Integer.valueOf(dataModel.retrieve(0)[5]) - Integer.valueOf(dataModel.retrieve(0)[6]);
            for(int i=1; i<dataModel.getAmountRows(); i++) {
                int difference = Integer.valueOf(dataModel.retrieve(i)[1]) - Integer.valueOf(dataModel.retrieve(i)[2]);
                if(difference < goalDifference) {
                    goalDifference = difference;
                    team = dataModel.retrieve(i)[0];
                }
            }
            this.result = team;
        }
    }

    @Override
    public String getResult() {
        return result;
    }
}
