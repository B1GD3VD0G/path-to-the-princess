package story.snowy_mountains.inn;

import model.AbstractInncounter;
import story.snowy_mountains.SnowySplitPathEncounter;

public final class SleepWithBarkeepInncounter extends AbstractInncounter {

    public SleepWithBarkeepInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You follow the barkeep to the bedroom.\n");
        sb.append("The bed is big, and the mattress is very comfortable.\n");
        sb.append("You hope for the barkeep's sake that you do not break it.\n\n");
        sb.append("You awaken the next morning at dawn, well rested and satisfied.\n");
        sb.append("You sneak out of the room before the barkeep awakens.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You leave the inn and resume your quest for the princess.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Nice.", new SnowySplitPathEncounter());
    }
}
