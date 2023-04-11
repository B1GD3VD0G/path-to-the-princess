package story.introduction.camp;

import model.AbstractEncounter;
import model.Inventory;
import story.introduction.dog.DogEncounter;

public final class CampFightEncounter extends AbstractEncounter {

    public CampFightEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        if (inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("The knight uses his heavy metal gauntlet to strike you in the face.\n");
            sb.append("You fall to the ground, defenseless without a close quarters weapon.\n");
            sb.append("He gets on top of you and beats you to a pulp.\n");
            hasDied = true;
        }
        else if (inventory.contains(Inventory.SWORD_AND_SHIELD)) {
            sb.append("You block the knight's punch with your shield.\n");
            sb.append("You use your sword to kill him while he stumbles.\n");
            sb.append("He falls to the ground, and you go to search his chest.\n");
            sb.append("Inside his chest you find 50 gold pieces and a long piece of rope.\n");
            sb.append("You also take the steak off the fire.\n");
            inventory.collect(50);
            inventory.collect(Inventory.ROPE);
            inventory.collect(Inventory.STEAK);
        }
        else {
            sb.append("You block the knight's attack with your axe.\n");
            sb.append("Then you strike him with all your might.\n");
            sb.append("He falls to the ground, lifeless.\n");
            sb.append("You go to search his chest.\n");
            sb.append("You find 50 gold pieces and a long piece of rope.\n");
            sb.append("You also take the steak off of the fire.\n");
            inventory.collect(50);
            inventory.collect(Inventory.ROPE);
            inventory.collect(Inventory.STEAK);
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
        }
        else {
            question = "You continue down the road toward the princess.";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Yay!", new DogEncounter());
        }
    }
}
