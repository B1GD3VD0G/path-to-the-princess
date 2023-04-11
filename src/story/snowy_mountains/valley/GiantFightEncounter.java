package story.snowy_mountains.valley;

import model.AbstractEncounter;
import model.Inventory;

public final class GiantFightEncounter extends AbstractEncounter {

    public GiantFightEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("You take a wide stance and draw your weapon and wait for the giant to approach you.\n");
        sb.append("The giant looks at you hungrily.\n");
        sb.append("He reaches out his hand to try and pick you up.\n");
        if (!inventory.contains(Inventory.BOW_AND_ARROWS)){
            sb.append("You use your weapon to cut off one of his fingers!\n");
            sb.append("This has made him very angry!\n");
            sb.append("He then lifts up his leg and stomps on you.\n");
            hasDied = true;
        }
        else{
            if (inventory.contains(Inventory.ROPE)){
                sb.append("You dodge him, and reach into your backpack for your rope.\n");
                sb.append("You tie your rope to an arrow, and fire it into the cliff.\n");
                sb.append("You then pull it taut. You have made a tripwire!\n");
                sb.append("The giant trips over the wire, and crashes to the ground violently.\n");
                sb.append("Before he recovers, you take two more arrows and fire them into his eye sockets.\n");
                sb.append("The giant is not dead, but he is blind. You run away and he can no longer find you.\n");
            }
            else {
                sb.append("You dodge backward and avoid his grasp.\n");
                sb.append("You shoot an arrow at his eye, but you miss and hit him in his naturally armored forehead.\n");
                sb.append("This makes him really angry, and the giant punches at you.\n");
                sb.append("He misses you, but he does hit the rock wall behind you.\n");
                sb.append("The rock cracks, and a huge avalanche of snow and rock come falling down on top of the both of you.\n");
                hasDied = true;
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
            question = "";
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
