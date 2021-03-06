package edu.gatech.cs2340.lab3newcomponents.entity;

@SuppressWarnings("ALL")
public enum TechLevel {
    PRE_AGRICULTURE ("Pre-Agriculture", "0"),
    AGRICULTURE ("Agriculture", "1"),
    MEDIEVAL ("Medieval", "2"),
    RENAISSANCE ("Renaissance", "3"),
    EARLY_INDUSTRIAL ("Early-Industrial", "4"),
    INDUSTRIAL ("Industrial", "5"),
    POST_INDUSTRIAL ("Post-Industrial", "6"),
    HI_TECH ("Hi-Tech", "7");

    /** the full string representation of the tech level */
    private final String name;

    /** the representation of the tech level abbrev. */
    private final String code;

    /**
     * Constructor for the enumeration
     *
     * @param pName   full name of the course
     * @param pCode   letter code / abbreviation for the cour`se
     */
    TechLevel(String pName, String pCode) {
        name = pName;
        code = pCode;
    }

    /**
     *
     * @return   the full course name
     */
    public String getName() { return name; }


    /**
     *
     * @return the abbreviation for the course
     */
    public String getCode() { return code; }

    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return name; }

    /**
     * Checks if TechLevel enum has correct fields
     * @param name TechLevel
     * @param code Value associated with TechLevel
     * @return boolean
     */
    public boolean techLevelEquals(String name, String code) {
        return this.name.equals(name) && this.code.equals(code);
    }


}
