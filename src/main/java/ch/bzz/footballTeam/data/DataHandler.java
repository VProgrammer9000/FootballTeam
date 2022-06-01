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
     * reads all Games
     *
     * @return list of games
     */
    public static List<Game> readAllGames() {
        return getGameList();
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
     * gets gameList
     *
     * @return value of gameList
     */
    private static List<Game> getGameList() {
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