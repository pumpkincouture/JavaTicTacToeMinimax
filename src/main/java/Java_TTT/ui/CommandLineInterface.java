package Java_TTT.ui;

import Java_TTT.boards.Board;
import Java_TTT.participants.Participant;

import java.io.PrintStream;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface {
    private PrintStream out;
    private Scanner scannerIn;

    public CommandLineInterface(PrintStream out, Scanner in) {
        this.out = out;
        this.scannerIn = in;
    }

    private void printLinesForBoard(String string) {
        out.print(string);
    }

    public void printWithoutLineBreak(String string) {
        out.print(string);
    }
    public void printMessage(String string) {
        out.println(string);
    }

    public void chooseGameConfiguration() {
        printWithoutLineBreak("Welcome, please choose your desired player configuration.\n" +
                "1 : Human vs Human\n" +
                "2 : Human vs SimpleAI\n" +
                "3 : Human vs HardAI\n" +
                "4 : SimpleAI vs HardAI\n" +
                "Configuration choice: ");
    }

    public void promptForBoardSize() {
       printWithoutLineBreak("Please pick your board size (3, 4): ");
    }

    public void printWelcomeMessage(int boardSize) {
        printMessage("Welcome to Tic Tac Toe! The first player to get " + boardSize + " in a row wins!");
    }

    public void chooseStartingPlayer(int playerConfigChoice) {
        switch (playerConfigChoice) {
            case 1:
                printWithoutLineBreak("Please choose the starting player (1 for Human, 2 for Human):");
                break;
            case 2:
                printWithoutLineBreak("Please choose the starting player (1 for Human, 2 for SimpleAI):");
                break;
            case 3:
                printWithoutLineBreak("Please choose the starting player (1 for Human, 2 for HardAI):");
                break;
            case 4:
                printWithoutLineBreak("Please choose the starting player (1 for SimpleAI, 2 for HardAI):");
                break;
        }

    }

    public void printGamePieceAssignment(Participant player1, Participant player2) {
        printMessage(player1.getName() + " will have the " + player1.getGamePiece() + " piece and " + player2.getName() + " will have the " + player2.getGamePiece() + " piece. " + player1.getGamePiece() + " will start. Please indicate your chosen space with a number.");
    }

    public String captureChoice() {
        return scannerIn.next();
    }

    public void printChoice(Participant player, String choice) {
        printMessage(player.getName() + " has chosen space " + choice + ".");
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
        int boardSquareRoot = board.getCellsSquareRoot();
        int boardLength = board.getLength();
        String boardToDisplay = boardRows(boardSquareRoot);

        for (int i=0; i < boardLength; i++) {
            boardToDisplay += "| " + board.getCells()[i] + " ";
            if (i % boardSquareRoot == boardSquareRoot - 1) {
                boardToDisplay += "|" + boardRows(boardSquareRoot);
            }
        }
        printLinesForBoard(boardToDisplay);
    }

    private String boardRows(int squareRoot) {
            String rowsToDisplay = "\n";
            for(int i=0; i<squareRoot; i++) {
                rowsToDisplay += "----";
            }
            rowsToDisplay += "\n";
            return rowsToDisplay;
    }
}