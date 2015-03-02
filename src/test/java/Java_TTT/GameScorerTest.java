package Java_TTT;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameScorerTest {
    private GameScorer gameScorerTest;
    private Board board;

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
    public void checkEntire3x3BoardForWinWithX() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        simulateFilled3x3Board();

        assertEquals(true, gameScorerTest.isThereAWinner("X"));
        assertEquals("X", gameScorerTest.getWinningPlayer("O", "X"));

    }

    @Test
    public void checkEntire4x4BoardForWinWithO() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        simulateFilled4x4Board();

        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("O", "X"));
    }

    @Test
    public void checkEntire3x3BoardForWinWithO() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        simulateFilled3x3Board();

        assertEquals(false, gameScorerTest.isThereAWinner("O"));
    }

    @Test
    public void checkEntire4x4BoardForWinWithX() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        simulateFilled3x3Board();

        assertEquals(false, gameScorerTest.isThereAWinner("X"));
    }

    @Test
    public void check3x3BoardForWinInScenarioTwo() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("1", "X");
        fillBoard("5", "X");
        fillBoard("9", "X");

        assertEquals(true, gameScorerTest.isThereAWinner("X"));
        assertEquals("X", gameScorerTest.getWinningPlayer("O", "X"));
    }

    @Test
    public void check4x4BoardForWinInScenarioTwo() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("3", "X");
        fillBoard("7", "X");
        fillBoard("11", "X");
        fillBoard("15", "X");


        assertEquals(true, gameScorerTest.isThereAWinner("X"));
        assertEquals("X", gameScorerTest.getWinningPlayer("O", "X"));
    }

    @Test
    public void check3x3BoardForWinScenarioThree() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("3", "O");
        fillBoard("5", "O");
        fillBoard("7", "O");

        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("X", "O"));
    }

    @Test
    public void check3x3BoardForWinScenarioFour() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("1", "O");
        fillBoard("2", "O");
        fillBoard("3", "O");

        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("X", "O"));
    }

    @Test
    public void check3x3BoardForWinScenarioFive() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("2", "O");
        fillBoard("5", "O");
        fillBoard("8", "O");

        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("X", "O"));
    }

    @Test
    public void check3x3BoardForWinScenarioSix() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("3", "O");
        fillBoard("6", "O");
        fillBoard("9", "O");

        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("X", "O"));
    }

    @Test
    public void check3x3BoardForWinScenarioSeven() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("4", "O");
        fillBoard("5", "O");
        fillBoard("6", "O");

        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("X", "O"));
    }


    @Test
    public void check3x3BoardForWinScenarioEight() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("7", "O");
        fillBoard("8", "O");
        fillBoard("9", "O");

        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("X", "O"));
    }

    @Test
    public void check4x4BoardForWinScenarioThree() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("4", "O");
        fillBoard("7", "O");
        fillBoard("10", "O");
        fillBoard("13", "O");


        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("X", "O"));
    }

    @Test
    public void check3x3BoardForCatsGameScenarioFour() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("5", "X");
        fillBoard("6", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");

        assertEquals(false, gameScorerTest.isThereAWinner("X"));
        assertEquals(false, gameScorerTest.isThereAWinner("O"));
    }

    @Test
    public void check4x4BoardForCatsGameScenarioFour() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
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

        assertEquals(false, gameScorerTest.isThereAWinner("X"));
        assertEquals(false, gameScorerTest.isThereAWinner("O"));
    }

    @Test
    public void check3x3BoardForWin() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("1", "X");
        assertEquals(false, gameScorerTest.isThereAWinner("O"));
    }

    @Test
    public void check4x4BoardForWin() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("15", "X");
        assertEquals(false, gameScorerTest.isThereAWinner("O"));
    }

    @Test
    public void checkIfGameOverOn3x3Board() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        simulateFilled3x3Board();

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInRowOneOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("1", "O");
        fillBoard("2", "O");
        fillBoard("3", "O");
        fillBoard("4", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInRowTwoOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("5", "O");
        fillBoard("6", "O");
        fillBoard("7", "O");
        fillBoard("8", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInRowThreeOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("9", "O");
        fillBoard("10", "O");
        fillBoard("11", "O");
        fillBoard("12", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInRowFourOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("13", "O");
        fillBoard("14", "O");
        fillBoard("15", "O");
        fillBoard("16", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInColumnOneOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("1", "O");
        fillBoard("5", "O");
        fillBoard("9", "O");
        fillBoard("13", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInColumnTwoOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("2", "O");
        fillBoard("6", "O");
        fillBoard("10", "O");
        fillBoard("14", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInColumnThreeOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("3", "O");
        fillBoard("7", "O");
        fillBoard("11", "O");
        fillBoard("15", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInColumnFourOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("4", "O");
        fillBoard("8", "O");
        fillBoard("12", "O");
        fillBoard("16", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInDiagonalOneOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("1", "O");
        fillBoard("6", "O");
        fillBoard("11", "O");
        fillBoard("16", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfOWonInDiagonalTwoOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        fillBoard("4", "O");
        fillBoard("7", "O");
        fillBoard("10", "O");
        fillBoard("13", "O");

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }

    @Test
    public void checkIfGameOverOn4x4Board() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        simulateFilled4x4Board();

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }
}