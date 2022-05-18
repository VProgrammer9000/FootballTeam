package ch.bzz.footballTeam.data;

import ch.bzz.footballTeam.model.Game;
import ch.bzz.footballTeam.model.Player;
import ch.bzz.footballTeam.model.Team;

import ch.bzz.footballTeam.service.Config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static DataHandler instance = null;
    private List<Game> gameList;
    private List<Player> playerList;
    private List<Team> teamList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
        setGameList(new ArrayList<>());
        readGameJSON();
        setPlayerList(new ArrayList<>());
        readPlayerJSON();
        setTeamList(new ArrayList<>());
        readTeamJSON();
    }

    /**
     * gets the only instance of this class
     * @return
     */
    public static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }

    /**
     * reads all Games
     * @return list of games
     */
    public List<Game> readAllGames() {

        return getGameList();
    }

    /**
     * reads all Players
     * @return list of players
     */
    public List<Player> readAllPlayers() {

        return getPlayerList();
    }

    /**
     * reads all Teams
     * @return list of teams
     */
    public List<Team> readAllTeams() {
        return getTeamList();
    }



    /**
     * reads a game by its uuid
     * @param gameUUID
     * @return the Game (null=not found)
     */
    public Game readGameByUUID(String gameUUID) {
        Game game = null;
        for (Game entry : getGameList()) {
            if (entry.getUUID().equals(gameUUID)) {
                game = entry;
            }
        }
        return game;
    }

    /**
     * reads a game by its uuid
     * @param playerUUID
     * @return the Player (null=not found)
     */
    public Player readPlayerByUUID(String playerUUID) {
        Player player = null;
        for (Player entry : getPlayerList()) {
            if (entry.getUUID().equals(playerUUID)) {
                player = entry;
            }
        }
        return player;
    }

    /**
     * reads a game by its uuid
     * @param teamUUID
     * @return the team (null=not found)
     */
    public Team readTeamByUUID(String teamUUID) {
        Team team = null;
        for (Team entry : getTeamList()) {
            if (entry.getUUID().equals(teamUUID)) {
                team = entry;
            }
        }
        return team;
    }



    /**
     * reads the game from the JSON-file
     */
    private void readGameJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("GameJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Game[] games = objectMapper.readValue(jsonData, Game[].class);
            for (Game game : games) {
                getGameList().add(game);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    /**
     * reads the publishers from the JSON-file
     */
    private void readPlayerJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("publisherJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Player[] players = objectMapper.readValue(jsonData, Player[].class);
            for (Player player : players) {
                getPlayerList().add(player);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    /**
     * reads the publishers from the JSON-file
     */
    private void readTeamJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("publisherJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Team[] teams = objectMapper.readValue(jsonData, Team[].class);
            for (Team team : teams) {
                getTeamList().add(team);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }










    /**
     * gets gameList
     *
     * @return value of gameList
     */
    private List<Game> getGameList() {
        return gameList;
    }

    /**
     * sets gameList
     *
     * @param gameList the value to set
     */
    private void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }



    /**
     * gets playerList
     *
     * @return value of playerList
     */
    private List<Player> getPlayerList() {
        return playerList;
    }

    /**
     * sets playerList
     *
     * @param playerList the value to set
     */
    private void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }




    /**
     * gets teamList
     *
     * @return value of teamList
     */
    private List<Team> getTeamList() {
        return teamList;
    }

    /**
     * sets teamList
     *
     * @param teamList the value to set
     */
    private void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}