package Java_TTT;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandLineInterfaceTest {
    private ByteArrayOutputStream printedToScreen = new ByteArrayOutputStream();
    private UserInterface ui;
    private Scanner input = new Scanner("3");
    private Board board;
    private PrintStream output = new PrintStream(printedToScreen);

    @Before
    public void setUp() {
        this.ui = new CommandLineInterface(output, input);
        this.board = new Board(3);
    }

    @Test
    public void printToScreenTest() {
        ui.printMessage("hello");
        assertEquals("hello\n", printedToScreen.toString());
    }

    @Test
    public void printWelcomeMessageTest() {
        ui.printWelcomeMessage();
        assertEquals("Welcome to Tic Tac Toe! The first player to get 3 in a row wins!\n", printedToScreen.toString());
    }

    @Test
    public void printComputerThinkingAboutAMove() {
        ui.printComputerThinking();
        assertEquals("Computer is considering a move....\n", printedToScreen.toString());
    }

    @Test
    public void printChooseStartingPlayerPrompt() {
        ui.chooseStartingPlayer();
        assertEquals("Please choose the starting player : yourself, or your opponent (please enter 'y' to indicate yourself and 'o' to indicate your opponent)\n", printedToScreen.toString());
    }

    @Test
    public void printChosenOpponentTest() {
        ui.printChosenOpponent("ComputerOpponent");
        assertEquals("You've chosen to play against ComputerOpponent.\n", printedToScreen.toString());
    }

    @Test
    public void printGamePieceAssignmentTest() {
        ui.printGamePieceAssignment("ComputerOpponent", "$", "HumanOpponent", "#");
        assertEquals("ComputerOpponent will have the $ piece and HumanOpponent will have the # piece.\n", printedToScreen.toString());
    }

    @Test
    public void printStartingPlayerMessage() {
        ui.printStartingPlayer("X");
        assertEquals("Player with X will start.\n", printedToScreen.toString());
    }

    @Test
    public void getChosenInputMove() {
        Scanner input = new Scanner("4\n");
        String choice = input.nextLine();
        ui.captureChoice();
        assertEquals(choice, "4");
    }

    @Test
    public void printPromptForOpponentMessage() {
        ui.promptForOpponent();
        assertEquals("Please choose your opponent : press 'h' for human, 'c' for computer, or 'i' for AI computer.\n", printedToScreen.toString());
    }

    @Test
    public void printUserPromptMessage() {
        ui.printUserPrompt("X");
        assertEquals("Please choose a move for your X by pressing a number for that corresponding space.\n", printedToScreen.toString());
    }

    @Test
    public void printWinnerMessage() {
        ui.printWinner("O");
        assertEquals("O wins!\n", printedToScreen.toString());
    }

    @Test
    public void printCatsGameMessage() {
        ui.printCatsGame();
        assertEquals("Cat's game!\n", printedToScreen.toString());
    }

    @Test
    public void printErrorMessage() {
        ui.printError("hhhhhh");
        assertEquals("hhhhhh is not available, please try again.\n", printedToScreen.toString());
    }

    @Test
    public void printBoard() {
        ui.printBoard(board.getBoardCells());
        assertEquals(" |  | \n" +
                     "-------\n" +
                     " |  | \n" +
                     "-------\n" +
                     " |  | \n" +
                     "\n", printedToScreen.toString());
    }
}
