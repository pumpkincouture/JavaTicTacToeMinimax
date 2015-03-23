package Java_TTT.rules;

import Java_TTT.boards.BoardInterface;

public class BoardRules implements BoardRulesInterface {
    private BoardInterface board;

    public BoardRules(BoardInterface board) {
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
        if (checkColumns() != "") {
            return checkColumns();
        }
        if (checkRows() != "") {
            return checkRows();
        }
        if (checkRightDiagonal() != "") {
            return checkRightDiagonal();
        }
        if (checkLeftDiagonal() != "") {
            return checkLeftDiagonal();
        }
        return "";
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
        for (int row = 0; row < board.getMatrix().length; row++) {
            String value = board.getMatrix()[row][0];
            if (value == "*") {
                continue;
            }
            for (int column = 1; column < board.getMatrix()[row].length; column++) {
                String currentSpace = board.getMatrix()[row][column];
                if (currentSpace == "*" || !currentSpace.equals(value)) {
                    break;
                }
                if (column == board.getMatrix().length - 1) {
                    return value;
                }
            }
        }
        return "";
    }

    private String checkRows() {
        for (int row = 0; row < board.getMatrix().length; row++) {
            String value = board.getMatrix()[1][row];
            if (value == "*") {
                continue;
            }
            for (int column = 0; column < board.getMatrix()[row].length; column++) {
                String currentSpace = board.getMatrix()[column][row];
                if (currentSpace == "*" || !currentSpace.equals(value)) {
                    break;
                }
                if (column == board.getMatrix()[row].length - 1) {
                    return value;
                }

            }
        }
        return "";
    }

    public String checkRightDiagonal() {
        for (int row = 0; row < board.getMatrix().length; row++) {
            String value = board.getMatrix()[row][board.getMatrix().length - 1];
            if (value == "*") {
                continue;
            }
            for (int column = 0; column < board.getMatrix().length; column++) {
                String currentSpace = board.getMatrix()[column][board.getMatrix().length - column - 1];
                if (currentSpace == "*" || !currentSpace.equals(value)) {
                    break;
                }
                if (column == board.getMatrix().length - 1) {
                    return value;
                }
            }
        }
        return "";
    }


    public String checkLeftDiagonal() {
        for (int row = 1; row < board.getMatrix().length; row++) {
            String value = board.getMatrix()[0][0];
            if (value == "*") {
                continue;
            }
            for (int column = 1; column < board.getMatrix().length; column++) {
                String currentSpace = board.getMatrix()[column][column];
                if (currentSpace == "*" || !currentSpace.equals(value)) {
                    break;
                }
                if (column == board.getMatrix().length - 1) {
                    return value;
                }
            }
        }
        return "";
    }
}
