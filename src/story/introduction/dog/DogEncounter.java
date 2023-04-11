package story.introduction.dog;

import model.Inventory;
import model.AbstractEncounter;

public final class DogEncounter extends AbstractEncounter {

    public DogEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        sb.append("After about another hour of walking, the sun starts to rise.\n");
        sb.append("It rises in pink and orange over the snowy mountains to the east.\n");
        sb.append("You are admiring it, when out of the bush comes a snarling wild dog.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "What do you do?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Attack the dog.", new DogFightEncounter());
        if (inventory.contains(Inventory.STEAK)) {
            addProgressButton("Give the dog the steak.", new DogSteakEncounter());
        }
    }
}
