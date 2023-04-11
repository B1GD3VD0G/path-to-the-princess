package story.snowy_mountains;

import model.AbstractEncounter;

public final class SnowyDeathEncounter extends AbstractEncounter {
    public SnowyDeathEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Against your better judgment. You head up the mountain.\n");
        sb.append("With every step, you feel yourself get weaker.\n");
        sb.append("The sun begins to set and there is no light. You struggle to see.\n");
        sb.append("You hear the growl of a mountain lion to your side.\n");
        sb.append("You look around you, but you cannot see.\n");
        sb.append("Before you can draw your weapon, he pounces.\n");
        sb.append("You feel too weak to fight back.\n");
        sb.append("The mountain lion overpowers you and you die.\n");
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
