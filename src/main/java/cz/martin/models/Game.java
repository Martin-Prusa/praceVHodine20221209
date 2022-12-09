package cz.martin.models;

public class Game {
    private int id;
    private String mdate;
    private String stadium;
    private String team1;
    private String team2;

    private int goals = 0;

    public Game(int id, String mdate, String stadium, String team1, String team2) {
        this.id = id;
        this.mdate = mdate;
        this.stadium = stadium;
        this.team1 = team1;
        this.team2 = team2;
    }

    public int getId() {
        return id;
    }

    public String getMdate() {
        return mdate;
    }

    public String getStadium() {
        return stadium;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
