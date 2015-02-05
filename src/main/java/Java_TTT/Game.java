package Java_TTT;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private CommandLineInterface userinterface;
    private GameScorer gameScorer;

    public Game(Player player1, Player player2, Board board, CommandLineInterface userinterface, GameScorer gameScorer) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.userinterface = userinterface;
        this.gameScorer = gameScorer;
    }

    public void startGame() {
        playGame();
        printGameWinner(getWinnerName(firstPlayerPiece(), secondPlayerPiece()));
        displayBoard();
    }

    private boolean playGame() {
        printIntro();
        while (boardHasOpenSpaces()) {
            getFirstMove(player1.getGamePiece());
            if (thereIsAWinner(firstPlayerPiece()) || !boardHasOpenSpaces()) {
                return false;
            }
            getSecondMove(player2.getGamePiece());
            if (thereIsAWinner(secondPlayerPiece())) {
                return false;
            }
        }
        return true;
    }

    public void getFirstMove(String firstPlayer) {
        printPlayerPrompt(firstPlayer);
        displayBoard();
        String choice = player1.getMove();
        if (isInvalidMove(choice)) {
            printChoiceError(choice);
            getFirstMove(firstPlayer);
        } else {
            placeMoveOnBoard(choice, firstPlayerPiece());
        }

    }

    public void getSecondMove(String secondPlayer) {
        printPlayerPrompt(secondPlayer);
        displayBoard();
        String choice = player2.getMove();
        if (isInvalidMove(choice)) {
            printChoiceError(choice);
            getSecondMove(secondPlayer);
        } else {
            placeMoveOnBoard(choice, secondPlayerPiece());
        }
    }

    public void displayBoard() {
        userinterface.printBoard(board.getBoardCells());
    }

    public void printPlayerPrompt(String gamePiece) {
        userinterface.printUserPrompt(gamePiece);
    }

    public String getWinnerName(String playerOne, String playerTwo) {
        return gameScorer.getWinningPlayer(playerOne, playerTwo);
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
        userinterface.printGamePieceAssignment(getPlayerName(player1), firstPlayerPiece(), getPlayerName(player2), secondPlayerPiece());
    }

    public void printStartingPlayer() {
        userinterface.printStartingPlayer(firstPlayerPiece());
    }

    public void printChoiceError(String move) {
        if (isInvalidMove(move)) {
            userinterface.printError(move);
        }
    }

    private String getPlayerName(Player player) {
        return player.getClass().getSimpleName();
    }

    private boolean isInvalidMove(String move) {
        return board.isMoveValid(move) == false;
    }

    private boolean thereIsAWinner(String gamePiece) {
        return gameScorer.isThereAWinner(gamePiece);
    }

    private boolean boardHasOpenSpaces() {
        return board.doesBoardHaveOpenSpaces();
    }

    private void placeMoveOnBoard(String answer, String gamePiece) {
        board.placeMove(answer, gamePiece);
    }
}