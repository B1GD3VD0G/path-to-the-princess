package story.keep.final_battle.fight.execute;

import model.AbstractEncounter;
import story.keep.final_battle.KissPrincessEncounter;

public final class ShowMercyEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("You decide to show mercy.\n");
        sb.append("You take his key off his belt and go to free the princess.\n");
        sb.append("\n");
        sb.append("Princess: Sir Longwood, look out!!\n");
        sb.append("\n");
        sb.append("Instinctively, you jump out of the way.\n");
        sb.append("The bandit chief swung at you while you weren't looking, but he missed.\n");
        sb.append("Now you are mad. You gave him a chance and showed him mercy!\n");
        sb.append("You charge at him.\n");
        sb.append("He is very tired, and he cannot dodge.\n");
        sb.append("You strike him down. He falls dead on the ground.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You turn back toward the cage to free the princess.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yay!", new KissPrincessEncounter());
    }
}
