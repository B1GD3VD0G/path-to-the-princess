package story.keep.sewer;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.final_battle.MeetPrincessEncounter;

public final class SewerExitEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You leave the chest alone. All you care about is finding the princess.\n");
        sb.append("After another couple minutes of walking, you find a ladder leading to a trapdoor.\n");
        sb.append("You hope this is the door to the princess!\n");
        sb.append("You climb up the ladder and through the trapdoor.\n");
        if (inventory.contains(Inventory.WIZARD)){
            sb.append("Your wizard companion follows you.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You feel so close to victory, but save the celebrations for later.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yay!", new MeetPrincessEncounter());
    }
}
