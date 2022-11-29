package com.codingmiracle.xoxyz;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;

@Path("/game")
public class GameRestService {
    List<Game> gameList = new ArrayList<Game>();
    @GET
    @Path("/{GameId}")
    public Game getState(@PathParam("GameId") long gameId) {
        return new Game(gameId);
    }

    @POST()
    public void createGame(long playerId) {
        gameList.add(new Game(new Player(playerId)));
    }

    @POST
    @Path("/{GameId}/join")
    public boolean joinGame(long playerId, @PathParam("GameId") long gameId) {
        return true;
    }

    @POST
    @Path("{GameId}/set")
    public boolean setAtGame(@PathParam("GameId") long gameId) {
        return true;
    }
}

