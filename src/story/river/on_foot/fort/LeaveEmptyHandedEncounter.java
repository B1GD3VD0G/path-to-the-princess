package story.river.on_foot.fort;

import model.AbstractEncounter;
import story.river.on_foot.food.RiversideFoodEncounter;

public final class LeaveEmptyHandedEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        story = "You feel sorry for intruding into the poor family's home.";
    }

    @Override
    protected void setQuestion() {
        question = "You leave the fort empty handed and continue on your journey up the river.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new RiversideFoodEncounter());
    }
}
