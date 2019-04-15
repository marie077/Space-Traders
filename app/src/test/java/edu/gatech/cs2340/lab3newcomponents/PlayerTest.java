package edu.gatech.cs2340.lab3newcomponents;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.cs2340.lab3newcomponents.entity.Difficulty;
import edu.gatech.cs2340.lab3newcomponents.entity.Player;

import static junit.framework.TestCase.assertEquals;


@SuppressWarnings("ALL")
public class PlayerTest {
    private Player testPlayer;

    @Before
    public void setUp() {
        testPlayer = new Player("Sally",Difficulty.BEGINNER,1,4,10,1,500,"",50);
    }

    @Test
    //sonica
    public void testBeginner() {
        assertEquals("Difficulty int not correct",0,
                testPlayer.findPositionClass(testPlayer.getDifficulty()));
        assertEquals("Difficulty int not correct",1,
                testPlayer.findPositionClass(Difficulty.EASY));
        assertEquals("Difficulty int not correct",2,
                testPlayer.findPositionClass(Difficulty.NORMAL));
        assertEquals("Difficulty int not correct",3,
                testPlayer.findPositionClass(Difficulty.HARD));
        assertEquals("Difficulty int not correct",4,
                testPlayer.findPositionClass(Difficulty.IMPOSSIBLE));
        assertEquals("Difficulty int not correct",0,
                testPlayer.findPositionClass(null));
    }

    @Test
    //megha
    public void testPoints() {
        assertEquals("Position int not correct",0,
                testPlayer.findPosition(0));
        assertEquals("Position int not correct",1,
                testPlayer.findPosition(1));
        assertEquals("Position int not correct",2,
                testPlayer.findPosition(2));
        assertEquals("Position int not correct",3,
                testPlayer.findPosition(3));
        assertEquals("Position int not correct",4,
                testPlayer.findPosition(4));
        assertEquals("Position int not correct",5,
                testPlayer.findPosition(5));
        assertEquals("Position int not correct",6,
                testPlayer.findPosition(6));
        assertEquals("Position int not correct",7,
                testPlayer.findPosition(7));
        assertEquals("Position int not correct",8,
                testPlayer.findPosition(8));
        assertEquals("Position int not correct",9,
                testPlayer.findPosition(9));
        assertEquals("Position int not correct",10,
                testPlayer.findPosition(10));
        assertEquals("Position int not correct",11,
                testPlayer.findPosition(11));
        assertEquals("Position int not correct",12,
                testPlayer.findPosition(12));
        assertEquals("Position int not correct",13,
                testPlayer.findPosition(13));
        assertEquals("Position int not correct",14,
                testPlayer.findPosition(14));
        assertEquals("Position int not correct",15,
                testPlayer.findPosition(15));
        assertEquals("Position int not correct",16,
                testPlayer.findPosition(16));
        assertEquals("Position int not correct",0,
                testPlayer.findPosition(null));
    }
}
