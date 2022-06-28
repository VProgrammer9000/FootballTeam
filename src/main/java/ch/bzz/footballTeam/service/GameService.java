package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.annotations.GameDate;
import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Game;
import ch.bzz.footballTeam.util.AESEncrypt;
import ch.bzz.footballTeam.util.Converter;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
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
 * @version 2.0
 * @since 14.06.2022
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
    public Response gameList(
            @QueryParam("sort") String sort,
            @CookieParam("userRole") String userRole
    ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

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
    public Response gameRead(
            @QueryParam("uuid") String gameUUID,
            @CookieParam("userRole") String userRole
    ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

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
            @Valid @BeanParam Game game,
            @GameDate()
            @Size(min=10,max=10)
            @Pattern(regexp="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])")
            @FormParam("date") String date,
            @CookieParam("userRole") String userRole
    ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("user")||userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

        game.setUuid(UUID.randomUUID().toString());
        game.setDate(Converter.stringToLocalDate(date));
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
            @Valid @BeanParam Game game,
            @Pattern(regexp="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])")
            @Size(min=10,max=10)
            @GameDate()
            @FormParam("date") String date,
            @CookieParam("userRole") String userRole
            ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("user")||userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

        Game oldGame = DataHandler.readGameByUUID(game.getUuid());
        if (oldGame == null) {
            return Response.status(410).entity("").build();
        }

        oldGame.setTeam1(game.getTeam1());
        oldGame.setTeam2(game.getTeam2());
        oldGame.setGameResult(game.getGameResult());
        oldGame.setDate(Converter.stringToLocalDate(date));

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
            @QueryParam("uuid") String gameUUID,
            @CookieParam("userRole") String userRole
    ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("user")||userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

        int httpStatus = 200;

        if (!DataHandler.deleteGame(gameUUID)) {
            httpStatus = 410;
        }

        return Response.status(httpStatus).entity("").build();
    }
}
