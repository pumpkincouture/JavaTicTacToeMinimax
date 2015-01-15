package Java_TTT;

import java.util.ArrayList;

public class GameScorer {
    private Board board;

    public GameScorer(Board board) {
        this.board = board;
    }

    public int getBoardLength() {
        return board.getLength();
    }

    public int getBoardSquareRoot() {
        return board.getCellsSquareRoot(getBoardLength());
    }

    public boolean isGameOver(String playerOne, String playerTwo) {
        return !getWinningPlayer(playerOne, playerTwo).isEmpty() || board.getOpenSpaces().isEmpty();
    }

    public boolean isThereAWinner (String gamePiece) {
        for (ArrayList<String> boardPart: createBoardMatrix()) {
            if (checkBoardForWin(gamePiece, boardPart) == getBoardSquareRoot()) {
                return true;
            }
        }
        return false;
    }

    public String getWinningPlayer(String playerOne, String playerTwo) {
        String noWinner = "";
        for (ArrayList<String> boardPart: createBoardMatrix()) {
            if (checkBoardForWin(playerOne, boardPart) == getBoardSquareRoot()) {
                return playerOne;
            } else if (checkBoardForWin(playerTwo, boardPart) == getBoardSquareRoot()) {
                return playerTwo;
            }
        }
        return noWinner;
    }


    private ArrayList<ArrayList<String>> createBoardMatrix () {
        ArrayList<ArrayList<String>> boardMatrix = new ArrayList();
        boardMatrix.add(getPartOfBoard(0, 1, 2));
        boardMatrix.add(getPartOfBoard(3, 4, 5));
        boardMatrix.add(getPartOfBoard(6, 7, 8));
        boardMatrix.add(getPartOfBoard(0, 4, 8));
        boardMatrix.add(getPartOfBoard(2, 4, 6));
        boardMatrix.add(getPartOfBoard(0, 3, 6));
        boardMatrix.add(getPartOfBoard(1, 4, 7));
        boardMatrix.add(getPartOfBoard(2, 5, 8));

        return boardMatrix;
    }

    private ArrayList<String> getPartOfBoard(int space1, int space2, int space3) {
        ArrayList<String> boardPart = new ArrayList();

        boardPart.add(board.getBoardCells()[space1]);
        boardPart.add(board.getBoardCells()[space2]);
        boardPart.add(board.getBoardCells()[space3]);

        return boardPart;
    }

    private int checkBoardForWin(String gamePiece, ArrayList<String> boardPart) {
        int inARow = 0;

        if (boardPart.get(0) == gamePiece && boardPart.get(1) == gamePiece && boardPart.get(2) == gamePiece) {
            inARow = 3 ;
        }
        return inARow;
    }
}
