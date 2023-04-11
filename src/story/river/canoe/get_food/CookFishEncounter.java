package story.river.canoe.get_food;

import model.AbstractEncounter;
import model.Inventory;
import story.river.canoe.river_monster.RiverMonsterEncounter;

public final class CookFishEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You canoe over to shore and pull your boat out of the river.\n");
        sb.append("You gather some sticks and start a fire to cook your fish.\n");
        sb.append("You eat the fish. You feel stronger already and very satisfied.\n");
        inventory.drop(Inventory.RAW_FISH);
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You go back to the boat and continue your journey up the river.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yum!", new RiverMonsterEncounter());
    }
}
