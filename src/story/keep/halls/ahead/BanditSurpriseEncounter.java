package story.keep.halls.ahead;

import model.AbstractEncounter;

public final class BanditSurpriseEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You take a right.\n");
        sb.append("As you walk along, a bandit comes out of the door to a room.\n");
        sb.append("He sees you and attacks before you have a chance to do anything.\n");
        sb.append("You were so close!\n");
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
