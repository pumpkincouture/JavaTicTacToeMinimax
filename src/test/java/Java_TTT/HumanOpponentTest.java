package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class HumanOpponentTest {
    private HumanPlayer humanPlayerTest;
    private MockUserInterface mockUI;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);

    @Before
    public void setUp() {
        mockUI =  new MockUserInterface(output, input);
        humanPlayerTest = new HumanPlayer("X", mockUI);
    }

    @Test
    public void getHumanPlayerGamePiece() {
        assertEquals("X", humanPlayerTest.getGamePiece());
    }

    @Test
    public void getHumanPlayerMove() {
        mockUI.addNextMove("5");
        assertEquals("5", humanPlayerTest.getMove(new Board(3)));
    }
}