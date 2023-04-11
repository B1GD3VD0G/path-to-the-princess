package story.introduction.wolves;

import model.AbstractEncounter;
import model.Inventory;
import story.introduction.SplitPathEncounter;

public final class ShootWolvesEncounter extends AbstractEncounter {

    public ShootWolvesEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        System.out.println("The wolves bark and growl at you up in the tree.");
        System.out.println("Eventually they get bored, and remember the body laying in the clearing.");
        System.out.println("You fire arrows at the wolves down below.");
        System.out.println("Your first arrow strikes the biggest wolf in the head, killing him instantly.");
        System.out.println("The other wolves look up at you, howl, then resume their feast.");
        System.out.println("You loose another arrow, hitting the next wolf in the leg.");
        System.out.println("He lets out a piercing yelp, and he and his friend run off back into the woods.");
        System.out.println("You wait a couple minutes in the tree. They do not come back.");
        System.out.println("You hop down from the branch.");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Would you like to take the warm coat off the body?\n" +
                "(Doing so will replace your current armor.)";
    }

    @Override
    protected void setChoices() {
        addTradeArmorButton("Yes.", new SplitPathEncounter(), Inventory.WARM_COAT);
        addProgressButton("No.", new SplitPathEncounter());
    }
}
