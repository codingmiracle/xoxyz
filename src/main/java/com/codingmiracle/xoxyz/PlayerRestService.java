package com.codingmiracle.xoxyz;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;

@Path("/player")
public class PlayerRestService {
    private List<Player> playerList = new ArrayList<Player>();
    @Path("/new")
    @POST
    public void createPlayer(String name) {
        playerList.add(new Player(name));
    }

    @Path("/{PlayerId}")
    @GET
    public Player getPlayer(@PathParam("PlayerId") long playerId) {
        return new Player(playerId, "mark");
    }


}
