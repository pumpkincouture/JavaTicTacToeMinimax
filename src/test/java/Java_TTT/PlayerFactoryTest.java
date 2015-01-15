package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class PlayerFactoryTest {
    private MockUserInterface mockui;
    private PlayerFactory playerFactoryTest;
    private Board board;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);

    @Before
    public void setUp() {
        mockui = new MockUserInterface(output, input);
        board = new Board(3);
        playerFactoryTest = new PlayerFactory(mockui, board);
    }

    @Test
    public void checkThatAIComputerIsCreated() {
        mockui.addNextMove("i");
        assertEquals("AIComputerPlayer", playerFactoryTest.getChosenOpponent().getClass().getSimpleName());
    }

    @Test
    public void checkThatComputerOpponentIsCreated() {
        mockui.addNextMove("c");
        assertEquals("ComputerPlayer", playerFactoryTest.getChosenOpponent().getClass().getSimpleName());
    }

    @Test
    public void checkThatHumanOpponentIsCreated() {
        mockui.addNextMove("h");
        assertEquals("HumanPlayer", playerFactoryTest.getChosenOpponent().getClass().getSimpleName());
    }

    @Test
    public void promptAgainIfInvalidOutput() {
        mockui.addNextMove("f");
        mockui.addNextMove("-");
        mockui.addNextMove("c");
        playerFactoryTest.getChosenOpponent();

        assertEquals(true, mockui.isDisplayInvalidMoveMessageCalled());
        assertEquals("ComputerPlayer", playerFactoryTest.getAssignedOpponent().getClass().getSimpleName());
    }
}
