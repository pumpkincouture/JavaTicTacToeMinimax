package Java_TTT.rules;

import Java_TTT.boards.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardRules implements BoardRulesInterface {
    private Board board;
    private int boardLength;
    private int maxIndexValue;

    public BoardRules(Board board) {
        this.board = board;
    }

    @Override
    public boolean isGameOver() {
        return !getBoardWinner().isEmpty() || board.getOpenSpaces().isEmpty();
    }

    @Override
    public String getOpponentPiece(String gamePiece) {
        return findOpponentPiece(gamePiece);
    }

    @Override
    public String getBoardWinner() {
        boardLength = board.getMatrix().length;
        maxIndexValue = boardLength - 1;
        for (String winningGamePiece : checkEntireBoardForWin()) {
            if (!winningGamePiece.isEmpty()) {
                return winningGamePiece;
            }
        }
        return "";
    }

    private List<String> checkEntireBoardForWin() {
        List<String> valuesAfterCheckingForWin = new ArrayList<>();

        valuesAfterCheckingForWin.add(checkColumns());
        valuesAfterCheckingForWin.add(checkRows());
        valuesAfterCheckingForWin.add(checkRightDiagonal());
        valuesAfterCheckingForWin.add(checkLeftDiagonal());

        return valuesAfterCheckingForWin;
    }

    private String findOpponentPiece(String gamePiece) {
        for (int i = 0; i < board.getMatrix().length; i++) {
            for (int j = 0; j < board.getMatrix()[i].length; j++) {
                if (!board.getMatrix()[i][j].contains(board.getBoardEmptySpace())) {
                    if (board.getMatrix()[i][j] != gamePiece) {
                        return board.getMatrix()[i][j];
                    }
                }
            }
        }
        return "";
    }

    private String checkColumns() {
        String[][] lineValues = new String[boardLength][boardLength];

        for (int columnIndex = 0; columnIndex < boardLength; columnIndex++) {
            for (int index = 0; index < boardLength; index++) {
                lineValues[columnIndex][index] = getValueAtIndex(columnIndex, maxIndexValue - index);
            }
        }

        for (int i = 0; i < boardLength; i++) {
            if (isWinningCombo(lineValues[i])) {
                return lineValues[i][0];
            }
        }

        return "";
    }

    private String checkRows() {
        String[][] lineValues = new String[boardLength][boardLength];

        for (int rowIndex = 0; rowIndex < boardLength; rowIndex++) {
            for (int index = 0; index < boardLength; index++) {
                lineValues[rowIndex][index] = getValueAtIndex(maxIndexValue - index, rowIndex);
            }
        }

        for (int i = 0; i < boardLength; i++) {
            if (isWinningCombo(lineValues[i])) {
                return lineValues[i][0];
            }
        }
        return "";
    }

    private String checkRightDiagonal() {
        String[] lineValues = new String[boardLength];

        findDiagonalValuesOnBoard(lineValues, true);
        return checkDiagonalsForWinningCombo(lineValues);
    }

    private String checkLeftDiagonal() {
        String[] lineValues = new String[boardLength];

        findDiagonalValuesOnBoard(lineValues, false);
        return checkDiagonalsForWinningCombo(lineValues);
    }



    private void findDiagonalValuesOnBoard(String[] lineValues, boolean rightDiagonal) {
        for (int index = 0; index < boardLength; index++) {
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
