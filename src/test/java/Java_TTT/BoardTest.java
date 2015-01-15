package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    private Board boardTest;
    private Player testPlayer;

    private void simulateFilledBoard() {
        fillBoard("9", "X");
        fillBoard("8", "X");
        fillBoard("7", "O");
        fillBoard("6", "O");
        fillBoard("5", "X");
        fillBoard("4", "O");
        fillBoard("3", "X");
        fillBoard("2", "O");
        fillBoard("1", "X");
    }

    private ArrayList<Integer> simulateOpenCellsArray() {
        ArrayList<Integer>openCells = new ArrayList();
        openCells.add(1);
        openCells.add(3);
        openCells.add(4);
        openCells.add(5);
        openCells.add(6);
        openCells.add(7);
        openCells.add(8);

        return openCells;
    }

    private ArrayList<Integer> simulateOccupiedCellsArray() {
        ArrayList<Integer>occupiedCells = new ArrayList();
        occupiedCells.add(0);
        occupiedCells.add(1);

        return occupiedCells;
    }

    private boolean getCell(String answer, String gamePiece) {
       if (boardTest.getBoardCells()[convertAnswerToInteger(answer) - 1] == gamePiece) {
           return true;
       }
        return false;
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
    }

    private void fillBoard(String choice, String gamePiece) {
        boardTest.placeMove(choice, gamePiece);
    }

    @Before
    public void setUp() {
        boardTest = new Board(3);
        testPlayer = new Player("X");
    }

    @Test
    public void getLengthOfBoard() {
        assertEquals(9, boardTest.getLength());
    }

    @Test
    public void checkBoardSquareRoot() {
        assertEquals(3, boardTest.getCellsSquareRoot(9));
    }

    @Test
    public void returnBoardCellsAsThreeByThreeArray() {
        assertEquals("", boardTest.getBoardCells()[4]);
    }

    @Test
    public void checkSpaceOfBoardCellArray() {
        fillBoard("4", "X");
        fillBoard("5", "O");
        assertEquals("X", boardTest.getBoardCells()[3]);
        assertEquals("O", boardTest.getBoardCells()[4]);
    }

    @Test
    public void checkIfSevenIsValid() {
        assertEquals(true, boardTest.isMoveValid("7"));
    }

    @Test
    public void checkIfVIsValid() {
        assertEquals(false, boardTest.isMoveValid("v"));
    }

    @Test
    public void checkIfSymbolIsValid() {
        assertEquals(false, boardTest.isMoveValid("-"));
    }

    @Test
    public void checkTakenSpace() {
        fillBoard("1", "O");
        assertEquals(false, boardTest.isMoveValid("1"));
    }

    @Test
    public void checkIfBoardHasOpenSpaces() {
        assertEquals(true, boardTest.isBoardOpen());
    }

    @Test
    public void checkIfBoardFullWithMockInputs () {
        simulateFilledBoard();
        assertEquals(false, boardTest.isBoardOpen());
    }

    @Test
    public void placeMoveOnBoard() {
        fillBoard("9", testPlayer.getGamePiece());
        assertEquals(true, getCell("9", testPlayer.getGamePiece()));
    }

    @Test
    public void getEmptySpaces() {
        fillBoard("1", "X");
        fillBoard("3", "O");

        assertEquals(simulateOpenCellsArray(), boardTest.getOpenSpaces());
    }

    @Test
    public void getOccupiedSpaces() {
        fillBoard("1", "X");
        fillBoard("2", "O");

        assertEquals(simulateOccupiedCellsArray(), boardTest.getOccupiedSpaces());
    }

    @Test
    public void getOpponentGamePieceIfOpponentHasX() {
        fillBoard("1", "X");
        fillBoard("2", "O");
        fillBoard("5", "X");
        fillBoard("7", "O");

        assertEquals("X", boardTest.getOpponentPiece("O"));
    }

    @Test
    public void getOpponentGamePieceIfOpponentHasMadeNoMoves() {
        fillBoard("1", "X");

        assertEquals("", boardTest.getOpponentPiece("X"));
    }
}