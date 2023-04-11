package story.river.on_foot.trolls;

import model.AbstractEncounter;
import story.river.on_foot.ExitRiverOnFootEncounter;

public final class AskToCrossBridgeEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You: Okay. Thank you. May I get across, please?\n");
        sb.append("\n");
        sb.append("Troll: Haha! It is not that easy, my friend.\n");
        sb.append("Troll: It costs 750 gold to cross this here bridge!\n");
        sb.append("\n");
        if(inventory.getGold() < 750) {
            sb.append("You do not have enough gold to cross the bridge.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Will you pay the trolls to cross the bridge?";
    }

    @Override
    protected void setChoices() {
        if (inventory.getGold() > 750) {
            addPayButton("Yes. Pay 750 gold.", new PayTrollsEncounter(), 750);
        }
        addProgressButton("No. Go the other way.", new ExitRiverOnFootEncounter());
    }
}
