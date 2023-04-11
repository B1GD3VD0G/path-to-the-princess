package story.keep;


import model.AbstractEncounter;
import story.keep.halls.HallsEnterEncounter;
import story.keep.sewer.SewerEnterEncounter;

public final class KeepSplitPathEncounter extends AbstractEncounter {

    public KeepSplitPathEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You continue on your way toward the Northern Keep.\n");
        sb.append("Once you are approaching the gate, you see a sewer grate on the road right in front.");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How would you like to enter the keep?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Sneak in through the sewer.", new SewerEnterEncounter());
        addProgressButton("Walk in through the front door.", new HallsEnterEncounter());
    }
}
