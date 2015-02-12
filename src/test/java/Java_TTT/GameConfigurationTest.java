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

    private void chooseStartingPlayer(String choice) {
        gameConfigTest.validateStartingPlayer(choice);
    }

    private void chooseBoardSize(String choice) {
        gameConfigTest.validateBoardSizeChoice(choice);
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

        assertEquals("HumanPlayer", gameConfigTest.getPlayer1().getName());
        assertEquals("HumanPlayer", gameConfigTest.getPlayer2().getName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsBasicComputer() {
        mockUi.addNextMove("b");
        mockUi.addNextMove("9");
        mockUi.addNextMove("2");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("HumanPlayer", gameConfigTest.getPlayer1().getName());
        assertEquals("ComputerPlayer",gameConfigTest.getPlayer2().getName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsAI() {
        mockUi.addNextMove("---");
        mockUi.addNextMove("3");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("HumanPlayer", gameConfigTest.getPlayer1().getName());
        assertEquals("AIComputerPlayer", gameConfigTest.getPlayer2().getName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsBasicComputerAndPlayer2IsAI() {
        mockUi.addNextMove("---");
        mockUi.addNextMove("4");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("ComputerPlayer", gameConfigTest.getPlayer1().getName());
        assertEquals("AIComputerPlayer", gameConfigTest.getPlayer2().getName());
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

        assertEquals("HumanPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("ComputerPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
    }

    @Test
    public void choiceReturnsBasicComputerAsStartingPlayerAgainstHumanPlayer() {
        mockUi.addNextMove("2");

        choosePlayerCombinations("2");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("ComputerPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("HumanPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
    }

    @Test
    public void choiceReturnsAIComputerPlayerAsStartingPlayerAgainstHumanPlayer() {
        mockUi.addNextMove("2");

        choosePlayerCombinations("3");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("AIComputerPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("HumanPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
    }

    @Test
    public void choiceReturnsBasicComputerPlayerAsStartingPlayerAgainstAIPlayer() {
        mockUi.addNextMove("1");

        choosePlayerCombinations("4");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("ComputerPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("AIComputerPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
    }

    @Test
    public void choiceReturnsAIComputerPlayerAsStartingPlayerAgainstBasicPlayer() {
        mockUi.addNextMove("2");

        choosePlayerCombinations("4");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("AIComputerPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("ComputerPlayer", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
    }

    @Test
    public void validateBoardSizeUntilChoiceIs3() {
        mockUi.addNextMove("2");
        mockUi.addNextMove("p");
        mockUi.addNextMove("3");

        chooseBoardSize(mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
        assertEquals(true, mockUi.isBoardSizePromptCalled());
        assertEquals(3, gameConfigTest.getBoardSize());
    }

    @Test
    public void validateBoardSizeUntilChoiceIs4() {
        mockUi.addNextMove("2");
        mockUi.addNextMove("p");
        mockUi.addNextMove("4");

        chooseBoardSize(mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
        assertEquals(true, mockUi.isBoardSizePromptCalled());
        assertEquals(4, gameConfigTest.getBoardSize());
    }
}
