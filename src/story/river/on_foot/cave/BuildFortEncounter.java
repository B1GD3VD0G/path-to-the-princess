package story.river.on_foot.cave;

import model.AbstractEncounter;
import story.river.on_foot.trolls.RiverTrollsEncounter;

public final class BuildFortEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You look around and collect some sticks.\n");
        sb.append("You build a fort to provide minimal shelter\n");
        sb.append("You sleep peacefully through the night in your fort.\n");
        sb.append("You awake in the morning feeling refreshed.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You continue your journey up the river, toward the princess.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new RiverTrollsEncounter());
    }
}
