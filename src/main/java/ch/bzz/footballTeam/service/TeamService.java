package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Player;
import ch.bzz.footballTeam.model.Team;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Path("team")
public class TeamService {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teamList(@QueryParam("sort") String sort) {
        List<Team> teamList= DataHandler.getInstance().readAllTeams();

        //sort
        if (sort!=null) {
            List<Team> cloned_teamList = new ArrayList<>(teamList);

            if (sort.equals("name")) {
                cloned_teamList.sort(Comparator.comparing(Team::getName));
            } else if (sort.equals("amountWins")) {
                cloned_teamList.sort(Comparator.comparing(Team::getAmountWins));
            } else if (sort.equals("amountLost")) {
                cloned_teamList.sort(Comparator.comparing(Team::getAmountLost));
            }else{
                return Response.status(400).build();
            }

            return Response.status(200).entity(cloned_teamList).build();
        }

        return Response.status(200).entity(teamList).build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teamRead(@QueryParam("uuid") String teamUUID,@QueryParam("filterN") String teamName) {
        Team team=DataHandler.getInstance().readTeamByUUID(teamUUID);

        if(team==null) {
            return Response.status(400).build();
        }


        return Response.status(200).entity(team).build();
    }
}
