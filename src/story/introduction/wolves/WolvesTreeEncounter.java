package story.introduction.wolves;

import model.AbstractEncounter;
import model.Inventory;

public final class WolvesTreeEncounter extends AbstractEncounter {

    public WolvesTreeEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You manage to scramble up the tree just quickly enough so that the wolves can't get you.\n");
        sb.append("You get to a branch where you can sit comfortably enough.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "What will you do about these wolves?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Wait until they leave.", new WatchWolvesEatEncounter());
        if (inventory.contains(Inventory.BOW_AND_ARROWS)) {
            addProgressButton("Shoot at them from the tree!", new ShootWolvesEncounter());
        }
    }
}
