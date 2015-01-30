package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameScorerTest {
    private GameScorer gameScorerTest;
    private Board board;

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

    private void fillBoard(String choice, String gamePiece) {
        board.placeMove(choice, gamePiece);
    }

    @Before
    public void setUp() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
    }

    @Test
    public void checkBoardSquareRoot() {
        assertEquals(3, gameScorerTest.getBoardSquareRoot());
    }

    @Test
    public void checkEntireBoardForWinWithX() {
        simulateFilledBoard();

        assertEquals(true, gameScorerTest.isThereAWinner("X"));
        assertEquals("X", gameScorerTest.getWinningPlayer("O", "X"));

    }

    @Test
    public void checkEntireBoardForWinWithO() {
        simulateFilledBoard();

        assertEquals(false, gameScorerTest.isThereAWinner("O"));
    }

    @Test
    public void checkBoardForWinInScenarioTwo() {
        fillBoard("1", "X");
        fillBoard("5", "X");
        fillBoard("9", "X");

        assertEquals(true, gameScorerTest.isThereAWinner("X"));
        assertEquals("X", gameScorerTest.getWinningPlayer("O", "X"));
    }

    @Test
    public void checkBoardForWinScenarioThree() {
        fillBoard("3", "O");
        fillBoard("5", "O");
        fillBoard("7", "O");

        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkBoardForWinScenarioFour() {
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("5", "X");
        fillBoard("6", "");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");

        assertEquals(false, gameScorerTest.isThereAWinner("X"));
        assertEquals(false, gameScorerTest.isThereAWinner("O"));
        assertEquals("", gameScorerTest.getWinningPlayer("X", "O"));

    }

    @Test
    public void checkEmptyIshBoardForWin() {
        fillBoard("1", "X");

        assertEquals(false, gameScorerTest.isThereAWinner("O"));
    }

    @Test
    public void checkIfGameOver() {
        simulateFilledBoard();

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }
}