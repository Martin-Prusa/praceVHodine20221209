package cz.martin.services;

import cz.martin.models.Game;
import cz.martin.repositories.GamesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GamesService {
    @Inject
    private GamesRepository gamesRepository;

    public List<Game> getGamesForTeam(String teamID) {
        return gamesRepository.getGamesForTeam(teamID);
    }
}
