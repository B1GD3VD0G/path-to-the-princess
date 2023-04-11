package story.snowy_mountains.tallest_mountain.cave;

import model.AbstractEncounter;
import model.Inventory;
import story.snowy_mountains.tallest_mountain.MountainSleepEncounter;

public final class FindNecklaceEncounter extends AbstractEncounter {

    public FindNecklaceEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("You enter the cave, and you see a chest tucked in a corner.\n");
        sb.append("You open the chest and find a beautiful silver and sapphire necklace.\n");
        sb.append("It looks very expensive.\n");
        inventory.collect(Inventory.NECKLACE);
        sb.append("You put it on and feel beautiful.\n");
        sb.append("You wish there was a mirror so that you could admire yourself.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to sleep in the cave?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes.", new SleepMurderEncounter());
        addProgressButton("No. I'll find somewhere else to sleep.", new MountainSleepEncounter());
    }
}
