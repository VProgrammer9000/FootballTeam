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

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
