package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Player;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/**
 * services for reading, adding, changing and deleting players
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 24.05.2022
 */
@Path("player")
public class PlayerService {
    /**
     * reads a list of all players
     * @param sort by which attribute is sorted
     * @return  players as JSON
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response playerList(@QueryParam("sort") String sort) {
        List<Player> playerList= DataHandler.readAllPlayers();

        //sort
        if (sort!=null) {
            List<Player> cloned_playerList = new ArrayList<>(playerList);

            if (sort.equals("name")) {
                cloned_playerList.sort(Comparator.comparing(Player::getName));
            }else if (sort.equals("prename")) {
                cloned_playerList.sort(Comparator.comparing(Player::getPrename));
            }else if (sort.equals("number")) {
                cloned_playerList.sort(Comparator.comparing(Player::getNumber));
            }else{
                return Response.status(400).build();
            }

            return Response.status(200).entity(cloned_playerList).build();
        }

        return Response.status(200).entity(playerList).build();
    }

    /**
     * reads a player identified by the uuid
     * @param playerUUID the key
     * @return player
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response playerRead(@QueryParam("uuid") String playerUUID) {
        Player player=DataHandler.readPlayerByUUID(playerUUID);

        if(player==null) {
            return Response.status(400).build();
        }

        return Response.status(200).entity(player).build();
    }



    /**
     * inserts a new player
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPlayer(
            @Valid @BeanParam Player player,
            @FormParam("playerUUID") String playerUUID
    ) {
        player.setUuid(UUID.randomUUID().toString());

        DataHandler.insertPlayer(player);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a new player
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updatePlayer(
            @Valid @BeanParam Player player
    ) {
        Player oldPlayer = DataHandler.readPlayerByUUID(player.getUuid());

        if (oldPlayer == null){
            return Response.status(410).entity("").build();
        }

        oldPlayer.setName(player.getName());
        oldPlayer.setPrename(player.getPrename());
        oldPlayer.setNumber(player.getNumber());
        DataHandler.updatePlayer();

        return Response.status(200).entity("").build();
    }

    /**
     * deletes a player identified by its uuid
     * @param playerUUID  the key
     * @return  Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteBook(
            @NotNull
            @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @QueryParam("uuid") String playerUUID
    ) {
        int httpStatus = 200;
        if (!DataHandler.deletePlayer(playerUUID)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}
