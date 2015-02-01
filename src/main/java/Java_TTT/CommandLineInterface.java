package Java_TTT;

import java.io.PrintStream;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface {
    private PrintStream out;
    private Scanner in;

    public CommandLineInterface(PrintStream out, Scanner in) {
        this.out = out;
        this.in = in;
    }

    public void printBoard(String string) {
        out.print(string);
    }

    public void printWelcomeMessage() {
        printMessage("Welcome to Tic Tac Toe! The first player to get 3 in a row wins!");
    }

    public void printChosenOpponent(String opponentName) {
        printMessage("You've chosen to play against " + opponentName + ".");
    }

    public void printGamePieceAssignment(String playerOnePiece, String opponentName, String playerTwoPiece) {
        printMessage("Player 1 will have the " + playerOnePiece + " piece and " + opponentName + " will have the " + playerTwoPiece + " piece.");
    }

    public void printStartingPlayer(String gamePiece) {
        printMessage("Player with " + gamePiece + " will start.");
    }

    public String captureChoice() {
        return in.nextLine();
    }

    public void promptForOpponent() {
        printMessage("Please choose your opponent : press 'h' for human, 'c' for computer, or 'i' for AI computer.");
    }

    public void printUserPrompt(String gamePiece) {
        printMessage("Please choose a move for your " + gamePiece + " by pressing a number for that corresponding space.");
    }

    public void printWinner(String gamePiece) {
        printMessage(gamePiece + " wins!");
    }

    public void printCatsGame() {
        printMessage("Cat's game!");
    }

    public void printError(String choice) {
        printMessage(choice + " is not available, please try again.");
    }

    public void printBoard(String[] boardCells) {
        printTopRow(boardCells);
        printLines();
        printMiddleRow(boardCells);
        printLines();
        printBottomRow(boardCells);
        printMessage("\n");
    }

    private void printTopRow(String[] boardCells) {
        printBoard(boardCells[0] + " | ");
        printBoard(boardCells[1] + " | ");
        printBoard(boardCells[2]);
    }

    private void printMiddleRow(String[] boardCells) {
        printBoard(boardCells[3] + " | ");
        printBoard(boardCells[4] + " | ");
        printBoard(boardCells[5]);
    }

    private void printBottomRow(String[] boardCells) {
        printBoard(boardCells[6] + " | ");
        printBoard(boardCells[7] + " | ");
        printBoard(boardCells[8]);
    }

    private void printLines() {
        printBoard("\n");
        printBoard("-------");
        printBoard("\n");
    }

    public void printMessage(String string) {
        out.println(string);
    }
}
