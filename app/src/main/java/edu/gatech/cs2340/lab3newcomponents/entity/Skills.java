package edu.gatech.cs2340.lab3newcomponents.entity;

//assigned values of 4 to each skills (meaning 4 points per skill...)
public enum Skills {
    PILOT ("Pilot", 4),
    TRADER ("Trader", 4),
    FIGHTER ("Fighter", 4),
    ENGINEER ("Engineer", 4);

    private final String skillType;
    private final int pointAmt;

    Skills(String skill, int points) {
        skillType = skill;
        pointAmt = points;

    }

    public String getSkillType() {
        return skillType;
    }
    public int getPointAmt() {
        return pointAmt;
    }

}
