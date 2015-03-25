package Java_TTT.rules;

import Java_TTT.boards.Board;

public class RightDiagonalWinnerDetector extends GameWinnerDetector {
    private Board board;
    private WinnerValidator winnerValidator;
    private String[] lineValues;

    public RightDiagonalWinnerDetector(Board board, WinnerValidator winnerValidator) {
        this.board = board;
        this.winnerValidator = winnerValidator;
        this.lineValues = new String[board.getMatrix().length];
    }

    @Override
    protected void addGamePiecesToList(int index) {
        int maxIndexValue = board.getMatrix().length - 1;
        lineValues[index] = winnerValidator.getValueAtIndex(board, index, maxIndexValue - index);
    }

    @Override
    protected String checkIfWinnerExists() {
        return winnerValidator.checkDiagonalsForWin(board, lineValues);
    }
}
