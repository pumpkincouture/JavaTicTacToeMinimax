package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player testPlayer;

    @Before
    public void setUp() {
        testPlayer = new Player("X");
    }

    @Test
    public void printPiece() {
        assertEquals("X", testPlayer.getGamePiece());
    }
}
