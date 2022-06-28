package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;
import ch.bzz.footballTeam.model.Team;
import ch.bzz.footballTeam.util.AESEncrypt;

import javax.annotation.security.RolesAllowed;
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
 * services for reading, adding, changing and deleting teams
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 14.06.2022
 */
@Path("team")
public class TeamService {

    /**
     * reads a list of all teams
     * @param sort by which attribute is sorted
     * @return  teams as JSON
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teamList(
            @QueryParam("sort") String sort,
            @CookieParam("userRole") String userRole
    ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

        List<Team> teamList= DataHandler.readAllTeams();

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

    /**
     * reads a book identified by the uuid
     * @param teamUUID the key
     * @return team
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teamRead(
            @QueryParam("uuid") String teamUUID,
            @CookieParam("userRole") String userRole
    ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

        Team team=DataHandler.readTeamByUUID(teamUUID);

        if(team==null) {
            return Response.status(400).build();
        }


        return Response.status(200).entity(team).build();
    }


    /**
     * inserts a new team
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertTeam(
            @Valid @BeanParam Team team,
            @CookieParam("userRole") String userRole
    ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("user")||userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

        team.setUuid(UUID.randomUUID().toString());

        DataHandler.insertTeam(team);
        team.setAllPlayer(new ArrayList<>());

        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a new team
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateTeam(
            @Valid @BeanParam Team team,
            @CookieParam("userRole") String userRole
    ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("user")||userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

        Team oldTeam = DataHandler.readTeamByUUID(team.getUuid());

        if (oldTeam == null) {
            return Response.status(410).entity("").build();
        }
            oldTeam.setAllPlayer(team.getAllPlayer());
            oldTeam.setAmountWins(team.getAmountWins());
            oldTeam.setAmountLost(team.getAmountLost());
            oldTeam.setName(team.getName());

            DataHandler.updateTeam();

        return Response.status(200).entity("").build();
    }

    /**
     * deletes a team identified by its uuid
     * @param teamUUID the key
     * @return  Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteTeam(
            @NotNull
            @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @QueryParam("uuid") String teamUUID,
            @CookieParam("userRole") String userRole
    ) {
        userRole = AESEncrypt.decrypt(userRole);
        if (userRole.equals("user")||userRole.equals("guest")||userRole==null){
            return Response.status(403).build();
        }

        int httpStatus = 200;
        if (!DataHandler.deleteTeam(teamUUID)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

}
