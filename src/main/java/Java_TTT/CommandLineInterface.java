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

    private void printBoard(String string) {
        out.print(string);
    }

    public void printMessage(String string) {
        out.println(string);
    }

    public void chooseGameConfiguration() {
        printMessage("Welcome, please choose your desired game configuration.\n" +
                "1 : Human vs Human Player \n" +
                "2 : Human vs Basic Computer Player \n" +
                "3 : Human vs AI Computer Player \n" +
                "4 : Basic Computer Player vs AI Computer Player");
    }

    public void printWelcomeMessage() {
        printMessage("Welcome to Tic Tac Toe! The first player to get 3 in a row wins!");
    }

    public void chooseStartingPlayer(String player1, String player2) {
        printMessage("Please choose the starting player : " + player1 + " or " + player2 +
                " (please enter 1 to indicate " + player1 + " or 2 to indicate " + player2 + ")");
    }

    public void printChosenOpponent(String opponentName) {
        printMessage("You've chosen to play against " + opponentName + ".");
    }

    public void printComputerThinking() {
        printMessage("Computer is considering a move....");
    }

    public void printGamePieceAssignment(PlayerInterface player1, PlayerInterface player2) {
        printMessage(player1.getName() + " will have the " + player1.getGamePiece() + " piece and " + player2.getName() + " will have the " + player2.getGamePiece() + " piece.");
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

    public void printUserPrompt() {
        printMessage("Please choose a move for your game piece by pressing a number for that corresponding space.");
    }

    public void printChoice(PlayerInterface player, String choice) {
        printMessage(player.getName() + " has chosen space " + choice + "!");
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

    public void printBoard(Board board) {
        printTopRow(board.getCells());
        printLines();
        printMiddleRow(board.getCells());
        printLines();
        printBottomRow(board.getCells());
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
}