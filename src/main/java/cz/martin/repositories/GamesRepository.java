package cz.martin.repositories;

import cz.martin.models.Eteam;
import cz.martin.models.Game;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GamesRepository {
    public List<Game> getGamesForTeam(String teamID) {
        ArrayList<Game> games = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/euro?user=root&password=password");
            PreparedStatement statement = connection.prepareStatement("""
                SELECT G.id, G.mdate, G.stadium, G.team1, G.team2, COUNT(L.teamid)
                FROM Game AS G JOIN Goal AS L ON L.matchid = G.id
                WHERE G.team1 LIKE ? OR G.team2 LIKE ?
                GROUP BY G.id
            """);

            statement.setString(1, teamID);
            statement.setString(2, teamID);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Game g =new Game(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                g.setGoals(resultSet.getInt(6));
                games.add(g);
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return games;
    }
}
