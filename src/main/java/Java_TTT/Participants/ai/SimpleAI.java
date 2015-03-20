package Java_TTT.participants.ai;

import Java_TTT.boards.BoardInterface;
import Java_TTT.participants.GameParticipants;
import Java_TTT.participants.Participant;

import java.util.Random;

public class SimpleAI extends Participant implements GameParticipants {
    private Random randomGenerator;
    private BoardInterface board;

    public SimpleAI(String gamePiece, BoardInterface board) {
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

    private String convertChosenIndexToString(BoardInterface board) {
        return Integer.toString(convertIndexToSpace(board));
    }

    private int convertIndexToSpace(BoardInterface board) {
        return getRandomIndex(board) + 1;
    }

    private int getRandomIndex(BoardInterface board) {
        int randomSpace = board.getOpenSpaces().get(randomGenerator.nextInt(board.getOpenSpaces().size()));
        return randomSpace;
    }
}
