package story.snowy_mountains.inn;

import model.AbstractInncounter;
import story.snowy_mountains.SnowySplitPathEncounter;

public final class SleepAloneInncounter extends AbstractInncounter {

    public SleepAloneInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("The barkeep shows you to your room.\n");
        sb.append("The bed is small, and made of straw covered in some animal hides.\n");
        sb.append("Not nearly up to the standards of your bed in the castle, but it'll do.\n");
        sb.append("You lay down, and fall asleep quickly.\n");
        sb.append("You awaken the next morning at dawn.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You leave the inn and resume your quest for the princess.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new SnowySplitPathEncounter());
    }
}
