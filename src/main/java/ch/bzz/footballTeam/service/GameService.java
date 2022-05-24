package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Game;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Path("game")
public class GameService {
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gameList(@QueryParam("sort") String sort) {
        List<Game> gameList= DataHandler.getInstance().readAllGames();

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

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gameRead(@QueryParam("uuid") String gameUUID) {
        Game game=DataHandler.getInstance().readGameByUUID(gameUUID);

        if(game==null) {
            return Response.status(400).build();
        }

        return Response.status(200).entity(game).build();
    }
}
