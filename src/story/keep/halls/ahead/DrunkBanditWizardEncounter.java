package story.keep.halls.ahead;

import model.AbstractEncounter;
import model.Inventory;

public final class DrunkBanditWizardEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You show him your wizard and say he can grant him any wish he desires!\n");
        sb.append("The drunk bandit is in awe! He takes the wizard from you,");
        sb.append("and is so consumed that you just walk away.\n");
        inventory.drop(Inventory.WIZARD);
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You continue along the hallway.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Okay.", new DownstairsChiefDoorEncounter());
    }
}
