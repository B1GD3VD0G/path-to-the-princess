package story.river.canoe;

import model.AbstractEncounter;
import model.Inventory;
import story.river.canoe.get_food.CatchFishEncounter;
import story.river.canoe.get_food.ShoreFoodSearchEncounter;

public final class GetIntoCanoeEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You situate the canoe on the river and get inside of it.\n");
        sb.append("You find a fishing pole inside the canoe! It's your lucky day!\n");
        inventory.collect(Inventory.FISHING_ROD);
        sb.append("\n");
        sb.append("You begin to travel up the river.\n");
        sb.append("After a while traveling up the river, you begin to feel weak.\n");
        sb.append("You need to eat something.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How will you try to satisfy your hunger?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Try to catch a fish.", new CatchFishEncounter());
        addProgressButton("Row ashore to find something there.", new ShoreFoodSearchEncounter());
    }
}
