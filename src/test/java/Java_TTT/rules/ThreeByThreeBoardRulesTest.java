package Java_TTT.rules;

import Java_TTT.boards.Board;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreeByThreeBoardRulesTest {
    private ThreeByThreeBoardRules boardRules;
    private Board board;

    private void addMovesToBoard(String... positions) {
        for (int counter = 0; counter < board.getLength(); counter++) {
            if (positions[counter] != "*") {
                board.placeMove(String.valueOf(counter + 1), positions[counter]);
            }
        }
    }

    @Test
    public void threeByThreeBoardHasAWinnerInFirstRow() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "X", "X",
                        "O", "O", "*",
                        "*", "*", "*");

        assertEquals(3, boardRules.getWinnerInRows("X"));
        assertEquals("X", boardRules.checkForRowWinner("X", "O"));
    }

    @Test
    public void threeByThreeBoardHasAWinnerInSecondRow() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "X", "*",
                        "O", "O", "O",
                        "*", "*", "X");

        assertEquals(3, boardRules.getWinnerInRows("O"));
        assertEquals(2, boardRules.getWinnerInRows("X"));
//        assertEquals("O", boardRules.checkForRowWinner("X", "O"));
    }

    @Test
    public void threeByThreeBoardHasAWinnerInThirdRow() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "X", "*",
                        "O", "*", "*",
                        "X", "X", "X");

        assertEquals("X", boardRules.checkForRowWinner("X", "O"));
    }

    @Test
    public void threeByThreeBoardHasWinnerO() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "*", "O",
                        "*", "*", "*",
                        "*", "*", "*");

        assertFalse(boardRules.isThereAWinner("O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioTwo() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "*", "O", "*", "X", "*", "*", "*", "X");

        assertTrue(boardRules.isThereAWinner("X"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioThree() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "*", "O", "*", "O", "*", "O", "*", "*");

        assertTrue(boardRules.isThereAWinner("O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioFour() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("O", "O", "O",
                        "*", "*", "*",
                        "*", "*", "*");

        assertTrue(boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioFive() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "O", "*",
                        "*", "O", "*",
                        "*", "O", "*");

        assertTrue(boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioSix() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "*", "O", "*", "*", "O", "*", "*", "O");

        assertTrue(boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkThreeByThreeBoardForWinScenarioSeven() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "*", "X", "O", "O", "O", "*", "*", "*");

        assertTrue(boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }


    @Test
    public void checkThreeByThreeBoardForWinScenarioEight() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "*", "O", "*", "*", "*", "O", "O", "O");

        assertTrue(boardRules.isThereAWinner("O"));
        assertEquals("O", boardRules.getWinningPlayer("X", "O"));
    }

    @Test
    public void checkThreeByThreeBoardForCatsGameScenarioFour() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "O", "O",
                        "O", "X", "X",
                        "X", "O", "O");

        assertFalse(boardRules.isThereAWinner("X"));
        assertEquals(false, boardRules.isThereAWinner("O"));
    }

    @Test
    public void getOpponentGamePieceIfOpponentHasX() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "O", "O", "*", "X", "*", "O", "*", "*");

        assertEquals("X", boardRules.getOpponentPiece("O"));
    }

    @Test
    public void getOpponentGamePieceIfOpponentHasMadeNoMoves() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "*", "*", "*", "*", "*", "*", "*", "*");

        assertEquals("", boardRules.getOpponentPiece("X"));
    }

    @Test
    public void checkIfGameOverOn3x3Board() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "O", "O",
                        "O", "X", "X",
                        "X", "O", "O");

        assertTrue(boardRules.isGameOver("X", "O"));
    }

    @Test
    public void check3x3BoardForWin() {
        board = new Board(3);
        boardRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "O", "O", "O", "X", "X", "X", "O", "O");
        assertFalse(boardRules.isThereAWinner("O"));
    }
}
