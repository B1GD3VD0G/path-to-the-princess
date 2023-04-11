package story.snowy_mountains;

import model.AbstractEncounter;
import story.snowy_mountains.SnowyDeathEncounter;
import story.snowy_mountains.inn.EatInncounter;

public final class SnowyIntroductionEncounter extends AbstractEncounter {

    public SnowyIntroductionEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You start out on the way to the mountain range.\n");
        sb.append("The mountain on the horizon seems terribly far away.\n");
        sb.append("You take in a deep breath of the air as it approaches high noon.\n");
        sb.append("You start to regret wearing the warm coat, but know it will be necessary as you go.\n");
        sb.append("After a very long walk, you approach a small village on the foothills of the mountain.\n");
        sb.append("The sun is setting behind the mountains.\n");
        sb.append("You take in the beautiful view until your stomach loudly rumbles and brings you back to reality\n");
        sb.append("You realize you are very tired too, and let out a great yawn.\n");
        sb.append("You see a sign marking the local inn.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How do you choose to proceed?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Enter the inn.", new EatInncounter(false, false, false, 50));
        addProgressButton("Continue your journey up the mountain. No time to waste!", new SnowyDeathEncounter());
    }
}
