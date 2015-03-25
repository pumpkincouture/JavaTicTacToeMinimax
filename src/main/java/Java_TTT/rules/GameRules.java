package Java_TTT.rules;

import Java_TTT.boards.Board;

import java.util.ArrayList;
import java.util.List;

public class GameRules implements GameRulesInterface {
    private Board board;
    private TicTacToeWinnerDetector gameWinnerDetector;
    private WinnerValidator winnerValidator;
    private GameWinnerDetector gameDetector;

    public GameRules(Board board, TicTacToeWinnerDetector gameWinnerDetector) {
        this.board = board;
        this.gameWinnerDetector = gameWinnerDetector;
        this.winnerValidator = new WinnerValidator();
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
        gameDetector = new ColumnWinnerDetector(board, winnerValidator);
        System.out.println(gameDetector.findBoardWinner(board.getMatrix().length) + " printing from getBoardWinner in GameRules");
        for (String winningGamePiece : gameWinnerDetector.findBoardWinner()) {
            if (!winningGamePiece.isEmpty()) {
                return winningGamePiece;
            }
        }
        return "";
    }

//    public List<String> findBoardWinner() {
//        List<String> valuesAfterCheckingForWin = new ArrayList<>();

//        valuesAfterCheckingForWin.add(new ColumnWinnerDetector(board, winnerValidator).getWinner());
//        valuesAfterCheckingForWin.add(new RowWinnerDetector(board, winnerValidator));
//        valuesAfterCheckingForWin.add(checkRightDiagonal());
//        valuesAfterCheckingForWin.add(checkLeftDiagonal());
//
//        return valuesAfterCheckingForWin;
//    }

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
