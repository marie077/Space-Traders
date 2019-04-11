package edu.gatech.cs2340.lab3newcomponents;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.cs2340.lab3newcomponents.entity.Resources;
import edu.gatech.cs2340.lab3newcomponents.entity.Universe;
import edu.gatech.cs2340.lab3newcomponents.entity.TechLevel;

import static junit.framework.TestCase.assertEquals;


public class UniverseTest {
    private Universe universe1;
    private Universe universe2;
    private Universe universe3;
    private Universe universe4;


    @Before
    public void setUp() {
        universe1 = new Universe(TechLevel.HI_TECH, Resources.MINERAL_POOR, 12, 10, "First");
        universe2 = new Universe(TechLevel.HI_TECH, Resources.MINERAL_POOR, 6, 8, "First");
        universe3 = new Universe(TechLevel.HI_TECH, Resources.MINERAL_POOR, 12, 10, "Second");
        universe4 = new Universe(TechLevel.HI_TECH, Resources.MINERAL_POOR, 12, 10, "First");
    }

    @Test
    //calista
    public void testUniverse() {
        assertEquals("Universes not equal", false,
                universe1.univEquals(universe2));
        assertEquals("Universes not equal", false,
                universe1.univEquals(universe3));
        assertEquals("Universes not equal", true,
                universe1.univEquals(universe4));
        assertEquals("Universes not equal", true,
                universe1.univEquals(universe1));
    }
}