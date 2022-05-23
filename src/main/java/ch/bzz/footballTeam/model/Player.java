package ch.bzz.footballTeam.model;

public class Player {
    private String prename;
    private String name;
    private int number;
    private String uuid;

    /**
     * gets the Prename from the Player-object
     * @return prename
     */
    public String getPrename() {
        return prename;
    }

    /**
     * sets prename
     *
     * @param prename the value to set
     */
    public void setPrename(String prename) {
        this.prename = prename;
    }

    /**
     * gets the Name from the Player-object
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     *
     * @param name the value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the Nummer from the Player-object
     * @return nummer
     */
    public int getNumber() {
        return number;
    }

    /**
     * sets nummer
     *
     * @param number the value to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * gets the UUID from the Player-object
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
