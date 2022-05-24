package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Game;
import ch.bzz.footballTeam.model.Player;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("player")
public class PlayerService {
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response playerList(@QueryParam("sort") String sort) {
        List<Player> playerList= DataHandler.getInstance().readAllPlayers();

        //sort
        if (sort!=null) {
            List<Player> cloned_playerList = playerList.stream().collect(Collectors.toList());

            if (sort.equals("name")) {
                cloned_playerList.sort(Comparator.comparing(Player::getName));
            }

            if (sort.equals("prename")) {
                cloned_playerList.sort(Comparator.comparing(Player::getPrename));
            }

            if (sort.equals("number")) {
                cloned_playerList.sort(Comparator.comparing(Player::getNumber));
            }

            return Response.status(200).entity(cloned_playerList).build();
        }

        return Response.status(200).entity(playerList).build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response playerRead(@QueryParam("uuid") String playerUUID) {
        Player player=DataHandler.getInstance().readPlayerByUUID(playerUUID);

        if(player==null) {
            return Response.status(400).build();
        }

        return Response.status(200).entity(player).build();
    }

}
