package Java_TTT;

public class Human extends Player implements PlayerInterface {
    private CommandLineInterface ui;

    public Human(String gamePiece, CommandLineInterface ui) {
        super(gamePiece);
        this.ui = ui;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getMove() {
        return ui.captureChoice();
    }
}
