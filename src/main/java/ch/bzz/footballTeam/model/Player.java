package ch.bzz.footballTeam.model;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;

/**
 * The Model-Class Player is storing data for the Server.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 24.05.2022
 */
public class Player {
    @FormParam("prename")
    @NotEmpty
    @Size(min = 1,max = 32)
    private String prename;

    @FormParam("name")
    @NotEmpty
    @Size(min = 1,max = 32)
    private String name;

    @FormParam("number")
    @DecimalMin(value="1")
    @DecimalMax(value="99")
    private int number;

    @FormParam("uuid")
    @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    private String uuid;

    /**
     * gets the Prename from the Player-object
     * @return prename
     */
    public String getPrename() {
        return prename;
    }

    /**
     * sets prename
     *
     * @param prename the value to set
     */
    public void setPrename(String prename) {
        this.prename = prename;
    }

    /**
     * gets the Name from the Player-object
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     *
     * @param name the value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the Nummer from the Player-object
     * @return nummer
     */
    public int getNumber() {
        return number;
    }

    /**
     * sets nummer
     *
     * @param number the value to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * gets the UUID from the Player-object
     * @return UUID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * sets UUID
     *
     * @param uuid the value to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
