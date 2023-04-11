package story.river.on_foot.cave;

import model.AbstractEncounter;

public final class GhostTruthEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Ghost: Oh, you are a knight you say?\n");
        sb.append("Ghost: A knight killed me in this spot a hundred years ago. I don't like them!\n");
        sb.append("Ghost: Put back my things and leave this cave immediately! \n");
        sb.append("Ghost: Else, I will trap you in this chest with me forever!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "How will you respond?";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Return his things and leave immediately.", new LeaveCaveEncounter());
        addProgressButton("Try to escape with his things.", new TrappedInChestEncounter());
    }
}
