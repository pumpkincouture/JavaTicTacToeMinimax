package Java_TTT.rules;

import Java_TTT.boards.BoardInterface;

import java.util.ArrayList;

public class ThreeByThreeBoardRules implements TTTBoardRules {
    private BoardInterface board;

    public ThreeByThreeBoardRules(BoardInterface board) {
        this.board = board;
    }

    @Override
    public boolean isGameOver(String playerOne, String playerTwo) {
        return !getWinningPlayer(playerOne, playerTwo).isEmpty() || board.getOpenSpaces().isEmpty();
    }

    @Override
    public boolean isThereAWinner(String gamePiece) {
        for (ArrayList<String> boardPart: getMatrix()) {
            if (checkBoardForWin(gamePiece, boardPart) == board.getCellsSquareRoot()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getWinningPlayer(String playerOne, String playerTwo) {
        String noWinner = "";
        for (ArrayList<String> boardPart: getMatrix()) {
            if (checkBoardForWin(playerOne, boardPart) == board.getCellsSquareRoot()) {
                return playerOne;
            } else if (checkBoardForWin(playerTwo, boardPart) == board.getCellsSquareRoot()) {
                return playerTwo;
            }
        }
        return noWinner;
    }

    public ArrayList<ArrayList<String>> getMatrix() {
        ArrayList<ArrayList<String>> boardMatrix = new ArrayList();
        return boardMatrix;
    }

    public String getOpponentPiece(String gamePiece) {
        return "X";
//        return findOpponentPiece(gamePiece);
    }

//    private String findOpponentPiece(String gamePiece) {
//        for (int i = 0; i < board.getCells().length; i++) {
//            for (int j = 0; j < board.getCells()[i].length; j++) {
//                if (!board.getCells()[i][j].contains("*")) {
//                    if (board.getCells()[i][j] != gamePiece) {
//                        return board.getCells()[i][j];
//                    }
//                }
//            }
//        }
//        return "";
//    }


    @Override
    public String checkForRowWinner(String playerOne, String playerTwo) {
        return "";
    }

    public String getBoardWinner() {
        if (checkColumns() != "") {
            return checkColumns();
        }
        if (checkRows() != "") {
            return checkRows();
        }if (checkFirstDiagonal() != "") {
            return checkFirstDiagonal();
        } if (checkSecondDiagonal() != "") {
            return checkSecondDiagonal();
        }
        return "";
    }

    private String checkColumns() {
        for (int i = 0; i < board.getMatrix().length; i++) {
            String value = board.getMatrix()[i][0];
            if (value == "*") {
                continue;
            }
            for (int j = 1; j < board.getMatrix()[i].length; j++) {
                String currentSpace = board.getMatrix()[i][j];
                if (currentSpace == "*" || !currentSpace.equals(value)) {
                    break;
                }
                if (j == board.getMatrix()[i].length - 1) {
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

    private String checkFirstDiagonal() {
        for (int row = 0; row < board.getMatrix().length; row++) {
            String value = board.getMatrix()[board.getMatrix().length - 1][row];
            if (value == "*") {
                continue;
            }
            for (int column = 1; column < board.getMatrix().length; column++) {
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


    private String checkSecondDiagonal() {
        for (int row = 1; row < board.getMatrix().length; row++) {
            String value = board.getMatrix()[0][0];
            if (value == "*") {
                continue;
            }
            for (int column = 1; column < board.getMatrix().length; column++) {
                String currentSpace = board.getMatrix()[row][row];
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

    private int checkBoardForWin(String gamePiece, ArrayList<String> boardPart) {
        int inARow = 0;

        for (int i=0; i < boardPart.size(); i++ ) {
            if (boardPart.get(i) == gamePiece) {
                inARow += 1;
            }
        }
        return inARow;
    }
}
