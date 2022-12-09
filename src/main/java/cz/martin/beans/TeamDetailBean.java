package cz.martin.beans;

import cz.martin.models.Eteam;
import cz.martin.models.Game;
import cz.martin.services.GamesService;
import cz.martin.services.TeamsService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@RequestScoped
@Named("detail")
public class TeamDetailBean {
    @Inject
    private TeamsService teamsService;

    @Inject
    private GamesService gamesService;

    public Eteam getTeam() {
        return teamsService.getTeamByID(getTeamID());
    }

    public List<Game> getGames() {
        return gamesService.getGamesForTeam(getTeamID());
    }

    private String getTeamID() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        return id;
    }
}
