package story.keep.halls.upstairs;

import model.AbstractEncounter;

public final class GotCaughtEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("As you contemplate whether to go into the door or continue walking,\n");
        sb.append("a bandit comes up the stairs.\n");
        sb.append("He sees you standing at the door, as you are about to walk away.\n");
        sb.append("\n");
        sb.append("Bandit: That is the chief bandit's room!\n");
        sb.append("Bandit: You are forbidden to go into that room,\n");
        sb.append("and you are forbidden in this castle!\n");
        sb.append("\n");
        sb.append("The bandit charges at you, with his sword already out.\n");
        sb.append("The bandit takes you down before you have a chance to grab your weapon.\n");
        sb.append("You should have gone into that room!\n");
        hasDied = true;
        story = sb.toString();
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
