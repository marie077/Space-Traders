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

    /** the representation of the tech level abbrv. */
    private final String code;

    /**
     * Constructor for the enumeration
     *
     * @param pname   full name of the course
     * @param pcode   letter code / abbreviation for the course
     */
    TechLevel(String pname, String pcode) {
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
    public String toString() { return name; }

//    public static TechLevel getRandomLevel() {
//        Random random = new Random();
//        return values()[random.nextInt(values().length)];
//    }
}
