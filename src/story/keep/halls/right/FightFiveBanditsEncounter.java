package story.keep.halls.right;

import model.AbstractEncounter;
import model.Inventory;

public final class FightFiveBanditsEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        if(inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("You pull out your bow and arrow.\n");
            sb.append("You shoot one bandit before they notice, and you knock him down.\n");
            sb.append("The rest of the bandits begin to charge at you!\n");
            sb.append("You quickly take them down one by one.\n");
        }
        else {
            sb.append("You try to take them on as they charge at you.\n");
            sb.append("You swing your weapon and get two down in a swift movement.\n");
            sb.append("The three others take you down before you can readjust.\n");
            sb.append("Three against one is not a fair fight!\n");
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
            question = "The bow and arrow came in handy!";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
            return;
        }
        addProgressButton("Yay!", new CourtyardSlaughterEncounter());
    }
}
