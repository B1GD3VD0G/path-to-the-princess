package story.snowy_mountains.inn.chat;

import model.AbstractInncounter;
import story.snowy_mountains.inn.SleepAloneInncounter;
import story.snowy_mountains.inn.SleepWithBarkeepInncounter;

public final class MountainChatInncounter extends AbstractInncounter {

    public MountainChatInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Barkeep: Travelers often come back telling of wolves, trolls, and goblins.\n");
        sb.append("Barkeep: One traveler even said that he'd seen a giant lurking around.\n");
        sb.append("Barkeep: But your biggest concern is just the cold.\n");
        sb.append("Barkeep: Although, your coat seems like it'll keep ya plenty warm.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Barkeep: What else would you like to talk about?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("\"What do travelers usually come here for?\"", new TravelerChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
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
