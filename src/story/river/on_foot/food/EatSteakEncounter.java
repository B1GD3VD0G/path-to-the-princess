package story.river.on_foot.food;

import model.AbstractEncounter;
import story.river.on_foot.cave.FindCaveEncounter;

public final class EatSteakEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("You eat the meat.\n");
        sb.append("It was perfectly cooked, even though it is cold now.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You feel full and satisfied.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yum!", new FindCaveEncounter());
    }
}
