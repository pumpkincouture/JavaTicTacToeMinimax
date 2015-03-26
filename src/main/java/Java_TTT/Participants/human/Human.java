package Java_TTT.participants.human;

import Java_TTT.participants.GameParticipants;
import Java_TTT.participants.Participant;
import Java_TTT.ui.UserInterface;

public class Human extends Participant implements GameParticipants {
    private UserInterface ui;

    public Human(String gamePiece, UserInterface ui) {
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
