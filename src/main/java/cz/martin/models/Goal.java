package cz.martin.models;

public class Goal {
    private String teamId;
    private String player;
    private int matchId;
    private int gtime;

    public Goal(String teamId, String player, int matchId, int gtime) {
        this.teamId = teamId;
        this.player = player;
        this.matchId = matchId;
        this.gtime = gtime;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getPlayer() {
        return player;
    }

    public int getMatchId() {
        return matchId;
    }

    public int getGtime() {
        return gtime;
    }
}
