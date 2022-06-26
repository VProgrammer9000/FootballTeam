package ch.bzz.footballTeam.service;


import ch.bzz.footballTeam.data.UserData;
import ch.bzz.footballTeam.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * services for authentication and authorization of users
 */
@Path("user")
public class UserService {

    @POST
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(
            @FormParam("username") String username,
            @FormParam("password") String password
    ) {

        User user= UserData.findUser(username,password);
        if (user.getRole().equals("guest")){
            return Response.status(404).entity("").build();
        }

        return Response.status(200).entity("").build();
    }

    @DELETE
    @Path("logout")
    @Produces(MediaType.TEXT_PLAIN)
    public Response logout() {

        return Response.status(200).entity("").build();
    }
}
