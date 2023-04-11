package story.river.canoe.tunnel;

import model.AbstractEncounter;
import story.river.canoe.CanoeExitEncounter;

public final class RiverTunnelEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("After that monster set back, you are making record time!\n");
        sb.append("Rowing is so much faster than walking!\n");
        sb.append("Up ahead, you see a dark tunnel that you will have to go through.\n");
        sb.append("It still isn't dark yet, so you aren't feeling too nervous about it.\n");
        sb.append("As you approach the tunnel, you see that the underneath is covered in vines and moss.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to continue through the tunnel?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes.", new TunnelMonsterEncounter());
        addProgressButton("No. Get out here.", new CanoeExitEncounter());
    }
}
