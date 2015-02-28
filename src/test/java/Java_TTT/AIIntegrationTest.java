package Java_TTT;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AIIntegrationTest {
    private Board board;
    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);
    private MockUserInterface mockUi = new MockUserInterface(output, input);
    private PlayerInterface player1;
    private PlayerInterface player2;
    private GameScorer gameScorer;
    private Game game;

    @Test
    public void gameWithTwoAIsFor3x3Board() {
        board = new Board(4);
        player1 = new AI("X", board, mockUi);
        player2 = new AI("O", board, mockUi);
        gameScorer = new GameScorer(board);
        game = new Game(player1, player2, board, mockUi, gameScorer);


        game.start();
        assertEquals(false, gameScorer.isThereAWinner("X"));
        assertEquals(false, gameScorer.isThereAWinner("O"));
        assertEquals(true, gameScorer.isGameOver("X", "O"));
    }

}
