package cz.martin.models;

public class Eteam {
    private String id;
    private String teamName;
    private String coach;

    public Eteam(String id, String teamName, String coach) {
        this.id = id;
        this.teamName = teamName;
        this.coach = coach;
    }

    public String getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCoach() {
        return coach;
    }
}
