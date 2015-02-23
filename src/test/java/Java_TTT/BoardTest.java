package Java_TTT;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    private Board boardTest;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private PlayerInterface player1 = new Human("X", mockUi);

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

    private ArrayList<Integer> simulateOpenCellsArrayFor3x3Board() {
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

    private ArrayList<Integer> simulateOpenCellsArrayFor4x4Board() {
        ArrayList<Integer>openCells = new ArrayList();
        openCells.add(0);
        openCells.add(1);
        openCells.add(2);
        openCells.add(3);
        openCells.add(4);
        openCells.add(5);
        openCells.add(6);
        openCells.add(7);
        openCells.add(8);
        openCells.add(10);
        openCells.add(11);
        openCells.add(13);
        openCells.add(14);
        openCells.add(15);

        return openCells;
    }

    private ArrayList<Integer> simulateOccupiedCellsArrayFor3x3Board() {
        ArrayList<Integer>occupiedCells = new ArrayList();
        occupiedCells.add(0);
        occupiedCells.add(1);

        return occupiedCells;
    }

    private ArrayList<Integer> simulateOccupiedCellsArrayFor4x4Board() {
        ArrayList<Integer>occupiedCells = new ArrayList();
        occupiedCells.add(9);
        occupiedCells.add(14);

        return occupiedCells;
    }

    private boolean getCell(String answer, String gamePiece) {
       if (boardTest.getCells()[convertAnswerToInteger(answer) - 1] == gamePiece) {
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

    @Test
    public void getLengthOf3x3Board() {
        boardTest = new Board(3);
        assertEquals(9, boardTest.getLength());
    }

    @Test
    public void getLengthOf4x4Board() {
        boardTest = new Board(4);
        assertEquals(16, boardTest.getLength());
    }

    @Test
    public void checkBoardSquareRootOf3x3() {
        boardTest = new Board(3);
        assertEquals(3, boardTest.getCellsSquareRoot(9));
    }

    @Test
    public void checkBoardSquareRootOf4x4() {
        boardTest = new Board(4);
        assertEquals(4, boardTest.getCellsSquareRoot(16));
    }

    @Test
    public void returnBoardCellsAsThreeByThreeArray() {
        boardTest = new Board(3);
        assertEquals("*", boardTest.getCells()[4]);
    }

    @Test
    public void returnBoardCellsAsFourByFourArray() {
        boardTest = new Board(4);
        assertEquals("*", boardTest.getCells()[15]);
    }

    @Test
    public void checkSpaceOfBoardCell3x3Array() {
        boardTest = new Board(3);
        fillBoard("4", "X");
        fillBoard("5", "O");
        assertEquals("X", boardTest.getCells()[3]);
        assertEquals("O", boardTest.getCells()[4]);
    }

    @Test
    public void checkSpaceOfBoardCell4x4Array() {
        boardTest = new Board(4);
        fillBoard("9", "X");
        fillBoard("16", "O");
        assertEquals("X", boardTest.getCells()[8]);
        assertEquals("O", boardTest.getCells()[15]);
    }

    @Test
    public void checkIfSevenIsValid() {
        boardTest = new Board(3);
        assertEquals(true, boardTest.isMoveValid("7"));
    }

    @Test
    public void checkIfVIsValid() {
        boardTest = new Board(3);
        assertEquals(false, boardTest.isMoveValid("v"));
    }

    @Test
    public void checkIfSymbolIsValid() {
        boardTest = new Board(3);
        assertEquals(false, boardTest.isMoveValid("-"));
    }

    @Test
    public void checkTakenSpaceOn3x3() {
        boardTest = new Board(3);
        fillBoard("1", "O");
        assertEquals(false, boardTest.isMoveValid("1"));
    }

    @Test
    public void checkTakenSpaceOn4x4() {
        boardTest = new Board(4);
        fillBoard("11", "O");
        assertEquals(false, boardTest.isMoveValid("11"));
    }

    @Test
    public void checkIfBoardHasOpenSpaces() {
        boardTest = new Board(3);
        assertEquals(true, boardTest.hasOpenSpaces());
    }

    @Test
    public void checkIfBoardCompletelyEmpty() {
        boardTest = new Board(3);
        assertEquals(true, boardTest.isEmpty());
    }

    @Test
    public void checkIfBoardFullWithMockInputs () {
        boardTest = new Board(3);
        simulateFilledBoard();
        assertEquals(false, boardTest.hasOpenSpaces());
    }

    @Test
    public void placeMoveOn3x3Board() {
        boardTest = new Board(3);
        fillBoard("9", player1.getGamePiece());
        assertEquals(true, getCell("9", player1.getGamePiece()));
    }

    @Test
    public void placeMoveOn4x4Board() {
        boardTest = new Board(4);
        fillBoard("16", player1.getGamePiece());
        assertEquals(true, getCell("16", player1.getGamePiece()));
    }

    @Test
    public void getEmptySpacesOn3x3Board() {
        boardTest = new Board(3);
        fillBoard("1", "X");
        fillBoard("3", "O");

        assertEquals(simulateOpenCellsArrayFor3x3Board(), boardTest.getOpenSpaces());
    }

    @Test
    public void getEmptySpacesOn4x4Board() {
        boardTest = new Board(4);
        fillBoard("10", "X");
        fillBoard("13", "O");

        assertEquals(simulateOpenCellsArrayFor4x4Board(), boardTest.getOpenSpaces());
    }

    @Test
    public void getOccupiedSpacesOn3x3Board() {
        boardTest = new Board(3);
        fillBoard("1", "X");
        fillBoard("2", "O");

        assertEquals(simulateOccupiedCellsArrayFor3x3Board(), boardTest.getOccupiedSpaces());
    }

    @Test
    public void getOccupiedSpacesOn4x4Board() {
        boardTest = new Board(4);
        fillBoard("15", "X");
        fillBoard("10", "O");

        assertEquals(simulateOccupiedCellsArrayFor4x4Board(), boardTest.getOccupiedSpaces());
    }

    @Test
    public void getOpponentGamePieceIfOpponentHasX() {
        boardTest = new Board(3);
        fillBoard("1", "X");
        fillBoard("2", "O");
        fillBoard("5", "X");
        fillBoard("7", "O");

        assertEquals("X", boardTest.getOpponentPiece("O"));
    }

    @Test
    public void getOpponentGamePieceIfOpponentHasMadeNoMoves() {
        boardTest = new Board(3);
        fillBoard("1", "X");

        assertEquals("", boardTest.getOpponentPiece("X"));
    }
}