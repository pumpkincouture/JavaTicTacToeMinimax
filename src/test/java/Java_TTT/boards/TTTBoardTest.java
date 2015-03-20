package Java_TTT.boards;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TTTBoardTest {
    private TTTBoard boardTest;


    private void addMovesToBoard(String... positions) {
        for (int counter = 0; counter < boardTest.getLength(); counter++) {
            if (positions[counter] != "*") {
                boardTest.placeMove(String.valueOf(counter + 1), positions[counter]);
            }
        }
    }

    @Test
    public void getSizeOf3x3Board() {
        boardTest = new TTTBoard(3);
        assertEquals(9, boardTest.getLength());
    }

    @Test
    public void getSizeOf4x4Board() {
        boardTest = new TTTBoard(4);
        assertEquals(16, boardTest.getLength());
    }

    @Test
    public void checkBoardSquareRootOf3x3() {
        boardTest = new TTTBoard(3);
        assertEquals(3, boardTest.getCellsSquareRoot());
    }

    @Test
    public void checkBoardSquareRootOf4x4() {
        boardTest = new TTTBoard(4);
        assertEquals(4, boardTest.getCellsSquareRoot());
    }

    @Test
    public void emptyCellsOnThreeByThreeInitializedWithAsterisk() {
        boardTest = new TTTBoard(3);
        for (int i=0; i < boardTest.getCells().length; i++) {
            for (int j=0; j < boardTest.getCells()[i].length; j++) {
                assertEquals("*", boardTest.getCells()[i][j]);
            }
        }
    }

    @Test
    public void emptyCellsOnFourByFourInitializedWithAsterisk() {
        boardTest = new TTTBoard(4);
        for (int i=0; i < boardTest.getCells().length; i++) {
            for (int j=0; j < boardTest.getCells()[i].length; j++) {
                assertEquals("*", boardTest.getCells()[i][j]);
            }
        }
    }

    @Test
    public void checkIfSpaceIsAlreadyOccupiedOn3x3Board() {
        boardTest = new TTTBoard(3);
        boardTest.placeMove("4", "X");
        assertFalse(boardTest.isMoveValid("4"));
    }

    @Test
    public void checkIfSpace9IsAleadyOccupiedOn4x4Board() {
        boardTest = new TTTBoard(4);
        boardTest.placeMove("9", "X");
        assertFalse(boardTest.isMoveValid("9"));
    }

    private TTTBoard emptyBoard(int size) {
        return new TTTBoard(size);
    }

    @Test
    public void checkIfSevenIsValid() {
        assertTrue(emptyBoard(3).isMoveValid("7"));
    }

    @Test
    public void checkIfVIsValid() {
        assertFalse(emptyBoard(3).isMoveValid("v"));
    }

    @Test
    public void checkIfSymbolIsValid() {
        assertFalse(emptyBoard(3).isMoveValid("-"));
    }

    @Test
    public void checkIfSpaceIsTakenOn3x3Board() {
        boardTest = emptyBoard(3);
        boardTest.placeMove("1", "O");
        assertFalse(boardTest.isMoveValid("1"));
    }

    @Test
    public void checkIfSpaceIsTakenOn4x4Board() {
        boardTest = new TTTBoard(4);
        boardTest.placeMove("11", "O");
        assertFalse(boardTest.isMoveValid("11"));
    }

    @Test
    public void checkIfBoardHasOpenSpaces() {
        assertFalse(emptyBoard(3).isFull());
    }

    @Test
    public void checkIfBoardFullWithMockInputs () {
        boardTest = new TTTBoard(3);
        addMovesToBoard("X", "*", "O", "*", "*", "*", "*", "*", "*");
        assertTrue(boardTest.isFull());
    }

    @Test
    public void checkIfCellIsClearedOn4x4Board() {
        boardTest = new TTTBoard(4);
        boardTest.placeMove("11", "O");
        boardTest.resetCell(10);

        assertTrue(boardTest.isMoveValid("11"));
    }

    @Test
    public void checkIfCellIsClearedOn3x3Board() {
        boardTest = new TTTBoard(4);
        boardTest.placeMove("11", "O");
        boardTest.resetCell(10);

        assertTrue(boardTest.isMoveValid("11"));
    }

    @Test
    public void getEmptySpacesOn3x3Board() {
        boardTest = new TTTBoard(3);
        addMovesToBoard("X", "X", "O",
                        "*", "*", "*",
                        "*", "*", "X");
        assertEquals(Arrays.asList(3, 4, 5, 6, 7), boardTest.getOpenSpaces());
    }

    @Test
    public void getEmptySpacesOn4x4Board() {
        boardTest = new TTTBoard(4);
        boardTest.placeMove("1", "X");
        boardTest.placeMove("2", "O");
        boardTest.placeMove("3", "X");
        boardTest.placeMove("4", "O");
        boardTest.placeMove("5", "X");
        boardTest.placeMove("10", "X");
        boardTest.placeMove("13", "O");

        assertEquals(Arrays.asList(5, 6, 7, 8, 10, 11, 13, 14, 15),
                boardTest.getOpenSpaces());
    }

    @Test
    public void getOccupiedSpacesOn3x3Board() {
        boardTest = new TTTBoard(3);
        boardTest.placeMove("1", "X");
        boardTest.placeMove("2", "O");
        boardTest.placeMove("3", "X");
        boardTest.placeMove("4", "O");
        boardTest.placeMove("5", "X");

        assertEquals(Arrays.asList(5, 6, 7, 8),
                boardTest.getOpenSpaces());
    }

    @Test
    public void getOpponentGamePieceIfOpponentHasX() {
        boardTest = new TTTBoard(3);
        boardTest.placeMove("1", "X");
        boardTest.placeMove("2", "O");
        boardTest.placeMove("5", "X");
        boardTest.placeMove("7", "O");

        assertEquals("X", boardTest.getOpponentPiece("O"));
    }

    @Test
    public void getOpponentGamePieceIfOpponentHasMadeNoMoves() {
        boardTest = new TTTBoard(3);
        boardTest.placeMove("1", "X");

        assertEquals("", boardTest.getOpponentPiece("X"));
    }
}