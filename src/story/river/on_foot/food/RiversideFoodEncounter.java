package story.river.on_foot.food;

import model.AbstractEncounter;
import model.Inventory;

public final class RiversideFoodEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("It slowly begins to get dark as you've been walking for what feels like forever.\n");
        sb.append("You are feeling weak and tired. You need to eat something and find a place to rest.\n");
        sb.append("There is a bush next to you that appears to have some berries.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "What would you like to do for food?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Try to find an animal to kill.", new RiversideHunterEncounter());
        addProgressButton("Try to forage some berries.", new EatPoisonBerriesEncounter());
        if (inventory.contains(Inventory.COOKED_FISH)) {
            addProgressButton("Eat the peasant's fish.", new EatCookedFishEncounter());
        }
        if (inventory.contains(Inventory.STEAK)) {
            addProgressButton("Eat the steak from the camp you robbed.", new EatSteakEncounter());
        }
    }
}
