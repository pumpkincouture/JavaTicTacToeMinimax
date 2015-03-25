package Java_TTT.rules;

import Java_TTT.boards.Board;

public class WinnerValidator {

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
