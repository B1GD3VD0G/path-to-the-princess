package story.snowy_mountains.tallest_mountain.cave;

import model.AbstractEncounter;

public final class SleepMurderEncounter extends AbstractEncounter {

    public SleepMurderEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You find yourself a space to rest in the corner.\n");
        sb.append("You fall asleep almost immediately.\n");
        sb.append("As you are sleeping, a group of bandits returns home to find an intruder sleeping!\n");
        sb.append("They kill you in your sleep.\n");
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
