package Java_TTT;

import java.util.ArrayList;

public class GameScorer {
    private Board board;

    public GameScorer(Board board) {
        this.board = board;
    }

    public boolean isGameOver(String playerOne, String playerTwo) {
        return !getWinningPlayer(playerOne, playerTwo).isEmpty() || board.getOpenSpaces().isEmpty();
    }

    public boolean isThereAWinner (String gamePiece) {
        for (ArrayList<String> boardPart: create3x3BoardMatrix()) {
            if (checkBoardForWin(gamePiece, boardPart) == board.getCellsSquareRoot(board.getLength())) {
                return true;
            }
        }
        return false;
    }

    public String getWinningPlayer(String playerOne, String playerTwo) {
        String noWinner = "";
        for (ArrayList<String> boardPart: create3x3BoardMatrix()) {
            if (checkBoardForWin(playerOne, boardPart) == board.getCellsSquareRoot(board.getLength())) {
                return playerOne;
            } else if (checkBoardForWin(playerTwo, boardPart) == board.getCellsSquareRoot(board.getLength())) {
                return playerTwo;
            }
        }
        return noWinner;
    }

    private ArrayList<ArrayList<String>> create3x3BoardMatrix() {
        ArrayList<ArrayList<String>> boardMatrix = new ArrayList();

//        boardMatrix.add(getPartOfBoard(0, 1, 2));
        boardMatrix.add(getFirstRowOfBoard());
        boardMatrix.add(getPartOfBoard(3, 4, 5));
        boardMatrix.add(getPartOfBoard(6, 7, 8));
        boardMatrix.add(getPartOfBoard(0, 4, 8));
        boardMatrix.add(getPartOfBoard(2, 4, 6));
        boardMatrix.add(getPartOfBoard(0, 3, 6));
        boardMatrix.add(getPartOfBoard(1, 4, 7));
        boardMatrix.add(getPartOfBoard(2, 5, 8));

        return boardMatrix;
    }


    public ArrayList<String> getFirstRowOfBoard() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> firstRow = new ArrayList();
        firstRow.add(board.getCells()[0]);
        firstRow.add(board.getCells()[squareRoot]);
        firstRow.add(board.getCells()[squareRoot * 2]);
        firstRow.add(board.getCells()[squareRoot * 3]);

        return firstRow;
    }

    public ArrayList<String> getSecondRowOfBoard() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> secondRow = new ArrayList();
        secondRow.add(board.getCells()[1]);
        secondRow.add(board.getCells()[squareRoot + 1]);
        secondRow.add(board.getCells()[squareRoot * 2 + 1]);
        secondRow.add(board.getCells()[squareRoot * 3 + 1]);

        return secondRow;
    }


    public ArrayList<String> getThirdRowOfBoard() {
        int squareRoot = board.getCellsSquareRoot(board.getLength());
        ArrayList<String> thirdRow = new ArrayList();
        thirdRow.add(board.getCells()[1]);
        thirdRow.add(board.getCells()[squareRoot + 1]);
        thirdRow.add(board.getCells()[squareRoot * 2 + 1]);
        thirdRow.add(board.getCells()[squareRoot * 3 + 1]);

        return thirdRow;
    }

    public ArrayList<String> getPartOfBoard(int space1, int space2, int space3) {
        ArrayList<String> boardPart = new ArrayList();

        boardPart.add(board.getCells()[space1]);
        boardPart.add(board.getCells()[space2]);
        boardPart.add(board.getCells()[space3]);

        return boardPart;
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
