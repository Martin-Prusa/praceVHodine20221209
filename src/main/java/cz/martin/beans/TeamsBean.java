package cz.martin.beans;

import cz.martin.models.Eteam;
import cz.martin.services.TeamsService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@RequestScoped
@Named("teams")
public class TeamsBean {
    @Inject
    private TeamsService teamsService;

    public List<Eteam> getTeams() {
        return teamsService.getTeams();
    }
}
