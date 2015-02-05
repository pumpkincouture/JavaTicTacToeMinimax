package Java_TTT;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private CommandLineInterface userinterface;
    private GameScorer gameScorer;
    private Player currentPlayer;

    public Game(Player player1, Player player2, Board board, CommandLineInterface userinterface, GameScorer gameScorer) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.userinterface = userinterface;
        this.gameScorer = gameScorer;
    }

    public void startGame() {
        printIntro();
        playGame();
        printGameWinner(getWinnerName(getPlayerPiece(player1), getPlayerPiece(player2)));
        displayBoard();
    }

    public boolean playGame() {
        currentPlayer = player1;
        while(boardHasOpenSpaces()) {
            getPlayerMove(currentPlayer);
            if (thereIsAWinner(getPlayerPiece(currentPlayer)) || !boardHasOpenSpaces()) {
                return false;
            }
            switchPlayers();
        }
        return true;
    }

    public void getPlayerMove(Player player) {
        displayBoard();
        getPlayerChoice(player, player.getMove());
    }

    public void getPlayerChoice(Player player, String choice) {
        if (isInvalidMove(choice)) {
            printChoiceError(choice);
            getPlayerMove(currentPlayer);
        }
        else {
            placeMoveOnBoard(choice, getPlayerPiece(player));
            userinterface.printChoice(player, choice);
        }
    }

    public void printIntro() {
        printWelcome();
        printGamePieces();
        printStartingPlayer();
        printPlayerPrompt();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    public void displayBoard() {
        userinterface.printBoard(board.getBoardCells());
    }

    public void printPlayerPrompt() {
        userinterface.printUserPrompt();
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

    public void printWelcome() {
        userinterface.printWelcomeMessage();
    }

    public void printGamePieces() {
        userinterface.printGamePieceAssignment(getPlayerName(player1), getPlayerPiece(player1), getPlayerName(player2), getPlayerPiece(player2));
    }

    public void printStartingPlayer() {
        userinterface.printStartingPlayer(getPlayerPiece(player1));
    }

    public void printChoiceError(String move) {
        if (isInvalidMove(move)) {
            userinterface.printError(move);
        }
    }

    private String getPlayerName(Player player) {
        return player.getClass().getSimpleName();
    }

    private String getPlayerPiece(Player player) {
        return player.getGamePiece();
    }


    private void switchPlayers() {
        if (currentPlayer == player1) {
            setCurrentPlayer(player2);
        } else {
            setCurrentPlayer(player1);
        }
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