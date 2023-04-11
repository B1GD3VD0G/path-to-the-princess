package story.keep.final_battle.fight.react;

import model.AbstractEncounter;

public final class BlockHammerEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("The giant hammer splinters your shield into tiny pieces.\n");
        sb.append("You are stunned from the impact.\n");
        sb.append("The bandit chief picks his hammer up and strikes again.\n");
        sb.append("He smashes your head into the wall.\n");
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
