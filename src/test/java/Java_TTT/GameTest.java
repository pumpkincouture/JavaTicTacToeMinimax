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
    private Player player1 = new HumanPlayer("X", mockUi);
    private Player player2 = new HumanPlayer("O", mockUi);
    private GameScorer gameScorer = new GameScorer(board);

    private void fillBoard(String choice, String gamePiece) {
        board.placeMove(choice, gamePiece);
    }

    private boolean getCell(String answer, String gamePiece) {
        if (board.getBoardCells()[convertAnswerToInteger(answer) - 1] == gamePiece) {
            return true;
        }
        return false;
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
    }


    @Before
    public void setUp() {
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
    }

    @Test
    public void displayWelcomeMessage() {
        gameTest.printWelcome();
        assertEquals(true, mockUi.isWelcomeMessageCalled());
    }

    @Test
    public void displayGamePieces() {
        gameTest.printGamePieces();
        assertEquals(true, mockUi.isGamePieceMessageCalled());
    }

    @Test
    public void displayStartingPlayer() {
        gameTest.printStartingPlayer();
        assertEquals(true, mockUi.isStartingPlayerCalled());
    }

    @Test
    public void getInitialBoardDisplay() {
        gameTest.displayBoard();
        assertEquals(true, mockUi.isDisplayBoardCalled());
    }

    @Test
    public void displayUserPrompt() {
        gameTest.printPlayerPrompt(player1.getClass().getSimpleName(), player1.getGamePiece());
        assertEquals(true, mockUi.isUserPromptCalled());
    }
    @Test
    public void testIfMoveInvalid() {
        mockUi.addNextMove("ppppp");
        gameTest.printChoiceError(mockUi.captureChoice());
        assertEquals(true, mockUi.isDisplayInvalidMoveMessageCalled());
    }

    @Test
    public void promptUntilMoveValid() {
        mockUi.addNextMove("PPP");
        mockUi.addNextMove("hehhghntnt");
        mockUi.addNextMove("3");
        gameTest.getFirstMove(mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidMoveMessageCalled());
        fillBoard("3", "X");
        assertEquals(true, getCell("3", "X"));
    }

    @Test
    public void testIfMoveValid() {
        mockUi.addNextMove("5");
        gameTest.printChoiceError(mockUi.captureChoice());
        assertEquals(false, mockUi.isDisplayInvalidMoveMessageCalled());
    }

    @Test
    public void testForWinner() {
        mockUi.addNextMove("1");
        mockUi.addNextMove("2");
        mockUi.addNextMove("3");

        for (int i = 0; i <= 2; i++) {
            fillBoard(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameTest.getWinnerName(player1.getGamePiece(), player2.getGamePiece()));
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

        gameTest.printGameWinner(gameTest.getWinnerName(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isCatsGameCalled());
    }
}
