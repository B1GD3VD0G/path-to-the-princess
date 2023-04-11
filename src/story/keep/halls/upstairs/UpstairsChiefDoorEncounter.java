package story.keep.halls.upstairs;

import model.AbstractEncounter;
import story.keep.final_battle.MeetPrincessEncounter;

public final class UpstairsChiefDoorEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        story = "After walking some ways, you see a huge door.";
    }

    @Override
    protected void setQuestion() {
        question = "Will you enter this room?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes.", new MeetPrincessEncounter());
        addProgressButton("No. Continue down the hall.", new GotCaughtEncounter());
    }
}
