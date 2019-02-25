package edu.gatech.cs2340.lab3newcomponents.entity;

/**
 * Created by robertwaters on 1/5/17.
 *
 * This class represents the various school codes for registration
 */
public enum Difficulty {
    BEGINNER ("Beginner", "Beginner"),
    EASY ("Easy", "Easy"),
    NORMAL ("Normal", "Normal"),
    HARD ("Hard", "Hard"),
    IMPOSSIBLE ("Impossible", "Impossible");

//hi this is calista
    /** the full string representation of the course name */
    private final String name;

    /** the representation of the course name abbreviation - always at least 2 characters, but never more than 4*/
    private final String code;

    /**
     * Constructor for the enumeration
     *
     * @param pname   full name of the course
     * @param pcode   letter code / abbreviation for the course
     */
    Difficulty(String pname, String pcode) {
        name = pname;
        code = pcode;
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
    public String toString() { return code; }
}
