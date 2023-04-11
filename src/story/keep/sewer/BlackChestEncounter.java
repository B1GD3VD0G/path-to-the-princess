package story.keep.sewer;

import model.AbstractEncounter;
import model.Inventory;

public final class BlackChestEncounter extends AbstractEncounter {

    public BlackChestEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You continue through the sewer.\n");
        sb.append("You see a big black chest down the path in front of you.\n");
        if (inventory.contains(Inventory.WIZARD)){
            sb.append("\n");
            sb.append("Wizard: Do not open that chest - it is a trap!\n");
            sb.append("Wizard: It is filled with poisonous gas!\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to open it?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yes.", new OpenChestEncounter());
        addProgressButton("No.", new SewerExitEncounter());
    }
}
