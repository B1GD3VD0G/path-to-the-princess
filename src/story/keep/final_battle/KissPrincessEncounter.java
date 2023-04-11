package story.keep.final_battle;

import model.AbstractEncounter;

public final class KissPrincessEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Princess: Oh, Sir Longwood! You've rescued me! I knew you would!\n");
        sb.append("\n");
        sb.append("You unlock the gate to release the princess.\n");
        sb.append("She jumps into your arms, and gives you a big wet kiss.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Congratulations! You have rescued the princess!";
    }

    @Override
    protected void setChoices() {
        addGameOverButtons();
    }
}
