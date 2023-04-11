package story.keep.final_battle.hide;

import model.AbstractEncounter;

public final class StayHiddenEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bandit Chief: I may have to kill you, but not now.\n");
        sb.append("Bandit Chief: Right now, I will sit at this table and eat my sweet roll.\n");
        sb.append("\n");
        sb.append("The bandit chief sits down at the table and he kicks you with his feet.\n");
        sb.append("You don't have time to react, because you're in an awkward position under the table.\n");
        sb.append("The bandit chief smashes the table and you in one fell swoop.\n");
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
