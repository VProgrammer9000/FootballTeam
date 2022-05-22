package ch.bzz.footballTeam.model;

import java.sql.Date;
import java.util.ArrayList;

public class Game {
    private Team team1;
    private Team team2;
    private int pointsTeam1;
    private int pointsTeam2;
    private Date date;
    private String UUID;

    /**
     * gets the first Team from the Game-object
     *
     * @return team1
     */
    public Team getTeam1() {
        return team1;
    }

    /**
     * gets the second Team from the Game-object
     *
     * @return team2
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * gets the Points of the first Team from the Game-object
     *
     * @return pointsTeam1
     */
    public int getPointsTeam1() {
        return pointsTeam1;
    }

    /**
     * gets the first Team from the Game-object
     *
     * @return Team1
     */
    public int getPointsTeam2() {
        return pointsTeam2;
    }

    /**
     * gets the Date from the Game-object
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * gets the UUID from the Game-object
     *
     * @return UUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * sets team1
     *
     * @param team1 the value to set
     */
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    /**
     * sets team2
     *
     * @param team2 the value to set
     */
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    /**
     * sets pointsTeam1
     *
     * @param pointsTeam1 the value to set
     */
    public void setPointsTeam1(int pointsTeam1) {
        this.pointsTeam1 = pointsTeam1;
    }

    /**
     * sets pointsTeam2
     *
     * @param pointsTeam2 the value to set
     */
    public void setPointsTeam2(int pointsTeam2) {
        this.pointsTeam2 = pointsTeam2;
    }

    /**
     * sets date
     *
     * @param date the value to set
     */
    public void setDate(Date date) {
        this.date = date;
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
