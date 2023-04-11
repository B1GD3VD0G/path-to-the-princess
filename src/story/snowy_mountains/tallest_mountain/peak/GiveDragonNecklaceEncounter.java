package story.snowy_mountains.tallest_mountain.peak;

import model.AbstractEncounter;

public final class GiveDragonNecklaceEncounter extends AbstractEncounter {

    public GiveDragonNecklaceEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dragon: Splendid! This will be the perfect addition to my collection!\n");
        sb.append("Dragon: You may now approach my master's shrine!\n");
        sb.append("Dragon: Also, when you are done, I will fly you to your destination!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "The dragon steps to the side, clearing the path to the shrine.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Approach the shrine.", new TalkToGodEncounter());
    }
}
