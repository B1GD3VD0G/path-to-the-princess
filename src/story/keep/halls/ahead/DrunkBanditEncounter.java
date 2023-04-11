package story.keep.halls.ahead;

import model.AbstractEncounter;
import model.Inventory;

public final class DrunkBanditEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You take a left.\n");
        sb.append("As you walk along, a bandit comes out of a room.\n");
        sb.append("He seems a little out of it. He must be drunk.\n");
        sb.append("\n");
        sb.append("Bandit: Who are you? I've never seen you around here before.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How will you respond?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Attack him!", new AttackDrunkBanditEncounter());
        addProgressButton("Tell him you just joined the keep.", new LieToDrunkBanditEncounter());
        if (inventory.contains(Inventory.WIZARD)) {
            addProgressButton("Distract him and offer him the wizard!", new DrunkBanditWizardEncounter());
        }
    }
}
