package Java_TTT.participants;

import Java_TTT.boards.Board;
import Java_TTT.participants.SimpleAI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleAITest {
    private SimpleAI computerPlayerTest;
    private Board board;

    private void simulateFilledBoard() {
        fillBoard("4", "O");
        fillBoard("3", "X");
        fillBoard("2", "O");
        fillBoard("1", "X");
    }

    private void simulateFilled4x4Board() {
        fillBoard("16", "O");
        fillBoard("15", "X");
        fillBoard("14", "X");
        fillBoard("13", "O");
        fillBoard("12", "X");
        fillBoard("11", "O");
        fillBoard("10", "O");
        fillBoard("9", "X");
        fillBoard("8", "O");
        fillBoard("7", "X");
        fillBoard("5", "O");
        fillBoard("4", "X");
        fillBoard("3", "X");
        fillBoard("2", "X");
    }

    private void fillBoard(String choice, String gamePiece) {
        board.placeMove(choice, gamePiece);
    }

    @Test
    public void getsGamePiece() {
        board = new Board(3);
        computerPlayerTest = new SimpleAI("Z", board);
        assertEquals("Z", computerPlayerTest.getGamePiece());
    }

    @Test
    public void getOpenSpace() {
        board = new Board(3);
        computerPlayerTest = new SimpleAI("Z", board);

        simulateFilledBoard();
        fillBoard("8", "X");
        fillBoard("7", "O");
        fillBoard("6", "O");
        fillBoard("5", "X");

        assertEquals("9", computerPlayerTest.getMove());
    }

    @Test
    public void getOpenSpaceOn4x4Board() {
        board = new Board(4);
        computerPlayerTest = new SimpleAI("Z", board);

        simulateFilled4x4Board();
        fillBoard("6", "O");

        assertEquals("1", computerPlayerTest.getMove());
    }

    @Test
    public void getOpenSpaceScenarioTwo() {
        board = new Board(3);
        computerPlayerTest = new SimpleAI("Z", board);

        simulateFilledBoard();
        fillBoard("8", "X");
        fillBoard("9", "O");
        fillBoard("7", "O");
        fillBoard("5", "X");

        assertEquals("6", computerPlayerTest.getMove());
    }

    @Test
    public void getOpenSpaceScenarioTwoOn4x4Board() {
        board = new Board(4);
        computerPlayerTest = new SimpleAI("Z", board);

        simulateFilled4x4Board();
        fillBoard("1", "O");

        assertEquals("6", computerPlayerTest.getMove());
    }
}
