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
    //private static List<String> planets = Arrays.asList("Acamar", "Brax", "Carzon", "Davlos", "Exo", "Frolix", "Iodine", "Jason", "Kaylon", "Malcoria");

    public Universe(TechLevel tech, Resources resource, Integer latitude, Integer longitude, String name) {
        this.tech = tech;
        this.resource = resource;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }
    public String createPlanets() {
        int i = 0;
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> planets = Arrays.asList("Acamar", "Brax", "Carzon", "Davlos", "Exo", "Frolix", "Iodine", "Jason", "Kaylon", "Malcoria");
        String planetsOut = "";
        String n = "";
        TechLevel t;
        Resources r;
        int j = 7;
        while (i < 10) {
            Random rand = new Random();
            int result = rand.nextInt(100);
            int result2 = rand.nextInt(100);
            List<Integer> list2 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
            //int randomInt = list.get(rand.nextInt(list.size()));
            n = planets.get(i);
            //list.remove(list.size()-1);
            t = TechLevel.values()[list2.get(j)];
            r = Resources.values()[list2.get(i)];
            Planet plan = new Planet(n, result, result2, t, r);
//            //Planet plan = planetObj[i];
            i++;
            j--;
            j = Math.abs(j);
            planetsOut += "PLANET: Name: " + plan.getName() + "\nLatitude: " + plan.getLatitude().toString() + "\nLongitude: " + plan.getLongitude().toString() + "\nLevel: " + plan.getLevel().toString() + "\nResource: " + plan.getResources().toString() + "\n\n";
        }
        return planetsOut;
    }

    public SolarSystem[] createSolarSystem() {
        int i = 0;
        while (i < 10) {
            solarSystem[i] = new SolarSystem(planetObj[i]);
        }
        return solarSystem;
    }


    public boolean univEquals(Universe universe) {
        return this.name.equals(universe.name) && this.latitude == universe.latitude;
    }

}
