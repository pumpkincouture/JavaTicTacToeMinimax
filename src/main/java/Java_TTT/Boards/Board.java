package Java_TTT.boards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board implements BoardInterface {

    private String[][] boardCells;
    private int boardSize;

    public Board(int boardSizeChoice) {
        this.boardSize = boardSizeChoice;
        boardCells = new String[boardSizeChoice][boardSizeChoice];
        fillArray();
    }

    public String[] getCells() {
        return boardCells[0];
    }

    public String[][] getMatrix() {
        return boardCells;
    }

    public List<Integer> getOpenSpaces() {
        return getOpenCellLocations();
    }

    public boolean isMoveValid(String answer) {
        return (checkIfMoveIsInteger(answer) && cellOpen(answer));
    }

    public boolean isFull() {
        return getOpenCellLocations().size() != getLength();
    }

    public void placeMove(String answer, String gamePiece) {
        findCorrectArraySpace(answer, gamePiece);
    }

    public void resetCell(int index) {
        boardCells[index % boardSize][index / boardSize] = "*";
    }

    public int getLength() {
        return boardCells[0].length * boardCells[1].length;
    }

    public int getCellsSquareRoot() {
        return boardSize;
    }

    private void fillArray() {
        for (String[] row : boardCells)
             Arrays.fill(row, "*");
    }

    private void findCorrectArraySpace(String answer, String gamePiece) {
        int answerWithIndex = Integer.parseInt(answer) - 1;

        boardCells[answerWithIndex % boardSize][answerWithIndex / boardSize] = gamePiece;
    }

    private boolean cellOpen(String space) {
        int answerWithIndex = Integer.parseInt(space) - 1;

        return boardCells[answerWithIndex % boardSize][answerWithIndex / boardSize].contains("*");
    }

    private boolean checkIfMoveIsInteger(String answer) {
        try {
            Integer.parseInt(answer);
            return true;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    private ArrayList<Integer> getOpenCellLocations() {
        ArrayList<Integer> openCells = new ArrayList();
        for (int i = 0; i < boardCells.length; i++) {
            for (int j = 0; j < boardCells[i].length; j++) {
                if (boardCells[i][j].contains("*")) {
                    openCells.add(boardSize * j + i);
                }
            }
        }
        Collections.sort(openCells);
        return openCells;
    }
}