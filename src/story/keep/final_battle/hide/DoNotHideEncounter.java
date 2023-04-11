package story.keep.final_battle.hide;

import model.AbstractEncounter;

public final class DoNotHideEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("After a few minutes of waiting, the bandit chief comes back.\n");
        sb.append("He sees you standing there and lets out a girlish scream.\n");
        sb.append("After hearing his scream, in rush fifteen more bandits.\n");
        sb.append("You are greatly overpowered.\n");
        hasDied = true;
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Game over.";
    }

    @Override
    protected void setChoices() {
        addGameOverButtons();
    }
}
