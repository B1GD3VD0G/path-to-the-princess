package story.river.on_foot.cave;

import model.AbstractEncounter;

public final class EnterCaveEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You enter the cave. It is dark and dingy inside.\n");
        sb.append("Your eyes slightly adjust and you see a chest sitting on the ground.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to open the chest?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes", new FindGhostEncounter());
        addProgressButton("No, go right to sleep.", new SleepInCaveEncounter());
    }
}
