package Java_TTT;

import java.util.Random;

public class Computer extends Player implements PlayerInterface {
    private Random randomGenerator;
    private Board board;

    public Computer(String gamePiece, Board board) {
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
