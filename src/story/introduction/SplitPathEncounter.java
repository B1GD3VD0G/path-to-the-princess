package story.introduction;

import model.AbstractEncounter;
import model.Inventory;
import story.introduction.kingdom.InstructionEncounter;
import story.river.RiverIntroductionEncounter;
import story.snowy_mountains.SnowyIntroductionEncounter;

public final class SplitPathEncounter extends AbstractEncounter {

    public SplitPathEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You step out of the woods.\n");
        sb.append("There are many different ways that you may follow to the princess.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Which way would you like to go?";
    }

    @Override
    protected void setChoices() {
        addDisabledProgressButton("Through the extremely bustling city. (Coming Soon)", new InstructionEncounter());
        addDisabledProgressButton("Through the dense jungle. (Coming Soon)", new InstructionEncounter());
        addProgressButton("Along the long, winding river.", new RiverIntroductionEncounter());
        addDisabledProgressButton("Through the deep, dark cave. (Coming Soon)", new InstructionEncounter());
        if (inventory.contains(Inventory.WARM_COAT)) {
            addProgressButton("Over the snowy mountains.", new SnowyIntroductionEncounter());
        }
    }
}
