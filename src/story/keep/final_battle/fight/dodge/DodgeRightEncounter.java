package story.keep.final_battle.fight.dodge;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.final_battle.fight.react.*;

public final class DodgeRightEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        if (inventory.contains(Inventory.METAL_ARMOR)) {
            sb.append("Your metal armor slows you down greatly.\n");
            sb.append("But you find out that it protects you very little from incoming giant warhammers\n");
            sb.append("The bandit chief smashes your head against the wall.\n");
            hasDied = true;
        }
        else {
            sb.append("You successfully dodge the attack!\n");
            sb.append("The bandit chief huffs angrily.\n");
            sb.append("He lifts his hammer again to swing at you.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
        }
        else {
            question = "How will you react?";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Dodge!", new DodgeAgainEncounter());
            addProgressButton("Counterattack!", new CounterattackEncounter());
            if (inventory.contains(Inventory.SWORD_AND_SHIELD)) {
                addProgressButton("Block the strike with your shield.", new BlockHammerEncounter());
            }
        }
    }
}
