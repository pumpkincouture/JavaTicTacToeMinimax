package Java_TTT;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private CommandLineInterface userinterface;
    private GameScorer gameScorer;
    private List<Player> positionsOfPlayers;


    public Game(Player player1, Player player2, Board board, CommandLineInterface userinterface, GameScorer gameScorer) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.userinterface = userinterface;
        this.gameScorer = gameScorer;
    }

    public void startGame() {
        userinterface.chooseStartingPlayer();
        findStartingPlayer();
        playGame();
        printGameWinner(getWinnerName(firstPlayerPiece(), secondPlayerPiece()));
        displayBoard();
    }

    public List<Player> findStartingPlayer() {
        validateStartingPlayer(captureStartingPlayerChoice());
        return accessFirstAndSecondPlayers();
    }

    public List<Player> accessFirstAndSecondPlayers() {
        return positionsOfPlayers;
    }

    public String captureStartingPlayerChoice() {
        return userinterface.captureChoice();
    }

    public void validateStartingPlayer(String startingPlayerChoice) {
        String capitalizedChoice = startingPlayerChoice.toUpperCase();
        List<Player> playerPositions = new ArrayList<>();


        switch (capitalizedChoice) {
            case "O":
                playerPositions.add(player2);
                playerPositions.add(player1);
                positionsOfPlayers = playerPositions;
                break;
            case "Y":
                playerPositions.add(player1);
                playerPositions.add(player2);
                positionsOfPlayers = playerPositions;
                break;
            default:
                userinterface.printError(capitalizedChoice);
                userinterface.chooseStartingPlayer();
                validateStartingPlayer(captureStartingPlayerChoice());
        }
    }


    private boolean playGame() {
        printIntro();
        while (boardHasOpenSpaces()) {
            getFirstMove(positionsOfPlayers.get(0).getGamePiece());
            if (thereIsAWinner(firstPlayerPiece()) || !boardHasOpenSpaces()) {
                return false;
            }
            getSecondMove(positionsOfPlayers.get(1));
            if (thereIsAWinner(secondPlayerPiece())) {
                return false;
            }
        }
        return true;
    }

    public void getFirstMove(String firstPlayer) {
        printPlayerPrompt(firstPlayerPiece());
        displayBoard();
        String choice = positionsOfPlayers.get((0)).getMove();
        if (isInvalidMove(choice)) {
            printChoiceError(choice);
            getFirstMove(firstPlayer);
        } else {
            placeMoveOnBoard(choice, firstPlayerPiece());
        }


    }

    public void getSecondMove(Player secondPlayer) {
        printPlayerPrompt(secondPlayer.getGamePiece());
        displayBoard();
        String choice = secondPlayer.getMove();
        if (isInvalidMove(choice)) {
            printChoiceError(choice);
            getSecondMove(positionsOfPlayers.get(1));
        } else {
            placeMoveOnBoard(choice, secondPlayerPiece());
        }
    }

    public String getWinnerName(String playerOne, String playerTwo) {
        return gameScorer.getWinningPlayer(playerOne, playerTwo);
    }

    public void printPlayerPrompt(String gamePiece) {
        userinterface.printUserPrompt(gamePiece);
    }

    public void printGameWinner(String gamePiece) {
        if (gamePiece.isEmpty()) {
            userinterface.printCatsGame();
        } else {
            userinterface.printWinner(gamePiece);
        }
    }

    public String firstPlayerPiece() {
        return player1.getGamePiece();
    }

    public String secondPlayerPiece() {
        return player2.getGamePiece();
    }

    public void printIntro() {
        printWelcome();
        printGamePieces();
        printStartingPlayer();
    }

    public void printWelcome() {
        userinterface.printWelcomeMessage();
    }

    public void printGamePieces() {
        userinterface.printGamePieceAssignment(firstPlayerPiece(), player2.getClass().getSimpleName(), secondPlayerPiece());
    }

    public void printStartingPlayer() {
        userinterface.printStartingPlayer(firstPlayerPiece());
    }

    public void printChoiceError(String move) {
        if (isInvalidMove(move)) {
            userinterface.printError(move);
        }
    }

    public boolean isInvalidMove(String move) {
        return board.isMoveValid(move) == false;
    }

    public boolean thereIsAWinner(String gamePiece) {
        return gameScorer.isThereAWinner(gamePiece);
    }

    public boolean boardHasOpenSpaces() {
        return board.isBoardOpen();
    }

    public void displayBoard() {
        userinterface.printBoard(board.getBoardCells());
    }

    public void placeMoveOnBoard(String answer, String gamePiece) {
        board.placeMove(answer, gamePiece);
    }
}