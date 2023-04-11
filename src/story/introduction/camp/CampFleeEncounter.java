package story.introduction.camp;

import model.AbstractEncounter;
import story.introduction.dog.DogEncounter;

public final class CampFleeEncounter extends AbstractEncounter {

    public CampFleeEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        story = "You run away before the knight can catch you.\nYou are emptyhanded but ultimately safe.";
    }

    @Override
    protected void setQuestion() {
        question = "You continue down the road toward the princess.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new DogEncounter());
    }
}
