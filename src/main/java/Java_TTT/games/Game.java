package Java_TTT.games;

import Java_TTT.boards.Board;
import Java_TTT.participants.Participant;
import Java_TTT.rules.GameRules;
import Java_TTT.messages.UserInterface;

public class Game {
    private Participant player1;
    private Participant player2;
    private Board board;
    private UserInterface userinterface;
    private GameRules gameRules;
    private Participant currentPlayer;

    public Game(Participant player1, Participant player2, Board board, UserInterface userinterface, GameRules gameRules) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.userinterface = userinterface;
        this.gameRules = gameRules;
    }

    public void start() {
        printIntro();
        playGame();
        printGameWinner(gameRules.getBoardWinner());
        userinterface.printBoard(board);
    }

    public boolean playGame() {
        currentPlayer = player1;
        while(!board.isFull()) {
            getPlayerMove(currentPlayer);
            System.out.println(gameRules.getBoardWinner());
            if (!gameRules.getBoardWinner().isEmpty() || board.isFull()) {
                return false;
            }
            switchPlayers();
        }
        return true;
    }

    public void getPlayerMove(Participant player) {
        userinterface.printBoard(board);
        getPlayerChoice(player, player.getMove());
    }

    public void getPlayerChoice(Participant player, String choice) {
        if (!board.isMoveValid(choice)) {
            userinterface.printError(choice);
            getPlayerMove(currentPlayer);
        }
        else {
            board.placeMove(choice, player.getGamePiece());
            userinterface.printChoice(player, choice);
        }
    }

    public void printIntro() {
        userinterface.printWelcomeMessage(board.getCellsSquareRoot());
        userinterface.printGamePieceAssignment(player1, player2);
    }

    public Participant getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Participant player) {
        currentPlayer = player;
    }

    public void printGameWinner(String gamePiece) {
        if (gamePiece == "") {
            userinterface.printCatsGame();
        } else {
            userinterface.printWinner(gamePiece);
        }
    }

    private void switchPlayers() {
        if (currentPlayer == player1) {
            setCurrentPlayer(player2);
        } else {
            setCurrentPlayer(player1);
        }
    }
}