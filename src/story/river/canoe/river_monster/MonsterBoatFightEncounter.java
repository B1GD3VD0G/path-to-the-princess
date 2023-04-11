package story.river.canoe.river_monster;

import model.AbstractEncounter;
import model.Inventory;
import story.river.canoe.tunnel.RiverTunnelEncounter;

public final class MonsterBoatFightEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        if(inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("You reach for your bow and arrow and aim for the monster's eye.\n");
            sb.append("It takes a few shots, but you're far away enough that you have some time to get it right.\n");
            sb.append("You take down the monster, and he falls back into the water.\n");
            sb.append("The water immediately calms down.\n");
        }
        else if(inventory.contains(Inventory.SWORD_AND_SHIELD)) {
            sb.append("As the river monster approaches you, you get ready to strike him with your sword.\n");
            sb.append("He reaches his neck down to bite into you and the canoe,\n");
            sb.append("but you strike him in his skull right before it's too late.\n");
            sb.append("The monster falls back into the river, extremely wounded.\n");
            sb.append("After a minute, the creature dies and the water calms down.\n");
        }
        else {
            sb.append("You pull out your battle axe, but the river monster beats you to it.\n");
            sb.append("Right as you go to swing, the monster bites down onto you and the canoe.\n");
            sb.append("You are now inside the monster's stomach.\n");
            hasDied = true;
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
        }
        else {
            question = "You continue on the way toward the princess.";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
            return;
        }
        addProgressButton("Phew!", new RiverTunnelEncounter());
    }
}
