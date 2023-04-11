package story.keep.sewer;

import model.AbstractEncounter;

public final class OpenChestEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You open the big black chest.\n");
        sb.append("A green, foul smelling gas leaves the chest, surrounding you.\n");
        sb.append("You die within 30 seconds.\n");
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
