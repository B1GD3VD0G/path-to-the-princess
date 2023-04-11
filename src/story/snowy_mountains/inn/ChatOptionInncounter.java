package story.snowy_mountains.inn;

import model.AbstractInncounter;
import story.snowy_mountains.inn.chat.InitialChatInncounter;

public final class ChatOptionInncounter extends AbstractInncounter {

    public ChatOptionInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        if (!isDrunk) {
            sb.append("You down the mug of mead. Your belly starts to feel warm.\n");
        }
        else {
            sb.append("You down the two mugs of mead. Your belly starts to feel warm.\n");
            sb.append("You start to feel drunk.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Barkeep: It's been a while since I've chatted with an outsider.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Stay and chat.", new InitialChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        addProgressButton("Politely decline and purchase a room for " + roomCost + " gold.", new SleepAloneInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
    }
}
