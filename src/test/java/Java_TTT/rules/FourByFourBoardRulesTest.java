package Java_TTT.rules;
import Java_TTT.boards.Board;
import Java_TTT.rules.TTTBoardRules;
import Java_TTT.rules.FourByFourBoardRules;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FourByFourBoardRulesTest {
    private TTTBoardRules boardRules;
    private Board board;

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
        fillBoard("6", "O");
        fillBoard("5", "O");
        fillBoard("4", "X");
        fillBoard("3", "X");
        fillBoard("2", "X");
        fillBoard("1", "O");
    }

    private void fillBoard(String choice, String gamePiece) {
        board.placeMove(choice, gamePiece);
    }

    @Test
    public void checkEntire4x4BoardForWinWithO() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        simulateFilled4x4Board();

        assertEquals(true, boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkEntire4x4BoardForWinWithX() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        simulateFilled4x4Board();

        assertEquals(false, boardRules.isThereAWinner("X"));
    }

    @Test
    public void check4x4BoardForWinInScenarioTwo() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("3", "X");
        fillBoard("7", "X");
        fillBoard("11", "X");
        fillBoard("15", "X");

        assertEquals(true, boardRules.isThereAWinner("X"));
        assertEquals("X", boardRules.getWinningPlayer("O", "X"));
    }

    @Test
    public void check4x4BoardForWinScenarioThree() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("4", "O");
        fillBoard("7", "O");
        fillBoard("10", "O");
        fillBoard("13", "O");


        assertEquals(true, boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void check4x4BoardForCatsGameScenarioFour() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("5", "X");
        fillBoard("6", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");
        fillBoard("10", "O");
        fillBoard("11", "X");
        fillBoard("12", "X");
        fillBoard("13", "X");
        fillBoard("14", "O");
        fillBoard("15", "O");
        fillBoard("16", "O");

        assertEquals(false, boardRules.isThereAWinner("X"));
        assertEquals(false, boardRules.isThereAWinner("O"));
    }

    @Test
    public void checkIfOWonInDiagonalTwoOn4x4Board() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("4", "O");
        fillBoard("7", "O");
        fillBoard("10", "O");
        fillBoard("13", "O");

        assertEquals(true, boardRules.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInColumnTwoOn4x4Board() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("2", "O");
        fillBoard("6", "O");
        fillBoard("10", "O");
        fillBoard("14", "O");

        assertEquals(true, boardRules.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInColumnThreeOn4x4Board() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("3", "O");
        fillBoard("7", "O");
        fillBoard("11", "O");
        fillBoard("15", "O");

        assertEquals(true, boardRules.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInColumnFourOn4x4Board() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("4", "O");
        fillBoard("8", "O");
        fillBoard("12", "O");
        fillBoard("16", "O");

        assertEquals(true, boardRules.isGameOver("X", "O"));
    }

    @Test
    public void checkIfGameOverOn4x4Board() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        simulateFilled4x4Board();

        assertEquals(true, boardRules.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInRowThreeOn4x4Board() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("9", "O");
        fillBoard("10", "O");
        fillBoard("11", "O");
        fillBoard("12", "O");

        assertEquals(true, boardRules.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInRowFourOn4x4Board() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("13", "O");
        fillBoard("14", "O");
        fillBoard("15", "O");
        fillBoard("16", "O");

        assertEquals(true, boardRules.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInColumnOneOn4x4Board() {
        board = new Board(4);
        boardRules = new FourByFourBoardRules(board);
        fillBoard("1", "O");
        fillBoard("5", "O");
        fillBoard("9", "O");
        fillBoard("13", "O");

        assertEquals(true, boardRules.isGameOver("X", "O"));
    }
}

