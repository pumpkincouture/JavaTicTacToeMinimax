package Java_TTT.rules;

import Java_TTT.boards.Board;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameRulesTest {
    private GameRules threeByThreeRules;
    private Board board;

    private void addMovesToBoard(String... positions) {
        for (int counter = 0; counter < board.getLength(); counter++) {
            if (positions[counter] != "*") {
                board.placeMove(String.valueOf(counter + 1), positions[counter]);
            }
        }
    }

    @Test
    public void threeByThreeBoardHasGameOver() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "O", "X",
                        "O", "O", "X",
                        "O", "X", "O");

        assertTrue(threeByThreeRules.isGameOver());
    }

    @Test
    public void threeByThreeBoardDoesNotHaveGameOver() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "O", "X",
                        "O", "O", "X",
                        "*", "X", "O");

        assertFalse(threeByThreeRules.isGameOver());
    }

    @Test
    public void threeByThreeBoardIsNotInGameOverState() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "*", "O",
                        "*", "O", "O",
                        "X", "O", "X");

        assertFalse(threeByThreeRules.isGameOver());
    }

    @Test
    public void threeByThreeBoardHasAWinnerAndHasGameOver() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "O", "X",
                        "O", "X", "X",
                        "X", "X", "*");

        assertTrue(threeByThreeRules.isGameOver());
    }

    @Test
    public void getOpponentPieceIfPlayerIsX() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "O", "X",
                        "O", "X", "X",
                        "X", "X", "*");

        assertEquals("O", threeByThreeRules.getOpponentPiece("X"));
    }

    @Test
    public void getOpponentPieceIfPlayerIsO() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "O", "X",
                        "O", "X", "X",
                        "X", "X", "*");

        assertEquals("X", threeByThreeRules.getOpponentPiece("O"));
    }

    @Test
    public void threeByThreeBoardHasAWinnerInFirstRow() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "X", "X",
                        "O", "O", "*",
                        "*", "*", "*");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInSecondRow() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "X", "*",
                        "O", "O", "O",
                        "*", "*", "X");

        assertEquals("O", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInThirdRow() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "X", "*",
                        "O", "*", "*",
                        "X", "X", "X");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void fourByFourBoardHasAWinnerInFirstRow() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("O", "O", "O", "O",
                        "*", "*", "X", "X",
                        "*", "X", "*", "*",
                        "O", "*", "X", "X");

        assertEquals("O", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void fourByFourBoardHasAWinnerInSecondRow() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("O", "*", "*", "O",
                        "X", "X", "X", "X",
                        "*", "X", "*", "*",
                        "O", "*", "X", "X");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void fourByFourBoardHasAWinnerInThirdRow() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("O", "*", "*", "O",
                        "*", "*", "*", "*",
                        "O", "O", "O", "O",
                        "O", "*", "X", "X");

        assertEquals("O", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void fourByFourBoardHasAWinnerInFourthRow() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("O", "*", "*", "O",
                        "*", "*", "*", "*",
                        "*", "O", "O", "O",
                        "X", "X", "X", "X");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInFirstColumn() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "O", "*",
                        "X", "*", "*",
                        "X", "O", "*");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInSecondColumn() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("*", "O", "*",
                        "*", "O", "*",
                        "*", "O", "*");

        assertEquals("O", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInThirdColumn() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("*", "X", "X",
                        "O", "*", "X",
                        "*", "X", "X");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void fourByFourBoardHasAWinnerInFirstColumn() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("O", "X", "X", "O",
                        "O", "*", "X", "X",
                        "O", "X", "*", "*",
                        "O", "*", "X", "X");

        assertEquals("O", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void fourByFourBoardHasAWinnerInSecondColumn() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("*", "X", "X", "O",
                        "*", "X", "X", "X",
                        "O", "X", "*", "*",
                        "O", "X", "X", "X");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }


    @Test
    public void fourByFourBoardHasAWinnerInThirdColumn() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("*", "X", "O", "O",
                        "*", "*", "O", "X",
                        "O", "X", "O", "*",
                        "O", "X", "O", "X");

        assertEquals("O", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void fourByFourBoardHasAWinnerInFourthColumn() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("*", "X", "O", "X",
                        "*", "*", "*", "X",
                        "O", "X", "*", "X",
                        "O", "X", "O", "X");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void returnsEmptyStringIfThereIsNoWinnerOn4x4Board() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("*", "X", "O", "X",
                        "*", "*", "*", "X",
                        "*", "X", "*", "*",
                        "*", "X", "O", "X");

        assertEquals("", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void returnsEmptyStringIfThereIsNoWinnerOn3x3Board() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("*", "X", "X",
                        "O", "*", "*",
                        "*", "X", "X");

        assertEquals("", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void returnsEmptyStringIfNoWinnerOn3x3Board() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "O", "O",
                        "*", "O", "*",
                        "X", "*", "*");

        assertEquals("", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void threeByThreeBoardShouldHaveATie() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "X", "O",
                        "O", "X", "X",
                        "X", "O", "O");

        assertEquals("", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInFirstDiagonal() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("X", "*", "O",
                        "O", "X", "*",
                        "*", "*", "X");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInSecondDiagonal() {
        board = new Board(3);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("O", "*", "X",
                        "*", "X", "*",
                        "X", "*", "O");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void fourByFourHasWinnerInFirstDiagonal() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("O", "X", "O", "X",
                        "*", "O", "*", "X",
                        "*", "X", "O", "*",
                        "*", "X", "O", "O");

        assertEquals("O", threeByThreeRules.getBoardWinner());
    }

    @Test
    public void fourByFourHasWinnerInSecondDiagonal() {
        board = new Board(4);
        threeByThreeRules = new GameRules(board);
        addMovesToBoard("O", "X", "O", "X",
                        "*", "*", "X", "X",
                        "*", "X", "O", "*",
                        "X", "X", "O", "O");

        assertEquals("X", threeByThreeRules.getBoardWinner());
    }
}
