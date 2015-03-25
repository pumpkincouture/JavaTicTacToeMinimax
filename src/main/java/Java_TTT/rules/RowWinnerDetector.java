package Java_TTT.rules;

import Java_TTT.boards.Board;

public class RowWinnerDetector extends GameWinnerDetector {
    private Board board;
    private WinnerValidator winnerValidator;
    private String[][] lineValues;

    public RowWinnerDetector(Board board, WinnerValidator winnerValidator) {
        this.board = board;
        this.winnerValidator = winnerValidator;
        this.lineValues = new String[board.getMatrix().length][board.getMatrix().length];
    }

    @Override
    protected void addGamePiecesToList(int index) {
        int maxIndexValue = board.getMatrix().length - 1;
        for (int rowIndex = 0; rowIndex < board.getMatrix().length; rowIndex++) {
            lineValues[index][rowIndex] = winnerValidator.getValueAtIndex(board, maxIndexValue - rowIndex, index);
        }
    }

    @Override
    protected String checkIfWinnerExists() {
        return winnerValidator.checkRowsAndColumnsForWin(board, lineValues);
    }
}
