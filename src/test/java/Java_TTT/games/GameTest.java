package Java_TTT.games;

import Java_TTT.messages.MockUserInterface;
import Java_TTT.boards.Board;
import Java_TTT.players.Human;
import Java_TTT.players.PlayerInterface;
import Java_TTT.rules.GameRules;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game gameTest;
    private Board board;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private PlayerInterface player1 = new Human("X", mockUi);
    private PlayerInterface player2 = new Human("O", mockUi);
    private GameRules gameRules;


    private void addMovesToBoard(String... positions) {
        for (int counter = 0; counter < board.getLength(); counter++) {
            if (positions[counter] != "*") {
                board.placeMove(String.valueOf(counter + 1), positions[counter]);
            }
        }
    }

    private void setCurrentPlayer(PlayerInterface player) {
        gameTest.setCurrentPlayer(player);
    }

    private void switchPlayers() {
        if (gameTest.getCurrentPlayer() == player1) {
            setCurrentPlayer(player2);
        } else {
            setCurrentPlayer(player1);
        }
    }

    @Test
    public void displayWelcomeMessage() {
        board = new Board(3);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        gameTest.printIntro();
        assertEquals(true, mockUi.isWelcomeMessageCalled());
        assertEquals(true, mockUi.isGamePieceMessageCalled());
    }

    @Test
    public void getInitialBoardDisplay() {
        board = new Board(3);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        mockUi.printBoard(board);
        assertEquals(true, mockUi.isDisplayBoardCalled());
    }

    @Test
    public void promptUntilMoveValidOn3x3Board() {
        board = new Board(3);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        mockUi.addNextMove("PPP");
        mockUi.addNextMove("hehhghntnt");
        mockUi.addNextMove("3");

        setCurrentPlayer(player1);

        gameTest.getPlayerChoice(gameTest.getCurrentPlayer(), mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
        board.placeMove("3", "X");
        assertFalse(board.isMoveValid("3"));
    }

    @Test
    public void promptUntilMoveValidOn4x4Board() {
        board = new Board(4);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        mockUi.addNextMove("hhhhhhhhh");
        mockUi.addNextMove("ACDC");
        mockUi.addNextMove("15");

        setCurrentPlayer(player1);

        gameTest.getPlayerChoice(gameTest.getCurrentPlayer(), mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
        board.placeMove("15", "X");
        assertFalse(board.isMoveValid("15"));
    }

    @Test
    public void testIfCurrentPlayerIsPlayerWithX() {
        board = new Board(3);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        setCurrentPlayer(player1);

        assertEquals("X", gameTest.getCurrentPlayer().getGamePiece());
    }

    @Test
    public void switchPlayersAndTestIfPlayerWithOIsSetAsCurrentPlayer() {
        board = new Board(3);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        setCurrentPlayer(player1);
        switchPlayers();

        assertEquals("O", gameTest.getCurrentPlayer().getGamePiece());
    }

    @Test
    public void testForWinnerOn3x3Board() {
        board = new Board(3);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        mockUi.addNextMove("1");
        mockUi.addNextMove("2");
        mockUi.addNextMove("3");

        for (int i = 0; i <= 2; i++) {
            board.placeMove(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameRules.getBoardWinner());
        assertEquals(true, mockUi.isWinnerStringCalled());
    }

    @Test
    public void testForWinnerScenarioTwo3x3() {
        board = new Board(3);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        addMovesToBoard("X", "O", "O",
                        "*", "O", "*",
                        "X", "*", "*");

        gameTest.printGameWinner(gameRules.getBoardWinner());
        assertEquals(false, mockUi.isWinnerStringCalled());
    }

    @Test
    public void testForWinner() {
        board = new Board(3);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        mockUi.addNextMove("1");
        mockUi.addNextMove("2");
        mockUi.addNextMove("3");
        mockUi.addNextMove("4");

        for (int i = 0; i <= 3; i++) {
            board.placeMove(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameRules.getBoardWinner());
        assertEquals(true, mockUi.isWinnerStringCalled());
    }

    @Test
    public void testForCatsGameOn3x3Board() {
        board = new Board(3);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        addMovesToBoard("X", "X", "O",
                        "O", "X", "X",
                        "X", "O", "O");

        gameTest.printGameWinner(gameRules.getBoardWinner());
        assertEquals(true, mockUi.isCatsGameCalled());
    }

    @Test
    public void check4x4BoardForCatsGameScenarioFour() {
        board = new Board(4);
        gameRules = new GameRules(board);
        gameTest = new Game(player1, player2, board, mockUi, gameRules);
        addMovesToBoard("X", "X", "O", "O",
                        "X", "X", "X", "O",
                        "O", "O", "X", "X",
                        "X", "O", "O", "O");

        gameTest.printGameWinner(gameRules.getBoardWinner());
        assertEquals(true, mockUi.isCatsGameCalled());
    }
}