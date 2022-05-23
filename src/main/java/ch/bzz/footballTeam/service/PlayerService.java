package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Player;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("player")
public class PlayerService {
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response playerList() {
        List<Player> playerList= DataHandler.getInstance().readAllPlayers();
        return Response
                .status(200)
                .entity(playerList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response playerRead(@QueryParam("uuid") String playerUUID) {
        try {
            UUID uuid = UUID.fromString(playerUUID);
        } catch (IllegalArgumentException e) {
            return Response
                    .status(400)
                    .build();
        }

        Player player=DataHandler.getInstance().readPlayerByUUID(playerUUID);

        return Response
                .status(200)
                .entity(player)
                .build();
    }

}
