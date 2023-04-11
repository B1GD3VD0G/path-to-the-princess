package story.snowy_mountains.tallest_mountain.peak;

import model.AbstractEncounter;

public final class PayDragonEncounter extends AbstractEncounter {

    public PayDragonEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        int goldOfferedToDragon = inventory.getGold();
        inventory.pay(goldOfferedToDragon);
        StringBuilder sb = new StringBuilder();
        if (goldOfferedToDragon >= 700){
            sb.append("Dragon: Splendid! This will be the perfect addition to my collection!\n");
            sb.append("Dragon: You may now approach my master's shrine!\n");
            sb.append("Dragon: Also, when you are done, I will fly you to your destination!\n");
        }
        else{ //didn't give him at least 700 gold
            sb.append("Dragon: This gift offends me!\n");
            sb.append("The dragon breathes inhales and you see his throat glow from the flames.\n");
            sb.append("He exhales fire, and it's so hot you don't even feel it before you die.\n");
            hasDied = true;
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
            return;
        }
        question = "The dragon steps to the side, clearing the path to the shrine.";
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Approach the shrine.", new TalkToGodEncounter());
        }
    }
}
