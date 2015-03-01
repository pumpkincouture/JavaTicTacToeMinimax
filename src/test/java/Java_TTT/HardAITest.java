package Java_TTT;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HardAITest {
    private HardAI aiComputerTest;
    private Board board;

    private void fillBoard(String choice, String gamePiece) {
        board.placeMove(choice, gamePiece);
    }

    @Test
    public void returnsBlockIfCompCannotWinInNextMove() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("4", "O");
        fillBoard("5", "O");
        fillBoard("6", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");

        assertEquals("3", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinForItselfRatherThanBlockingOpponentFromWinning() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("3", "O");
        fillBoard("5", "O");
        fillBoard("6", "O");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "X");

        assertEquals("2", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinForItself() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("6", "X");
        fillBoard("7", "O");
        fillBoard("9", "X");

        assertEquals("5", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinningMoveIfFiveSpacesLeft() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("2", "O");
        fillBoard("4", "X");
        fillBoard("5", "O");

        assertEquals("8", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinningMoveAndBlocksOpponent() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "O");
        fillBoard("3", "X");
        fillBoard("4", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");

        assertEquals("5", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinningSpotWhenThereAreSixSpotsOnTheBoard() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "O");
        fillBoard("3", "O");
        fillBoard("5", "X");

        assertEquals("2", aiComputerTest.getMove());
    }

    @Test
    public void returnsBestMoveAfterOpponentPlacesFirstMove() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");

        assertEquals("5", aiComputerTest.getMove());
    }

    @Test
    public void returnsBlockingMove() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("7", "O");
        fillBoard("5", "X");

        assertEquals("9", aiComputerTest.getMove());
    }

    @Test
    public void returnsBlockForOpponent() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("9", "X");
        fillBoard("1", "O");
        fillBoard("8", "X");

        assertEquals("7", aiComputerTest.getMove());
    }

    @Test
    public void picksASpaceIfBoardEmpty() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);

        assertEquals("1", aiComputerTest.getMove());
    }

    @Test
    public void AIWinsIfBoardHasThreeInARow() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "O");
        fillBoard("2", "O");
        fillBoard("3", "O");
        fillBoard("4", "X");

        assertEquals(10, aiComputerTest.getScores(board, 0));
    }

    @Test
    public void testForCatsGame() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);

        assertEquals(0, aiComputerTest.getScores(board, 0));
    }


    @Test
    public void XWinsIfBoardHasThreeInARow() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "X");
        fillBoard("4", "O");

        assertEquals(-10, aiComputerTest.getScores(board, 0));
    }

    @Test
    public void XWinsIfBoardHas4InARow() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "X");
        fillBoard("4", "X");

        assertEquals(-10, aiComputerTest.getScores(board, 0));
    }

    @Test
    public void OWinsIfBoardHas4InARow() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);
        fillBoard("2", "O");
        fillBoard("6", "O");
        fillBoard("10", "O");
        fillBoard("14", "O");

        assertEquals(10, aiComputerTest.getScores(board, 0));
    }

    @Test
    public void picksFirstMoveOn4x4Board() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);

        assertEquals("1", aiComputerTest.getMove());
    }

    @Test
    public void picksThirdMoveOn4x4Board() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("2", "O");
        fillBoard("5", "X");
        fillBoard("3", "O");
        fillBoard("9", "X");

        assertEquals("13", aiComputerTest.getMove());
    }

    @Test
    public void getsMoveToBlockOn4x4Board() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("5", "O");
        fillBoard("3", "X");

        assertEquals("4", aiComputerTest.getMove());
    }

    @Test
    public void picksWinningMoveOn4x4Board() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("6", "X");
        fillBoard("11", "O");

        fillBoard("3", "X");
        fillBoard("4", "O");
        fillBoard("8", "O");
        fillBoard("7", "X");
        fillBoard("5", "X");
        fillBoard("12", "O");
        fillBoard("9", "X");

        assertEquals("16", aiComputerTest.getMove());
    }

    @Test
    public void makesMoveToWinInNextMoveOn4x4Board() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "X");

        fillBoard("5", "O");
        fillBoard("6", "O");
        fillBoard("7", "O");

        assertEquals("8", aiComputerTest.getMove());
    }


    @Test
    public void blocksOpponentWinOn4x4Board() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "X");
        fillBoard("4", "O");

        fillBoard("5", "X");
        fillBoard("7", "X");
        fillBoard("8", "X");

        assertEquals("6", aiComputerTest.getMove());
    }

    @Test
    public void makesMoveOn4x4BoardToWin() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("3", "O");
        fillBoard("7", "O");
        fillBoard("9", "X");
        fillBoard("13", "X");
        fillBoard("15", "O");

        assertEquals("11", aiComputerTest.getMove());
    }

    @Test
    public void returnsWinForItselfOn4x4Board() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);

        fillBoard("1", "O");
        fillBoard("2", "O");
        fillBoard("6", "O");
        fillBoard("10","O");
        fillBoard("16", "X");

        assertEquals("14", aiComputerTest.getMove());
    }

    @Test
    public void picksMoveAgainstOpponentOn4x4Board() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);

        fillBoard("3", "X");
        fillBoard("4", "O");
        fillBoard("7", "X");
        fillBoard("1", "O");
        fillBoard("11","X");

        assertEquals("15", aiComputerTest.getMove());
    }

    @Test
    public void benchmarkTestForDepth6On4x4BoardGetsCorrectMoveScenarioOne() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);

        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("5", "O");
        fillBoard("3", "X");

        long start = System.currentTimeMillis();
        aiComputerTest.makeCalculation(board, 0, "O", Integer.MIN_VALUE, Integer.MAX_VALUE, 6);
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(elapsedTime + ": elapsed time for computer on 4x4 to get correct move, stopping at depth 6.");

        assertEquals(3, aiComputerTest.getChoice());
    }

    @Test
    public void benchmarkTestForDepth6On4x4BoardGetsCorrectMoveScenarioTwo() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);

        fillBoard("3", "X");
        fillBoard("4", "O");
        fillBoard("7", "X");
        fillBoard("1", "O");
        fillBoard("11","X");

        long start = System.currentTimeMillis();
        aiComputerTest.makeCalculation(board, 0, "O", Integer.MIN_VALUE, Integer.MAX_VALUE, 6);
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(elapsedTime + ": elapsed time for computer on 4x4 to get correct move, stopping at depth 6.");

        assertEquals(14, aiComputerTest.getChoice());
    }

    @Test
    public void benchmarkTestForDepth6On3x3BoardReturnsCorrectMove() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");
        fillBoard("7", "O");
        fillBoard("5", "X");

        long start = System.currentTimeMillis();
        aiComputerTest.makeCalculation(board, 0, "O", Integer.MIN_VALUE, Integer.MAX_VALUE, 6);
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(elapsedTime + ": elapsed time for computer on 3x3 to get move, stopping at depth 6.");

        assertEquals(8, aiComputerTest.getChoice());
    }

    @Test
    public void benchmarkTestForDepth6On3x3BoardReturnsMiddleSpace() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");

        long start = System.currentTimeMillis();
        aiComputerTest.makeCalculation(board, 0, "O", Integer.MIN_VALUE, Integer.MAX_VALUE, 6);
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(elapsedTime + ": elapsed time for computer on 3x3 to get move, stopping at depth 6.");

        assertEquals(4, aiComputerTest.getChoice());
    }

    @Test
    public void benchmarkTestForDepth5On4x4Board() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);

        fillBoard("3", "X");
        fillBoard("4", "O");
        fillBoard("7", "X");
        fillBoard("1", "O");
        fillBoard("11","X");

        long start = System.currentTimeMillis();
        aiComputerTest.makeCalculation(board, 0, "O", Integer.MIN_VALUE, Integer.MAX_VALUE, 5);
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(elapsedTime + ": elapsed time for computer on 4x4 to get correct move, stopping at depth 5.");

        assertEquals(14, aiComputerTest.getChoice());
    }

    @Test
    public void benchmarkTestForDepth5On3x3BoardDoesNotReturnMiddleSpace() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");

        long start = System.currentTimeMillis();
        aiComputerTest.makeCalculation(board, 0, "O", Integer.MIN_VALUE, Integer.MAX_VALUE, 5);
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(elapsedTime + ": elapsed time for computer on 3x3 to get move, stopping at depth 5.");

        assertNotEquals(4, aiComputerTest.getChoice());
    }

    @Test
    public void benchmarkTestForDepth4On4x4BoardGetsCorrectMove() {
        board = new Board(4);
        aiComputerTest = new HardAI("O", board);

        fillBoard("3", "X");
        fillBoard("4", "O");
        fillBoard("7", "X");
        fillBoard("1", "O");
        fillBoard("11","X");

        long start = System.currentTimeMillis();
        aiComputerTest.makeCalculation(board, 0, "O", Integer.MIN_VALUE, Integer.MAX_VALUE, 4);
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(elapsedTime + ": elapsed time for computer on 4x4 to get correct move, stopping at depth 4.");

        assertEquals(14, aiComputerTest.getChoice());
    }

    @Test
    public void benchmarkTestForDepth4On3x3BoardDoesNotReturnMiddleSpace() {
        board = new Board(3);
        aiComputerTest = new HardAI("O", board);
        fillBoard("1", "X");

        long start = System.currentTimeMillis();
        aiComputerTest.makeCalculation(board, 0, "O", Integer.MIN_VALUE, Integer.MAX_VALUE, 4);
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(elapsedTime + ": elapsed time for computer on 3x3 to get move, stopping at depth 4.");

        assertNotEquals(4, aiComputerTest.getChoice());
    }
}
