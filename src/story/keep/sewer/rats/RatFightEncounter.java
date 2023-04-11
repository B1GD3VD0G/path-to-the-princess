package story.keep.sewer.rats;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.sewer.BlackChestEncounter;

public final class RatFightEncounter extends AbstractEncounter {

    public RatFightEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        if (inventory.contains(Inventory.WIZARD)) {
            sb.append("Before you can draw your weapon, your wizard companion launches a fireball at the rats.\n");
            sb.append("Once the fire clears, you see the rats are dead.\n");
        }
        if (inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("Your bow and arrow doesn't do you much good in the sewer.\n");
            if (inventory.contains(Inventory.METAL_ARMOR)) {
                sb.append("So you use your metal gauntlets to beat the rats to a pulp.\n");
            }

            else {
                sb.append("The rats overpower you and eat you.\n");
                hasDied = true;
            }
        }

        else {
            if (inventory.contains(Inventory.SHROUDED_ROBES) || inventory.contains(Inventory.WARM_COAT)) {
                sb.append("You manage to kill the first rat, but your weapon gets stuck in its thick skull.\n");
                sb.append("As you are trying to get it out, the second rat bites you in the neck.\n");
                sb.append("You bleed out on top of a stinky rat.\n");
                hasDied = true;
            }

            else {
                sb.append("The rats jump all over you and try to bite, but they fail!\n");
                sb.append("Your armor is too thick to pierce.\n");
                sb.append("You manage to take down both of the rats.\n");
            }
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
        }
        else {
            question = "You continue onward toward the princess.";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Yay!", new BlackChestEncounter());
        }
    }
}
