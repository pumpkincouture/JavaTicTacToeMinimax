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

    public ArrayList<ArrayList<String>> getMatrix() {
        ArrayList<ArrayList<String>> boardMatrix = new ArrayList();
            boardMatrix.add(getColumn1());
            boardMatrix.add(getColumn2());
            boardMatrix.add(getColumn3());
            boardMatrix.add(getRow1());
            boardMatrix.add(getRow2());
            boardMatrix.add(getRow3());
            boardMatrix.add(getDiagonal1());
            boardMatrix.add(getDiagonal2());
        return boardMatrix;
    }

    @Override
    public String checkForRowWinner(String playerOne, String playerTwo) {
        if (getWinnerInRows(playerOne) == board.getCellsSquareRoot()) {
            return playerOne;
        } else if (getWinnerInRows(playerTwo) == board.getCellsSquareRoot()) {
            return playerTwo;
        }
        return "";
    }

    public int getWinnerInRows(String gamePiece) {
        int count = 0;

        for (int i = 0; i < board.getMatrix().length; i++) {
            for (int j = 0; j < board.getMatrix()[i].length; j++) {
                if (board.getMatrix()[i][j] == gamePiece) {
                    count++;
                    System.out.println(board.getCellsSquareRoot() * j + i);
                    if (board.getMatrix()[i][j] != gamePiece) {
                        count = 0;
                        System.out.println(board.getCellsSquareRoot() * j + i);
                    }
                }
                }
            }
        return count;
    }

    private ArrayList<String> getDiagonal1() {
        int squareRoot = board.getCellsSquareRoot();
        ArrayList<String> diagonal = new ArrayList();
        int squareDoubled= squareRoot * 2;

        for (int i=0; i <  board.getLength(); i++) {
            if (i == 0) {
                diagonal.add(board.getCells()[i]);
            }
            if (i == squareRoot + 1) {
                diagonal.add(board.getCells()[i]);
            }
            if (i == squareDoubled + 2) {
                diagonal.add(board.getCells()[i]);
            }
        }
        return diagonal;
    }

    private ArrayList<String> getDiagonal2() {
        int squareRoot = board.getCellsSquareRoot();
        ArrayList<String> diagonal = new ArrayList();
        int squareDoubled= squareRoot * 2;

        for (int i=0; i <  board.getLength(); i++) {
            if (i == squareRoot - 1) {
                diagonal.add(board.getCells()[i]);
            }
            if (i == squareRoot + 1) {
                diagonal.add(board.getCells()[i]);
            }
            if (i == squareDoubled) {
                diagonal.add(board.getCells()[i]);
            }
        }
        return diagonal;
    }

    private ArrayList<String> getRow1() {
        int squareRoot = board.getCellsSquareRoot();
        ArrayList<String> row = new ArrayList();

        for (int i=0; i < squareRoot; i++) {
            row.add(board.getCells()[i]);
        }
        return row;
    }

    private ArrayList<String> getRow2() {
        int squareRoot = board.getCellsSquareRoot();
        ArrayList<String> row = new ArrayList();
        int squareDoubled= squareRoot * 2;

        for (int i= squareRoot; i < squareDoubled; i++) {
            row.add(board.getCells()[i]);
        }
        return row;
    }

    private ArrayList<String> getRow3() {
        int squareRoot = board.getCellsSquareRoot();
        ArrayList<String> row = new ArrayList();
        int squareDoubled= squareRoot * 2;
        int squareTripled = squareRoot * 3;

        for (int i= squareDoubled; i < board.getLength(); i++) {
                row.add(board.getCells()[i]);
            }
        return row;
    }

    private ArrayList<String> getColumn1() {
        int squareRoot = board.getCellsSquareRoot();
        ArrayList<String> column = new ArrayList();

        column.add(board.getCells()[0]);
        column.add(board.getCells()[squareRoot]);
        column.add(board.getCells()[board.getLength() - squareRoot]);
        return column;
    }

    private ArrayList<String> getColumn2() {
        int squareRoot = board.getCellsSquareRoot();
        ArrayList<String> column = new ArrayList();


        column.add(board.getCells()[1]);
        column.add(board.getCells()[squareRoot + 1]);
        column.add(board.getCells()[board.getLength() - (squareRoot - 1)]);
        return column;
    }

    private ArrayList<String> getColumn3() {
        int squareRoot = board.getCellsSquareRoot();
        ArrayList<String> column = new ArrayList();

        column.add(board.getCells()[2]);
        column.add(board.getCells()[squareRoot + 2]);
        column.add(board.getCells()[board.getLength() - (squareRoot - 2)]);
        return column;
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
