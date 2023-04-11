package story.snowy_mountains.inn.chat;

import model.AbstractInncounter;
import story.snowy_mountains.inn.SleepAloneInncounter;
import story.snowy_mountains.inn.SleepWithBarkeepInncounter;

public final class OffendBarkeepInncounter extends AbstractInncounter {

    public OffendBarkeepInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        if (barkeepIsSeduced){
            sb.append("Barkeep: You know what, you wanna keep that attitude you can sleep alone buddy.\n");
            sb.append("Barkeep: And you can pay extra too!\n");
            roomCost = 100;
        }
        else{
            sb.append("Barkeep: Whoa, there! Didn't mean to offend ya buddy.\n\n");

            sb.append("He hasn't said it but you can tell you've hurt his feelings.\n");
            roomCost = 75;
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You regret offending the barkeep.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("\"What should I expect to see in the mountains?\"", new MountainChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        addProgressButton("\"What do travelers usually come here for?\"", new TravelerChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
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
