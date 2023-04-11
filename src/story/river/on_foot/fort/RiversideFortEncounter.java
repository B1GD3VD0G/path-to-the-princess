package story.river.on_foot.fort;

import model.AbstractEncounter;
import story.river.on_foot.food.RiversideFoodEncounter;

public final class RiversideFortEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        story = "You continue along the river side on foot.";
        story += "\nAfter a while, you approach what looks to be a fort built out of sticks.";
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to enter the fort?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes.", new BargeInEncounter());
        addProgressButton("No.", new RiversideFoodEncounter());
    }
}
