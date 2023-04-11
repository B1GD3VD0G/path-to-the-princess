package story.snowy_mountains.tallest_mountain.cave;

import model.AbstractEncounter;
import story.snowy_mountains.tallest_mountain.MountainSleepEncounter;
import story.snowy_mountains.tallest_mountain.cave.FindNecklaceEncounter;

public final class MountainCaveEncounter extends AbstractEncounter {

    public MountainCaveEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Staring at the mountain before you, you wonder if you are crazy for making that choice.\n");
        sb.append("But there's no time for second-guessing. The princess is in danger!\n");
        sb.append("After many hours of climbing, it is nightfall.\n");
        sb.append("You are at the base of the tallest mountain.\n");
        sb.append("You need to rest. You see that there is a cave nearby.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to go into the cave?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes.", new FindNecklaceEncounter());
        addProgressButton("No, I'll find somewhere else to sleep.", new MountainSleepEncounter());
    }
}
