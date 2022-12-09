package cz.martin.models;

public class StadiumGoals {
    private String stadium;
    private int goals;

    public StadiumGoals(String stadium, int goals) {
        this.stadium = stadium;
        this.goals = goals;
    }

    public String getStadium() {
        return stadium;
    }

    public int getGoals() {
        return goals;
    }
}
