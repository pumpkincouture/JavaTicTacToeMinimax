package Java_TTT.players;

public abstract class Player {

    private String gamePiece;

    public Player(String gamePiece) {
        this.gamePiece = gamePiece;
    }

    public String getGamePiece() {
        return gamePiece;
    }
}
