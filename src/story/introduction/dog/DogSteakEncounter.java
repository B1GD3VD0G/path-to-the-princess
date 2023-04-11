package story.introduction.dog;

import model.AbstractEncounter;
import model.Inventory;
import story.introduction.wolves.WolvesEncounter;

public final class DogSteakEncounter extends AbstractEncounter {
    public DogSteakEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You toss the meat towards the dog.\n");
        sb.append("He sniffs the meat suspiciously, and then he eats viciously.\n");
        sb.append("He then comes up to you and licks your hand.");
        inventory.collect(Inventory.DOG);
        inventory.drop(Inventory.STEAK);
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You have gained a companion!";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yay!", new WolvesEncounter());
    }
}
