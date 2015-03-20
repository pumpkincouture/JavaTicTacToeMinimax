package Java_TTT.boards;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    private Board boardTest;


    private void addMovesToBoard(String... positions) {
        for (int counter = 0; counter < boardTest.getLength(); counter++) {
            if (positions[counter] != "*") {
                boardTest.placeMove(String.valueOf(counter + 1), positions[counter]);
            }
        }
    }

    @Test
    public void getSizeOf3x3Board() {
        boardTest = new Board(3);
        assertEquals(9, boardTest.getLength());
    }

    @Test
    public void getSizeOf4x4Board() {
        boardTest = new Board(4);
        assertEquals(16, boardTest.getLength());
    }

    @Test
    public void emptyCellsOnThreeByThreeInitializedWithAsterisk() {
        boardTest = new Board(3);
        for (int i=0; i < boardTest.getCells().length; i++) {
            for (int j=0; j < boardTest.getMatrix()[i].length; j++) {
                assertEquals("*", boardTest.getMatrix()[i][j]);
            }
        }
    }

    @Test
    public void emptyCellsOnFourByFourInitializedWithAsterisk() {
        boardTest = new Board(4);
        for (int i=0; i < boardTest.getCells().length; i++) {
            for (int j=0; j < boardTest.getMatrix()[i].length; j++) {
                assertEquals("*", boardTest.getMatrix()[i][j]);
            }
        }
    }

    @Test
    public void checkIfSpaceIsAlreadyOccupiedOn3x3Board() {
        boardTest = new Board(3);
        boardTest.placeMove("4", "X");
        assertFalse(boardTest.isMoveValid("4"));
    }

    @Test
    public void checkIfSpaceIsAleadyOccupiedOn4x4Board() {
        boardTest = new Board(4);
        boardTest.placeMove("9", "X");
        assertFalse(boardTest.isMoveValid("9"));
    }

    private Board emptyBoard(int size) {
        return new Board(size);
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
    public void checkIfSpace1IsTakenOn3x3Board() {
        boardTest = emptyBoard(3);
        boardTest.placeMove("1", "O");
        assertFalse(boardTest.isMoveValid("1"));
    }

    @Test
    public void checkIfSpace11IsTakenOn4x4Board() {
        boardTest = new Board(4);
        boardTest.placeMove("11", "O");
        assertFalse(boardTest.isMoveValid("11"));
    }

    @Test
    public void checkIfBoardIsEmpty() {
        assertFalse(emptyBoard(3).isFull());
    }

    @Test
    public void checkIfBoardFullWithMockInputs () {
        boardTest = new Board(3);
        addMovesToBoard("X", "*", "O",
                        "*", "*", "*",
                        "*", "*", "*");
        assertTrue(boardTest.isFull());
    }

    @Test
    public void checkIfCellIsClearedOn3x3Board() {
        boardTest = new Board(3);
        boardTest.placeMove("4", "O");
        boardTest.resetCell(3);

        assertTrue(boardTest.isMoveValid("4"));
    }

    @Test
    public void checkIfCellIsClearedOn4x4Board() {
        boardTest = new Board(4);
        boardTest.placeMove("11", "O");
        boardTest.resetCell(10);

        assertTrue(boardTest.isMoveValid("11"));
    }

    @Test
    public void getListOfIndexedEmptySpacesOn3x3Board() {
        boardTest = new Board(3);
        addMovesToBoard("X", "X", "O",
                        "*", "*", "*",
                        "*", "*", "X");
        assertEquals(Arrays.asList(3, 4, 5, 6, 7), boardTest.getOpenSpaces());
    }

    @Test
    public void getListOfIndexedEmptySpacesOn4x4Board() {
        boardTest = new Board(4);
        addMovesToBoard("X", "O", "X", "O",
                        "X", "*", "*", "*",
                        "*", "X", "*", "*",
                        "O", "*", "*", "*");

        assertEquals(Arrays.asList(5, 6, 7, 8, 10, 11, 13, 14, 15),
                boardTest.getOpenSpaces());
    }

    @Test
    public void getListOfIndexedOccupiedSpacesOn3x3Board() {
        boardTest = new Board(3);
        addMovesToBoard("X", "O", "X",
                        "O", "X", "*",
                        "*", "*", "*");

        assertEquals(Arrays.asList(5, 6, 7, 8),
                boardTest.getOpenSpaces());
    }
}