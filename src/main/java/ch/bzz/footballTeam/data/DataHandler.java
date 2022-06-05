package ch.bzz.footballTeam.data;

import ch.bzz.footballTeam.model.Game;
import ch.bzz.footballTeam.model.Player;
import ch.bzz.footballTeam.model.Team;

import ch.bzz.footballTeam.service.Config;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Get and Converts the Data from the JSON-Files
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 24.05.2022
 */
public class DataHandler {
    private static List<Game> gameList;
    private static List<Player> playerList;
    private static List<Team> teamList;


    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {}


    /**
     * initializes the lists
     */
    public static void initLists() {
        DataHandler.setGameList(null);
        DataHandler.setPlayerList(null);
        DataHandler.setTeamList(null);
    }



    /**
     * reads all Games
     *
     * @return list of games
     */
    public static List<Game> readAllGames() {
        return getGameList();
    }

    /**
     * reads a game by its uuid
     *
     * @param gameUUID UUID of the Game
     * @return the Game (null=not found)
     */
    public static Game readGameByUUID(String gameUUID) {
        Game game = null;
        for (Game entry : getGameList()) {
            if (entry.getUuid().equals(gameUUID)) {
                game = entry;
            }
        }
        return game;
    }

    /**
     * inserts a new game into the gameList
     *
     * @param game the game to be saved
     */
    public static void insertGame(Game game) {
        getGameList().add(game);
        writeGameJSON();
    }

    /**
     * updates the gameList
     */
    public static void updateGame() {
        writeGameJSON();
    }

    /**
     * deletes a game identified by the gameUID
     * @param gameUUID  the key
     * @return  success=true/false
     */
    public static boolean deleteGame(String gameUUID) {
        Game game = readGameByUUID(gameUUID);
        if (game != null) {
            getGameList().remove(game);
            writeGameJSON();
            return true;
        } else {
            return false;
        }
    }


    /**
     * reads all Players
     *
     * @return list of players
     */
    public static List<Player> readAllPlayers() {
        return getPlayerList();
    }

    /**
     * reads a game by its uuid
     *
     * @param playerUUID UUID of the Player
     * @return the Player (null=not found)
     */
    public static Player readPlayerByUUID(String playerUUID) {
        Player player = null;
        for (Player entry : getPlayerList()) {
            if (entry.getUuid().equals(playerUUID)) {
                player = entry;
            }
        }
        return player;
    }

    /**
     * inserts a new player into the playerList
     *
     * @param player the player to be saved
     */
    public static void insertPlayer(Player player) {
        getPlayerList().add(player);
        writePlayerJSON();
    }

    /**
     * updates the playerList
     */
    public static void updatePlayer() {
        writePlayerJSON();
    }

    /**
     * deletes a player identified by the playerUUID
     * @param playerUUID  the key
     * @return  success=true/false
     */
    public static boolean deletePlayer(String playerUUID) {
        Player player = readPlayerByUUID(playerUUID);
        if (player != null) {
            getPlayerList().remove(player);
            writePlayerJSON();
            return true;
        } else {
            return false;
        }
    }


    /**
     * reads all Teams
     *
     * @return list of teams
     */
    public static List<Team> readAllTeams() {
        return getTeamList();
    }

    /**
     * reads a game by its uuid
     *
     * @param teamUUID UUID of the Player
     * @return the team (null=not found)
     */
    public static Team readTeamByUUID(String teamUUID) {
        Team team = null;
        for (Team entry : getTeamList()) {
            if (entry.getUuid().equals(teamUUID)) {
                team = entry;
            }
        }
        return team;
    }

    /**
     * inserts a new team into the teamList
     *
     * @param team the team to be saved
     */
    public static void insertTeam(Team team) {
        getTeamList().add(team);
        writeTeamJSON();
    }

    /**
     * updates the teamList
     */
    public static void updateTeam() {
        writeTeamJSON();
    }

    /**
     * deletes a team identified by the teamUUID
     * @param teamUUID  the key
     * @return  success=true/false
     */
    public static boolean deleteTeam(String teamUUID) {
        Team team = readTeamByUUID(teamUUID);
        if (team != null) {
            getTeamList().remove(team);
            writeTeamJSON();
            return true;
        } else {
            return false;
        }
    }



    /**
     * reads the game from the JSON-file
     */
    private static void readGameJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("gameJSON")
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
     * writes the gameList to the JSON-file
     */
    private static void writeGameJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = Config.getProperty("gameJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getGameList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the players from the JSON-file
     */
    private static void readPlayerJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("playerJSON")
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
     * writes the playerList to the JSON-file
     */
    private static void writePlayerJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = Config.getProperty("playerJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getPlayerList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the teams from the JSON-file
     */
    private static void readTeamJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("teamJSON")
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
     * writes the teamList to the JSON-file
     */
    private static void writeTeamJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = Config.getProperty("teamJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getTeamList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    /**
     * gets gameList
     *
     * @return value of gameList
     */
    private static List<Game> getGameList() {
        if (gameList==null){
            setGameList(new ArrayList<>());
            readGameJSON();
        }
        return gameList;
    }

    /**
     * sets gameList
     *
     * @param gameList the value to set
     */
    private static void setGameList(List<Game> gameList) {
        DataHandler.gameList = gameList;
    }

    /**
     * gets playerList
     *
     * @return value of playerList
     */
    private static List<Player> getPlayerList() {
        if (playerList==null) {
            setPlayerList(new ArrayList<>());
            readPlayerJSON();
        }
        return playerList;
    }

    /**
     * sets playerList
     *
     * @param playerList the value to set
     */
    private static  void setPlayerList(List<Player> playerList) {
        DataHandler.playerList = playerList;
    }

    /**
     * gets teamList
     *
     * @return value of teamList
     */
    private static List<Team> getTeamList() {
        if (teamList==null){
            setTeamList(new ArrayList<>());
            readTeamJSON();
        }
        return teamList;
    }

    /**
     * sets teamList
     *
     * @param teamList the value to set
     */
    private static void setTeamList(List<Team> teamList) {
        DataHandler.teamList = teamList;
    }
}