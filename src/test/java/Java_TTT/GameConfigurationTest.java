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

    private void choosePlayerCombinations(String choice) {
        gameConfigTest.validateGameConfiguration(choice);
    }

    private String getPlayerName(Player player) {
        return player.getClass().getSimpleName();
    }

    private void chooseStartingPlayer(String choice) {
        gameConfigTest.validateStartingPlayer(choice);
    }

    @Test
    public void capturesUserChoiceForConfigurations() {
        mockUi.addNextMove("a");
        mockUi.addNextMove("1");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals(true, mockUi.areGameConfigOptionsCalled());
        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsHuman() {
        mockUi.addNextMove("ppp");
        mockUi.addNextMove("1");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("HumanPlayer", getPlayerName(gameConfigTest.getPlayer1()));
        assertEquals("HumanPlayer", getPlayerName(gameConfigTest.getPlayer2()));
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsBasicComputer() {
        mockUi.addNextMove("b");
        mockUi.addNextMove("9");
        mockUi.addNextMove("2");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("HumanPlayer", getPlayerName(gameConfigTest.getPlayer1()));
        assertEquals("ComputerPlayer", getPlayerName(gameConfigTest.getPlayer2()));
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsAI() {
        mockUi.addNextMove("---");
        mockUi.addNextMove("3");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("HumanPlayer", getPlayerName(gameConfigTest.getPlayer1()));
        assertEquals("AIComputerPlayer", getPlayerName(gameConfigTest.getPlayer2()));
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsBasicComputerAndPlayer2IsAI() {
        mockUi.addNextMove("---");
        mockUi.addNextMove("4");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("ComputerPlayer", getPlayerName(gameConfigTest.getPlayer1()));
        assertEquals("AIComputerPlayer", getPlayerName(gameConfigTest.getPlayer2()));
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void capturesAndValidatesChoiceUntilValidInputIsReturned() {
        mockUi.addNextMove("dddd");
        mockUi.addNextMove("5555");
        mockUi.addNextMove("1");

        choosePlayerCombinations("2");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
        assertEquals(true, mockUi.isStartingPlayerMessageCalled());
    }

    @Test
    public void choiceReturnsHumanPlayerAsStartingPlayerAgainstBasicComputerPlayer() {
        mockUi.addNextMove("1");

        choosePlayerCombinations("2");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("HumanPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(0)));
        assertEquals("ComputerPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(1)));
    }

    @Test
    public void choiceReturnsBasicComputerAsStartingPlayerAgainstHumanPlayer() {
        mockUi.addNextMove("2");

        choosePlayerCombinations("2");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("ComputerPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(0)));
        assertEquals("HumanPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(1)));
    }

    @Test
    public void choiceReturnsAIComputerPlayerAsStartingPlayerAgainstHumanPlayer() {
        mockUi.addNextMove("2");

        choosePlayerCombinations("3");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("AIComputerPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(0)));
        assertEquals("HumanPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(1)));
    }

    @Test
    public void choiceReturnsBasicComputerPlayerAsStartingPlayerAgainstAIPlayer() {
        mockUi.addNextMove("1");

        choosePlayerCombinations("4");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("ComputerPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(0)));
        assertEquals("AIComputerPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(1)));
    }

    @Test
    public void choiceReturnsAIComputerPlayerAsStartingPlayerAgainstBasicPlayer() {
        mockUi.addNextMove("2");

        choosePlayerCombinations("4");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("AIComputerPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(0)));
        assertEquals("ComputerPlayer", getPlayerName(gameConfigTest.accessFirstAndSecondPlayers().get(1)));
    }
}
