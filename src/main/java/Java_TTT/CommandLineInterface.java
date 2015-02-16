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

    private void printLinesForBoard(String string) {
        out.print(string);
    }

    public void printMessage(String string) {
        out.println(string);
    }

    public void chooseGameConfiguration() {
        printMessage("Welcome, please choose your desired player configuration.\n" +
                "1 : Human vs Human\n" +
                "2 : Human vs Computer\n" +
                "3 : Human vs AI\n" +
                "4 : Computer vs AI");
    }

    public void promptForBoardSize() {
        printMessage("Please pick between 3 and 4 for your board size.");
    }

    public void printWelcomeMessage(int boardSize) {
        printMessage("Welcome to Tic Tac Toe! The first player to get " + boardSize + " in a row wins!");
    }

    public void chooseStartingPlayer(String player1, String player2) {
        printMessage("Please choose the starting player : enter 1 for " + player1 + " or 2 for " + player2);
    }

    public void printComputerThinking() {
        printMessage("Computer is considering a move....");
    }

    public void printGamePieceAssignment(PlayerInterface player1, PlayerInterface player2) {
        printMessage(player1.getName() + " will have the " + player1.getGamePiece() + " piece and " + player2.getName() + " will have the " + player2.getGamePiece() + " piece. " + player1.getGamePiece() + " will start.");
    }

    public String captureChoice() {
        return in.nextLine();
    }

    public void printChoice(PlayerInterface player, String choice) {
        printMessage(player.getName() + " has chosen space " + choice);
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
        int boardSquareRoot = board.getCellsSquareRoot(board.getLength());
        for (int i = 0; i < board.getLength(); i++) {
            if (i % boardSquareRoot == boardSquareRoot - 1 ) {
                printLinesForBoard(board.getCells()[i]);
                printLines();
            } else {
                printLinesForBoard(board.getCells()[i] + " | ");
            }
        }
    }

    private void printLines() {
        printLinesForBoard("\n");
        printLinesForBoard("----------");
        printLinesForBoard("\n");
    }
}