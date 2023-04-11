package story.snowy_mountains.tallest_mountain;

import model.AbstractEncounter;
import model.Inventory;

public final class MountainSleepEncounter extends AbstractEncounter {

    public MountainSleepEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        if (inventory.contains(Inventory.NECKLACE)) {
            sb.append("You leave the comfort of the cave, hoping that there will be shelter somewhere close.\n");
        }
        sb.append("You keep walking along the path for maybe half a mile more.\n");
        sb.append("You see a overhang in the mountain which will provide you with cover from the snow.\n");
        sb.append("You lie down to rest. Despite being very uncomfortable, you fall asleep almost immediately\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You fall asleep and dream of the princess.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Zzz...", new WakeUpEncounter());
    }
}
