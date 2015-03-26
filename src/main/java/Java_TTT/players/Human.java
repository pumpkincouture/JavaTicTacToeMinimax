package Java_TTT.players;

import Java_TTT.messages.UserInterface;

public class Human extends Player implements PlayerInterface {
    private UserInterface ui;

    public Human(String gamePiece, UserInterface ui) {
        super(gamePiece);
        this.ui = ui;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getMove() {
        return ui.captureChoice();
    }
}
