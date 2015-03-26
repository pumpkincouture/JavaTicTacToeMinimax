package Java_TTT.participants;

import Java_TTT.messages.MockUserInterface;
import Java_TTT.boards.Board;
import Java_TTT.games.Game;
import Java_TTT.rules.GameRules;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AIIntegrationTest {
    private Board board;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private Participant player1;
    private Participant player2;
    private GameRules gameRules;
    private Game game;

    @Test
    public void gameWithTwoAIsFor4x4Board() {
        board = new Board(4);
        gameRules = new GameRules(board);
        player1 = new HardAI("X", gameRules, board, "O");
        player2 = new HardAI("O", gameRules, board, "X");
        game = new Game(player1, player2, board, mockUi, gameRules);
        int gameCounter = 0;

        for (int i = 0; i < 1000; i++) {
            gameCounter +=1;
            game.start();
        }

        assertEquals(1000, gameCounter);
        assertEquals("", gameRules.getBoardWinner());
        assertEquals(true, gameRules.isGameOver());
    }

    @Test
    public void gameWithTwoAIsFor3x3Board() {
        board = new Board(3);
        gameRules = new GameRules(board);
        player1 = new HardAI("X", gameRules, board, "O");
        player2 = new HardAI("O", gameRules, board, "X");
        game = new Game(player1, player2, board, mockUi, gameRules);
        int gameCounter = 0;

        for (int i = 0; i < 1000; i++) {
            gameCounter +=1;
            game.start();
        }

        assertEquals(1000, gameCounter);
        assertEquals("", gameRules.getBoardWinner());
        assertEquals(true, gameRules.isGameOver());
    }
}
