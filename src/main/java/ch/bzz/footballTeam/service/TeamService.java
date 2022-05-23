package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Team;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;
@Path("team")
public class TeamService {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teamList() {
        List<Team> teamList= DataHandler.getInstance().readAllTeams();
        return Response
                .status(200)
                .entity(teamList)
                .build();
    }

    @GET
    @Path("read")
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
