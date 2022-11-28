package com.codingmiracle.xoxyz;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerRestService {

    private List<Player> playerList = new ArrayList<>();

    @Path("/{PlayerName}")
    @POST
    public void createPlayer(@PathParam("PlayerName") String name) {
        Player player = new Player(name);playerList.add(player);
    }

    @Path("/{PlayerId}")
    @DELETE
    public void deletePlayer(@PathParam("PlayerId") long playerId) {
        playerList.remove(new Player(playerId));
    }

    @Path("/{PlayerId}")
    @GET
    public Player getPlayer(@PathParam("PlayerId") long playerId) {
        return playerList.get(playerList.indexOf(new Player(playerId)));
    }

    @Path("/list")
    @POST
    public List<Player> getPlayerList() {
        return playerList;
    }


}
