package story.river.on_foot.cave;

import model.AbstractEncounter;
import story.river.on_foot.trolls.RiverTrollsEncounter;

public final class SleepInCaveEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You sleep peacefully in the cave tonight.\n");
        sb.append("You awake in the morning feeling rested.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You continue your journey up the river toward the princess.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new RiverTrollsEncounter());
    }
}
