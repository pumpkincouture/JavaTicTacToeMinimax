package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AIComputerTest {
    private AIComputerPlayer aiComputerTest;
    private Board board;
    PrintStream output = new PrintStream(System.out);
    Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);

    private void fillBoard(String choice, String gamePiece) {
        board.placeMove(choice, gamePiece);
    }

    @Before
    public void setUp() {
        board = new Board(3);
        aiComputerTest = new AIComputerPlayer("O", board, mockUi);
    }

    @Test
    public void returnsBlockIfCompCannotWinInNextMove() {
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("4", "O");
        fillBoard("5", "O");
        fillBoard("6", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");

        assertEquals("3", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinForItselfRatherThanBlockingOpponentFromWinning() {
        fillBoard("1", "X");
        fillBoard("3", "X");
        fillBoard("5", "O");
        fillBoard("6", "O");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "X");

        assertEquals("2", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinForItself() {
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("6", "X");
        fillBoard("7", "O");
        fillBoard("9", "X");

        assertEquals("5", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinningMoveIfFiveSpacesLeft() {
        fillBoard("1", "X");
        fillBoard("2", "O");
        fillBoard("4", "X");
        fillBoard("5", "O");

        assertEquals("8", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinningMoveAndBlocksOpponent() {
        fillBoard("1", "O");
        fillBoard("3", "X");
        fillBoard("4", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");

        assertEquals("5", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinningSpotWhenThereAreSixSpotsOnTheBoard() {
        fillBoard("1", "O");
        fillBoard("3", "O");
        fillBoard("5", "X");

        assertEquals("2", aiComputerTest.getMove());
    }

    @Test
    public void returnsBestMoveAfterOpponentPlacesFirstMove() {
        fillBoard("1", "X");

        assertEquals("5", aiComputerTest.getMove());
    }

    @Test
    public void returnsBlockingMove() {
        fillBoard("1", "X");
        fillBoard("7", "O");
        fillBoard("5", "X");

        assertEquals("9", aiComputerTest.getMove());
    }

    @Test
    public void returnsBlockForOpponent() {
        fillBoard("9", "X");
        fillBoard("1", "O");
        fillBoard("8", "X");

        assertEquals("7", aiComputerTest.getMove());
    }

    @Test
    public void picksMiddleSpaceIfBoardEmpty() {

        assertEquals("5", aiComputerTest.getMove());
        assertEquals(true, mockUi.isComputerThinkingCalled());
    }
}