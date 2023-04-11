package story.keep.final_battle.hide;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.final_battle.FreezeChiefEncounter;
import story.keep.final_battle.fight.RevealYourselfEncounter;

public final class HideUnderTableEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You hide under the table, and hope that the is long enough to conceal you!\n");
        sb.append("After a few moments, you hear the bandit chief enter the room.\n");
        sb.append("\n");
        sb.append("Bandit Chief: Oh, beautiful princess! Have you reconsidered my offer?\n");
        sb.append("Princess: I'll never marry a lowlife like you!\n");
        sb.append("Bandit Chief: You will change your mind! You would like to leave your cage someday, yes?\n");
        sb.append("Princess: I'd rather die in this cage than show you one ounce of affection!\n");
        sb.append("Bandit Chief: Then maybe we will have to arrange that!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "What will you do?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Reveal yourself and fight the Bandit Chief.", new RevealYourselfEncounter());
        addProgressButton("Stay underneath the table.", new StayHiddenEncounter());
        if (inventory.contains(Inventory.STAFF)) {
            addProgressButton("Use your staff to freeze time, and take the key!", new FreezeChiefEncounter());
        }
    }
}
