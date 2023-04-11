package story.river.canoe.river_monster;

import model.AbstractEncounter;

public final class SwimToShoreEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You swim out of the boat leaving all of your belongings.\n");
        sb.append("The monster sees you trying to swim and swoops down to your level.\n");
        sb.append("He makes eye contact with you as he opens his mouth and swallows you whole.\n");
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
