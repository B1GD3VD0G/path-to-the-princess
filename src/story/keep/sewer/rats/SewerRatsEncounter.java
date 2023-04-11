package story.keep.sewer.rats;

import model.AbstractEncounter;
import model.Inventory;

public final class SewerRatsEncounter extends AbstractEncounter {

    public SewerRatsEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You continue down the right path.\n");
        sb.append("After a couple minutes you start to hear squeaking noises.\n");
        sb.append("Two giant rats come around a corner!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How will you proceed?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Fight the rats!", new RatFightEncounter());
        addProgressButton("Hide!", new HideFromRatsEncounter());
        addProgressButton("Run away!", new RunFromRatsEncounter());
        if (inventory.contains(Inventory.STAFF)) {
            addProgressButton("Use the staff of freeze time on the rats!", new FreezeRatsEncounter());
        }
    }
}
