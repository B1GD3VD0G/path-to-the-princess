package story.keep.final_battle.fight.react;

import model.AbstractEncounter;

public final class DodgeAgainEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("The bandit chief seems to have learned your dodging technique!\n");
        sb.append("He sweeps down low, and the blow literally knocks your legs off your body.\n");
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
