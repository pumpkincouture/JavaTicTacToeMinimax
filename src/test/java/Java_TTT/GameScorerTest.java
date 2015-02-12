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
    public void checkEntire4x4BoardForWinWithX() {
        board = new Board(4);
        gameScorerTest = new GameScorer(board);
        simulateFilled4x4Board();

        System.out.println(gameScorerTest.getFirstRowOfBoard());
        System.out.println(gameScorerTest.getSecondRowOfBoard());
        System.out.println(gameScorerTest.getThirdRowOfBoard());
        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("O", "X"));
    }

    @Test
    public void checkEntireBoardForWinWithO() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        simulateFilled3x3Board();

        assertEquals(false, gameScorerTest.isThereAWinner("O"));
    }

    @Test
    public void checkBoardForWinInScenarioTwo() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("1", "X");
        fillBoard("5", "X");
        fillBoard("9", "X");

        assertEquals(true, gameScorerTest.isThereAWinner("X"));
        assertEquals("X", gameScorerTest.getWinningPlayer("O", "X"));
    }

    @Test
    public void checkBoardForWinScenarioThree() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("3", "O");
        fillBoard("5", "O");
        fillBoard("7", "O");

        assertEquals(true, gameScorerTest.isThereAWinner("O"));
        assertEquals("O", gameScorerTest.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkBoardForWinScenarioFour() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
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
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        fillBoard("1", "X");

        assertEquals(false, gameScorerTest.isThereAWinner("O"));
    }

    @Test
    public void checkIfGameOver() {
        board = new Board(3);
        gameScorerTest = new GameScorer(board);
        simulateFilled3x3Board();

        assertEquals(true, gameScorerTest.isGameOver("X", "O"));
    }
}