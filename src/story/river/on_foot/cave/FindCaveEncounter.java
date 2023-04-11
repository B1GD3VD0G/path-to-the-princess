package story.river.on_foot.cave;

import model.AbstractEncounter;

public final class FindCaveEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You now need to find a place to sleep for the night.\n");
        sb.append("Up ahead, you see a small opening in some rocks. It appears to be a small cave.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Will you enter the cave?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes", new EnterCaveEncounter());
        addProgressButton("No, build a fort out of sticks.", new BuildFortEncounter());
    }
}
