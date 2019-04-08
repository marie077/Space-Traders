package edu.gatech.cs2340.lab3newcomponents.entity;

import java.util.Random;

public enum Resources {

    NO_SPECIAL_RESOURCES ("NoSpecialResources", "0"),
    MINERAL_RICH ("MineralRich", "1"),
    MINERAL_POOR ("MineralPoor", "2"),
    DESERT ("Desert", "3"),
    LOTS_OF_WATER ("LotsOfWater", "4"),
    RICH_SOIL ("RichSoil", "5"),
    POOR_SOIL ("PoorSoil", "6"),
    FAUNA ("Fauna", "7"),
    LIFELESS ("Lifeless", "8"),
    WEIRD_MUSHROOMS ("WeirdMushrooms", "9"),
    LOTS_OF_HERBS ("LotsOfHerbs", "10"),
    ARTISTIC ("Artistic", "11"),
    WARLIKE ("Warlike", "12");

    /** the full string representation of the resource */
    private final String resource;

    /** the representation of the resource abbrv. */
    private final String rcode;

    /**
     * Constructor for the enumeration
     *
     * @param pname   full name of the course
     * @param pcode   letter code / abbreviation for the course
     */
    Resources(String pname, String pcode) {
        resource = pname;
        rcode = pcode;
    }

    /**
     *
     * @return   the full course name
     */
    public String getName() { return resource; }


    /**
     *
     * @return the abbreviation for the course
     */
    public String getCode() { return rcode; }

    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return resource; }

//    public static Resources getRandomResource() {
//        Random random = new Random();
//        return values()[random.nextInt(values().length)];
//    }
}
