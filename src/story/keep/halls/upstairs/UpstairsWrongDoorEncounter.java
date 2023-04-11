package story.keep.halls.upstairs;

import model.AbstractEncounter;

public final class UpstairsWrongDoorEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("You take a left.\n");
        sb.append("You walk along the hall and see a door at the end of the hallway.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Will you enter this room?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes.", new BanditsRoomEncounter());
        addProgressButton("No. Turn back the way you came.", new UpstairsChiefDoorEncounter());
    }
}
