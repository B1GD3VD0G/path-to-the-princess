package story.introduction.camp;

import model.AbstractEncounter;
import story.introduction.dog.DogEncounter;

public final class SleepyCamperEncounter extends AbstractEncounter {

    public SleepyCamperEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        sb.append("You are now ready to leave the city.\n");
        sb.append("It is dark when you step outside the walls. There's still a couple hours until dawn.\n");
        sb.append("A mile or so out of the city you see a small campsite by the side of the road.\n");
        sb.append("A knight snores loudly, surrounded by many empty bottles of mead.\n");
        sb.append("Beside him is also a chest, which you notice is not locked, and a steak cooking on his fire.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How do you choose to proceed?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Rob his camp.", new CampRobberEncounter());
        addProgressButton("Keep walking along the road.", new DogEncounter());
    }
}
