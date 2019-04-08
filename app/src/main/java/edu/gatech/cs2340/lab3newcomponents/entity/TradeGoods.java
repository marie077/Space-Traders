package edu.gatech.cs2340.lab3newcomponents.entity;

public enum TradeGoods {
    WATER ("Water", 30),
    FURS ("Furs", 250),
    FOOD ("FOOD", 100),
    ORE ("Ore", 350),
    GAMES ("Games", 250),
    FIREARMS ("Firearms", 1250),
    MEDICINE ("Medicine", 650),
    MACHINES ("Machines", 900),
    NARCOTICS ("Narcotics", 3500),
    ROBOTS ("Robots", 5000);



    /** the full string representation of the tech level */
    private final String name;

    /** the representation of the tech level abbrv. */
    private final Integer price;

    /**
     * Constructor for the enumeration
     *
     * @param pname   full name of the course
     * @param pprice   letter code / abbreviation for the course
     */
    TradeGoods(String pname, Integer pprice) {
        name = pname;
        price = pprice;
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
    public Integer getPrice() { return price; }

    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return name; }


}
