package ch.bzz.footballTeam.service;


import ch.bzz.footballTeam.data.UserData;
import ch.bzz.footballTeam.model.User;
import ch.bzz.footballTeam.util.AESEncrypt;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
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
        int httpStatus=200;

        User user= UserData.findUser(username,password);
        if (user.getRole().equals("guest")){
            httpStatus = 404;
        }

        NewCookie cookie=new NewCookie(
                "userRole",
                AESEncrypt.encrypt(user.getRole()),
                "/",
                "",
                "Login-Cookie",
                600,
                false
        );
        return Response
                .status(httpStatus)
                .entity("")
                .cookie(cookie)
                .build();
    }
    @DELETE
    @Path("logout")
    @Produces(MediaType.TEXT_PLAIN)
    public Response logout() {
        NewCookie cookie=new NewCookie(
                "userRole",
                "guest",
                "/",
                "",
                "Login-Cookie",
                1,
                false
        );

        return Response.status(200).entity("").build();
    }
}
