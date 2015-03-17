package Java_TTT.games.setup;

import Java_TTT.boards.Board;
import Java_TTT.rules.FourByFourBoardRules;
import Java_TTT.rules.TTTBoardRules;
import Java_TTT.rules.ThreeByThreeBoardRules;
import Java_TTT.ui.MockUserInterface;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ParticipantSetUpTest {
    private ParticipantSetUp playerConfigurationTest;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUI = new MockUserInterface(output, input);

    private void choosePlayerCombinations(String userChoice) {
        playerConfigurationTest.validatePlayerConfiguration(userChoice);
    }

    private void chooseStartingPlayer(String startingPlayerChoice) {
        playerConfigurationTest.validateStartingPlayer(startingPlayerChoice);
    }

    @Test
    public void capturesUserChoiceForPlayerConfiguration() {
        Board board = new Board(3);
        TTTBoardRules boardRules = new ThreeByThreeBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("a");
        mockUI.addNextMove("1");

        choosePlayerCombinations(mockUI.captureChoice());

        assertEquals(true, mockUI.areGameConfigOptionsCalled());
        assertEquals(true, mockUI.isDisplayInvalidChoiceMessageCalled());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsHuman() {
        Board board = new Board(3);
        TTTBoardRules boardRules = new ThreeByThreeBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("ppp");
        mockUI.addNextMove("1");

        choosePlayerCombinations(mockUI.captureChoice());

        assertEquals("Human", playerConfigurationTest.getPlayer1().getName());
        assertEquals("Human", playerConfigurationTest.getPlayer2().getName());
        assertEquals("X", playerConfigurationTest.getPlayer1().getGamePiece());
        assertEquals("O", playerConfigurationTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsBasicComputer() {
        Board board = new Board(3);
        TTTBoardRules boardRules = new ThreeByThreeBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("b");
        mockUI.addNextMove("9");
        mockUI.addNextMove("2");

        choosePlayerCombinations(mockUI.captureChoice());

        assertEquals("Human", playerConfigurationTest.getPlayer1().getName());
        assertEquals("SimpleAI", playerConfigurationTest.getPlayer2().getName());
        assertEquals("X", playerConfigurationTest.getPlayer1().getGamePiece());
        assertEquals("O", playerConfigurationTest.getPlayer2().getGamePiece());
    }

    @Test
    public void checkThatPlayer1IsHumanAndPlayer2IsAI() {
        Board board = new Board(3);
        TTTBoardRules boardRules = new ThreeByThreeBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("---");
        mockUI.addNextMove("3");

        choosePlayerCombinations(mockUI.captureChoice());

        assertEquals("Human", playerConfigurationTest.getPlayer1().getName());
        assertEquals("HardAI", playerConfigurationTest.getPlayer2().getName());
        assertEquals("X", playerConfigurationTest.getPlayer1().getGamePiece());
        assertEquals("O", playerConfigurationTest.getPlayer2().getGamePiece());
        assertEquals("1", playerConfigurationTest.getPlayer2().getMove());
    }

    @Test
    public void checkThatPlayer1IsBasicComputerAndPlayer2IsAI() {
        Board board = new Board(3);
        TTTBoardRules boardRules = new ThreeByThreeBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("---");
        mockUI.addNextMove("4");

        choosePlayerCombinations(mockUI.captureChoice());

        assertEquals("SimpleAI", playerConfigurationTest.getPlayer1().getName());
        assertEquals("HardAI", playerConfigurationTest.getPlayer2().getName());
        assertEquals("X", playerConfigurationTest.getPlayer1().getGamePiece());
        assertEquals("O", playerConfigurationTest.getPlayer2().getGamePiece());
    }

    @Test
    public void capturesAndValidatesChoiceUntilValidInputIsReturned() {
        Board board = new Board(3);
        TTTBoardRules boardRules = new ThreeByThreeBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("dddd");
        mockUI.addNextMove("5555");
        mockUI.addNextMove("1");

        choosePlayerCombinations("2");
        chooseStartingPlayer(mockUI.captureChoice());

        assertEquals(true, mockUI.isDisplayInvalidChoiceMessageCalled());
        assertEquals(true, mockUI.isStartingPlayerMessageCalled());
    }

    @Test
    public void choiceReturnsHumanPlayerAsStartingPlayerAgainstBasicComputerPlayer() {
        Board board = new Board(3);
        TTTBoardRules boardRules = new ThreeByThreeBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("1");

        choosePlayerCombinations("2");
        chooseStartingPlayer(mockUI.captureChoice());

        assertEquals("Human", playerConfigurationTest.accessFirstAndSecondPlayers().get(0).getClass().getSimpleName());
        assertEquals("SimpleAI", playerConfigurationTest.accessFirstAndSecondPlayers().get(1).getClass().getSimpleName());
    }

    @Test
    public void choiceReturnsBasicComputerAsStartingPlayerAgainstHumanPlayer() {
        Board board = new Board(3);
        TTTBoardRules boardRules = new ThreeByThreeBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("2");

        choosePlayerCombinations("2");
        chooseStartingPlayer(mockUI.captureChoice());

        assertEquals("SimpleAI", playerConfigurationTest.accessFirstAndSecondPlayers().get(0).getClass().getSimpleName());
        assertEquals("Human", playerConfigurationTest.accessFirstAndSecondPlayers().get(1).getClass().getSimpleName());
    }

    @Test
    public void choiceReturnsAIComputerPlayerAsStartingPlayerAgainstHumanPlayer() {
        Board board = new Board(3);
        TTTBoardRules boardRules = new ThreeByThreeBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("2");

        choosePlayerCombinations("3");
        chooseStartingPlayer(mockUI.captureChoice());

        assertEquals("HardAI", playerConfigurationTest.accessFirstAndSecondPlayers().get(0).getClass().getSimpleName());
        assertEquals("Human", playerConfigurationTest.accessFirstAndSecondPlayers().get(1).getClass().getSimpleName());
    }

    @Test
    public void choiceReturnsBasicComputerPlayerAsStartingPlayerAgainstAIPlayer() {
        Board board = new Board(4);
        TTTBoardRules boardRules = new FourByFourBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("1");

        choosePlayerCombinations("4");
        chooseStartingPlayer(mockUI.captureChoice());

        assertEquals("SimpleAI", playerConfigurationTest.accessFirstAndSecondPlayers().get(0).getClass().getSimpleName());
        assertEquals("HardAI", playerConfigurationTest.accessFirstAndSecondPlayers().get(1).getClass().getSimpleName());
    }

    @Test
    public void choiceReturnsAIComputerPlayerAsStartingPlayerAgainstBasicPlayer() {
        Board board = new Board(4);
        TTTBoardRules boardRules = new FourByFourBoardRules(board);
        playerConfigurationTest = new ParticipantSetUp(mockUI, boardRules, board);
        mockUI.addNextMove("2");

        choosePlayerCombinations("4");
        chooseStartingPlayer(mockUI.captureChoice());

        assertEquals("HardAI", playerConfigurationTest.accessFirstAndSecondPlayers().get(0).getClass().getSimpleName());
        assertEquals("SimpleAI", playerConfigurationTest.accessFirstAndSecondPlayers().get(1).getClass().getSimpleName());
    }

    @Test
    public void geParticipantOptionsList() {
        Board board = new Board(4);
        TTTBoardRules boardRules = new FourByFourBoardRules(board);
        Configurable participantConfig = new ParticipantSetUp(mockUI, boardRules, board);

        mockUI.addNextMove("4");
        mockUI.addNextMove("1");

        participantConfig.getConfigurationChoice();

        assertEquals("SimpleAI", participantConfig.getDesiredGameOptions().get(0).getClass().getSimpleName());
        assertEquals("HardAI", participantConfig.getDesiredGameOptions().get(1).getClass().getSimpleName());
    }

}
