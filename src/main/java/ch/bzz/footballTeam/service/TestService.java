package ch.bzz.footballTeam.service;

import ch.bzz.footballTeam.data.DataHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Testing if Server is running correctly and trying out Services.
 *
 * @author Vivek Viruthiyel
 * @version 2.0
 * @since 14.06.2022
 */
@Path("test")
public class TestService {

    /**
     * confirms the application runs
     * @return  message
     */
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {

        return Response
                .status(200)
                .entity("Test erfolgreich")
                .build();
    }

    /**
     * restores the json-files
     * @return Response
     */
    @GET
    @Path("restore")
    @Produces(MediaType.TEXT_PLAIN)
    public Response restore() {
        try {
            java.nio.file.Path path = Paths.get(Config.getProperty("gameJSON"));
            String filename = path.getFileName().toString();
            String folder = path.getParent().toString();

            byte[] gameJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
            FileOutputStream fileOutputStream = new FileOutputStream(Config.getProperty("gameJSON"));
            fileOutputStream.write(gameJSON);



            path = Paths.get(Config.getProperty("playerJSON"));
            filename = path.getFileName().toString();
            folder = path.getParent().toString();

            byte[] playerJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
            fileOutputStream = new FileOutputStream(Config.getProperty("playerJSON"));
            fileOutputStream.write(playerJSON);



            path = Paths.get(Config.getProperty("teamJSON"));
            filename = path.getFileName().toString();
            folder = path.getParent().toString();

            byte[] teamJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
            fileOutputStream = new FileOutputStream(Config.getProperty("teamJSON"));
            fileOutputStream.write(teamJSON);



            path = Paths.get(Config.getProperty("userJSON"));
            filename = path.getFileName().toString();
            folder = path.getParent().toString();

            byte[] userJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
            fileOutputStream = new FileOutputStream(Config.getProperty("userJSON"));
            fileOutputStream.write(userJSON);

        } catch (IOException e) {
            e.printStackTrace();
        }

        DataHandler.initLists();
        return Response
                .status(200)
                .entity("Erfolgreich")
                .build();
    }
}