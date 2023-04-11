package story.introduction.kingdom;

import model.Inventory;
import model.AbstractEncounter;
import story.introduction.camp.SleepyCamperEncounter;

public final class ChooseArmorEncounter extends AbstractEncounter {

    public ChooseArmorEncounter() {
        super();
    }
    @Override
    protected void setStory() {
        StringBuilder sb = new StringBuilder(512);
        if (inventory.contains(Inventory.BOW_AND_ARROWS)) {
            sb.append("You are now equipped with the bow and arrow. You feel more confident.\n");
        }
        if (inventory.contains(Inventory.BATTLEAXE)) {
            sb.append("You are now equipped with the battle axe. You feel stronger already!\n");
        }
        if (inventory.contains(Inventory.SWORD_AND_SHIELD)) {
            sb.append("You are now equipped with the sword and shield. You feel protected.\n");
        }
        sb.append("Now you must purchase some armor.\n");
        story = sb.toString();
    }

    @Override
    protected void setQuestion() {
        question = "What kind of armor would you like to buy?";
    }

    @Override
    protected void setChoices() {
        addBuyButton("Leather armor for 200 gold pieces. Provides medium protection.", new SleepyCamperEncounter(),
                Inventory.LEATHER_ARMOR, 200);
        addBuyButton("Shrouded robes for 250 gold pieces. Makes you sneaky, but provides little protection.", new SleepyCamperEncounter(),
                Inventory.SHROUDED_ROBES, 250);
        addBuyButton("Metal armor for 350 gold pieces. Provides maximum protection.", new SleepyCamperEncounter(),
                Inventory.METAL_ARMOR, 350);
    }
}
