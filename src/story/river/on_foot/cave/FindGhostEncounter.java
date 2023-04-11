package story.river.on_foot.cave;

import model.AbstractEncounter;

public final class FindGhostEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You open the chest.\n");
        sb.append("Inside you find 200 gold pieces.\n");
        sb.append("You reach into the chest to take the items.\n");
        sb.append("When you take the first handful of gold, a ghost comes out of the chest.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Ghost: What are you doing with my things! Who are you?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Tell him you are a knight, trying to rescue the princess.", new GhostTruthEncounter());
        addProgressButton("Tell him you are a poor man, trying to find a place to sleep.", new GhostLieEncounter());
    }
}
