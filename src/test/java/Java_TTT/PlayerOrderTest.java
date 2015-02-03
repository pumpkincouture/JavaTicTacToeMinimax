package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class PlayerOrderTest {
    private PlayerOrder playerOrderTest;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private Player player1 = new HumanPlayer("X", mockUi);
    private Player player2 = new HumanPlayer("O", mockUi);

    @Before
    public void setUp() {
        playerOrderTest = new PlayerOrder(player1, player2, mockUi);
    }

    @Test
    public void capturesAndValidatesChoiceUntilValidInputIsReturned() {
        mockUi.addNextMove("dddd");
        mockUi.addNextMove("5555");
        mockUi.addNextMove("y");

        playerOrderTest.validateStartingPlayer(mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
        assertEquals(true, mockUi.isChooseStartingPlayerMessafeCalled());
    }

    @Test
    public void choiceReturnsOpponentAsPlayerOne() {
        mockUi.addNextMove("o");

        playerOrderTest.validateStartingPlayer(mockUi.captureChoice());

        assertEquals("O", playerOrderTest.accessFirstAndSecondPlayers().get(0).getGamePiece());
        assertEquals("X", playerOrderTest.accessFirstAndSecondPlayers().get(1).getGamePiece());
    }

    @Test
    public void choiceReturnsUserAsPlayerOne() {
        mockUi.addNextMove("y");

        playerOrderTest.validateStartingPlayer(mockUi.captureChoice());

        assertEquals("X", playerOrderTest.accessFirstAndSecondPlayers().get(0).getGamePiece());
        assertEquals("O", playerOrderTest.accessFirstAndSecondPlayers().get(1).getGamePiece());
    }
}
