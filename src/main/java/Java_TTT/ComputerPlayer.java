package Java_TTT;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random randomGenerator;
    private Board board;

    public ComputerPlayer(String gamePiece, Board board) {
        super(gamePiece);
        this.board = board;
        randomGenerator = new Random();
    }

    @Override
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
