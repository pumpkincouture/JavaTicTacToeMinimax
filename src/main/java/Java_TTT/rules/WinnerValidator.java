package Java_TTT.rules;

import Java_TTT.boards.Board;

public class WinnerValidator {

    public String checkDiagonalsForWin(Board board, String[] lineValues) {
      if (isWinningCombo(board, lineValues)) {
         return lineValues[0];
      }
      return "";
    }

    public String checkRowsAndColumnsForWin(Board board, String[][] lineValues) {
        for (int i = 0; i < board.getMatrix().length; i++) {
            if (isWinningCombo(board, lineValues[i])) {
                return lineValues[i][0];
            }
        } return "";
    }

    public String getValueAtIndex(Board board, int startingIndex, int endingIndex) {
        return board.getMatrix()[startingIndex][endingIndex];
    }

    public boolean isWinningCombo(Board board, String[] lineValues) {
        String first = lineValues[0];
        for (String value : lineValues) {
            if (value != first || value == board.getBoardEmptySpace()) {
                return false;
            }
        }
        return true;
    }
}
