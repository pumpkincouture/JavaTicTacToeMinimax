package Java_TTT;

public class Player implements MoveInterface {

    private String gamePiece;

    public Player(String gamePiece) {
        this.gamePiece = gamePiece;
    }

    public String getGamePiece() {
        return gamePiece;
    }

    @Override
    public String getMove(Board board) {
        return "";
    }
}
