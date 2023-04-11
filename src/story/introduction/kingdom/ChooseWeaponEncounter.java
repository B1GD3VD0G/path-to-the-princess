package story.introduction.kingdom;

import model.Inventory;
import model.AbstractEncounter;
public final class ChooseWeaponEncounter extends AbstractEncounter {

    public ChooseWeaponEncounter() {
        super();
    }

    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("You are Sir Richard Longwood.\n");
        sb.append("You are a knight, sworn to protect the princess.\n");
        sb.append("You are violently jarred awake from a deep slumber by the King!\n");
        sb.append("\n");
        sb.append("King: My daughter has been kidnapped!\n");
        sb.append("King: I suspect it was the Bandits in the Northern Keep!\n");
        sb.append("\n");
        sb.append("You realize that your trusty suit of armor and weapons have also been stolen from your room.\n");
        sb.append("You must buy some weapons and armor from the local blacksmith.\n");
        sb.append("You have 1200 gold pieces in your safe!\n");
        sb.append("You give the king your word - you will find the princess.\n");
        sb.append("You leave the castle and head to the blacksmith.\n");
        sb.append("\n");
        sb.append("First, you must find a weapon.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "Which weapon would you like to purchase?";
    }

    @Override
    protected void setChoices() {
        addBuyButton("A bow and arrows for 100 gold pieces. Good for long range but useless in close quarters.", new ChooseArmorEncounter(),
                Inventory.BOW_AND_ARROWS, 100);
        addBuyButton("A battleaxe for 175 gold pieces. Slow but extremely powerful.", new ChooseArmorEncounter(),
                Inventory.BATTLEAXE, 175);
        addBuyButton("A sword and shield for 300 gold pieces. Provides medium damage and extra protection.", new ChooseArmorEncounter(),
                Inventory.SWORD_AND_SHIELD, 300);
    }
}
