package story.river.canoe.tunnel;

import model.AbstractEncounter;
import story.keep.exchange.ExchangeEncounter;

public final class StayQuietEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You sit completely still, waiting for this creature to leave your boat.\n");
        sb.append("After what feels like a million years, you hear another thud.\n");
        sb.append("Your boat rocks back and forth. Another has joined you.\n");
        sb.append("You are too scared to even breathe.\n");
        sb.append("The light bulb flickers back on. The creatures disintegrate into the light.\n");
        sb.append("You continue rowing through the tunnel.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You finally make it through. You are safe.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Phew!", new ExchangeEncounter());
    }
}
