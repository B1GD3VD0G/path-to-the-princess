package story.river.on_foot.fort;

import model.AbstractEncounter;
import model.Inventory;
import story.river.on_foot.food.RiversideFoodEncounter;

public final class ReceiveHelpEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        sb.append("You: I am Sir Richard Longwood. I have been sent to save the princess.\n");
        sb.append("\n");
        sb.append("Man: Oh boy! Please take whatever you would like.\n");
        sb.append("Man: We don't have much, theres a fish and a few gold pieces that you may take on your journey.\n");
        inventory.collect(10);
        inventory.collect(Inventory.COOKED_FISH);
        sb.append("\n");
        sb.append("You: Thank you so much! This will definitely come in handy on my journey!\n");
        sb.append("\n");
        sb.append("Man: Be safe on your journey! Be careful of the river trolls.\n");
        sb.append("Man: Know that you need to keep going straight in order to get to the Northern Keep.\n");
        sb.append("Man: Don't let the trolls fool you! They'll try to get you to cross!\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You are grateful for the kind man's generosity.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Continue down the river.", new RiversideFoodEncounter());
    }
}
