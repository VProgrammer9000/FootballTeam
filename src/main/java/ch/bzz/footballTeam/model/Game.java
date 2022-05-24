package ch.bzz.footballTeam.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class Game {
    private String team1;
    private String team2;
    private int pointsTeam1;
    private int pointsTeam2;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String uuid;

    /**
     * gets the first Team (UUID) from the Game-object
     *
     * @return team1
     */
    public String getTeam1() {
        return team1;
    }

    /**
     * gets the second Team (UUID) from the Game-object
     *
     * @return team2
     */
    public String getTeam2() {
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
    public LocalDate getDate() {
        return date;
    }

    /**
     * gets the UUID from the Game-object
     *
     * @return UUID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * sets team1 (UUID)
     *
     * @param team1 the value to set
     */
    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    /**
     * sets team2 (UUID)
     *
     * @param team2 the value to set
     */
    public void setTeam2(String team2) {
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
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * sets UUID
     *
     * @param uuid the value to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
