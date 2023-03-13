package com.codingmiracle.xoxyz.data;


import com.codingmiracle.xoxyz.Models.GameDto;
import com.codingmiracle.xoxyz.Models.MoveDto;
import com.codingmiracle.xoxyz.Models.PlayerDto;

import java.sql.*;

public class GameDataService {

    private final Connection connection;
    PlayerDataService playerDataService;

    public GameDataService(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        playerDataService = new PlayerDataService(url, user, password);
    }

    public boolean createGame(PlayerDto host) throws SQLException {
        PreparedStatement playerInsert = connection.prepareStatement("INSERT INTO db_xoxyz.tbl_game (game_host) VALUES (?)");
        playerInsert.setLong(1, host.getId());
        return playerInsert.execute();
    }

    public boolean joinGame(Long gameId, PlayerDto guest) throws SQLException {
        PreparedStatement gameStatement = connection.prepareStatement("UPDATE db_xoxyz.tbl_game t SET t.game_guest = ? WHERE t.game_id = ?");
        gameStatement.setLong(2, gameId);
        gameStatement.setLong(1, guest.getId());
        return gameStatement.execute();
    }

    public GameDto queryGameById(Long id) throws SQLException {
        GameDto gameDto = null;
        PreparedStatement gameQuery = connection.prepareStatement("SELECT * from tbl_game WHERE game_id = ?");
        gameQuery.setLong(1, id);
        ResultSet queryResult = gameQuery.executeQuery();
        while (queryResult.next()) {
            gameDto = new GameDto(queryResult.getBigDecimal(1).longValue(), playerDataService.queryPlayerById(queryResult.getLong(2)), playerDataService.queryPlayerById(queryResult.getLong(3)), playerDataService.queryPlayerById(queryResult.getLong(4)));
        }
        return gameDto;
    }

    public boolean setMove(GameDto gameDto, MoveDto moveDto) throws SQLException {
        PreparedStatement playerInsert = connection.prepareStatement("INSERT INTO db_xoxyz.tbl_game (game_host) VALUES (?)");
        playerInsert.setLong(1, moveDto.getPlayerId());
        return playerInsert.execute();
    }


}
