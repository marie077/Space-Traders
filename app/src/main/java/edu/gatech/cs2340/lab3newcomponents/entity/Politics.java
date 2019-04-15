package edu.gatech.cs2340.lab3newcomponents.entity;

@SuppressWarnings("ALL")
public enum Politics {
    ANARCHY ("Anarchy", TradeGoods.FOOD, true),
    CAPITALIST ("Capitalist", TradeGoods.ORE, true),
    CONFEDERACY ("Confederacy", TradeGoods.GAMES, false),
    CORPORATE ("Corporate", TradeGoods.ROBOTS, false),
    CYBERNETIC ("Cybernetic", TradeGoods.NARCOTICS, false),
    DEMOCRACY ("Democracy", TradeGoods.FURS, true),
    FASCIST ("Fascist", TradeGoods.MACHINES, true),
    FEUDAL ("Feudal", TradeGoods.FIREARMS, true),
    MILITARY ("Military", TradeGoods.WATER, false);


    /** the full string representation of the political type */
    private final String name;

    /** the representation of the scarce resource */
    private final TradeGoods good;

    /** whether or not the political type is corruptible */
    private final boolean corruptible;

    /**
     * Constructor for the enumeration
     *
     * @param pName   full name of the political type
     * @param pGood   scare resource
     * @param pCorrupt   whether or not corruptible
     */
    Politics(String pName, TradeGoods pGood, boolean pCorrupt) {
        name = pName;
        good = pGood;
        corruptible = pCorrupt;
    }

    /**
     *
     * @return   the political type name
     */
    public String getName() { return name; }


    /**
     *
     * @return the abbreviation for the course
     */
    public TradeGoods getGood() { return good; }


    /**
     *
     * @return the abbreviation for the course
     */
    public boolean getCorruptible() { return corruptible; }

    /**
     *
     * @return the display string representation of the political type
     */
    public String toString() { return name; }
}




