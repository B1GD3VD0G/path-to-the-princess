package story.keep.sewer;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.sewer.rats.SewerRatsEncounter;

public final class SewerEnterEncounter extends AbstractEncounter {

    public SewerEnterEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You decide to sneak through the sewer to get into the castle.\n");
        sb.append("You lift the grate and lower yourself down.\n");
        sb.append("The air is dank and cold, but there doesnt seem to be anybody else down here");
        if (inventory.contains(Inventory.WIZARD)) {
            sb.append(", except your wizard friend.\n");
        }
        else {
            sb.append(".\n");
        }
        sb.append("Ahead of you the sewer branches into two paths.\n");
        sb.append("You realize that you have no idea where you're going.\n\n");
        if (inventory.contains(Inventory.WIZARD)) {
            sb.append("Wizard: I used to run with these bandits, ages ago.\n");
            sb.append("Wizard: I know the way through these sewers.\n");
            sb.append("Wizard: Take a right up ahead.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Which way would you like to turn?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Turn left.", new TripwireEncounter());
        addProgressButton("Turn right.", new SewerRatsEncounter());
    }
}
