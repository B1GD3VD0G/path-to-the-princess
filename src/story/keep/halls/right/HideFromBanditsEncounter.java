package story.keep.halls.right;

import model.AbstractEncounter;

public final class HideFromBanditsEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You see a door to a room two feet ahead.\n");
        sb.append("You walk into the room, feeling slight relief.\n");
        sb.append("You look around the room and see a group of 7 bandits drinking mead.\n");
        sb.append("They all look at you before almost immediately getting up and charging at you.\n");
        sb.append("You do not have enough time to get your weapon before one takes you down.\n");
        sb.append("They don't give up! The other six all take a swing at you.\n");
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
