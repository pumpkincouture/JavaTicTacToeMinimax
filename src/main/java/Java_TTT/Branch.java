package Java_TTT;

public class Branch {
    private final int score;
    private final int move;

    public Branch(int score, int move) {
        this.score = score;
        this.move = move;
    }

    public int getScore() {
        return score;
    }

    public int getMove() {
        return move;
    }
}
