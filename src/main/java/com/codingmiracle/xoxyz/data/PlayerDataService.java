package com.codingmiracle.xoxyz.data;

import com.codingmiracle.xoxyz.Player;

import java.sql.*;

public class PlayerDataService {

    private final Connection connection;

    public PlayerDataService(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public boolean createPlayer(String name) throws SQLException {
        PreparedStatement playerInsert = connection.prepareStatement("INSERT INTO db_xoxyz.tbl_player (player_name) VALUES (?)");
        playerInsert.setString(1, name);
        return playerInsert.execute();
    }

    public boolean deletePlayer(Long id) throws SQLException {
        PreparedStatement playerDelete = connection.prepareStatement("DELETE FROM db_xoxyz.tbl_player WHERE player_id = ?");
        playerDelete.setLong(1, id);
        return playerDelete.execute();
    }

    public Player queryPlayerById(Long id) throws SQLException {
        Player player = null;
        PreparedStatement playerQuery = connection.prepareStatement("SELECT * from tbl_player WHERE player_id = ?");
        playerQuery.setLong(1, id);
        ResultSet queryResult = playerQuery.executeQuery();
        while (queryResult.next()) {
            player = new Player(queryResult.getBigDecimal(1).longValue(), queryResult.getString(2));
        }
        return player;
    }

    public Player queryPlayerByName(String name) throws SQLException {
        Player player = null;
        PreparedStatement playerQuery = connection.prepareStatement("SELECT * from tbl_player WHERE player_name = ?");
        playerQuery.setString(1, name);
        ResultSet queryResult = playerQuery.executeQuery();
        while (queryResult.next()) {
            player = new Player(queryResult.getBigDecimal(1).longValue(), queryResult.getString(2));
        }
        return player;
    }
}
