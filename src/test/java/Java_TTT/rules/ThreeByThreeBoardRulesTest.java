package Java_TTT.rules;

import Java_TTT.boards.TTTBoard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreeByThreeBoardRulesTest {
    private TTTBoardRules boardRules;
    private TTTBoard board;

    private void simulateFilled3x3Board() {
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

    @Test
    public void threeByThreeBoardHasAWinner() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        simulateFilled3x3Board();

        assertEquals(true, boardRules.isThereAWinner("X"));
        assertEquals("X", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void threeByThreeBoardHasWinnerO() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        simulateFilled3x3Board();

        assertEquals(false, boardRules.isThereAWinner("O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioTwo() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        fillBoard("1", "X");
        fillBoard("5", "X");
        fillBoard("9", "X");

        assertEquals(true, boardRules.isThereAWinner("X"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioThree() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        fillBoard("3", "O");
        fillBoard("5", "O");
        fillBoard("7", "O");

        assertEquals(true, boardRules.isThereAWinner("O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioFour() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        fillBoard("1", "O");
        fillBoard("2", "O");
        fillBoard("3", "O");

        assertEquals(true, boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioFive() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        fillBoard("2", "O");
        fillBoard("5", "O");
        fillBoard("8", "O");

        assertEquals(true, boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioSix() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        fillBoard("3", "O");
        fillBoard("6", "O");
        fillBoard("9", "O");

        assertEquals(true, boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioSeven() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        fillBoard("4", "O");
        fillBoard("5", "O");
        fillBoard("6", "O");

        assertEquals(true, boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }


    @Test
    public void checkThreeByThreeBoardForWinScenarioEight() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        fillBoard("7", "O");
        fillBoard("8", "O");
        fillBoard("9", "O");

        assertEquals(true, boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkThreeByThreeBoardForCatsGameScenarioFour() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("5", "X");
        fillBoard("6", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");

        assertEquals(false, boardRules.isThereAWinner("X"));
        assertEquals(false, boardRules.isThereAWinner("O"));
    }


    @Test
    public void checkIfGameOverOn3x3Board() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        simulateFilled3x3Board();

        assertEquals(true, boardRules.isGameOver("X", "O"));
    }

    @Test
    public void check3x3BoardForWin() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        fillBoard("1", "X");
        assertEquals(false, boardRules.isThereAWinner("O"));
    }
}
