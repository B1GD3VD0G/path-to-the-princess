package story.river.canoe.get_food;

import model.AbstractEncounter;
import model.Inventory;

public final class EatRawFishEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You eat the fish. It is not very good raw.\n");
        inventory.drop(Inventory.RAW_FISH);
        sb.append("You continue up the river, and after a while, you get a massive stomach ache.\n");
        sb.append("You begin to throw up uncontrollably right as you come to an area full of rapids.\n");
        sb.append("You are too weak to navigate the rapids, so you fall out of the canoe.\n");
        sb.append("When you fall out, you hit your head on a rock.\n");
        sb.append("You have died. You shouldn't have eaten that fish raw!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = GAME_OVER;
    }

    @Override
    protected void setChoices() {
        addGameOverButtons();
    }
}
