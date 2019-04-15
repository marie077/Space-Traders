package edu.gatech.cs2340.lab3newcomponents.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents a single Student in the database. It is an information holder.
 */

@SuppressWarnings("ALL")
public class Player implements Serializable {
    /** a demonstration of using something other than an enum for holding choices
     *  IRL I would always use an enumeration for this
     */

    /** this players name */
    private String name;

    /** this player's difficulty */
    private Difficulty difficulty;

    private int fighterPoints;
    private int pilotPoints;
    private int traderPoints;
    private int engineerPoints;
    private int money;
    private int fuel;
    private String cargoList;
//    public static List<String> cargoList = new ArrayList<>();


    public static List<Integer> pointList = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);

    /**
     * Constructor required for making the  new object
     *
     * @param nam     name of the student
     */
    public Player (String nam, Difficulty difficult, int fighter, int pilot, int trader, int engineer, int money, String cargoList,int fuel) {
        this.name = nam;
        this.difficulty = difficult;
        this.fighterPoints = fighter;
        this.pilotPoints = pilot;
        this.traderPoints = trader;
        this.engineerPoints = engineer;
        this.money = money;
        this.cargoList = cargoList;
        this.fuel = fuel;
    }



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
            if (code == (pointList.get(i))) return i;
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




    //Getters are required for accessing the fields from the database


    public String getName() {
        return name;
    }

    public void setName(String nam) { name = nam; }

    public Difficulty getDifficulty() {return difficulty; }

    public void setDifficulty(Difficulty diff) {difficulty = diff;}

    public Integer getPilotPoints() {return pilotPoints;}

    public void setPilotPoints(int p) {pilotPoints = p;}

    public Integer getFighterPoints() {return fighterPoints;}

    public void setFighterPoints(int f) {fighterPoints = f;}

    public Integer getTraderPoints() {return traderPoints;}

    public void setTraderPoints(int t) {traderPoints = t;}

    public Integer getEngineerPoints() {return engineerPoints;}

    public void setEngineerPoints(int e) {engineerPoints = e;}

    public Integer getMoney() {return money;}

    public void setMoney(int m) {money = m;}

    public String getCargoList() {return cargoList;}

    public void setCargoList(String c) {cargoList = c;}

    public Integer getFuel() {return fuel;}

    public void setFuel(int fl) {fuel = fl;}

    @Override
    public String toString() {
        return String.format("Player: %s, difficulty: %s", name, difficulty);
    }

}
