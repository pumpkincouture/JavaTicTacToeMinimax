package Java_TTT.rules;

import Java_TTT.boards.Board;

import java.util.ArrayList;

public class ThreeByThreeBoardRules implements BoardRules {
    private Board board;

    public ThreeByThreeBoardRules(Board board) {
        this.board = board;
    }

    @Override
    public boolean isGameOver(String playerOne, String playerTwo) {
        return !getWinningPlayer(playerOne, playerTwo).isEmpty() || board.getOpenSpaces().isEmpty();
    }

    @Override
    public boolean isThereAWinner(String gamePiece) {
        for (ArrayList<String> boardPart: getMatrix()) {
            if (checkBoardForWin(gamePiece, boardPart) == board.getCellsSquareRoot(board.getLength())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getWinningPlayer(String playerOne, String playerTwo) {
        String noWinner = "";
        for (ArrayList<String> boardPart: getMatrix()) {
            if (checkBoardForWin(playerOne, boardPart) == board.getCellsSquareRoot(board.getLength())) {
                return playerOne;
            } else if (checkBoardForWin(playerTwo, boardPart) == board.getCellsSquareRoot(board.getLength())) {
                return playerTwo;
            }
        }
        return noWinner;
    }

    public ArrayList<ArrayList<String>> getMatrix() {
        System.out.println(board.getCells());
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

    private ArrayList<String> getDiagonal1() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
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
        int squareRoot = board.getCellsSquareRoot(board.getLength());
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
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> row = new ArrayList();

        for (int i=0; i < squareRoot; i++) {
            row.add(board.getCells()[i]);
        }
        return row;
    }

    private ArrayList<String> getRow2() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> row = new ArrayList();
        int squareDoubled= squareRoot * 2;

        for (int i= squareRoot; i < squareDoubled; i++) {
            row.add(board.getCells()[i]);
        }
        return row;
    }

    private ArrayList<String> getRow3() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> row = new ArrayList();
        int squareDoubled= squareRoot * 2;
        int squareTripled = squareRoot * 3;

        for (int i= squareDoubled; i < board.getLength(); i++) {
                row.add(board.getCells()[i]);
            }
        return row;
    }

    private ArrayList<String> getColumn1() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> column = new ArrayList();

        column.add(board.getCells()[0]);
        column.add(board.getCells()[squareRoot]);
        column.add(board.getCells()[board.getLength() - squareRoot]);
        return column;
    }

    private ArrayList<String> getColumn2() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> column = new ArrayList();


        column.add(board.getCells()[1]);
        column.add(board.getCells()[squareRoot + 1]);
        column.add(board.getCells()[board.getLength() - (squareRoot - 1)]);
        return column;
    }

    private ArrayList<String> getColumn3() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
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
