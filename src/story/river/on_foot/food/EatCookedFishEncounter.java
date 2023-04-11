package story.river.on_foot.food;

import model.AbstractEncounter;
import story.river.on_foot.cave.FindCaveEncounter;

public final class EatCookedFishEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You eat the fish.\n");
        sb.append("That poor man sure knows how to cook up a fish! It tastes delicious!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You feel full and satisfied.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yum!", new FindCaveEncounter());
    }
}
