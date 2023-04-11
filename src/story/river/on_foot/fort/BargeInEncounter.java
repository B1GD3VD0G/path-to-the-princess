package story.river.on_foot.fort;

import model.AbstractEncounter;
import model.Inventory;

public final class BargeInEncounter extends AbstractEncounter {

    boolean isArmored = inventory.contains(Inventory.METAL_ARMOR) || inventory.contains(Inventory.LEATHER_ARMOR);

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("When you enter the fort, there is a peasant man with a family.\n");
        if (isArmored) {
            sb.append("The man and his family cower in the corner.\n");
            sb.append("\n");
            sb.append("Man: Please don't harm us. You can take whatever you like.\n");
            sb.append("Man: We don't have much, but you can take the fish we just caught and the gold,\n");
            sb.append("just please don't hurt us. We have done nothing wrong.\n");
        }
        else {
            sb.append("Man: Who are you? What do you want from us?\n");
            sb.append("\n");
            sb.append("The man doesn't realize you are a knight in your attire.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (isArmored) {
            question = "Will you rob the poor family?";
        }
        else {
            question = "How do you respond to the peasants?";
        }
    }

    @Override
    protected void setChoices() {
        if (isArmored) {
            addProgressButton("Yes.", new RobFamilyEncounter());
            addProgressButton("No.", new LeaveEmptyHandedEncounter());
        }
        else {
            addProgressButton("Tell the truth", new ReceiveHelpEncounter());
            addProgressButton("Pretend you are a commoner", new ExpulsionEncounter());
        }
    }
}
