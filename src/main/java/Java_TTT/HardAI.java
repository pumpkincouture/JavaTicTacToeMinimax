package Java_TTT;

import java.util.*;

public class HardAI extends Player implements PlayerInterface{
    private GameScorer gameScorer;
    private int choice;
    private Board board;


    public HardAI(String gamePiece, Board board) {
        super(gamePiece);
        this.board = board;
        gameScorer = new GameScorer(board);
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public int getChoice() {
        return choice;
    }

    public String getMove() {
        makeCalculation(this.board, 0, this.getGamePiece(), Integer.MIN_VALUE, Integer.MAX_VALUE, 6);
        return convertChosenIndexToString(choice);
    }

    public int makeCalculation(Board board, int depth, String gamePiece, int minValue, int maxValue, int endingDepth) {
        ArrayList<Branch> movesList = new ArrayList();
        int maxAmount = 0;

        if (isGameOver(board) || depth == endingDepth) {
            return getScores(board, depth);
        }

        for (Integer move : board.getOpenSpaces()) {
            board.placeMove(convertChosenIndexToString(move), gamePiece);
            int score = (makeCalculation(board, depth + 1, switchPlayers(board, gamePiece), minValue, maxValue, endingDepth));
            Branch branch = new Branch(score, move);
            board.clearBoard(move);

            if (gamePiece == this.getGamePiece()) {
                movesList.add(branch);
                if (branch.getScore() > minValue) minValue = branch.getScore();

            } else {
                if (branch.getScore() < maxValue) maxValue = branch.getScore();
            }

            if (maxValue <= minValue) break;
        }

        if (gamePiece != this.getGamePiece()) {
            return maxValue;

        }
        choice = getBestBranch(movesList).getMove();
        return minValue;
    }

    private Branch getBestBranch(ArrayList<Branch> movesList) {
        Optional<Branch> branches = movesList.stream().max(new Comparator<Branch>() {
            @Override
            public int compare(Branch o1, Branch o2) {
                return o1.getScore() - o2.getScore();
            }
        });
        return branches.get();
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
