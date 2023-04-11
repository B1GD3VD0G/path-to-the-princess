package story.keep.sewer.rats;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.sewer.BlackChestEncounter;

public final class HideFromRatsEncounter extends AbstractEncounter {

    public HideFromRatsEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        if (inventory.contains(Inventory.SHROUDED_ROBES)) {
            sb.append("You hide in a corner where the rats cannot see you.\n");
            sb.append("Your enchanted robes make it so that you are silent.\n");
            sb.append("The rats walk past you and do not see you.\n");
        }
        else {
            sb.append("You hide in a corner where the rats cannot see you.\n");
            sb.append("As the rats walk past you, they notice you.\n");
            sb.append("One bites you on the hand. You manage to kill them both.\n");
            sb.append("The bite, however, gets infected rapidly.\n");
            sb.append("You die a few minutes later.\n");
            hasDied = true;
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
        }
        else {
            question = "You continue cautiously through the sewers.";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Phew!", new BlackChestEncounter());
        }
    }
}
