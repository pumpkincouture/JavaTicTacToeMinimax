package Java_TTT.rules;

import Java_TTT.boards.Board;

public class LeftDiagonalWinnerDetector extends GameWinnerDetector {
    private Board board;
    private WinnerValidator winnerValidator;

    public LeftDiagonalWinnerDetector(Board board, WinnerValidator winnerValidator) {
        this.board = board;
        this.winnerValidator = winnerValidator;
    }
    private String[] lineValues;

    @Override
    protected void addGamePiecesToList(int index) {
        lineValues = new String[board.getMatrix().length];
        lineValues[index] = winnerValidator.getValueAtIndex(board, index, index);
    }

    @Override
    protected String checkIfWinnerExists() {
        if (winnerValidator.isWinningCombo(board, lineValues)) {
            return lineValues[0];
        }
        return "";
    }
}
