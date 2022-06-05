package ch.bzz.footballTeam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;
import java.util.ArrayList;

/**
 * The Model-Class Team is storing data for the Server.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 24.05.2022
 */
public class Team {
    //TODO Regexing correctly
    private ArrayList<String> allPlayer;

    @FormParam("name")
    @NotEmpty
    @Size(min = 1,max = 100)
    private String name;

    @FormParam("amountWins")
    @NotEmpty
    @DecimalMin(value="0")
    private int amountWins;

    @FormParam("amountLost")
    @NotEmpty
    @DecimalMin(value="0")
    private int amountLost;

    @FormParam("uuid")
    @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    private String uuid;

    /**
     * gets name from the Team-object
     *
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
     * gets the Amounts of wins from the Team-object
     *
     * @return amountWins
     */
    public int getAmountWins() {
        return amountWins;
    }

    /**
     * sets amountWins
     *
     * @param amountWins the value to set
     */
    public void setAmountWins(int amountWins) {
        this.amountWins = amountWins;
    }

    /**
     * gets the Amounts of loses from the Team-object
     *
     * @return amountWins
     */
    public int getAmountLost() {
        return amountLost;
    }

    /**
     * sets amountLost
     *
     * @param amountLost the value to set
     */
    public void setAmountLost(int amountLost) {
        this.amountLost = amountLost;
    }

    /**
     * gets all Players from the Team-object
     *
     * @return players
     */
    public ArrayList<String> getAllPlayer() {
        return allPlayer;
    }

    /**
     * sets allPlayer
     *
     * @param allPlayer the value to set
     */
    public void setAllPlayer(ArrayList<String> allPlayer) {
        this.allPlayer = allPlayer;
    }

    /**
     * gets Uuid from the Team-object
     * 
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * sets uuid
     *
     * @param uuid the value to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
