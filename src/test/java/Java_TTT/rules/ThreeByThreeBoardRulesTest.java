package Java_TTT.rules;

import Java_TTT.boards.Board;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreeByThreeBoardRulesTest {
    private ThreeByThreeBoardRules threeByThreeRules;
    private FourByFourBoardRules fourByFourRules;
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
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "X", "X", "O", "O", "*", "*", "*", "*");

        assertEquals("X", threeByThreeRules.getWinnerInRows());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInSecondRow() {
        board = new Board(3);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "X", "*",
                        "O", "O", "O",
                        "*", "*", "X");

        assertEquals("O", threeByThreeRules.getWinnerInRows());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInThirdRow() {
        board = new Board(3);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "X", "*",
                        "O", "*", "*",
                        "X", "X", "X");

        assertEquals("X", threeByThreeRules.getWinnerInRows());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInFirstColumn() {
        board = new Board(3);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("X", "O", "*",
                        "X", "*", "*",
                        "X", "O", "*");

        assertEquals("X", threeByThreeRules.getWinnerInRows());
    }


    @Test
    public void threeByThreeBoardHasAWinnerInSecondColumn() {
        board = new Board(3);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("*", "O", "*",
                        "*", "O", "*",
                        "*", "O", "*");

        assertEquals("O", threeByThreeRules.getWinnerInRows());
    }

    @Test
    public void threeByThreeBoardHasAWinnerInThirdColumn() {
        board = new Board(3);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("*", "X", "X",
                        "O", "*", "X",
                        "*", "X", "X");

        assertEquals("X", threeByThreeRules.getWinnerInRows());
    }

    @Test
    public void fourByFourBoardHasAWinnerInFirstColumn() {
        board = new Board(4);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("O", "X", "X", "O",
                        "O", "*", "X", "X",
                        "O", "X", "*", "*",
                        "O", "*", "X", "X");

        assertEquals("O", threeByThreeRules.getWinnerInRows());
    }

    @Test
    public void fourByFourBoardHasAWinnerInSecondColumn() {
        board = new Board(4);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("*", "X", "X", "O",
                        "*", "X", "X", "X",
                        "O", "X", "*", "*",
                        "O", "X", "X", "X");

        assertEquals("X", threeByThreeRules.getWinnerInRows());
    }


    @Test
    public void fourByFourBoardHasAWinnerInThirdColumn() {
        board = new Board(4);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("*", "X", "O", "O",
                        "*", "*", "O", "X",
                        "O", "X", "O", "*",
                        "O", "X", "O", "X");

        assertEquals("O", threeByThreeRules.getWinnerInRows());
    }

    @Test
    public void fourByFourBoardHasAWinnerInFourthColumn() {
        board = new Board(4);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("*", "X", "O", "X",
                        "*", "*", "*", "X",
                        "O", "X", "*", "X",
                        "O", "X", "O", "X");

        assertEquals("X", threeByThreeRules.getWinnerInRows());
    }

    @Test
    public void returnsEmptyStringIfThereIsNoWinnerOn4x4Board() {
        board = new Board(4);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("*", "X", "O", "X",
                        "*", "*", "*", "X",
                        "*", "X", "*", "*",
                        "*", "X", "O", "X");

        assertEquals("", threeByThreeRules.getWinnerInRows());
    }

    @Test
    public void returnsEmptyStringIfThereIsNoWinnerOn3x3Board() {
        board = new Board(3);
        threeByThreeRules = new ThreeByThreeBoardRules(board);
        addMovesToBoard("*", "X", "X",
                        "O", "*", "*",
                        "*", "X", "X");

        assertEquals("", threeByThreeRules.getWinnerInRows());
    }

}
