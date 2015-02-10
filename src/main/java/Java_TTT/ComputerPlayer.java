package Java_TTT;

import java.util.Random;

public class ComputerPlayer extends Player implements PlayerInterface {
    private Random randomGenerator;
    private Board board;
    private CommandLineInterface ui;

    public ComputerPlayer(String gamePiece, Board board, CommandLineInterface ui) {
        super(gamePiece);
        this.board = board;
        this.ui = ui;
        randomGenerator = new Random();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getMove() {
        ui.printComputerThinking();
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
