package story.keep.final_battle.hide;

import model.AbstractEncounter;

public final class HideInCellEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You hide in a vacant cell next to the princess.\n");
        sb.append("You tuck yourself into a dark corner where he cannot see you.\n");
        sb.append("You wait for the bandit chief to arrive.\n");
        sb.append("After a few minutes, he comes into the chamber.\n");
        sb.append("As soon as he walks in, he notices the cell door is open.\n");
        sb.append("\n");
        sb.append("Bandit Chief: Dagnabbit, I'm always leaving this door open!\n");
        sb.append("\n");
        sb.append("He closes the door, trapping you inside.\n");
        sb.append("There is nothing you can do.\n");
        hasDied = true;
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Game over.";
    }

    @Override
    protected void setChoices() {
        addGameOverButtons();
    }
}
