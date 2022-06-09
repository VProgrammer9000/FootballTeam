package ch.bzz.footballTeam.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
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

    @FormParam("uuid")
    @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    private String uuid;

    @NotEmpty
    @FormParam("team1")
    @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    private String team1;

    @NotEmpty
    @FormParam("team2")
    @Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    private String team2;

    @FormParam("gameResult")
    @Pattern(regexp="[0-9]{1,2}-[0-9]{1,2}")
    private String gameResult;

    @FormParam("date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

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
     * gets the gameResult
     *
     * @return gameResult
     */
    public String getGameResult() {
        return gameResult;
    }

    /**
     * sets gameResult
     *
     * @param gameResult the value to set
     */
    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
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
