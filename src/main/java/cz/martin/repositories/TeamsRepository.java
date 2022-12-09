package cz.martin.repositories;

import cz.martin.models.Eteam;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TeamsRepository {

    public List<Eteam> getEteams() {
        ArrayList<Eteam> teams = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/euro?user=root&password=password");
            PreparedStatement statement = connection.prepareStatement("""
                SELECT T.id, T.teamname, T.coach
                FROM Eteam AS T
            """);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                teams.add(new Eteam(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
            }

            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teams;
    }

    public Eteam getTeamByID(String id) {
        Eteam team = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/euro?user=root&password=password");
            PreparedStatement statement = connection.prepareStatement("""
                SELECT T.id, T.teamname, T.coach
                FROM Eteam AS T
                WHERE T.id LIKE ?
            """);

            statement.setString(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                team = (new Eteam(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return team;
    }
}
