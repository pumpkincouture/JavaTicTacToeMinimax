package Java_TTT.players;

import Java_TTT.boards.Board;

import java.util.Random;

public class SimpleAI extends Player implements PlayerInterface {
    private Random randomGenerator;
    private Board board;

    public SimpleAI(String gamePiece, Board board) {
        super(gamePiece);
        this.board = board;
        randomGenerator = new Random();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getMove() {
        return convertChosenIndexToString(board);
    }

    private String convertChosenIndexToString(Board board) {
        return Integer.toString(convertIndexToSpace(board));
    }

    private int convertIndexToSpace(Board board) {
        return getRandomIndex(board) + 1;
    }

    private int getRandomIndex(Board board) {
        int randomSpace = board.getOpenSpaces().get(randomGenerator.nextInt(board.getOpenSpaces().size()));
        return randomSpace;
    }
}
