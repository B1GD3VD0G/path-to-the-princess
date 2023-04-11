package story.snowy_mountains.valley;

import model.AbstractEncounter;
import story.keep.exchange.ExchangeEncounter;

public final class MountainExitEncounter extends AbstractEncounter {

    public MountainExitEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You walk all day, and finally you see the Northern Keep in the distance.\n");
        sb.append("You descend from the snowy mountain into a vast hilly region.");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        StringBuilder sb = new StringBuilder();
        sb.append("You feel relieved that you have made it.\n");
        sb.append("But you know that the hardest part of your mission has just begun.\n");
        question = sb.toString();
    }

    @Override
    protected void setChoices() {
        addProgressButton("*Gulp*", new ExchangeEncounter());
    }
}
