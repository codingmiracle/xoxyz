package com.codingmiracle.xoxyz.rest;

import com.codingmiracle.xoxyz.Models.GameDto;
import com.codingmiracle.xoxyz.Models.PlayerDto;
import com.codingmiracle.xoxyz.data.GameDataService;
import com.codingmiracle.xoxyz.data.PlayerDataService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Path("/game")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameRestService {

    PlayerDataService playerDataService;
    GameDataService gameDataService;
    Set<GameDto> runningGameDtos;

    public GameRestService() {
        String url = "jdbc:mariadb://localhost:3306/db_xoxyz";
        String user = "web_client";
        String password = "password";
        runningGameDtos = new HashSet<>();
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
    public Response createGame(@QueryParam("id") String param) {
        PlayerDto playerDto;
        try {
            if(PlayerDto.isPlayerId(param)) {
                playerDto = playerDataService.queryPlayerById(Long.parseLong(param));
            } else {
                playerDto = playerDataService.queryPlayerByName(param);
            }
        } catch (SQLException e) {
            return Response.status(500).build();
        }

        if(playerDto == null) {
            return Response.status(404, "Player couldn't be found").build();
        }

        try {
            if(!gameDataService.createGame(playerDto)) {
                return Response.ok().build();
            }
            return Response.status(500, "Something went wrong").build();
        } catch (SQLException e) {
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/{GameId}/join")
    public Response joinGame(@QueryParam("id") long playerId, @PathParam("GameId") long gameId) {
        try {
            PlayerDto playerDto = playerDataService.queryPlayerById(playerId);
            if(!gameDataService.joinGame(gameId, playerDto)) {
                return Response.ok().build();
            } else {
                return Response.status(500, "Could not join Game").build();
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

