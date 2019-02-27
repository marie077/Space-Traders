package edu.gatech.cs2340.lab3newcomponents.entity;

public class SolarSystem {
    Planet planet;
    /*
    constructor for Solar System class.
    It passes in the planet object and
     */
    public SolarSystem(Planet planet) {
        this.planet = planet;
    }
    private Planet getPlanet() {
        return planet;
    }

}
