package ch.bzz.footballTeam.model;

import java.util.ArrayList;

public class Team {
    private String name;
    private int amountWins;
    private int amountLost;
    private ArrayList<Player> allPlayer;
    private ArrayList <Game>allGame;
    private String UUID;

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
    public ArrayList<Player> getAllPlayer() {
        return allPlayer;
    }

    /**
     * sets allPlayer
     *
     * @param allPlayer the value to set
     */
    public void setAllPlayer(ArrayList<Player> allPlayer) {
        this.allPlayer = allPlayer;
    }

    /**
     * gets name from the Team-object
     *
     * @return Name
     */
    public ArrayList<Game> getAllGame() {
        return allGame;
    }

    /**
     * sets allGame
     *
     * @param allGame the value to set
     */
    public void setAllGame(ArrayList<Game> allGame) {
        this.allGame = allGame;
    }

    /**
     * gets UUID from the Team-object
     * @return UUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * sets UUID
     *
     * @param UUID the value to set
     */
    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
