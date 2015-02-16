package Java_TTT;

public class Game {
    private PlayerInterface player1;
    private PlayerInterface player2;
    private Board board;
    private CommandLineInterface userinterface;
    private GameScorer gameScorer;
    private PlayerInterface currentPlayer;

    public Game(PlayerInterface player1, PlayerInterface player2, Board board, CommandLineInterface userinterface, GameScorer gameScorer) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.userinterface = userinterface;
        this.gameScorer = gameScorer;
    }

    public void start() {
        printIntro();
        playGame();
        printGameWinner(gameScorer.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        userinterface.printBoard(board);
    }

    public boolean playGame() {
        currentPlayer = player1;
        while(board.hasOpenSpaces()) {
            getPlayerMove(currentPlayer);
            if (gameScorer.isThereAWinner(currentPlayer.getGamePiece()) || !board.hasOpenSpaces()) {
                return false;
            }
            switchPlayers();
        }
        return true;
    }

    public void getPlayerMove(PlayerInterface player) {
        userinterface.printBoard(board);
        getPlayerChoice(player, player.getMove());
    }

    public void getPlayerChoice(PlayerInterface player, String choice) {
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
        userinterface.printWelcomeMessage(board.getCellsSquareRoot(board.getLength()));
        userinterface.printGamePieceAssignment(player1, player2);
    }

    public PlayerInterface getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerInterface player) {
        currentPlayer = player;
    }

    public void printGameWinner(String gamePiece) {
        if (gamePiece.isEmpty()) {
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