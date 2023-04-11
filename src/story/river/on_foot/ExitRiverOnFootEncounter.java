package story.river.on_foot;

import model.AbstractEncounter;
import story.keep.exchange.ExchangeEncounter;

public final class ExitRiverOnFootEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You walk away from the trolls.\n");
        sb.append("You made the right choice. The trolls were going to try to trick you!\n");
        sb.append("You continue along the same path.\n");
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
