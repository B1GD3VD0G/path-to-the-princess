package story.river.on_foot.cave;

import model.AbstractEncounter;

public final class TrappedInChestEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("As you try to run away the ghost comes up behind you and snaps your neck.\n");
        sb.append("That was not a wise choice.\n");
        sb.append("You are now a ghost in the chest stuck with the person who killed you for eternity.\n");
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
