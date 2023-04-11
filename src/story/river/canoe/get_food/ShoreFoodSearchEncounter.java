package story.river.canoe.get_food;

import model.AbstractEncounter;
import model.Inventory;
import story.river.canoe.river_monster.RiverMonsterEncounter;

public final class ShoreFoodSearchEncounter extends AbstractEncounter {
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You row to the shore and pull your boat up onto the bank.\n");
        sb.append("You see a rabbit hopping about 50 yards in front of you.\n");
        if(inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("You pull out your bow and arrow and shoot the rabbit.\n");
            sb.append("You aimed well! The rabbit is dead.\n");
            sb.append("You make a fire and cook the rabbit.\n");
            sb.append("Once you eat the rabbit, you feel much stronger.\n");
        }
        else {
            sb.append("You try to sneakily approach the rabbit.\n");
            sb.append("The rabbit senses you coming and hops away. You are unable to catch him.\n");
            sb.append("You sit down and wait to see another animal.\n");
            sb.append("A squirrel runs near you and stops about two feel from where you are sitting.\n");
            sb.append("You slowly pull out your weapon and strike at the squirrel.\n");
            sb.append("You got one this time! You build a fire and cooke the squirrel.\n");
            sb.append("You eat your food and feel satisfied and strong.\n");
        }
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "You get back into your boat and continue your journey down the river.";
    }

    @Override
    protected void setChoices() {
        addProgressButton("Yum!", new RiverMonsterEncounter());
    }
}
