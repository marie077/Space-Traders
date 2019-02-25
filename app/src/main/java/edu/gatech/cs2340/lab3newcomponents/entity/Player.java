package edu.gatech.cs2340.lab3newcomponents.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents a single Student in the database. It is an information holder.
 */

public class Player implements Serializable {
    /** a demonstration of using something other than an enum for holding choices
     *  IRL I would always use an enumeration for this
     */

    /** this players name */
    private String name;

    /** this player's difficulty */
    private Difficulty difficulty;

    private Integer fighterPoints;
    private Integer pilotPoints;
    private Integer traderPoints;
    private Integer engineerPoints;


    public static List<Integer> pointList = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);

    /**
     * Lookup a major based on its code.  Returns the position of that
     * major in the array, would not have to do this for an enum
     *
     * @param code the major to find
     *
     * @return the index of the array that corresponds to the submitted major
     */
    public static int findPosition(Integer code) {
        int i = 0;
        while (i < pointList.size()) {
            if (code.equals(pointList.get(i))) return i;
            ++i;
        }
        return 0;
    }

    public static int findPositionClass(Difficulty codeDifficulty) {
        if (codeDifficulty == Difficulty.BEGINNER) {
            return 0;
        } else if (codeDifficulty == Difficulty.EASY) {
            return 1;
        } else if (codeDifficulty == Difficulty.NORMAL) {
            return 2;
        } else if (codeDifficulty == Difficulty.HARD) {
            return 3;
        } else if (codeDifficulty == Difficulty.IMPOSSIBLE) {
            return 4;
        }
        return 0;
    }


    /**
     * Constructor required for making the  new object
     *
     * @param nam     name of the student
     */
    public Player(String nam, Difficulty difficult) {
        this(nam);
        this.difficulty = difficult;
    }

    /**
     * Constructor required for making the  new object
     *
     * @param nam     name of the student
     */
    public Player(String nam) {
        this.name = nam;
        this.difficulty = Difficulty.BEGINNER;
    }



    //Getters are required for accessing the fields from the database


    public String getName() {
        return name;
    }

    public void setName(String nam) { name = nam; }

    public Difficulty getDifficulty() {return difficulty; }

    public void setDifficulty(Difficulty diff) {difficulty = diff;}

    public Integer getPilotPoints() {return pilotPoints;}

    public void setPilotPoints(Integer p) {pilotPoints = p;}

    public Integer getFighterPoints() {return fighterPoints;}

    public void setFighterPoints(Integer f) {fighterPoints = f;}

    public Integer getTraderPoints() {return traderPoints;}

    public void setTraderPoints(Integer t) {traderPoints = t;}

    public Integer getEngineerPoints() {return engineerPoints;}

    public void setEngineerPoints(Integer e) {engineerPoints = e;}

    @Override
    public String toString() {
        return String.format("Player: %s, difficulty: %s", name, difficulty);
    }

}
