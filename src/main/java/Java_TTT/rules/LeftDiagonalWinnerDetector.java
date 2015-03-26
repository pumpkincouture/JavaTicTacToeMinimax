package Java_TTT.rules;

import Java_TTT.boards.Board;

public class LeftDiagonalWinnerDetector extends GameWinnerDetector {
    private Board board;
    private WinnerValidator winnerValidator;
    private String[] lineValues;

    public LeftDiagonalWinnerDetector(Board board, WinnerValidator winnerValidator) {
        this.board = board;
        this.winnerValidator = winnerValidator;
        this.lineValues = new String[board.getMatrix().length];
    }

    @Override
    protected void addGamePiecesToList(int index) {
        lineValues[index] = winnerValidator.getValueAtIndex(board, index, index);
    }

    @Override
    protected String checkIfWinnerExists() {
        return winnerValidator.checkDiagonalsForWin(board, lineValues);
    }
}
