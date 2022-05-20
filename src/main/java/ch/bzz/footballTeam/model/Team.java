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
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the Amounts of wins from the Team-object
     * @return amountWins
     */
    public int getAmountWins() {
        return amountWins;
    }

    public void setAmountWins(int amountWins) {
        this.amountWins = amountWins;
    }

    /**
     * gets the Amounts of loses from the Team-object
     * @return amountWins
     */
    public int getAmountLost() {
        return amountLost;
    }

    public void setAmountLost(int amountLost) {
        this.amountLost = amountLost;
    }

    /**
     * gets all Players from the Team-object
     * @return players
     */
    public ArrayList<Player> getAllPlayer() {
        return allPlayer;
    }

    public void setAllPlayer(ArrayList<Player> allPlayer) {
        this.allPlayer = allPlayer;
    }

    /**
     * gets name from the Team-object
     * @return Name
     */
    public ArrayList<Game> getAllGame() {
        return allGame;
    }

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

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
