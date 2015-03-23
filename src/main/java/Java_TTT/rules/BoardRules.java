package Java_TTT.rules;

import Java_TTT.boards.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardRules implements BoardRulesInterface {
    private Board board;

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
                if (!board.getMatrix()[i][j].contains("*")) {
                    if (board.getMatrix()[i][j] != gamePiece) {
                        return board.getMatrix()[i][j];
                    }
                }
            }
        }
        return "";
    }

    private String checkColumns() {
        int boardLength = board.getMatrix().length;
        int maxIndexValue = boardLength - 1;
        String[][] lineValues = new String[boardLength][boardLength];

        for (int columnIndex = 0; columnIndex < boardLength; columnIndex++) {
            for (int index = 0; index < boardLength; index++) {
                lineValues[columnIndex][index] = board.getMatrix()[columnIndex][maxIndexValue - index];
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
        int boardLength = board.getMatrix().length;
        int maxIndexValue = boardLength - 1;
        String[][] lineValues = new String[boardLength][boardLength];

        for (int rowIndex = 0; rowIndex < boardLength; rowIndex++) {
            for (int index = 0; index < boardLength; index++) {
                lineValues[rowIndex][index] = board.getMatrix()[maxIndexValue - index][rowIndex];
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
        int boardLength = board.getMatrix().length;
        int maxIndexValue = boardLength - 1;
        String[] lineValues = new String[boardLength];

        for (int index = 0; index < boardLength; index++) {
            lineValues[index] = board.getMatrix()[index][maxIndexValue - index];
        }

        if (isWinningCombo(lineValues)) {
            return lineValues[0];
        }
        return "";
    }

    private String checkLeftDiagonal() {
        int boardLength = board.getMatrix().length;
        String[] lineValues = new String[boardLength];

        for (int index = 0; index < boardLength; index++) {
            lineValues[index] = board.getMatrix()[index][index];
        }

        if (isWinningCombo(lineValues)) {
            return lineValues[0];
        }
        return "";
    }

    private boolean isWinningCombo(String[] lineValues) {
        String first = lineValues[0];
        for (String value : lineValues) {
            if (value != first || value == "*") {
                return false;
            }
        }
        return true;
    }
}
