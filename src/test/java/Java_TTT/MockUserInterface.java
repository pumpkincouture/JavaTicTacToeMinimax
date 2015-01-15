package Java_TTT;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MockUserInterface extends CommandLineInterface implements UserInterface {

    private List<String> nextMoves = new LinkedList<String>();
    private boolean displayWelcomePromptCalled = false;
    private boolean displayGamePieceAssignmentCalled = false;
    private boolean displayStartingPlayerCalled = false;
    private boolean displayUserPromptCalled = false;
    private boolean displayOpponentPrompt = false;
    private boolean displayComputerThinkingMessage = false;
    private boolean displayChosenOpponent = false;
    private boolean displayInvalidMoveMessageCalled = false;
    private boolean displayBoardCalled = false;
    private boolean winnerStringCalled = false;
    private boolean catsGameCalled = false;

    public MockUserInterface(PrintStream out, Scanner in) {
        super(out, in);
    }
    public void addNextMove(String move) {
        nextMoves.add(move);
    }

    public String captureChoice() {
        return nextMoves.remove(0);
    }

    public void printWelcomeMessage() {
        displayWelcomePromptCalled = true;
    }

    public void printGamePieceAssignment(String onePiece, String playerOnePiece, String playerTwoPiece) {
        displayGamePieceAssignmentCalled = true;
    }

    public void printComputerThinking() {
        displayComputerThinkingMessage = true;
    }

    public void printChosenOpponent(String opponentName) {
        displayChosenOpponent = true;
    }

    public void  printStartingPlayer(String gamePiece) {
        displayStartingPlayerCalled = true;
    }

    public void promptForOpponent() {
        displayOpponentPrompt = true;
    }

    public void printUserPrompt(String playerName, String gamePiece) {
        displayUserPromptCalled = true;
    }

    public void printError(String choice) {
        displayInvalidMoveMessageCalled = true;
    }

    public void printBoard(String[] boardCells) {
        displayBoardCalled = true;
    }

    public void printWinner(String gamePiece) {
        winnerStringCalled = true;
    }

    public void printCatsGame() {
        catsGameCalled = true;
    }

    public boolean isWelcomeMessageCalled() {
        return displayWelcomePromptCalled;
    }

    public boolean isGamePieceMessageCalled() {
        return displayGamePieceAssignmentCalled;
    }

    public boolean isStartingPlayerCalled() {
        return displayStartingPlayerCalled;
    }

    public boolean isComputerThinkingMessageCalled() {
        return displayComputerThinkingMessage;
    }

    public boolean isDisplayBoardCalled() {
        return displayBoardCalled;
    }

    public boolean isUserPromptCalled() {
        return displayUserPromptCalled;
    }

    public boolean isDisplayInvalidMoveMessageCalled() {
        return displayInvalidMoveMessageCalled;
    }

    public boolean isWinnerStringCalled() {
        return winnerStringCalled;
    }

    public boolean isCatsGameCalled() {
        return catsGameCalled;
    }
}