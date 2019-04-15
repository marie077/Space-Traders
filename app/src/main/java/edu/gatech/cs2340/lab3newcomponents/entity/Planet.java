package edu.gatech.cs2340.lab3newcomponents.entity;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("ALL")
public class Planet {
    private String name;
    private TechLevel level;
    private Resources resource;
    private Politics politics;
    private int latitude;
    private int longitude;
    public static List<String> planets = Arrays.asList("Acamar", "Brax", "Carzon", "Davlos",
        "Exo", "Frolix", "Iodine", "Jason", "Kaylon", "Malcoria");

    public Planet(String name, int latitude, int longitude, TechLevel level, Resources resource, Politics politics) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.level = level;
        this.resource = resource;
        this.name = name;
        this.politics = politics;
    }

    public Integer getLatitude() {
        return this.latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return this.longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public TechLevel getLevel() {
        return this.level;
    }

    public void setLevel(TechLevel level) {
        this.level = level;
    }

    public Resources getResources() {
        return this.resource;
    }

    public void setResources(Resources resource) {
        this.resource = resource;
    }

    public Politics getPolitics() { return this.politics; }

    public void setPolitics(Politics politics) { this.politics = politics; }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Planet: %s, latitude: %s, longitude: %s, level: %s, resources: %s, politics: %s", name, latitude, longitude, level, resource, politics);
    }
}
