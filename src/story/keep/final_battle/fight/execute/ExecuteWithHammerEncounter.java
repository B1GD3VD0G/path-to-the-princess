package story.keep.final_battle.fight.execute;

import model.AbstractEncounter;

public final class ExecuteWithHammerEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You laugh at the bandit chief as you walk past him.\n");
        sb.append("You get to the other side of the room and stop by his warhammer.\n");
        sb.append("You struggle to pick it up! It is really heavy!\n");
        sb.append("The bandit chief sneaks behind you and knocks you down!\n");
        sb.append("He picks up his warhammer with ease. He uses it to smash your head.\n");
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
