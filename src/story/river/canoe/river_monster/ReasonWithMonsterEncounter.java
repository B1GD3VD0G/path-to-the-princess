package story.river.canoe.river_monster;

import model.AbstractEncounter;
import story.river.canoe.tunnel.RiverTunnelEncounter;

public final class ReasonWithMonsterEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You begin talking to the monster in a panic,\n");
        sb.append("thinking he doesn't understand anything that you are saying.\n");
        sb.append("The monster, however, is able to understand you.\n");
        sb.append("\n");
        sb.append("Monster: What is it you are talking about?\n");
        sb.append("\n");
        sb.append("You: The princess has been taken and I need to save her!\n");
        sb.append("You: I am trying to get to the Northern Keep to get her back from the bandits!\n");
        sb.append("\n");
        sb.append("Monster: The princess you say? Hmm....\n");
        sb.append("Monster: The princess is the reason I am able to live in this river.\n");
        sb.append("Monster: The king wanted to have me killed long ago so that he could peacefully \n");
        sb.append("Monster: come fishing with his friends on this river.\n");
        sb.append("Monster: The princess convinced him to let me live. She did not want to see any creature die.\n");
        sb.append("Monster: If the bandits keep her and kill her, I will also be killed.\n");
        sb.append("Monster: I will allow you to continue on your journey.\n");
        sb.append("Monster: There will be others for me to feast upon!\n");
        sb.append("\n");
        sb.append("The monster sinks back down into the water and calms the river.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You continue on your journey to the Northern Keep.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Phew!", new RiverTunnelEncounter());
    }
}
