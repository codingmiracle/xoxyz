package com.codingmiracle.xoxyz;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/Game")
public class GameRestService {
    @GET
    @Path("/{GameId}")
    public Game getState(@PathParam("GameId") long gameId) {
        return new Game(gameId);
    }

    @Path("/new")
    @POST()
    public void createGame(Player p) {

    }

    @POST
    @Path("/{GameId}/join")
    public void joinGame(Player p, @PathParam("GameId") long gameId) {

    }
}

