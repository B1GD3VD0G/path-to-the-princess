package story.river.on_foot.food;

import model.AbstractEncounter;
import model.Inventory;
import story.river.on_foot.cave.FindCaveEncounter;

public final class RiversideHunterEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        sb.append("Up ahead you see a deer.\n");
        if(inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("You pull out your bow and arrow and shoot the deer.\n");
            sb.append("The first arrow stuns him. You shoot another arrow at him.\n");
            sb.append("This arrow pierces his skull. You now have a massive dinner to feast on!\n");
            sb.append("You build a fire and cook some of the deer.\n");
        }
        else { // hasBattleAxe or hasSwordAndShield
            if(inventory.contains(Inventory.SHROUDED_ROBES) || inventory.contains(Inventory.LEATHER_ARMOR)
                    || inventory.contains(Inventory.WARM_COAT)) {
                sb.append("You slowly and stealthily approach the deer.\n");
                sb.append("You get close behind him without him noticing you and you strike him in the skull!\n");
                sb.append("You now have a massive dinner to feast on!\n");
                sb.append("You build a fire and cook some of the deer.\n");
            }
            else {
                sb.append("You try to approach the deer.\n");
                sb.append("Your armor is too loud! You scare the deer away.\n");
                sb.append("\n");
                sb.append("You walk toward the river, defeated, not knowing what you will do for food.\n");
                sb.append("You get to the river and look down at your reflection in the water.\n");
                sb.append("You see a group of fish swimming right by the shore.\n");
                sb.append("You take your weapon and try to hit a fish.\n");
                sb.append("You manage to get one! You build a fire and cook it.\n");
                sb.append("You eat the fish.\n");
            }
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You feel full and satisfied.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yum!", new FindCaveEncounter());
    }
}
