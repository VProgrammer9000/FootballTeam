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

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getPointsTeam1() {
        return pointsTeam1;
    }

    public int getPointsTeam2() {
        return pointsTeam2;
    }

    public Date getDate() {
        return date;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public void setPointsTeam1(int pointsTeam1) {
        this.pointsTeam1 = pointsTeam1;
    }

    public void setPointsTeam2(int pointsTeam2) {
        this.pointsTeam2 = pointsTeam2;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
