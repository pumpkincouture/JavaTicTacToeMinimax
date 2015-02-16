package Java_TTT;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game gameTest;
    private Board board;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private PlayerInterface player1 = new HumanPlayer("X", mockUi);
    private PlayerInterface player2 = new HumanPlayer("O", mockUi);
    private GameScorer gameScorer;

    private void fillBoard(String choice, String gamePiece) {
        board.placeMove(choice, gamePiece);
    }

    private boolean getCell(String answer, String gamePiece) {
        if (board.getCells()[convertAnswerToInteger(answer) - 1] == gamePiece) {
            return true;
        }
        return false;
    }

    private int convertAnswerToInteger(String answer) {
        return Integer.parseInt(answer);
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
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        gameTest.printIntro();
        assertEquals(true, mockUi.isWelcomeMessageCalled());
        assertEquals(true, mockUi.isUserPromptCalled());
        assertEquals(true, mockUi.isStartingPlayerCalled());
        assertEquals(true, mockUi.isGamePieceMessageCalled());
    }

    @Test
    public void getInitialBoardDisplay() {
        board = new Board(3);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        mockUi.printBoard(board);
        assertEquals(true, mockUi.isDisplayBoardCalled());
    }

    @Test
    public void promptUntilMoveValidOn3x3Board() {
        board = new Board(3);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        mockUi.addNextMove("PPP");
        mockUi.addNextMove("hehhghntnt");
        mockUi.addNextMove("3");

        setCurrentPlayer(player1);

        gameTest.getPlayerChoice(gameTest.getCurrentPlayer(), mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
        fillBoard("3", "X");
        assertEquals(true, getCell("3", "X"));
    }

    @Test
    public void promptUntilMoveValidOn4x4Board() {
        board = new Board(4);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        mockUi.addNextMove("hhhhhhhhh");
        mockUi.addNextMove("ACDC");
        mockUi.addNextMove("15");

        setCurrentPlayer(player1);

        gameTest.getPlayerChoice(gameTest.getCurrentPlayer(), mockUi.captureChoice());

        assertEquals(true, mockUi.isDisplayInvalidChoiceMessageCalled());
        fillBoard("15", "X");
        assertEquals(true, getCell("15", "X"));
    }

    @Test
    public void testIfCurrentPlayerIsPlayerWithX() {
        board = new Board(3);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        setCurrentPlayer(player1);

        assertEquals("X", gameTest.getCurrentPlayer().getGamePiece());
    }

    @Test
    public void switchPlayersAndTestIfPlayerWithOIsSetAsCurrentPlayer() {
        board = new Board(3);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        setCurrentPlayer(player1);
        switchPlayers();

        assertEquals("O", gameTest.getCurrentPlayer().getGamePiece());
    }

    @Test
    public void testForWinnerOn3x3Board() {
        board = new Board(3);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        mockUi.addNextMove("1");
        mockUi.addNextMove("2");
        mockUi.addNextMove("3");

        for (int i = 0; i <= 2; i++) {
            fillBoard(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameScorer.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isWinnerStringCalled());
    }

    @Test
    public void testForWinnerScenarioTwo3x3() {
        board = new Board(3);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        fillBoard("1", "X");
        fillBoard("2", "O");
        fillBoard("3", "O");
        fillBoard("5", "O");
        fillBoard("7", "X");

        gameTest.printGameWinner(gameScorer.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(false, mockUi.isWinnerStringCalled());
    }


    @Test
    public void testForWinner() {
        board = new Board(4);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        mockUi.addNextMove("1");
        mockUi.addNextMove("2");
        mockUi.addNextMove("3");
        mockUi.addNextMove("4");

        for (int i = 0; i <= 3; i++) {
            fillBoard(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameScorer.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isWinnerStringCalled());
    }



    @Test
    public void testForCatsGameOn3x3Board() {
        board = new Board(3);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("5", "X");
        fillBoard("6", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");


        gameTest.printGameWinner(gameScorer.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isCatsGameCalled());
    }

    @Test
    public void check4x4BoardForCatsGameScenarioFour() {
        board = new Board(4);
        gameScorer = new GameScorer(board);
        gameTest = new Game(player1, player2, board, mockUi, gameScorer);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("5", "X");
        fillBoard("6", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");
        fillBoard("10", "O");
        fillBoard("11", "X");
        fillBoard("12", "X");
        fillBoard("13", "X");
        fillBoard("14", "O");
        fillBoard("15", "O");
        fillBoard("16", "O");

        gameTest.printGameWinner(gameScorer.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isCatsGameCalled());
    }
}