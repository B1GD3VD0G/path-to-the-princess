package story.river.canoe.get_food;

import model.AbstractEncounter;
import model.Inventory;

public final class CatchFishEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        System.out.println("You stop rowing the canoe and reach for your fishing rod");
        System.out.println("You cast the line and wait for a fish to come.");
        System.out.println("After what feels like forever, you finally catch a fish!");
        inventory.collect(Inventory.RAW_FISH);
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How shall you prepare your fish?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Go to the shore and build a fire.", new CookFishEncounter());
        addProgressButton("Eat it raw!", new EatRawFishEncounter());
    }
}
