package Java_TTT;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private String[] boardCells;

    public Board(int boardSizeChoice) {
        boardCells = new String[createBoard(boardSizeChoice)];
        fillArray();
    }

    public String[] getCells() {
        return boardCells;
    }

    public ArrayList<Integer> getOpenSpaces() {
        return getOpenCellLocations();
    }

    public ArrayList<Integer> getOccupiedSpaces() {
        return getOccupiedCellLocations();
    }

    public String getOpponentPiece(String gamePiece) {
        return findOpponentPiece(gamePiece);
    }

    public boolean isMoveValid(String answer) {
        return validateCells(answer);
    }

    public boolean hasOpenSpaces() {
        return checkForOpenCells();
    }

    public boolean isBoardEmpty() {
        return getOpenCellLocations().size() == boardCells.length;
    }

    public String[] placeMove(String answer, String gamePiece) {
        findCorrectArraySpace(answer, gamePiece);
       return boardCells;
    }

    public void clearBoard(int index) {
        boardCells[index] = "";
    }

    public int getLength() {
        return boardCells.length;
    }

    public int getCellsSquareRoot(int boardLength) {
        long square = Math.round(Math.sqrt(boardLength));
        int squareRoot = (int) square;
        return squareRoot;
    }

    private int createBoard(int boardSize) {
        int sizeOfBoard = boardSize * boardSize;
        return sizeOfBoard;
    }

    private void fillArray() {
        Arrays.fill(boardCells, "");
    }

    private void findCorrectArraySpace(String answer, String gamePiece) {
        boardCells[convertAnswerToInteger(answer) - 1] = gamePiece;
    }

    private String getSpaceValue(String answer){
        return boardCells[convertAnswerToInteger(answer) - 1];
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
    }

    private boolean validateCells(String answer) {
        if (checkIfMoveIsInteger(answer) && getSpaceValue(answer).isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean checkIfMoveIsInteger(String answer) {
        try {
            Integer.parseInt(answer);
            return true;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    private boolean checkForOpenCells() {
        for (String space: boardCells) {
            if (space.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Integer> getOccupiedCellLocations() {
        ArrayList<Integer> openCells = new ArrayList();
        for (int i = 0; i < boardCells.length; i++)
            if (!boardCells[i].isEmpty()) {
                openCells.add(i);
            }
        return openCells;
    }

    private ArrayList<Integer> getOpenCellLocations() {
        ArrayList<Integer> openCells = new ArrayList();
        for (int i =0; i < boardCells.length; i++)
            if (boardCells[i].isEmpty()) {
                openCells.add(i);
            }
        return openCells;
    }

    private String findOpponentPiece(String gamePiece) {
        for (String space: boardCells) {
            if (!space.isEmpty()) {
                if (space != gamePiece) {
                    return space;
                }
            }
        } return "";
    }
}