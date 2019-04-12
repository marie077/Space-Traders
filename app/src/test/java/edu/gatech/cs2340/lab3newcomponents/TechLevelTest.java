package edu.gatech.cs2340.lab3newcomponents;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.cs2340.lab3newcomponents.entity.TechLevel;

import static junit.framework.TestCase.assertEquals;


public class TechLevelTest {
    private TechLevel level1;
    private TechLevel level2;
    private TechLevel level3;
    private TechLevel level4;


    @Before
    public void setUp() {
        level1 = TechLevel.EARLY_INDUSTRIAL;
        level2 = TechLevel.AGRICULTURE;
        level3 = TechLevel.HI_TECH;
        level4 = TechLevel.RENAISSANCE;
    }

    // Marie Ow
    @Test
    public void testTechLevel() {

        // All of these are expected to be true
        assertEquals("TechLevel not equal", true,
                level1.techLevelEquals("Early-Industrial", "4"));
        assertEquals("TechLevel not equal", true,
                level2.techLevelEquals("Agriculture", "1"));
        assertEquals("TechLevel not equal", true,
                level3.techLevelEquals("Hi-Tech", "7"));
        assertEquals("TechLevel not equal", true,
                level4.techLevelEquals("Renaissance", "3"));

        // All of these are expected to be false
        assertEquals("TechLevel not equal", false,
                level1.techLevelEquals("Fake Tech Level", "4"));
        assertEquals("TechLevel not equal", false,
                level2.techLevelEquals("Agriculture", "9"));
        assertEquals("TechLevel not equal", false,
                level3.techLevelEquals("Wrong Thing Here", "-1"));
        assertEquals("TechLevel not equal", false,
                level4.techLevelEquals("RENAISSANCE", "3"));
    }
}