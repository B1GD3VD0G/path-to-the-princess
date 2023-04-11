package story.keep.halls.ahead;

import model.AbstractEncounter;
import story.keep.final_battle.MeetPrincessEncounter;

public final class DownstairsChiefDoorEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Once you reach the end of the hallway, you come to a set of stairs.\n");
        sb.append("There is no other direction to go, so you begin to climb up them.\n");
        sb.append("You reach the top and see a door. This must be the chief bandit's room!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You enter the room.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new MeetPrincessEncounter());
    }
}
