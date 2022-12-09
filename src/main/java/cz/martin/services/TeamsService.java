package cz.martin.services;

import cz.martin.models.Eteam;
import cz.martin.repositories.TeamsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TeamsService {
    @Inject
    private TeamsRepository teamsRepository;

    public List<Eteam> getTeams() {
        return teamsRepository.getEteams();
    }

    public Eteam getTeamByID(String id) {
        return teamsRepository.getTeamByID(id);
    }

    public List<String> getTeamsID() {
        return teamsRepository.getAllTeams();
    }
}
