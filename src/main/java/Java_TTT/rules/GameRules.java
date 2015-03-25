package Java_TTT.rules;

import Java_TTT.boards.Board;

import java.util.ArrayList;
import java.util.List;

public class GameRules implements GameRulesInterface {
    private Board board;

    public GameRules(Board board) {
        this.board = board;
    }

    @Override
    public boolean isGameOver() {
        return !getBoardWinner().isEmpty() || board.getOpenSpaces().isEmpty();
    }

    @Override
    public String getOpponentPiece(String gamePiece) {
        return findOpponentPiece(gamePiece);
    }

    @Override
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

    private String findOpponentPiece(String gamePiece) {
        for (int i = 0; i < board.getMatrix().length; i++) {
            for (int j = 0; j < board.getMatrix()[i].length; j++) {
                if (!board.getMatrix()[i][j].contains(board.getBoardEmptySpace())) {
                    if (board.getMatrix()[i][j] != gamePiece) {
                        return board.getMatrix()[i][j];
                    }
                }
            }
        }
        return "";
    }
}
