package story.river.on_foot.trolls;

import model.AbstractEncounter;
import story.river.on_foot.ExitRiverOnFootEncounter;

public final class RiverTrollsEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        sb.append("After walking along the river for about half a mile, you reach a bridge.\n");
        sb.append("You see some small people standing beside the bridge.\n");
        sb.append("You approach the people, and as you get closer you realize they are trolls.\n");
        sb.append("It's too late now! You get trapped into talking with them.\n");
        sb.append("\n");
        sb.append("Troll: Who are you, what are you doing here?\n");
        sb.append("\n");
        sb.append("You: I am Sir Richard Longwood. I am trying to get to the Northern Keep " +
                "to save the princess.\n");
        sb.append("\n");
        sb.append("Troll: Ah yes, we heard about the princess. How unfortunate.\n");
        sb.append("Troll: The only way to get to the keep from here is to cross the river using this here bridge.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Do you trust the trolls?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes. Cross the bridge.", new AskToCrossBridgeEncounter());
        addProgressButton("No. Follow the other path.", new ExitRiverOnFootEncounter());
    }
}
