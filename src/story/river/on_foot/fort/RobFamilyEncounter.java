package story.river.on_foot.fort;

import model.AbstractEncounter;
import model.Inventory;
import story.river.on_foot.food.RiversideFoodEncounter;

public final class RobFamilyEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        story = "You now have 10 more gold pieces and a fish in your inventory.";
        inventory.collect(10);
        inventory.collect(Inventory.COOKED_FISH);
    }

    @Override
    protected void setQuestion() {
        question = "You leave the fort and continue on your journey up the river.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new RiversideFoodEncounter());
    }
}
