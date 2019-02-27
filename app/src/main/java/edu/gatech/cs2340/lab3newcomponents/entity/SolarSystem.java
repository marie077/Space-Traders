package edu.gatech.cs2340.lab3newcomponents.entity;

public class SolarSystem {
    Planet planet;
    /**
     * Constructor for Solar System
     * Planet is passed in
     */
    public SolarSystem(Planet planet) {
        this.planet = planet;
    }
    private Planet getPlanet() {
        return planet;
    }
}
