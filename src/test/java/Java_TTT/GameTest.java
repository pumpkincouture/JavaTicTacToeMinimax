package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game gameTest;
    private Board board = new Board(3);
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private PlayerInterface player1 = new HumanPlayer("X", mockUi);
    private PlayerInterface player2 = new HumanPlayer("O", mockUi);
    private GameScorer gameScorer = new GameScorer(board);

    private void fillBoard(String choice, String gamePiece) {
        board.placeMove(choice, gamePiece);
    }

    private boolean getCell(String answer, String gamePiece) {
        if (board.getCells()[convertAnswerToInteger(answer) - 1] == gamePiece) {
            return true;
        }
        return false;
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
    }

    private void setCurrentPlayer(PlayerInterface player) {
        gameTest.setCurrentPlayer(player);
    }

    private void switchPlayers() {
        if (gameTest.getCurrentPlayer() == player1) {
            setCurrentPlayer(player2);
        } else {
            setCurrentPlayer(player1);
        }
    }


    @Before
    public void setUp() {
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
    }

    @Test
    public void displayWelcomeMessage() {
        gameTest.printIntro();
        assertEquals(true, mockUi.isWelcomeMessageCalled());
        assertEquals(true, mockUi.isUserPromptCalled());
        assertEquals(true, mockUi.isStartingPlayerCalled());
        assertEquals(true, mockUi.isGamePieceMessageCalled());
    }

    @Test
    public void getInitialBoardDisplay() {
        mockUi.printBoard(board);
        assertEquals(true, mockUi.isDisplayBoardCalled());
    }

    @Test
    public void promptUntilMoveValid() {
        mockUi.addNextMove("PPP");
        mockUi.addNextMove("hehhghntnt");
        mockUi.addNextMove("3");

        setCurrentPlayer(player1);

        gameTest.getPlayerChoice(gameTest.getCurrentPlayer(), mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
        fillBoard("3", "X");
        assertEquals(true, getCell("3", "X"));
    }

    @Test
    public void testIfCurrentPlayerIsPlayerWithX() {
        setCurrentPlayer(player1);

        assertEquals("X", gameTest.getCurrentPlayer().getGamePiece());
    }

    @Test
    public void switchPlayersAndTestIfPlayerWithOIsSetAsCurrentPlayer() {
        setCurrentPlayer(player1);
        switchPlayers();

        assertEquals("O", gameTest.getCurrentPlayer().getGamePiece());
    }

    @Test
    public void testForWinner() {
        mockUi.addNextMove("1");
        mockUi.addNextMove("2");
        mockUi.addNextMove("3");

        for (int i = 0; i <= 2; i++) {
            fillBoard(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameScorer.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isWinnerStringCalled());
    }

    @Test
    public void testForCatsGame() {
        mockUi.addNextMove("1");
        mockUi.addNextMove("4");
        mockUi.addNextMove("3");
        mockUi.addNextMove("8");
        mockUi.addNextMove("9");
        mockUi.addNextMove("5");
        mockUi.addNextMove("2");
        mockUi.addNextMove("6");
        mockUi.addNextMove("7");

        for (int i = 0; i <= 4; i++) {
            fillBoard(mockUi.captureChoice(), player1.getGamePiece());
        }

        for (int i = 0; i <= 3; i++) {
            fillBoard(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameScorer.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isCatsGameCalled());
    }
}