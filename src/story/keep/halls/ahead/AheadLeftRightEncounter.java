package story.keep.halls.ahead;

import model.AbstractEncounter;

public final class AheadLeftRightEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You continue walking straight ahead.\n");
        sb.append("It is strange that no one is around. The bandits must be on another raid.\n");
        sb.append("The straight hallway leads to a T.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Which way would you like to go?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Go right.", new BanditSurpriseEncounter());
        addProgressButton("Go left.", new DrunkBanditEncounter());
    }
}
