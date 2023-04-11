package story.keep.halls;

import model.AbstractEncounter;
import story.keep.halls.ahead.AheadLeftRightEncounter;
import story.keep.halls.right.FiveBanditsEncounter;
import story.keep.halls.upstairs.UpstairsLeftRightEncounter;

public final class WhichWayEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You open the doors to the castle and walk in.\n");
        sb.append("It is dark and dingy inside.\n");
        sb.append("There is a hallway going straight ahead, a hallway to your right,\n");
        sb.append("and a hallway leading to a staircase on your left.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Which path would you like to take?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Straight ahead!", new AheadLeftRightEncounter());
        addProgressButton("To the right!", new FiveBanditsEncounter());
        addProgressButton("To the left!", new UpstairsLeftRightEncounter());
    }
}
