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
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private PlayerInterface player1 = new Human("X", mockUi);
    private PlayerInterface player2 = new Computer("O", board, mockUi);

    @Before
    public void setUp() {
        this.ui = new CommandLineInterface(output, input);
        this.board = new Board(3);
    }

    private String scannerInput(String mockInput) {
        Scanner input = new Scanner(mockInput);
        String choice = input.nextLine();
        return choice;
    }

    @Test
    public void printBoardChoicePrompt() {
        ui.promptForBoardSize();
        assertEquals("Please pick between 3 and 4 for your board size.\n", printedToScreen.toString());
    }

    @Test
    public void printOptionsForPlayerConfiguration() {
        ui.chooseGameConfiguration();
        assertEquals("Welcome, please choose your desired player configuration.\n" +
                "1 : Human vs Human\n" +
                "2 : Human vs Computer\n" +
                "3 : Human vs AI\n" +
                "4 : Computer vs AI\n", printedToScreen.toString());
    }

    @Test
    public void printWelcomeMessageTest() {
        ui.printWelcomeMessage(3);
        assertEquals("Welcome to Tic Tac Toe! The first player to get 3 in a row wins!\n", printedToScreen.toString());
    }

    @Test
    public void printComputerThinkingAboutAMove() {
        ui.printComputerThinking();
        assertEquals("Computer is considering a move....\n", printedToScreen.toString());
    }

    @Test
    public void printChooseStartingPlayerPrompt() {
        ui.chooseStartingPlayer("Computer", "Human");
        assertEquals("Please choose the starting player : enter 1 for Computer or 2 for Human\n", printedToScreen.toString());
    }

    @Test
    public void printGamePieceAssignmentTest() {
        ui.printGamePieceAssignment(player1, player2);
        assertEquals("Human will have the X piece and Computer will have the O piece. X will start.\n", printedToScreen.toString());
    }

    @Test
    public void getChosenInputMove() {
        scannerInput("4\n");
        ui.captureChoice();
        assertEquals(scannerInput("4\n"), "4");
    }

    @Test
    public void printMessageAfterUserChoseAMove() {
        ui.printChoice(player1, "3");
        assertEquals("Human has chosen space 3\n", printedToScreen.toString());
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
        ui.printBoard(board);
        assertEquals(" |  | \n" +
                "----------\n" +
                " |  | \n" +
                "----------\n" +
                " |  | \n" +
                "----------\n"
                , printedToScreen.toString());
    }
}