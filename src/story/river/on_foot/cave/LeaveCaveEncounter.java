package story.river.on_foot.cave;

import model.AbstractEncounter;
import story.river.on_foot.trolls.RiverTrollsEncounter;

public final class LeaveCaveEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        System.out.println("You put back the gold and leave the cave.");
        System.out.println("You must build a fort out of sticks now to sleep in for the night.");
        System.out.println("You get some sticks and build a fort.");
        System.out.println("You sleep peacefully through the night.");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You wake up in the morning feeling refreshed and continue your journey.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new RiverTrollsEncounter());
    }
}
