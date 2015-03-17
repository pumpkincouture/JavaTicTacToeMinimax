package Java_TTT.participants;

public abstract class Participant {

    private String gamePiece;

    public Participant(String gamePiece) {
        this.gamePiece = gamePiece;
    }

    public String getGamePiece() {
        return gamePiece;
    }
}
