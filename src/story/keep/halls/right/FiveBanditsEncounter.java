package story.keep.halls.right;

import model.AbstractEncounter;

public final class FiveBanditsEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You take a right.\n");
        sb.append("You walk a little ways when you see a group of five bandits laughing up ahead.\n");
        sb.append("They are walking toward you.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How will you proceed?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Fight them!", new FightFiveBanditsEncounter());
        addProgressButton("Try to find somewhere to hide!", new HideFromBanditsEncounter());
    }
}
