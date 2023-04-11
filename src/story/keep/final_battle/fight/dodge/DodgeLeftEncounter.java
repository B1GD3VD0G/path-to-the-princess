package story.keep.final_battle.fight.dodge;

import model.AbstractEncounter;

public final class DodgeLeftEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You successfully dodge the bandit chief's attack.\n");
        sb.append("The bandit chief grins evilly.\n");
        sb.append("He rushes to a lever on the wall to the right.\n");
        sb.append("When he pulls the lever, a loud bell starts ringing.\n");
        sb.append("Bandits start pouring into the room and start attacking you.\n");
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
