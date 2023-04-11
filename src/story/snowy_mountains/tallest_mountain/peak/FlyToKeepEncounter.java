package story.snowy_mountains.tallest_mountain.peak;

import model.AbstractEncounter;
import story.keep.exchange.ExchangeEncounter;

public final class FlyToKeepEncounter extends AbstractEncounter {

    public FlyToKeepEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You then approach the dragon and hop on his back.\n");
        sb.append("You grab on to one of his spikes and take a deep breath.\n");
        sb.append("You hope the dragon does not sense how absolutely terrified you are to do this.\n");
        sb.append("After 30 minutes of flying the dragon lands outside the castle.\n");
        sb.append("You thank him, and he flies back to his roost on the tallest mountain.");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Now out of the mountains and into the hills surrounding the Northern Keep, you continue onward\n"
                + "toward the princess.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new ExchangeEncounter());
    }
}
