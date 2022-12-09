package cz.martin.beans;

import cz.martin.services.GamesService;
import cz.martin.services.TeamsService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@RequestScoped
@Named("players")
public class PlayersBean {
    @Inject
    private TeamsService teamsService;

    @Inject
    private GamesService gamesService;

    private String team = "";

    public void send() {
        System.out.println(team);
    }

    public List<String> getPlayersScored() {
        return gamesService.getPlayersScored(team);
    }

    public List<String> getTeamsId() {
        return teamsService.getTeamsID();
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
