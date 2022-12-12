package com.codingmiracle.xoxyz.rest;

import com.codingmiracle.xoxyz.Player;
import com.codingmiracle.xoxyz.data.PlayerDataService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.security.InvalidParameterException;
import java.sql.SQLException;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerRestService {
    PlayerDataService playerDataService;

    PlayerRestService() {
        try {
            String url = "jdbc:mariadb://localhost:3306/db_xoxyz";
            String user = "web_client";
            String password = "password";
            playerDataService = new PlayerDataService(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Path("/{PlayerName}")
    @POST
    public Response createPlayer(@PathParam("PlayerName") String name) {
        try {
            if(!playerDataService.createPlayer(name)) {
                return Response.ok(playerDataService.queryPlayerByName(name)).build();
            }
            return Response.status(500).build();
        } catch (SQLException | InvalidParameterException e) {
            return Response.status(400).build();
        }
    }

    @Path("/{PlayerId}")
    @DELETE
    public Response deletePlayer(@PathParam("PlayerId") long playerId) {
        try {
            if(!playerDataService.deletePlayer(playerId)) {
                return Response.ok("Ok").build();
            }
            return Response.status(500).build();
        } catch (SQLException e) {
            return Response.status(400).build();
        }
    }

    @Path("/{PlayerValue}")
    @GET
    public Response getPlayer(@PathParam("PlayerValue") String playerVal) {
        Player player;
        if (Player.isPlayerId(playerVal)) {
            Long id = Long.parseLong(playerVal);
            try {
                player = playerDataService.queryPlayerById(id);
            } catch (SQLException e) {
                return Response.status(500).build();
            }
        } else {
            try {
                player = playerDataService.queryPlayerByName(playerVal);
            } catch (SQLException e) {
                return Response.status(500).build();
            }
        }
        if(player != null) {
            return Response.ok(player).build();
        }
        return Response.status(404).build();
    }
}
