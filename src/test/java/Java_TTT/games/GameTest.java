package Java_TTT.games;

import Java_TTT.ui.MockUserInterface;
import Java_TTT.boards.TTTBoard;
import Java_TTT.participants.GameParticipants;
import Java_TTT.participants.human.Human;
import Java_TTT.rules.TTTBoardRules;
import Java_TTT.rules.FourByFourBoardRules;
import Java_TTT.rules.ThreeByThreeBoardRules;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game gameTest;
    private TTTBoard board;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private GameParticipants player1 = new Human("X", mockUi);
    private GameParticipants player2 = new Human("O", mockUi);
    private TTTBoardRules boardRules;

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

    private void setCurrentPlayer(GameParticipants player) {
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
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
        gameTest.printIntro();
        assertEquals(true, mockUi.isWelcomeMessageCalled());
        assertEquals(true, mockUi.isGamePieceMessageCalled());
    }

    @Test
    public void getInitialBoardDisplay() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
        mockUi.printBoard(board);
        assertEquals(true, mockUi.isDisplayBoardCalled());
    }

    @Test
    public void promptUntilMoveValidOn3x3Board() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
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
        board = new TTTBoard(4);
        boardRules = new FourByFourBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
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
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
        setCurrentPlayer(player1);

        assertEquals("X", gameTest.getCurrentPlayer().getGamePiece());
    }

    @Test
    public void switchPlayersAndTestIfPlayerWithOIsSetAsCurrentPlayer() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
        setCurrentPlayer(player1);
        switchPlayers();

        assertEquals("O", gameTest.getCurrentPlayer().getGamePiece());
    }

    @Test
    public void testForWinnerOn3x3Board() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
        mockUi.addNextMove("1");
        mockUi.addNextMove("2");
        mockUi.addNextMove("3");

        for (int i = 0; i <= 2; i++) {
            fillBoard(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(boardRules.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isWinnerStringCalled());
    }

    @Test
    public void testForWinnerScenarioTwo3x3() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
        fillBoard("1", "X");
        fillBoard("2", "O");
        fillBoard("3", "O");
        fillBoard("5", "O");
        fillBoard("7", "X");

        gameTest.printGameWinner(boardRules.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(false, mockUi.isWinnerStringCalled());
    }


    @Test
    public void testForWinner() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
        mockUi.addNextMove("1");
        mockUi.addNextMove("2");
        mockUi.addNextMove("3");
        mockUi.addNextMove("4");

        for (int i = 0; i <= 3; i++) {
            fillBoard(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(boardRules.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isWinnerStringCalled());
    }

    @Test
    public void testForCatsGameOn3x3Board() {
        board = new TTTBoard(3);
        boardRules = new ThreeByThreeBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("5", "X");
        fillBoard("6", "X");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");


        gameTest.printGameWinner(boardRules.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isCatsGameCalled());
    }

    @Test
    public void check4x4BoardForCatsGameScenarioFour() {
        board = new TTTBoard(4);
        boardRules = new FourByFourBoardRules(board);
        gameTest = new Game(player1, player2, board, mockUi, boardRules);
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

        gameTest.printGameWinner(boardRules.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isCatsGameCalled());
    }
}