package Java_TTT;

import java.util.*;

public class AI extends Player implements PlayerInterface{
    private GameScorer gameScorer;
    private int choice;
    private Board board;
    private CommandLineInterface ui;


    public AI(String gamePiece, Board board, CommandLineInterface ui) {
        super(gamePiece);
        this.board = board;
        this.ui = ui;
        gameScorer = new GameScorer(board);
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getMove() {
        ui.printComputerThinking();
        if (board.isEmpty()) {
            return convertChosenIndexToString(findMiddleOfBoard());
        }
        minimax(this.board, 0, this.getGamePiece());
        return convertChosenIndexToString(choice);
    }

    private int minimax(Board board, int depth, String gamePiece) {
        List<Integer> scores = new ArrayList();
        List<Integer> moves = new ArrayList();
        depth += 1;

        if (isGameOver(board)) {
            return getScores(board, depth);
        }
        for (Integer openSpace: board.getOpenSpaces()) {
            board.placeMove(convertChosenIndexToString(openSpace), gamePiece);
            scores.add(minimax(board, depth, switchPlayers(board, gamePiece)));
            moves.add(openSpace);
            board.clearBoard(openSpace);
        }

        if (gamePiece == this.getGamePiece()) {
            int max_score = maxIndex(scores);
            choice = moves.get(max_score);
            return scores.get(max_score);
        }

        else {
            int min_score = minIndex(scores);
            choice = moves.get(min_score);
            return scores.get(min_score);
        }
    }

    private static int getMaxValue(List<Integer> scoresList) {
        int maxValue = Collections.max(scoresList);
        return maxValue;
    }

    private static int getMinValue(List<Integer> scoresList) {
        int minValue = Collections.min(scoresList);
        return minValue;
    }

    private static Integer maxIndex(List<Integer> list) {
        List<Integer> index = new ArrayList();
        int max =  getMaxValue(list);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == max) {
                index.add(i);
            }
        }
        return index.get(0);
    }

    private static Integer minIndex(List<Integer> list) {
        List<Integer> index = new ArrayList();
        int min = getMinValue(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == min) {
                index.add(i);
            }
        }
        return index.get(0);
    }

    private int getScores(Board board, int depth) {
        if (isComputerWinner(board)) {
            return 10 - depth;
        } else if (isOpponentWinner(board)) {
            return depth - 10;
        }
        return 0;
    }

    private boolean isOpponentWinner(Board board) {
        if (getGameWinner(board) == "") {
            return false;
        } else if (getGameWinner(board) != this.getGamePiece()) {
            return true;
        }
        return false;
    }

    private boolean isComputerWinner(Board board) {
        return getGameWinner(board) == this.getGamePiece();
    }

    private boolean isGameOver(Board board) {
        return gameScorer.isGameOver(board.getOpponentPiece(this.getGamePiece()), this.getGamePiece());
    }

    private String switchPlayers(Board board, String gamePiece) {
        return gamePiece == this.getGamePiece() ? board.getOpponentPiece(gamePiece) : this.getGamePiece();
    }

    private String getGameWinner(Board board) {
        return gameScorer.getWinningPlayer(board.getOpponentPiece(this.getGamePiece()), this.getGamePiece());
    }

    private String convertChosenIndexToString(int chosenSpace) {
        return Integer.toString(chosenSpace + 1);
    }

    private int findMiddleOfBoard() {
        return board.getCellsSquareRoot(board.getLength()) + 1;
    }
}
