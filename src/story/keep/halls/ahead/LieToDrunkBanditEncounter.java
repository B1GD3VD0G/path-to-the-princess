package story.keep.halls.ahead;

import model.AbstractEncounter;

public final class LieToDrunkBanditEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You explain how you just joined the bandits.\n");
        sb.append("He seems even more confused than he initially did.\n");
        sb.append("Right at that moment, another bandit comes out of the room.\n");
        sb.append("This bandit is not out of sorts. He exclaims that you are an intruder!\n");
        sb.append("The drunk bandit instantly pulls out his weapon, as does the other one.\n");
        sb.append("Two against one is an unfair fight. They take you down!\n");
        hasDied = true;
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = GAME_OVER;
    }

    @Override
    protected void setChoices() {
        addGameOverButtons();
    }
}
