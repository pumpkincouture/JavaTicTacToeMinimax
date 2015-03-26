package Java_TTT.participants;

import Java_TTT.ui.MockUserInterface;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Participant testPlayer;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);

    @Before
    public void setUp() {
        testPlayer = new Human("X", mockUi);
    }

    @Test
    public void printPiece() {
        assertEquals("X", testPlayer.getGamePiece());
    }
}
