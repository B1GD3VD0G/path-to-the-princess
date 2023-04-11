package story.river.on_foot.fort;

import model.AbstractEncounter;
import story.river.on_foot.food.RiversideFoodEncounter;

public final class ExpulsionEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You: I am nobody you would know.\n");
        sb.append("\n");
        sb.append("Man: Get out of here then! Leave us alone!\n");
        sb.append("\n");
        sb.append("You leave the fort. That man really did not appreciate you barging in!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You continue on your journey up the river.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new RiversideFoodEncounter());
    }
}
