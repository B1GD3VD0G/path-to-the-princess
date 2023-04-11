package story.river;

import model.AbstractEncounter;
import story.river.canoe.GetIntoCanoeEncounter;
import story.river.on_foot.fort.RiversideFortEncounter;

public final class RiverIntroductionEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You head to the river.\n");
        sb.append("Once you get to the river, there is an empty canoe lying on the bank.\n");
        sb.append("You do not see anyone around.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to travel on foot or by canoe?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Travel by foot.", new RiversideFortEncounter());
        addProgressButton("Take the canoe.", new GetIntoCanoeEncounter());
    }
}
