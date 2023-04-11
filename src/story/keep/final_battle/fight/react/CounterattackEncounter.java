package story.keep.final_battle.fight.react;

import model.AbstractEncounter;
import model.Inventory;
import story.keep.final_battle.fight.execute.*;

public final class CounterattackEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder();
        if (inventory.contains(Inventory.BOW_AND_ARROWS)){
            sb.append("What kind of counterattack were you planning with a bow?\n");
            sb.append("The bandits strike lands and hits you in the chest.\n");
            sb.append("You fly back into the wall.\n");
            hasDied = true;
        }
        else{
            sb.append("You swing your weapon at the bandit chief.\n");
            sb.append("Yours is much lighter than his, so you are able to land your blow.\n");
            sb.append("The bandit chief falls back.\n");
            sb.append("He loses grip of his warhammer, and it flies across the floor.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        if (hasDied) {
            question = GAME_OVER;
        }
        else {
            question = "How will you execute the bandit chief?";
        }
    }

    @Override
    protected void setChoices() {
        if (hasDied) {
            addGameOverButtons();
        }
        else {
            addProgressButton("Use his own warhammer on him.", new ExecuteWithHammerEncounter());
            addProgressButton("Use your own weapon.", new ExecuteWithOwnWeaponEncounter());
            addProgressButton("Show mercy on the bandit chief.", new ShowMercyEncounter());
        }
    }
}
