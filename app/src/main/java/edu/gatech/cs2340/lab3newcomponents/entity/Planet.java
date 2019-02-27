package edu.gatech.cs2340.lab3newcomponents.entity;
import java.util.Arrays;
import java.util.Random;
import java.util.List;


public class Planet {
    private String name;
    private TechLevel level;
    private Resources resource;
    private int latitude;
    private int longitude;
    public static List<String> planets = Arrays.asList("Acamar", "Brax", "Carzon", "Davlos",
        "Exo", "Frolix", "Iodine", "Jason", "Kaylon", "Malcoria");

    public Planet(String name, int latitude, int longitude, TechLevel level, Resources resource) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.level = level;
        this.resource = resource;
        this.name = name;
    }

    public int getLatitude(int latitude) {
        return this.latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude(int longitude) {
        return this.longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public TechLevel getLevel(TechLevel level) {
        return this.level;
    }

    public void setLevel(TechLevel level) {
        this.level = level;
    }

    public Resources getResources(Resources resource) {
        return this.resource;
    }

    public void setResources(Resources resource) {
        this.resource = resource;
    }


    public String getName(String name) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
