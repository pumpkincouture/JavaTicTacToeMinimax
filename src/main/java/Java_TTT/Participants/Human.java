package Java_TTT.participants;

import Java_TTT.ui.CommandLineInterface;
import Java_TTT.participants.GameParticipants;
import Java_TTT.participants.Participant;

public class Human extends Participant implements GameParticipants {
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
