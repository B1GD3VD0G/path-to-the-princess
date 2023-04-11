package story.keep.final_battle.fight.dodge;

import model.AbstractEncounter;

public final class JumpBackEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You jump backward to avoid the swing, but the warhammer is just too long.\n");
        sb.append("It crushes you in a single hit.\n");
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
