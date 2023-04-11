package story.snowy_mountains.inn.chat;

import model.AbstractInncounter;
import model.Inventory;
import story.snowy_mountains.inn.SleepAloneInncounter;
import story.snowy_mountains.inn.SleepWithBarkeepInncounter;

public final class BarkeepGiftInncounter extends AbstractInncounter {

    public BarkeepGiftInncounter(boolean isDrunk, boolean barkeepIsSeduced, boolean barkeepIsOffended, int roomCost) {
        super(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost);
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        if (!barkeepIsOffended) {
            sb.append("Barkeep: Holy smokes! The princess has been captured?!\n");
            sb.append("Barkeep: Well in that case, I ought to help in any way I can.\n");
            sb.append("Barkeep: I have a pair of snowshoes I can give you!\n");
            sb.append("Barkeep: They will help you to move more quickly in the deep snow!\n");
            inventory.collect(Inventory.SNOWSHOES);
            sb.append("Barkeep: I wish you the best on your journey, brave knight!\n");
        }
        else{
            sb.append("Barkeep: Holy smokes! The princess has been captured?!\n");
            sb.append("Barkeep: That's awful. I shall keep the royal family in my prayers tonight.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Barkeep: What else would you like to talk about?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("\"What should I expect to see in the mountains?\"", new MountainChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        addProgressButton("\"What do travelers usually come here for?\"", new TravelerChatInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        if (barkeepIsSeduced) {
            addProgressButton("Follow the barkeep to the bedroom.", new SleepWithBarkeepInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        }
        else {
            addPayButton("You are done talking. Purchase a room for 50 gold.", new SleepAloneInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost), roomCost);
        }
        if (isDrunk && !barkeepIsSeduced) {
            addProgressButton("Try to seduce the barkeep!", new SeductionAttemptInncounter(isDrunk, barkeepIsSeduced, barkeepIsOffended, roomCost));
        }
    }
}
