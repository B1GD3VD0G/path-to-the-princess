package story.introduction.wolves;

import model.AbstractEncounter;
import model.Inventory;

public final class WolvesEncounter extends AbstractEncounter {

    public WolvesEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("The road leads into a pine forest.\n");
        sb.append("You follow the path into the shade under the trees.\n");
        sb.append("At first, there is plenty of wildlife.\n");
        sb.append("Birds hop from branch to branch overhead,\n");
        sb.append("And squirrels rustle the bushes beside you.\n");
        sb.append("After many minutes of walking, you stop noticing wildlife.\n");
        sb.append("The woods are eerily quiet as you approach a clearing.\n");
        sb.append("In the clearing, you see a dead body. It seems to have been killed by predators.\n");
        sb.append("You approach the body closer.\n");
        sb.append("Upon further examination, you see it wears a warm coat made of thick leather.\n");
        if (!inventory.contains(Inventory.DOG)) {
            sb.append("You hear growls come from the trees. Out of the forest come three snarling wolves.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (inventory.contains(Inventory.DOG)) {
            question = "You hear growls come from the trees. Out of the forest come three snarling wolves.";
        }
        else {
            question = "How will you proceed?";
        }
    }

    @Override
    protected void setChoices() {
        if (inventory.contains(Inventory.DOG)) {
            addProgressButton("Oh no!", new WolfDogEncounter());
        }
        else {
            addProgressButton("Fight the wolves!", new WolvesFightEncounter());
            addProgressButton("Climb up a tree!", new WolvesTreeEncounter());
        }
    }
}
