package Java_TTT;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random randomGenerator;

    public ComputerPlayer(String gamePiece) {
        super(gamePiece);
        randomGenerator = new Random();
    }

    @Override
    public String getMove(Board board) {
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
