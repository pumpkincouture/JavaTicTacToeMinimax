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
        for (int rowIndex = 0; index < board.getMatrix().length; index++) {
            lineValues[index][rowIndex] = winnerValidator.getValueAtIndex(board, rowIndex, maxIndexValue - index);
        }
    }

    @Override
    protected String checkIfWinnerExists() {
        for (int i = 0; i < board.getMatrix().length; i++) {
            if (winnerValidator.isWinningCombo(board, lineValues[i])) {
                return lineValues[i][0];
            }
        } return "";
    }
}
