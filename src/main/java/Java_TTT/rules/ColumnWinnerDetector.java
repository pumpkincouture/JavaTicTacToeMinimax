package Java_TTT.rules;

import Java_TTT.boards.Board;

public class ColumnWinnerDetector extends GameWinnerDetector {
    private Board board;
    private WinnerValidator winnerValidator;
    private String[][] lineValues;

    public ColumnWinnerDetector(Board board, WinnerValidator winnerValidator) {
        this.board = board;
        this.winnerValidator = winnerValidator;
        this.lineValues = new String[board.getMatrix().length][board.getMatrix().length];
    }

    @Override
    protected void addGamePiecesToList(int index) {
        int maxIndexValue = board.getMatrix().length - 1;
        for (int columnIndex = 0; columnIndex < board.getMatrix().length; columnIndex++) {
            lineValues[index][columnIndex] = winnerValidator.getValueAtIndex(board, index, maxIndexValue - columnIndex);
        }
    }

    @Override
    protected String checkIfWinnerExists() {
        return winnerValidator.checkRowsAndColumnsForWin(board, lineValues);
    }
}
