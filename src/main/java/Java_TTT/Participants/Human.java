package Java_TTT.participants;

import Java_TTT.ui.UserInterface;

public class Human extends Participant {
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
