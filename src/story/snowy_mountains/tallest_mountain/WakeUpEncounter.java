package story.snowy_mountains.tallest_mountain;

import model.AbstractEncounter;
import story.snowy_mountains.tallest_mountain.peak.MeetDragonEncounter;

public final class WakeUpEncounter extends AbstractEncounter {

    public WakeUpEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You awaken very early, and have slept horribly.\n");
        sb.append("Your back aches, and you are very cold.\n");
        sb.append("You are alive though, and that is a blessing in itself.\n");
        sb.append("You are ready to resume your climb up the tallest mountain.\n");
        sb.append("After a while, you warm up, and you start to feel better.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You speed up, anxious to reach the peak.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Continue climbing.", new MeetDragonEncounter());
    }
}
