package Java_TTT.rules;

import Java_TTT.boards.Board;

import java.util.ArrayList;
import java.util.List;

public class GameRules {
    private Board board;

    public GameRules(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return !getBoardWinner().isEmpty() || board.getOpenSpaces().isEmpty();
    }

    public String getBoardWinner() {
        for (String winningGamePiece : boardWinner()) {
            if (!winningGamePiece.isEmpty()) {
                return winningGamePiece;
            }
        }
        return "";
    }

    public List<String> boardWinner() {
        List<GameWinnerDetector> detectors = new ArrayList<>();
        WinnerValidator winnerValidator = new WinnerValidator();
        detectors.add(new ColumnWinnerDetector(board, winnerValidator));
        detectors.add(new RowWinnerDetector(board, winnerValidator));
        detectors.add(new LeftDiagonalWinnerDetector(board, winnerValidator));
        detectors.add(new RightDiagonalWinnerDetector(board, winnerValidator));

        List<String> valuesAfterCheckingForWin = new ArrayList<>();
        for (GameWinnerDetector detector : detectors) {
            valuesAfterCheckingForWin.add(detector.findBoardWinner(board.getMatrix().length));
        }
        return valuesAfterCheckingForWin;
    }
}
