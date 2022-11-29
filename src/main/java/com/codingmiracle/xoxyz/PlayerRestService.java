package com.codingmiracle.xoxyz;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerRestService {

    private List<Player> playerList;

    PlayerRestService() {
        playerList = new ArrayList<>();
    }

    @Path("/{PlayerName}")
    @POST
    public Player createPlayer(@PathParam("PlayerName") String name) {
        Player player = new Player(name);
        playerList.add(player);
        return player;
    }

    @Path("/{PlayerId}")
    @DELETE
    public String deletePlayer(@PathParam("PlayerId") long playerId) {
        playerList.remove(new Player(playerId));
        return "Ok";
    }

    @Path("/{PlayerValue}")
    @GET
    public Player getPlayer(@PathParam("PlayerValue") String playerVal) {
        if (Player.isPlayerId(playerVal)) {
            Long id = Long.parseLong(playerVal);
            return new Player(id);
            //return playerList.stream().filter(player -> id.equals(player.getId())).findFirst().orElse(new Player());
        }
        return  new Player(playerVal);
        //return playerList.stream().filter(player -> playerVal.equals(player.getName())).findFirst().orElse(new Player());
    }

    @Path("/all")
    @GET
    public Object[] getPlayerList() {
        return playerList.toArray();
    }


}
