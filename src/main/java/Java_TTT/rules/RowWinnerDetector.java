package Java_TTT.rules;

import Java_TTT.boards.Board;

public class RowWinnerDetector extends GameWinnerDetector {
    private Board board;
    private WinnerValidator winnerValidator;

    public RowWinnerDetector(Board board, WinnerValidator winnerValidator) {
        this.board = board;
        this.winnerValidator = winnerValidator;
    }
    private String[][] lineValues;

    @Override
    protected void addGamePiecesToList(int index) {
        lineValues = new String[board.getMatrix().length][board.getMatrix().length];
        int maxIndexValue = board.getMatrix().length - 1;
        for (int rowIndex = 0; index < board.getMatrix().length; index++) {
            lineValues[rowIndex][index] = winnerValidator.getValueAtIndex(board, maxIndexValue - index, rowIndex);
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
