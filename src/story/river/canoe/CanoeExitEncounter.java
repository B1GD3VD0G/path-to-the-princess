package story.river.canoe;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.exchange.ExchangeEncounter;

public final class CanoeExitEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You row the boat to shore and hop out.\n");
        sb.append("You leave the fishing rod behind. It will prove useless to you now.\n");
        inventory.drop(Inventory.FISHING_ROD);
        sb.append("There are many hills around you, and you can see the top of the Northern Keep in the distance.\n");
        sb.append("You let out a sigh of relief. You are almost there!\n");
        sb.append("You walk for a couple more miles, and you are at the end of the river.\n");
        sb.append("There are many hills around you, and you can see the top of the Northern Keep in the distance.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You let out a sigh of relief. You are almost there!";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yay!", new ExchangeEncounter());
    }
}
