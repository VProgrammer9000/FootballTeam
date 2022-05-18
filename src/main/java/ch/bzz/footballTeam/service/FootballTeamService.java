package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Game;
import ch.bzz.footballTeam.model.Player;
import ch.bzz.footballTeam.model.Team;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

/**
 * Football Team service
 */
@Path("Football")
public class FootballTeamService {
    @GET
    @Path("gameList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gameList() {
        List<Game> bookMap=DataHandler.getInstance().readAllGames();
        return Response
                .status(200)
                .entity(bookMap)
                .build();
    }

    @GET
    @Path("gameRead")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gameRead(@QueryParam("uuid") String gameUUID) {
        try {
            UUID uuid = UUID.fromString(gameUUID);
        } catch (IllegalArgumentException e) {
            return Response
                    .status(400)
                    .build();
        }

        Game game=DataHandler.getInstance().readGameByUUID(gameUUID);

        return Response
                .status(200)
                .entity(game)
                .build();
    }

    @GET
    @Path("playerList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response playerList() {
        List<Player> bookMap=DataHandler.getInstance().readAllPlayers();
        return Response
                .status(200)
                .entity(bookMap)
                .build();
    }

    @GET
    @Path("playerRead")
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


    @GET
    @Path("teamList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teamList() {
        List<Team> teamList=DataHandler.getInstance().readAllTeams();
        return Response
                .status(200)
                .entity(teamList)
                .build();
    }

    @GET
    @Path("teamRead")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teamRead(@QueryParam("uuid") String teamUUID) {
        try {
            UUID uuid = UUID.fromString(teamUUID);
        } catch (IllegalArgumentException e) {
            return Response
                    .status(400)
                    .build();
        }

        Team team=DataHandler.getInstance().readTeamByUUID(teamUUID);

        return Response
                .status(200)
                .entity(team)
                .build();
    }
}