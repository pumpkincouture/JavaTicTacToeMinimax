package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;
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
        gameConfigTest = new GameConfiguration(mockUi);
    }

    private void choosePlayerCombinations(String playerComboChoice) {
        gameConfigTest.validateGameConfiguration(playerComboChoice);
    }

    private void chooseStartingPlayer(String startingPlayerChoice) {
        gameConfigTest.validateStartingPlayer(startingPlayerChoice);
    }

    private void chooseBoardSize(String boardSizeChoice) {
        gameConfigTest.validateBoardSizeChoice(boardSizeChoice);
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

        assertEquals("Human", gameConfigTest.getPlayer1().getName());
        assertEquals("Human", gameConfigTest.getPlayer2().getName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsBasicComputer() {
        mockUi.addNextMove("b");
        mockUi.addNextMove("9");
        mockUi.addNextMove("2");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("Human", gameConfigTest.getPlayer1().getName());
        assertEquals("Computer",gameConfigTest.getPlayer2().getName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsAI() {
        mockUi.addNextMove("---");
        mockUi.addNextMove("3");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("Human", gameConfigTest.getPlayer1().getName());
        assertEquals("AI", gameConfigTest.getPlayer2().getName());
        assertEquals("X", gameConfigTest.getPlayer1().getGamePiece());
        assertEquals("O", gameConfigTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsBasicComputerAndPlayer2IsAI() {
        mockUi.addNextMove("---");
        mockUi.addNextMove("4");

        choosePlayerCombinations(mockUi.captureChoice());

        assertEquals("Computer", gameConfigTest.getPlayer1().getName());
        assertEquals("AI", gameConfigTest.getPlayer2().getName());
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

        assertEquals("Human", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("Computer", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
    }

    @Test
    public void choiceReturnsBasicComputerAsStartingPlayerAgainstHumanPlayer() {
        mockUi.addNextMove("2");

        choosePlayerCombinations("2");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("Computer", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("Human", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
    }

    @Test
    public void choiceReturnsAIComputerPlayerAsStartingPlayerAgainstHumanPlayer() {
        mockUi.addNextMove("2");

        choosePlayerCombinations("3");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("AI", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("Human", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
    }

    @Test
    public void choiceReturnsBasicComputerPlayerAsStartingPlayerAgainstAIPlayer() {
        mockUi.addNextMove("1");

        choosePlayerCombinations("4");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("Computer", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("AI", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
    }

    @Test
    public void choiceReturnsAIComputerPlayerAsStartingPlayerAgainstBasicPlayer() {
        mockUi.addNextMove("2");

        choosePlayerCombinations("4");
        chooseStartingPlayer(mockUi.captureChoice());

        assertEquals("AI", gameConfigTest.accessFirstAndSecondPlayers().get(0).getName());
        assertEquals("Computer", gameConfigTest.accessFirstAndSecondPlayers().get(1).getName());
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
