package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Game;

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
 * services for reading, adding, changing and deleting games
 *
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 24.05.2022
 */

@Path("game")
public class GameService {

    /**
     * reads a list of all games
     * @param sort by which attribute is sorted
     * @return  games as JSON
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gameList(@QueryParam("sort") String sort) {
        List<Game> gameList= DataHandler.readAllGames();

        //sort
        if (sort!=null) {
            List<Game> cloned_gameList = new ArrayList<>(gameList);

            if (sort.equals("date")) {
                cloned_gameList.sort(Comparator.comparing(Game::getDate));
            }else{
                return Response.status(400).build();
            }

            return Response.status(200).entity(cloned_gameList).build();
        }

        return Response.status(200).entity(gameList).build();
    }

    /**
     * reads a game identified by the uuid
     * @param gameUUID the key
     * @return game
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gameRead(@QueryParam("uuid") String gameUUID) {
        Game game=DataHandler.readGameByUUID(gameUUID);

        if(game==null) {
            return Response.status(400).build();
        }

        return Response.status(200).entity(game).build();
    }



    /**
     * inserts a new game
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertGame(
            @Valid @BeanParam Game game
    ) {
        game.setUuid(UUID.randomUUID().toString());

        DataHandler.insertGame(game);

        return Response.status(200).entity("").build();
    }

    /**
     * updates a new game
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateGame(
            @Valid @BeanParam Game game
    ) {
        Game oldGame = DataHandler.readGameByUUID(game.getUuid());
        if (oldGame == null) {
            return Response.status(410).entity("").build();
        }
            oldGame.setTeam1(game.getTeam1());
            oldGame.setTeam2(game.getTeam2());
            oldGame.setGameResult(game.getGameResult());
            oldGame.setDate(game.getDate());

            DataHandler.updateGame();

        return Response.status(200).entity("").build();
    }

    /**
     * deletes a game identified by its uuid
     * @param gameUUID  the key
     * @return  Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteGame(
            @NotNull
            @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @QueryParam("uuid") String gameUUID
    ) {
        int httpStatus = 200;

        if (!DataHandler.deleteGame(gameUUID)) {
            httpStatus = 410;
        }

        return Response.status(httpStatus).entity("").build();
    }
}
