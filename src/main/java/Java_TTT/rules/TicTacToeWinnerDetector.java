package Java_TTT.rules;

import Java_TTT.boards.Board;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeWinnerDetector extends GameWinnerDetector {
    private Board board;
    private int maxIndexValue;

    public TicTacToeWinnerDetector(Board board) {
        this.board = board;
        this.maxIndexValue = board.getMatrix().length - 1;
    }

    @Override
    List<String> findBoardWinner() {
        List<String> valuesAfterCheckingForWin = new ArrayList<>();

        valuesAfterCheckingForWin.add(checkColumns());
        valuesAfterCheckingForWin.add(checkRows());
        valuesAfterCheckingForWin.add(checkRightDiagonal());
        valuesAfterCheckingForWin.add(checkLeftDiagonal());

        return valuesAfterCheckingForWin;
    }


    private String checkColumns() {
        String[][] lineValues = new String[board.getMatrix().length][board.getMatrix().length];
        findRowAndColumnValuesOnBoard(lineValues, false);
        return checkRowsAndColumnsForWinningCombo(lineValues);
    }

    private String checkRows() {
        String[][] lineValues = new String[board.getMatrix().length][board.getMatrix().length];
        findRowAndColumnValuesOnBoard(lineValues, true);
        return checkRowsAndColumnsForWinningCombo(lineValues);
    }

    private String checkRightDiagonal() {
        String[] lineValues = new String[board.getMatrix().length];
        findDiagonalValuesOnBoard(lineValues, true);
        return checkDiagonalsForWinningCombo(lineValues);
    }

    private String checkLeftDiagonal() {
        String[] lineValues = new String[board.getMatrix().length];
        findDiagonalValuesOnBoard(lineValues, false);
        return checkDiagonalsForWinningCombo(lineValues);
    }


    private String checkRowsAndColumnsForWinningCombo(String[][] lineValues) {
        for (int i = 0; i < board.getMatrix().length; i++) {
            if (isWinningCombo(lineValues[i])) {
                return lineValues[i][0];
            }
        } return "";
    }

    private void findRowAndColumnValuesOnBoard(String[][] lineValues, boolean row) {
        for (int rowIndex = 0; rowIndex < board.getMatrix().length; rowIndex++) {
            for (int index = 0; index < board.getMatrix().length; index++) {
                if (row) {
                    lineValues[rowIndex][index] = getValueAtIndex(maxIndexValue - index, rowIndex);
                } else {
                    lineValues[rowIndex][index] = getValueAtIndex(rowIndex, maxIndexValue - index);
                }
            }
        }
    }

    private void findDiagonalValuesOnBoard(String[] lineValues, boolean rightDiagonal) {
        for (int index = 0; index < board.getMatrix().length; index++) {
            if (rightDiagonal) {
                lineValues[index] = getValueAtIndex(index, maxIndexValue - index);
            } else {
                lineValues[index] = getValueAtIndex(index, index);
            }
        }
    }

    private String checkDiagonalsForWinningCombo(String[] lineValues) {
        if (isWinningCombo(lineValues)) {
            return lineValues[0];
        }
        return "";
    }

    private String getValueAtIndex(int startingIndex, int endingIndex) {
        return board.getMatrix()[startingIndex][endingIndex];
    }

    private boolean isWinningCombo(String[] lineValues) {
        String first = lineValues[0];
        for (String value : lineValues) {
            if (value != first || value == board.getBoardEmptySpace()) {
                return false;
            }
        }
        return true;
    }
}