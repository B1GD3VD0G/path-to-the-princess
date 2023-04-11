package story.snowy_mountains.inn.chat;

import model.AbstractInncounter;
import story.snowy_mountains.inn.SleepAloneInncounter;
import story.snowy_mountains.inn.SleepWithBarkeepInncounter;

public final class InitialChatInncounter extends AbstractInncounter {

    public InitialChatInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        story = "";
    }

    @Override
    protected void setQuestion() {
        question = "Barkeep: What do you want to talk about?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("\"What should I expect to see in the mountains?\"", new MountainChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        addProgressButton("\"What do travelers usually come here for?\"", new TravelerChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        addProgressButton("\"How far is it to the Northern Keep?\"", new NorthernKeepChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        if (barkeepIsSeduced) {
            addProgressButton("Follow the barkeep to the bedroom.", new SleepWithBarkeepInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        }
        else {
            addPayButton("You are done talking. Purchase a room for " + roomCost + " gold.", new SleepAloneInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost), roomCost);
        }
        if (isDrunk) {
            addProgressButton("Try to seduce the barkeep!", new SeductionAttemptInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        }
    }
}
