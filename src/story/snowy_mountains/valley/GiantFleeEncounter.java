package story.snowy_mountains.valley;

import model.AbstractEncounter;
import model.Inventory;

public final class GiantFleeEncounter extends AbstractEncounter {

   public GiantFleeEncounter() {
       super();
   }

    @Override
    protected void setStory() {
       StringBuilder sb = new StringBuilder();
        if (inventory.contains(Inventory.SNOWSHOES)){
            sb.append("You start running from the Frost Giant as quickly as you can.\n");
            sb.append("Your snowshoes make it easy to move quickly through the snow.\n");
            sb.append("Soon enough, you lose the giant, and are ready to get back to your quest.\n");
        }
        else{
            sb.append("You cannot run very quickly in the deep snow.\n");
            sb.append("The giant has great long legs to chase you with.\n");
            sb.append("He grabs you with his big arms, and bites your head off.\n");

        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
        }
        else {
            question = "You continue through the valley toward the princess.";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Phew!", new MountainExitEncounter());
        }
    }
}
