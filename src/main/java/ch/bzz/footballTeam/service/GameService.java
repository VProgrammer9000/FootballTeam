package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Game;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("game")
public class GameService {
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gameList() {
        List<Game> gameList= DataHandler.getInstance().readAllGames();
        return Response
                .status(200)
                .entity(gameList)
                .build();
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
