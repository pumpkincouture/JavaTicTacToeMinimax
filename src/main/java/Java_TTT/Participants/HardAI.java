package Java_TTT.participants;

import Java_TTT.boards.Board;
import Java_TTT.rules.GameRules;

import java.util.*;

public class HardAI extends Participant {
    public static final int MAX_DEPTH = 6;
    private GameRules gameRules;
    private int choice;
    private Board board;
    private String opponentPiece;


    public HardAI(String gamePiece, GameRules gameRules, Board board, String opponentPiece) {
        super(gamePiece);
        this.gameRules = gameRules;
        this.board = board;
        this.opponentPiece = opponentPiece;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public int getChoice() {
        return choice;
    }

    public String getMove() {
        makeCalculation(this.board, 0, this.getGamePiece(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        return convertChosenIndexToString(choice);
    }

    public int makeCalculation(Board board, int depth, String gamePiece, int minValue, int maxValue) {
        ArrayList<Branch> movesList = new ArrayList();

        if (isGameOver() || depth == MAX_DEPTH) {
            return getScores(depth);
        }

        for (Integer move : board.getOpenSpaces()) {
            board.placeMove(convertChosenIndexToString(move), gamePiece);
            int score = (makeCalculation(board, depth + 1, switchPlayers(gamePiece), minValue, maxValue));
            Branch branch = new Branch(score, move);
            board.resetCell(move);

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

    public int getScores(int depth) {
        if (isComputerWinner()) {
            return 10 - depth;
        } else if (isOpponentWinner()) {
            return depth - 10;
        }
        return 0;
    }

    private boolean isOpponentWinner() {
        if (gameRules.getBoardWinner() == "") {
            return false;
        } else if (gameRules.getBoardWinner() != this.getGamePiece()) {
            return true;
        }
        return false;
    }

    private boolean isComputerWinner() {
        return (gameRules.getBoardWinner() == this.getGamePiece());
    }

    private boolean isGameOver() {
        return gameRules.isGameOver();
    }

    private String switchPlayers(String gamePiece) {
        return gamePiece == this.getGamePiece() ? opponentPiece : this.getGamePiece();
    }

    private String convertChosenIndexToString(int chosenSpace) {
        return Integer.toString(chosenSpace + 1);
    }

    public class Branch {
        private final int score;
        private final int move;

        public Branch(int score, int move) {
            this.score = score;
            this.move = move;
        }

        public int getScore() {
            return score;
        }

        public int getMove() {
            return move;
        }
    }
}
