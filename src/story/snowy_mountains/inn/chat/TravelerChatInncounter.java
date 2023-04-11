package story.snowy_mountains.inn.chat;

import model.AbstractInncounter;
import story.snowy_mountains.inn.SleepAloneInncounter;
import story.snowy_mountains.inn.SleepWithBarkeepInncounter;

public final class TravelerChatInncounter extends AbstractInncounter {

    public TravelerChatInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Barkeep: Like I said, we don't get many travelers here.\n");
        sb.append("Barkeep: But most travelers these days are priests.\n");
        sb.append("Barkeep: On the top of the tallest peak is a shrine to Lord Kyr, the God of Time.\n");
        sb.append("Barkeep: They say he will help those in need, should they pray to him, \nand make an offering to him.\n");
        sb.append("Barkeep: But be sure not to offend him with an insufficient offering. \nHe can be quite easily offended.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Barkeep: What else would you like to talk about?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("\"What should I expect to see in the mountains?\"", new MountainChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        addProgressButton("\"How far is it to the Northern Keep?\"", new NorthernKeepChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        if (barkeepIsSeduced) {
            addProgressButton("Follow the barkeep to the bedroom.", new SleepWithBarkeepInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        }
        else {
            addPayButton("You are done talking. Purchase a room for " + roomCost + " gold.", new SleepAloneInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost), roomCost);
        }
        if (isDrunk && !barkeepIsSeduced) {
            addProgressButton("Try to seduce the barkeep!", new SeductionAttemptInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        }
    }
}
