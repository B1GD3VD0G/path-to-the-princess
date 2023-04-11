package story.keep.final_battle;

import model.AbstractEncounter;

public final class FreezeChiefEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("You freeze time using your mighty staff.\n");
        sb.append("It disappears back to the immortal plane right after you cast your spell.\n");
        sb.append("While the bandit chief is not moving, you strike him down with your weapon.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You grab the keys to the princess's cell from the bandit's corpse.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Free the princess!", new KissPrincessEncounter());
    }
}
