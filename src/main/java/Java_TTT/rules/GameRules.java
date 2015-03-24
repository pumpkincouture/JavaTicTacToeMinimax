package Java_TTT.rules;

import Java_TTT.boards.Board;

public class GameRules implements GameRulesInterface {
    private Board board;
    private GameWinnerDetector gameWinnerDetector;

    public GameRules(Board board, GameWinnerDetector gameWinnerDetector) {
        this.board = board;
        this.gameWinnerDetector = gameWinnerDetector;
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
        for (String winningGamePiece : gameWinnerDetector.findBoardWinner()) {
            if (!winningGamePiece.isEmpty()) {
                return winningGamePiece;
            }
        }
        return "";
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
