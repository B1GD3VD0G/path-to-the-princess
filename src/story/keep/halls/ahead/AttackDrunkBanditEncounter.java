package story.keep.halls.ahead;

import model.AbstractEncounter;

public final class AttackDrunkBanditEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You pull out your weapon, and easily take the bandit down.\n");
        sb.append("You had an unfair advantage over him! Drunk men can't fight!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You continue along the hallway.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yay!", new DownstairsChiefDoorEncounter());
    }
}
