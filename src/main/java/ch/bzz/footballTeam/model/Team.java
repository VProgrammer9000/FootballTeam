package ch.bzz.footballTeam.model;

import java.util.ArrayList;

public class Team {
    private String name;
    private String strengthClass;
    private int placeLiga;
    private int amountWins;
    private int amountLost;
    private ArrayList<Player> allPlayer;
    private ArrayList <Game>allGame;
    private String UUID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrengthClass() {
        return strengthClass;
    }

    public void setStrengthClass(String strengthClass) {
        this.strengthClass = strengthClass;
    }

    public int getPlaceLiga() {
        return placeLiga;
    }

    public void setPlaceLiga(int placeLiga) {
        this.placeLiga = placeLiga;
    }

    public int getAmountWins() {
        return amountWins;
    }

    public void setAmountWins(int amountWins) {
        this.amountWins = amountWins;
    }

    public int getAmountLost() {
        return amountLost;
    }

    public void setAmountLost(int amountLost) {
        this.amountLost = amountLost;
    }

    public ArrayList<Player> getAllPlayer() {
        return allPlayer;
    }

    public void setAllPlayer(ArrayList<Player> allPlayer) {
        this.allPlayer = allPlayer;
    }

    public ArrayList<Game> getAllGame() {
        return allGame;
    }

    public void setAllGame(ArrayList<Game> allGame) {
        this.allGame = allGame;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
