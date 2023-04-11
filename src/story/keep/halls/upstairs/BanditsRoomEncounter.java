package story.keep.halls.upstairs;

import model.AbstractEncounter;

public final class BanditsRoomEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You slowly creak open the door.\n");
        sb.append("You see a group of bandits sitting around a table.\n");
        sb.append("They all look up and see you. Three stand up from the table and charge at you.\n");
        sb.append("Before you can grab your weapon, they pile on top of you.\n");
        sb.append("They begin hitting you with their axes.\n");
        hasDied = true;
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
