package story.river.canoe.tunnel;

import model.AbstractEncounter;

public final class TunnelSwimEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You jump out of the boat into the river, leaving behind all of your items.\n");
        sb.append("As you are swimming through the darkness, another creature falls on top of you.\n");
        sb.append("You try to break free, but it drowns you.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = GAME_OVER;
    }

    @Override
    protected void setChoices() {
        addGameOverButtons();
    }
}
