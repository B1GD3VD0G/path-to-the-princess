package story.keep.exchange;

import model.AbstractEncounter;
import story.keep.KeepSplitPathEncounter;

public final class ExchangeEncounter extends AbstractEncounter {

    public ExchangeEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("As you walk through the hills toward the keep, you come across three dead bodies.\n");
        sb.append("You see that they all have different armor on and weapons.\n");
        sb.append("One body has shrouded robes and a sword and shield.\n");
        sb.append("Another body has metal armor and a bow and arrow.\n");
        sb.append("The last body has leather armor and a battle axe.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to trade any equipment with the bodies?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes.", new ExchangeWeaponEncounter());
        addProgressButton("No.", new KeepSplitPathEncounter());
    }
}
