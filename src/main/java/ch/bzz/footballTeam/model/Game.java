package ch.bzz.footballTeam.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.Pattern;
import javax.ws.rs.FormParam;
import java.time.LocalDate;

/**
 * The Model-Class Game is storing data for the Server.
 *
 * @author Vivek Viruthiyel
 * @version 1.0
 * @since 24.05.2022
 */
public class Game {
    @FormParam("team1")
    @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    private String team1;

    @FormParam("team2")
    @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    private String team2;

    //TODO see anwser of Suter
    private int pointsTeam1;
    private int pointsTeam2;

    @FormParam("date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @FormParam("uuid")
    @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
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
     * sets team1 (UUID)
     *
     * @param team1 the value to set
     */
    public void setTeam1(String team1) {
        this.team1 = team1;
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
     * sets team2 (UUID)
     *
     * @param team2 the value to set
     */
    public void setTeam2(String team2) {
        this.team2 = team2;
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
     * sets pointsTeam1
     *
     * @param pointsTeam1 the value to set
     */
    public void setPointsTeam1(int pointsTeam1) {
        this.pointsTeam1 = pointsTeam1;
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
     * sets pointsTeam2
     *
     * @param pointsTeam2 the value to set
     */
    public void setPointsTeam2(int pointsTeam2) {
        this.pointsTeam2 = pointsTeam2;
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
     * sets date
     *
     * @param date the value to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
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
     * sets UUID
     *
     * @param uuid the value to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
