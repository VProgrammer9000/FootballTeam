package ch.bzz.footballTeam.model;

public class Player {
    private String prename;
    private String name;
    private int nummer;
    private String UUID;

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
    public int getNummer() {
        return nummer;
    }

    /**
     * sets nummer
     *
     * @param nummer the value to set
     */
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    /**
     * gets the UUID from the Player-object
     * @return UUID
     */
    public String getUUID() {
        return UUID;
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
