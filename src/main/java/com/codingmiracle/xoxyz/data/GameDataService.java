package com.codingmiracle.xoxyz.data;


import com.codingmiracle.xoxyz.Game;
import com.codingmiracle.xoxyz.Move;
import com.codingmiracle.xoxyz.Player;

import java.sql.*;

public class GameDataService {

    private final Connection connection;
    PlayerDataService playerDataService;

    public GameDataService(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        playerDataService = new PlayerDataService(url, user, password);
    }

    public boolean createGame(Player host) throws SQLException {
        PreparedStatement playerInsert = connection.prepareStatement("INSERT INTO db_xoxyz.tbl_game (game_host) VALUES (?)");
        playerInsert.setLong(1, host.getId());
        return playerInsert.execute();
    }

    public boolean joinGame(Long gameId, Player guest) throws SQLException {
        PreparedStatement gameStatement = connection.prepareStatement("UPDATE db_xoxyz.tbl_game t SET t.game_guest = ? WHERE t.game_id = ?");
        gameStatement.setLong(1, gameId);
        gameStatement.setLong(2, guest.getId());
        return gameStatement.execute();
    }

    public Game queryGameById(Long id) throws SQLException {
        Game game = null;
        PreparedStatement gameQuery = connection.prepareStatement("SELECT * from tbl_game WHERE game_id = ?");
        gameQuery.setLong(1, id);
        ResultSet queryResult = gameQuery.executeQuery();
        while (queryResult.next()) {
            game = new Game(queryResult.getBigDecimal(1).longValue(), playerDataService.queryPlayerById(queryResult.getLong(2)), playerDataService.queryPlayerById(queryResult.getLong(3)), playerDataService.queryPlayerById(queryResult.getLong(4)));
        }
        return game;
    }

    public boolean setMove(Game game, Move move) throws SQLException {
        PreparedStatement playerInsert = connection.prepareStatement("INSERT INTO db_xoxyz.tbl_game (game_host) VALUES (?)");
        playerInsert.setLong(1, move.getPlayer());
        return playerInsert.execute();
    }


}
