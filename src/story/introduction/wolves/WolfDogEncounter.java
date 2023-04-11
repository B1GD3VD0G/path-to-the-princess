package story.introduction.wolves;

import model.AbstractEncounter;
import model.Inventory;
import story.introduction.SplitPathEncounter;

public final class WolfDogEncounter extends AbstractEncounter {

    public WolfDogEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You draw your weapon, but fear shakes your body.\n");
        sb.append("Your dog jumps out in front of you. It snarls at the wolves, and barks twice.\n");
        sb.append("The wolves seem to calm down. The dog and the wolves start sniffing each other.\n");
        sb.append("Your dog looks back at you and barks happily.\n");
        sb.append("He then joins the wolves in running away into the forest.\n");
        inventory.drop(Inventory.DOG);
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
