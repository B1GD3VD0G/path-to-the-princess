package story.snowy_mountains.inn.chat;

import model.AbstractInncounter;
import story.snowy_mountains.inn.SleepAloneInncounter;
import story.snowy_mountains.inn.SleepWithBarkeepInncounter;

public final class SeductionAttemptInncounter extends AbstractInncounter {

    public SeductionAttemptInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        if (barkeepIsOffended){
            sb.append("Barkeep: Why you drunken bastard!\n");
            sb.append("Barkeep: I'd be caught dead before sleeping with you!\n");
        }
        else{
            sb.append("Barkeep: Wow, those are some mighty kind words from a handsome traveler like you!\n");
            sb.append("Barkeep: Say, you can purchase your own room for " + roomCost + " gold...\n");
            sb.append("Barkeep: But I'll bet you'd rather follow me to mine!\n");
            barkeepIsSeduced = true;
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "The barkeep winks at you flirtatiously.";
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
    }
}
