package story.introduction.camp;

import model.Inventory;
import model.AbstractEncounter;
import story.introduction.dog.DogEncounter;

public final class CampRobberEncounter extends AbstractEncounter {

    public CampRobberEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        if (inventory.contains(Inventory.SHROUDED_ROBES)) {
            sb.append("You break into his chest and find a long rope and 50 gold pieces. \n");
            sb.append("You also grab the steak off the fire.\n");
            inventory.collect(50);
            inventory.collect(Inventory.ROPE);
            inventory.collect(Inventory.STEAK);
        }
        else {
            sb.append("You open the chest, and then the knight awakens! He seems very angry!");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (inventory.contains(Inventory.SHROUDED_ROBES)) {
            question = "You continue down the road toward the princess, and the knight continues sleeping.";
        }
        else {
            question = "How will you deal with the angry knight?";
        }
    }

    @Override
    protected void setChoices() {
        if (inventory.contains(Inventory.SHROUDED_ROBES)) {
            addProgressButton("Yay!", new DogEncounter());
        }
        else {
            addProgressButton("Fight!", new CampFightEncounter());
            addProgressButton("Run away!", new CampFleeEncounter());
        }
    }
}
