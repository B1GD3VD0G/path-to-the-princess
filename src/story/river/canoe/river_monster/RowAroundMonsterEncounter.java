package story.river.canoe.river_monster;

import model.AbstractEncounter;

public final class RowAroundMonsterEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You try to get around the monster but he's much faster than you.\n");
        sb.append("As you try to make swift motions to avoid both the monster and the water,\n");
        sb.append("you tip the boat and fall out.\n");
        sb.append("You get sucked into a whirlpool, and drown.\n");
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
