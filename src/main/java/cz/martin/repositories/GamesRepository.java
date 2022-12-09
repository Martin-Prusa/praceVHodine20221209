package cz.martin.repositories;

import cz.martin.models.Eteam;
import cz.martin.models.Game;
import cz.martin.models.StadiumGoals;
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

    public List<String> getPlayersScored(String team) {
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/euro?user=root&password=password");
            PreparedStatement statement = connection.prepareStatement("""
                SELECT DISTINCT GL.player
                FROM Goal AS GL JOIN Game AS GM ON (GM.id = GL.matchid)
                WHERE (GM.team1 LIKE ? OR GM.team2 LIKE ?) AND !(GL.teamid LIKE ?)
            """);

            statement.setString(1, team);
            statement.setString(2, team);
            statement.setString(3, team);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<StadiumGoals> getGoals() {
        ArrayList<StadiumGoals> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/euro?user=root&password=password");
            PreparedStatement statement = connection.prepareStatement("""
                SELECT DISTINCT GM.stadium, COUNT(GL.matchid)
                FROM Goal AS GL JOIN Game AS GM ON (GM.id = GL.matchid)
                GROUP BY GM.stadium
            """);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                list.add(new StadiumGoals(resultSet.getString(1), resultSet.getInt(2)));
            }
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
