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

    public int getChoice() {
        return choice;
    }

    public String getMove() {
        ui.printComputerThinking();
        makeCalculation(this.board, 0, this.getGamePiece(), Integer.MIN_VALUE, Integer.MAX_VALUE, 6);
        return convertChosenIndexToString(choice);
    }

    public int makeCalculation(Board board, int depth, String gamePiece, int minValue, int maxValue, int endingDepth) {
        List<Integer> scores = new ArrayList();
        List<Integer> moves = new ArrayList();
        int max;
        List<Integer> possibleMoves = new ArrayList();
        if (isGameOver(board) || depth == endingDepth) {
            return getScores(board, depth);
        }

        for (Integer openSpace : board.getOpenSpaces()) {
            board.placeMove(convertChosenIndexToString(openSpace), gamePiece);
            int score = (makeCalculation(board, depth + 1, switchPlayers(board, gamePiece), minValue, maxValue, endingDepth));
            scores.add(score);
            moves.add(openSpace);
            board.clearBoard(openSpace);

            if (gamePiece == this.getGamePiece()) {
                int maxScoreIndex = maxIndex(scores);
                possibleMoves.add(moves.get(maxScoreIndex));
                if (score > minValue) minValue = score;

            } else {
                if (score < maxValue) maxValue = score;
            }

            if (maxValue <= minValue) break;
        }

        if (gamePiece != this.getGamePiece()) {
            return maxValue;
        }
        choice = Collections.max(possibleMoves);
        return minValue;
    }

    private static int getMaxValue(List<Integer> scoresList) {
        return Collections.max(scoresList);
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

    public int getScores(Board board, int depth) {
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
}
