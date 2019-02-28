package edu.gatech.cs2340.lab3newcomponents.entity;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Universe {
    private TechLevel tech;
    private Resources resource;
    private int latitude;
    private int longitude;
    private String name;
    private Planet[] planetObj = new Planet[10];
    private SolarSystem[] solarSystem = new SolarSystem[10];
    public static List<String> planets = Arrays.asList("Acamar", "Brax", "Carzon", "Davlos",
            "Exo", "Frolix", "Iodine", "Jason", "Kaylon", "Malcoria");
    public Planet[] createPlanets() {
        int i = 0;
        while (i < 10) {
            Random rand = new Random();
            int result = rand.nextInt(100);
            int result2 = rand.nextInt(100);
            List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            int randomInt = list.get(rand.nextInt(list.size()));
            name = planets.get(randomInt);
            list.remove(randomInt);
            planetObj[i] = new Planet(name, result, result2, TechLevel.getRandomLevel(), Resources.getRandomResource());
            i++;
        }
        return planetObj;
    }

    public SolarSystem[] createSolarSystem() {
        int i = 0;
        while (i < 10) {
            solarSystem[i] = new SolarSystem(planetObj[i]);
        }
        return solarSystem;
    }



}
