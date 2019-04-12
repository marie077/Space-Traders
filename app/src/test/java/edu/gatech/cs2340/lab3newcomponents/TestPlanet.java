package edu.gatech.cs2340.lab3newcomponents;



import org.junit.Before;
import org.junit.Test;


import edu.gatech.cs2340.lab3newcomponents.entity.Planet;
import edu.gatech.cs2340.lab3newcomponents.entity.Resources;

import static edu.gatech.cs2340.lab3newcomponents.entity.TechLevel.AGRICULTURE;
import static edu.gatech.cs2340.lab3newcomponents.entity.TechLevel.MEDIEVAL;
import static org.junit.Assert.assertEquals;


public class TestPlanet {
    private Planet testPlanet;
    @Before
    public void setUp() {
        testPlanet = new Planet("Sam", 12, 12,AGRICULTURE, Resources.MINERAL_RICH);
    }

    @Test
    public void testSameNameOnly() {
        assertEquals("Beginner input",false,
                testPlanet.equals(new Planet("Sam", 12, 12,MEDIEVAL, Resources.MINERAL_RICH)));

    }

    @Test
    public void testSameLevelOnly() {
        assertEquals("Beginner input",false,
                testPlanet.equals(new Planet("Samantha", 12, 12,AGRICULTURE, Resources.MINERAL_RICH)));

    }
    @Test
    public void testBothSame() {
        assertEquals("Beginner input",true,
                testPlanet.equals(new Planet("Sam", 12, 12,AGRICULTURE, Resources.MINERAL_RICH)));

    }



    @Test
    public void testNoSame() {
        assertEquals("Beginner input",false,
                testPlanet.equals(new Planet("Samantha", 12, 12,MEDIEVAL, Resources.MINERAL_RICH)));

    }




}



