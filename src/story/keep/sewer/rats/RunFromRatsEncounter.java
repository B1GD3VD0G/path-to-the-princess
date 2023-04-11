package story.keep.sewer.rats;

import model.AbstractEncounter;

public final class RunFromRatsEncounter extends AbstractEncounter {

    public RunFromRatsEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("You start running away from the rats.\n");
        sb.append("They hear you running and start chasing you.\n");
        sb.append("You keep running away until you forget where you are.\n");
        sb.append("You step on a giant rat trap and you can no longer move!\n");
        sb.append("The rats catch up with you and eat you.\n");
        story = sb.toString();
        hasDied = true;
    }

    @Override
    protected void setQuestion() {
        question = GAME_OVER;
    }

    @Override
    protected void setChoices() {
        addGameOverButtons();
    }
}
