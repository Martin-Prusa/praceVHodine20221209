package cz.martin.beans;

import cz.martin.models.StadiumGoals;
import cz.martin.services.GamesService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@RequestScoped
@Named("stadium")
public class StadiumGoalsBean {
    @Inject
    private GamesService gamesService;

    public List<StadiumGoals> getGoals() {
        return gamesService.getGoals();
    }
}
