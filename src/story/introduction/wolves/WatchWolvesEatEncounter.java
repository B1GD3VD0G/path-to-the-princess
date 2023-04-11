package story.introduction.wolves;

import model.AbstractEncounter;
import story.introduction.SplitPathEncounter;

public final class WatchWolvesEatEncounter extends AbstractEncounter {

    public WatchWolvesEatEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(100);
        System.out.println("The wolves bark and growl at you up in the tree.");
        System.out.println("Eventually they get bored, and remember the body laying in the clearing.");
        System.out.println("Not long after they begin their feast, the carcass is unrecognizable.");
        System.out.println("The coat is torn to shreds.");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You continue down the road toward the princess.\n" +
                "After a couple minutes you notice that the wildlife is out and about again.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new SplitPathEncounter());
    }
}
