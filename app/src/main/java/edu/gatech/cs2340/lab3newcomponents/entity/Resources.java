package edu.gatech.cs2340.lab3newcomponents.entity;

public enum Resources {

    NOSPECIALRESOURCES ("NoSpecialResources", "0"),
    MINERALRICH ("MineralRich", "1"),
    MINERALPOOR ("MineralPoor", "2"),
    DESERT ("Desert", "3"),
    LOTSOFWATER ("LotsOfWater", "4"),
    RICHSOIL ("RichSoil", "5"),
    POORSOIL ("PoorSoil", "6"),
    FAUNA ("Fauna", "7"),
    LIFELESS ("Lifeless", "8"),
    WEIRDMUSHROOMS ("WeirdMushrooms", "9"),
    LOTSOFHERBS ("LotsOfHerbs", "10"),
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
    public String toString() { return rcode; }
}
