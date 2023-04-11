package story.keep.final_battle.fight.execute;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.final_battle.KissPrincessEncounter;

public final class ExecuteWithOwnWeaponEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(128);
        if (inventory.contains(Inventory.EXCALIBUR)){
            sb.append("You take the mighty excalibur in your hand.\n");
            sb.append("The bandit finally recognizes its glory!\n");
            sb.append("He lets out a terrified whimper.\n");
            sb.append("You stab the sword through his heart, and he dies!\n");
        }
        else{
            sb.append("You bring back your weapon, and swing it at the bandit chief.\n");
            sb.append("He dodges the attack, rolls toward you and knocks you down!\n");
            sb.append("He beats your head in.\n");
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
            question = "Yay!";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Save the princess!", new KissPrincessEncounter());
        }
    }
}
