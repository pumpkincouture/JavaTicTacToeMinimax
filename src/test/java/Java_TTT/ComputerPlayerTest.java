package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {
    private ComputerPlayer computerPlayerTest;
    private Board board;

    private void simulateFilledBoard() {
        fillBoard("4", "O");
        fillBoard("3", "X");
        fillBoard("2", "O");
        fillBoard("1", "X");
    }

    private void fillBoard(String choice, String gamePiece) {
        board.placeMove(choice, gamePiece);
    }

    @Before
    public void setUp() {
        board = new Board(3);
        computerPlayerTest = new ComputerPlayer("Z");
    }

    @Test
    public void getsGamePiece() {
        assertEquals("Z", computerPlayerTest.getGamePiece());
    }

    @Test
    public void getOpenSpace() {
        simulateFilledBoard();
        fillBoard("8", "X");
        fillBoard("7", "O");
        fillBoard("6", "O");
        fillBoard("5", "X");
        assertEquals("9", computerPlayerTest.getMove(board));
    }

    @Test
    public void getOpenSpaceScenarioTwo() {
        simulateFilledBoard();
        fillBoard("8", "X");
        fillBoard("9", "O");
        fillBoard("7", "O");
        fillBoard("5", "X");
        assertEquals("6", computerPlayerTest.getMove(board));
    }
}
