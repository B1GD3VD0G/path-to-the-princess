package story.river.on_foot.food;

import model.AbstractEncounter;

public final class EatPoisonBerriesEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You collect some berries and eat them.\n");
        sb.append("They are juicy and plump. What a treat!\n");
        sb.append("After a few minutes you begin to feel extremely sick.\n");
        sb.append("Sir Richard Longwood, you are a knight. You know nothing about foraging berries!\n");
        sb.append("Those berries were poisonous. You die.\n");
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
