package Java_TTT.games;

import Java_TTT.boards.BoardInterface;
import Java_TTT.participants.GameParticipants;
import Java_TTT.rules.TTTBoardRules;
import Java_TTT.ui.UserInterface;

public class Game {
    private GameParticipants player1;
    private GameParticipants player2;
    private BoardInterface board;
    private UserInterface userinterface;
    private TTTBoardRules boardRules;
    private GameParticipants currentPlayer;

    public Game(GameParticipants player1, GameParticipants player2, BoardInterface board, UserInterface userinterface, TTTBoardRules boardRules) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.userinterface = userinterface;
        this.boardRules = boardRules;
    }

    public void start() {
        printIntro();
        playGame();
        printGameWinner(boardRules.getWinningPlayer(player1.getGamePiece(), player2.getGamePiece()));
        userinterface.printBoard(board);
    }

    public boolean playGame() {
        currentPlayer = player1;
        while(board.hasOpenSpaces()) {
            getPlayerMove(currentPlayer);
            if (boardRules.isThereAWinner(currentPlayer.getGamePiece()) || !board.hasOpenSpaces()) {
                return false;
            }
            switchPlayers();
        }
        return true;
    }

    public void getPlayerMove(GameParticipants player) {
        userinterface.printBoard(board);
        getPlayerChoice(player, player.getMove());
    }

    public void getPlayerChoice(GameParticipants player, String choice) {
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

    public GameParticipants getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(GameParticipants player) {
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