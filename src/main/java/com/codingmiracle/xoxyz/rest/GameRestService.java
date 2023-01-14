package com.codingmiracle.xoxyz.rest;

import com.codingmiracle.xoxyz.Game;
import com.codingmiracle.xoxyz.Player;
import com.codingmiracle.xoxyz.data.GameDataService;
import com.codingmiracle.xoxyz.data.PlayerDataService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Path("/game")
public class GameRestService {

    PlayerDataService playerDataService;
    GameDataService gameDataService;
    Set<Game> runningGames;

    public GameRestService() {
        String url = "url";
        String user = "user";
        String password = "password";
        runningGames = new HashSet<>();
        try {
            playerDataService = new PlayerDataService(url, user, password);
            gameDataService = new GameDataService(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/{GameId}")
    public Response getState(@PathParam("GameId") long gameId) {
        try {
            return Response.ok(gameDataService.queryGameById(gameId)).build();
        } catch (SQLException e) {
            return Response.status(404).build();
        }
    }

    @POST()
    public Response createGame(long playerId) {
        Player player;
        try {
            player = playerDataService.queryPlayerById(playerId);
            if(!gameDataService.createGame(player)) {
                return Response.ok().build();
            }
            return Response.status(500, "Game already exists").build();
        } catch (SQLException e) {
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/{GameId}/join")
    public Response joinGame(long playerId, @PathParam("GameId") long gameId) {
        try {
            Player player = playerDataService.queryPlayerById(playerId);
            if(!gameDataService.joinGame(gameId, player)) {
                return Response.status(500, "Could not join Game").build();
            } else {
                return Response.status(500).build();
            }
        } catch (SQLException e) {
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/{GameId}/set")
    public boolean setAtGame(@PathParam("GameId") long gameId) {
        //check if move is possible
        //check if move leads to win
        //set move
        return true;
    }

    @DELETE
    @Path("/{GameId}")
    public Response deleteGame(@PathParam("GameId") long gameId) {
        return Response.ok().build();
    }
}

