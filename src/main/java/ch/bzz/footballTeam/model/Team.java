package ch.bzz.footballTeam.model;

import java.util.ArrayList;

public class Team {
    private ArrayList<String> allPlayer;

    private String uuid;
    private String name;
    private int amountWins;
    private int amountLost;

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
