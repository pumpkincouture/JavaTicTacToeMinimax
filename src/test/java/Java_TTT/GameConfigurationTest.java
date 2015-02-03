package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameConfigurationTest {
    private GameConfiguration gameConfigTest;
    private PrintStream output = new PrintStream(System.out);
    private Board board = new Board(3);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);

    @Before
    public void setUp() {
        gameConfigTest = new GameConfiguration(mockUi, board);
    }

    @Test
    public void capturesUserChoiceForConfigurations() {
        mockUi.addNextMove("a");
        mockUi.addNextMove("1");

        gameConfigTest.validateGameConfiguration(mockUi.captureChoice());

        assertEquals(true, mockUi.areGameConfigOptionsCalled());
        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsHuman() {
        mockUi.addNextMove("ppp");
        mockUi.addNextMove("1");

        gameConfigTest.validateGameConfiguration(mockUi.captureChoice());

        assertEquals("HumanPlayer", gameConfigTest.getPlayer1().getClass().getSimpleName());
        assertEquals("HumanPlayer", gameConfigTest.getPlayer2().getClass().getSimpleName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsBasicComputer() {
        mockUi.addNextMove("b");
        mockUi.addNextMove("9");
        mockUi.addNextMove("2");

        gameConfigTest.validateGameConfiguration(mockUi.captureChoice());

        assertEquals("HumanPlayer", gameConfigTest.getPlayer1().getClass().getSimpleName());
        assertEquals("ComputerPlayer", gameConfigTest.getPlayer2().getClass().getSimpleName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsAI() {
        mockUi.addNextMove("---");
        mockUi.addNextMove("3");

        gameConfigTest.validateGameConfiguration(mockUi.captureChoice());

        assertEquals("HumanPlayer", gameConfigTest.getPlayer1().getClass().getSimpleName());
        assertEquals("AIComputerPlayer", gameConfigTest.getPlayer2().getClass().getSimpleName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsBasicComputerAndPlayer2IsAI() {
        mockUi.addNextMove("---");
        mockUi.addNextMove("4");

        gameConfigTest.validateGameConfiguration(mockUi.captureChoice());

        assertEquals("ComputerPlayer", gameConfigTest.getPlayer1().getClass().getSimpleName());
        assertEquals("AIComputerPlayer", gameConfigTest.getPlayer2().getClass().getSimpleName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }
}
