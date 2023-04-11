package story.keep.sewer;

import model.AbstractEncounter;

public final class TripwireEncounter extends AbstractEncounter {

    public TripwireEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You turn down the path to the left.\n");
        sb.append("As you walk down the path, you step on a tripwire and trip and fall.\n");
        sb.append("You activate a trap which drops heavy rocks down on your body.\n");
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
