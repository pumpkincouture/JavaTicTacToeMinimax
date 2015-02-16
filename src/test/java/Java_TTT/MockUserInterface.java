package Java_TTT;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MockUserInterface extends CommandLineInterface implements UserInterface {

    private List<String> nextMoves = new LinkedList<String>();
    private boolean displayGameOptions = false;
    private boolean displayComputerThinking = false;
    private boolean displayPlayersChoiceMessage = false;
    private boolean displayBoardSizePrompt = false;
    private boolean displayWelcomePromptCalled = false;
    private boolean displayGamePieceAssignmentCalled = false;
    private boolean displayChooseStartingPlayerCalled = false;
    private boolean displayInvalidMoveMessageCalled = false;
    private boolean displayBoardCalled = false;
    private boolean winnerStringCalled = false;
    private boolean catsGameCalled = false;

    public MockUserInterface(PrintStream out, Scanner in) {
        super(out, in);
    }

    public void addNextMove(String move) {nextMoves.add(move);
    }

    public String captureChoice() {
        return nextMoves.remove(0);
    }

    public void promptForBoardSize() {
        displayBoardSizePrompt = true;
    }

    public void printWelcomeMessage(int boardSize) {
        displayWelcomePromptCalled = true;
    }

    public void chooseStartingPlayer(String player1, String player2) {
        displayChooseStartingPlayerCalled = true;
    }

    public void chooseGameConfiguration() { displayGameOptions = true;
    }

    public void printChoice(PlayerInterface player, String choice) {
        displayPlayersChoiceMessage = true;
    };

    public void printComputerThinking() {
        displayComputerThinking = true;
    };

    public void printGamePieceAssignment(PlayerInterface player1, PlayerInterface player2) {
        displayGamePieceAssignmentCalled = true;
    }

    public void printError(String choice) {
        displayInvalidMoveMessageCalled = true;
    }

    public void printBoard(Board board) {
        displayBoardCalled = true;
    }

    public void printWinner(String gamePiece) {
        winnerStringCalled = true;
    }

    public void printCatsGame() {
        catsGameCalled = true;
    }

    public boolean areGameConfigOptionsCalled() {
        return displayGameOptions;
    }

    public boolean isComputerThinkingCalled() {
        return displayComputerThinking;
    }

    public boolean isBoardSizePromptCalled() {
        return displayBoardSizePrompt;
    }

    public boolean isWelcomeMessageCalled() {
        return displayWelcomePromptCalled;
    }

    public boolean isGamePieceMessageCalled() {
        return displayGamePieceAssignmentCalled;
    }

    public boolean isStartingPlayerMessageCalled() {
        return displayChooseStartingPlayerCalled;
    }

    public boolean isDisplayBoardCalled() {
        return displayBoardCalled;
    }

    public boolean isDisplayInvalidChoiceMessageCalled() {
        return displayInvalidMoveMessageCalled;
    }

    public boolean isWinnerStringCalled() {
        return winnerStringCalled;
    }

    public boolean isCatsGameCalled() {
        return catsGameCalled;
    }
}